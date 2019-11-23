package com.hci.StarkIndustries.ui.DeviceMenu.Lamp;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.data.Models.devices.DeviceModels.LampModel;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceViewModel;
import com.madrapps.pikolo.ColorPicker;
import com.madrapps.pikolo.RGBColorPicker;
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener;

public class LampFragment extends DeviceFragment {
    private LampViewModel mViewModel;

    public static LampFragment newInstance() {
        return new LampFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.lamp_fragment, container, false);

        final ImageView imageView = root.findViewById(R.id.imageView);

        final SeekBar seekBar = root.findViewById(R.id.LampSeekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mViewModel.setIntensity(seekBar.getProgress());
            }
        });

        final Switch switch_ = root.findViewById(R.id.LampSwitch);
        switch_.setOnCheckedChangeListener((buttonView, isChecked) -> mViewModel.setEnabled(isChecked));

        final ColorPicker colorPicker = root.findViewById(R.id.colorPicker);
        colorPicker.setColorSelectionListener(new SimpleColorSelectionListener() {
            @Override
            public void onColorSelected(int color) {
                // Do whatever you want with the color

                if (switch_.isChecked()) {
                    imageView.getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
                    mViewModel.setColor(color);
                } else {
                    LampModel model = mViewModel.getModel(LampFragment.this, getID()).getValue();
                    imageView.getBackground().setColorFilter(model.getColorInt(), PorterDuff.Mode.MULTIPLY);
                    colorPicker.setColor(model.getColorInt());
                }
            }
        });

        imageView.getBackground().setColorFilter(colorPicker.getSolidColor(), PorterDuff.Mode.MULTIPLY);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LampViewModel.class);

        mViewModel.getModel(this, getID()).observe(this, lampModel -> {
            getView().findViewById(R.id.LampSeekBar).setEnabled(lampModel.isPowered());

            ((Switch) getView().findViewById(R.id.LampSwitch)).setChecked(lampModel.isPowered());

            ((SeekBar) getView().findViewById(R.id.LampSeekBar)).setProgress(lampModel.getBrightness());

            ((RGBColorPicker) getView().findViewById(R.id.colorPicker)).setColor(lampModel.getColorInt());

            getView().findViewById(R.id.imageView).getBackground().setTint(lampModel.getColorInt());
        });
    }

    @Override
    public DeviceViewModel getViewModel() {
        return this.mViewModel;
    }
}
