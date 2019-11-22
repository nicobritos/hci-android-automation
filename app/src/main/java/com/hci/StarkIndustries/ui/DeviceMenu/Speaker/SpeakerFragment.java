package com.hci.StarkIndustries.ui.DeviceMenu.Speaker;

import android.os.Bundle;
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
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.data.Models.devices.DeviceModels.SpeakerModel;
import com.hci.StarkIndustries.ui.DeviceMenu.IdentifiableFragment;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class SpeakerFragment extends IdentifiableFragment {
    private SpeakerViewModel mViewModel;
    private SongTimer songProgressTimer;

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
//                switch (model.playState) {
//                    case Playing:
//                        mViewModel.setPlayState(SpeakerModel.PlayState.Paused);
//                        break;
//                    case Paused:
//                        mViewModel.setPlayState(SpeakerModel.PlayState.Playing);
//                        break;
//                    case Stopped:
//                        mViewModel.setPlayState(SpeakerModel.PlayState.Playing);
//                        break;
//                }

        });

        final FloatingActionButton prevButton = root.findViewById(R.id.SpeakerPrevButton);

        prevButton.setOnClickListener(v -> {
            PauseSong();
            mViewModel.prevSong();
        });

        final FloatingActionButton nextButton = root.findViewById(R.id.SpeakerNextButton);
        nextButton.setOnClickListener(v -> {
            // PlayNextSong
            PauseSong();
            mViewModel.nextSong();
        });

        final FloatingActionButton stopButton = root.findViewById(R.id.SpeakerStopButton);
        stopButton.setOnClickListener(v -> {
            PauseSong();
            mViewModel.stop();
            // Stop
        });

        final SeekBar volumeSlider = root.findViewById(R.id.SpeakerVolumeSlider);
        volumeSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
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

//                if (speakerModel.playState == SpeakerModel.PlayState.Playing) {
//                    playPauseButton.setForeground(ContextCompat
//                            .getDrawable(getActivity(), R.drawable.ic_pause_black_24dp));
//
//                } else {
//                    playPauseButton.setForeground(ContextCompat
//                            .getDrawable(getActivity(), R.drawable.ic_play_arrow_white_48dp));
//
//                    if (speakerModel.playState == SpeakerModel.PlayState.Stopped) {
//                        ((TextView) getView().findViewById(R.id.SpeakerSongName)).setText(R.string.SpeakerNoSong);
//                    }
//                }
//
//
//                loadSong(speakerModel);
//                final Spinner modeDDL = getView().findViewById(R.id.SpeakerModeDDL);
//
//                modeDDL.setSelection(speakerModel.genre, true);


        });


    }

//    @Override
//    public void onStop() {
//        super.onStop();
//        PauseSong();
//    }

    @Override
    public String getID() {
        return getArguments().getString("id");
    }

    private void PlaySong() {
        SpeakerModel model = mViewModel.getModel(this, getID()).getValue();

        if (songProgressTimer == null) {
            songProgressTimer = new SongTimer();

//            int progress = model.SongTimestamp;
//            int duration = model.SongDuration;
//            songProgressTimer.scheduleAtFixedRate(new SongTimerTask(progress, duration), 0, 1000);
        }

    }

    private void PauseSong() {
        if (songProgressTimer != null) {
            songProgressTimer.cancel();
            songProgressTimer = null;
        }
    }

    private void loadSong(SpeakerModel model) {
//        ((TextView) getView().findViewById(R.id.SpeakerSongDurationText))
//                .setText(String.format("%d%d:%d%d", (model.SongDuration / 60) / 10, (model.SongDuration / 60) % 10, (model.SongDuration % 60) / 10, (model.SongDuration % 60) % 10));
//        final TextView songName = getView().findViewById(R.id.SpeakerSongName);
//        songName.setSelected(true);
//        songName.setText(model.SongName);
//
//        ((TextView) getView().findViewById(R.id.SpeakerSongProgressText))
//                .setText(String.format("%d%d:%d%d", (model.SongTimestamp / 60) / 10, (model.SongTimestamp / 60) % 10, (model.SongTimestamp % 60) / 10, (model.SongTimestamp % 60) % 10));
//
//        if (model.playState == SpeakerModel.PlayState.Playing)
//            PlaySong();
//        else
//            PauseSong();
//
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
        public void scheduleAtFixedRate(TimerTask task, Date firstTime, long period) {
            if (!isRunning) {
                super.scheduleAtFixedRate(task, firstTime, period);
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
        private int progress = 0;
        private int timestamp;
        private int duration;


        public SongTimerTask(int progress, int duration) {
            this.timestamp = progress;
            this.duration = duration;
        }

        @Override
        public void run() {
            getActivity().runOnUiThread(() -> {
                ((TextView) getView().findViewById(R.id.SpeakerSongProgressText))
                        .setText(String
                                .format("%d%d:%d%d", (timestamp / 60) / 10, (timestamp / 60) % 10, (timestamp % 60) / 10, (timestamp % 60) % 10));

                double temp = timestamp;
                double temp2 = duration;
                progress = (timestamp - 0) * 100 / duration + 0;
                ((ProgressBar) getView().findViewById(R.id.SpeakerSongProgress)).setProgress(progress, true);
                timestamp++;

                if (progress > duration) {
                    mViewModel.nextSong();
                }
            });

        }
    }

}
