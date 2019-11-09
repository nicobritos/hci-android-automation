package com.hci.StarkIndustries.ui.DeviceMenu.Lamp;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;

import com.hci.StarkIndustries.Models.DeviceModels.LampModel;
import com.hci.StarkIndustries.R;
import com.madrapps.pikolo.ColorPicker;
import com.madrapps.pikolo.RGBColorPicker;
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener;

public class LampFragment extends Fragment {

    private LampViewModel mViewModel;

    public static LampFragment newInstance() {
        return new LampFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.lamp_fragment, container, false);

        final ImageView imageView = root.findViewById(R.id.imageView);

        final SeekBar seekBar = root.findViewById(R.id.LampSeekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mViewModel.setIntensity(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        final Switch switch_ = root.findViewById(R.id.LampSwitch);
        switch_.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mViewModel.setEnabled(isChecked);
                seekBar.setEnabled(isChecked);

            }
        });

        final ColorPicker colorPicker = root.findViewById(R.id.colorPicker);
        colorPicker.setColorSelectionListener(new SimpleColorSelectionListener() {
            @Override
            public void onColorSelected(int color) {
                // Do whatever you want with the color

                if(switch_.isChecked()) {
                    imageView.getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
                    mViewModel.setColor(color);
                }else {
                    mViewModel.getModel("").observe(getViewLifecycleOwner(), new Observer<LampModel>() {
                        @Override
                        public void onChanged(LampModel lampModel) {
                            colorPicker.setColor(lampModel.color);
                        }
                    });

                }

            }
        });








        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LampViewModel.class);

        mViewModel.getModel("").observe(this, new Observer<LampModel>() {
            @Override
            public void onChanged(LampModel lampModel) {
                ((ImageView)getView().findViewById(R.id.imageView))
                        .getBackground()
                        .setColorFilter(lampModel.color, PorterDuff.Mode.MULTIPLY);

                ((Switch)getView().findViewById(R.id.LampSwitch)).setChecked(lampModel.isOn);

                ((SeekBar)getView().findViewById(R.id.LampSeekBar)).setProgress(lampModel.intensity);
                ((RGBColorPicker)getView().findViewById(R.id.colorPicker)).setColor(lampModel.color);

                if(lampModel.isOn){
                    ((SeekBar)getView().findViewById(R.id.LampSeekBar)).setEnabled(false);

                }
            }
        });
        // TODO: Use the ViewModel
    }

}
