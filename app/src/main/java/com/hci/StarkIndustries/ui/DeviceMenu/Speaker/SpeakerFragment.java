package com.hci.StarkIndustries.ui.DeviceMenu.Speaker;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.data.Models.devices.DeviceModels.SpeakerModel;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceViewModel;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static com.hci.StarkIndustries.data.Models.devices.DeviceModels.SpeakerModel.PlayState.Paused;
import static com.hci.StarkIndustries.data.Models.devices.DeviceModels.SpeakerModel.PlayState.Playing;
import static com.hci.StarkIndustries.data.Models.devices.DeviceModels.SpeakerModel.PlayState.Stopped;

public class SpeakerFragment extends DeviceFragment {
    private SpeakerViewModel mViewModel;
    private SongTimer songProgressTimer;
    private boolean loaded = false;

    public static SpeakerFragment newInstance() {
        return new SpeakerFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.speaker_fragment, container, false);


        final TextView songName = root.findViewById(R.id.SpeakerSongName);
        songName.setSelected(true);

        final FloatingActionButton playPauseButton = root.findViewById(R.id.SpeakerPlayPauseButton);
        playPauseButton.setOnClickListener(v -> {
            SpeakerModel model = mViewModel.getModel(this, getID()).getValue();
            switch (model.getPlayState()) {
                case Playing:
                    mViewModel.setPlayState(Paused);
                    break;
                case Paused:
                case Stopped:
                    mViewModel.setPlayState(Playing);
                    break;
            }
        });

        final FloatingActionButton prevButton = root.findViewById(R.id.SpeakerPrevButton);
        prevButton.setOnClickListener(v -> mViewModel.previousSong());

        final FloatingActionButton nextButton = root.findViewById(R.id.SpeakerNextButton);
        nextButton.setOnClickListener(v -> mViewModel.nextSong());

        final FloatingActionButton stopButton = root.findViewById(R.id.SpeakerStopButton);
        stopButton.setOnClickListener(v -> mViewModel.setPlayState(Stopped));

        final SeekBar volumeSlider = root.findViewById(R.id.SpeakerVolumeSlider);
        volumeSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (loaded) {
                    mViewModel.setVolume(progress / 10);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        final Spinner modeDDL = root.findViewById(R.id.SpeakerModeDDL);
        modeDDL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (loaded)
                    mViewModel.setGenre(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(SpeakerViewModel.class);
        mViewModel.getModel(this, getID()).observe(this, speakerModel -> {
            final FloatingActionButton playPauseButton = getView().findViewById(R.id.SpeakerPlayPauseButton);

            if (speakerModel.getPlayState() == SpeakerModel.PlayState.Playing) {
                playPauseButton.setForeground(ContextCompat.getDrawable(getActivity(), R.drawable.ic_pause_black_24dp));
            } else {
                playPauseButton.setForeground(ContextCompat.getDrawable(getActivity(), R.drawable.ic_play_arrow_white_48dp));
                if (speakerModel.getPlayState() == SpeakerModel.PlayState.Stopped) {
                    ((TextView) getView().findViewById(R.id.SpeakerSongName)).setText(R.string.SpeakerNoSong);
                }
            }

            loadSong(speakerModel);

            final Spinner modeDDL = getView().findViewById(R.id.SpeakerModeDDL);
            modeDDL.setSelection(mViewModel.getGenreInt(), true);

            final SeekBar volumeSlider = getView().findViewById(R.id.SpeakerVolumeSlider);
            volumeSlider.setProgress(speakerModel.getVolume() * 10);

            if (!loaded) {
                loaded = true;
                songProgressTimer = new SongTimer();
                songProgressTimer.scheduleAtFixedRate(new SongTimerTask(), 0, 1000);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (songProgressTimer != null) {
            songProgressTimer.cancel();
            songProgressTimer = null;
        }
    }

    private void loadSong(SpeakerModel model) {
        if (model.getCurrentSong() == null) return;

        ((TextView) getView().findViewById(R.id.SpeakerSongDurationText)).setText(model.getCurrentSong().getDuration());
        final TextView songName = getView().findViewById(R.id.SpeakerSongName);
        songName.setSelected(true);
        songName.setText(model.getCurrentSong().getTitle());

        ((TextView) getView().findViewById(R.id.SpeakerSongProgressText)).setText(model.getCurrentSong().getProgress());
    }

    @Override
    public DeviceViewModel getViewModel() {
        return this.mViewModel;
    }

    private class SongTimer extends Timer {
        public boolean isRunning = false;

        @Override
        public void scheduleAtFixedRate(TimerTask task, long delay, long period) {
            if (!isRunning) {
                super.scheduleAtFixedRate(task, delay, period);
                isRunning = true;
            }
        }

        @Override
        public void cancel() {
            if (isRunning) {
                isRunning = false;
                super.cancel();
                super.purge();
            }
        }
    }

    private class SongTimerTask extends TimerTask {
        @Override
        public void run() {
            getActivity().runOnUiThread(() -> {
                mViewModel.reloadModel();
            });
        }
    }
}
