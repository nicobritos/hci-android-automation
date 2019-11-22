package com.hci.StarkIndustries.ui.DeviceMenu.AC;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.data.Models.devices.DeviceModels.ACModel;
import com.hci.StarkIndustries.ui.DeviceMenu.IdentifiableFragment;

public class ACFragment extends IdentifiableFragment {
    private ACViewModel mViewModel;

    public static ACFragment newInstance() {
        return new ACFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.ac_fragment, container, false);

        final TextView tempView = root.findViewById(R.id.ACTemperatureView);

        final SeekBar tempSlider = root.findViewById(R.id.ACTemperatureSlider);

        tempSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tempView.setText(String.valueOf(ACModel.MIN_TEMPERATURE + progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mViewModel.setTemperature(ACModel.MIN_TEMPERATURE + seekBar.getProgress());
            }
        });

        final Spinner modeDDL = root.findViewById(R.id.ACModeDDL);
        modeDDL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // API
                mViewModel.selectMode(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final Spinner fanSpeedDDL = root.findViewById(R.id.ACFanSpeedDDL);
        fanSpeedDDL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mViewModel.selectFanSpeed(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final Spinner horizMovDDL = root.findViewById(R.id.ACHorizontalDDL);
        horizMovDDL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // API
                mViewModel.selectHorizontalMovement(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final Spinner vertMovDDL = root.findViewById(R.id.ACVerticalDDL);
        vertMovDDL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mViewModel.selectVerticalMovement(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Switch power = root.findViewById(R.id.ACPower);
        power.setOnCheckedChangeListener((buttonView, isChecked) -> mViewModel.setPower(isChecked));

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ACViewModel.class);

        mViewModel.getModel(this, getID()).observe(this, acModel -> {
            TextView tempView = getView().findViewById(R.id.ACTemperatureView);
            SeekBar tempSlider = getView().findViewById(R.id.ACTemperatureSlider);

            tempSlider.setProgress(acModel.getTemperature() - ACModel.MIN_TEMPERATURE, true);
            tempView.setText(String.valueOf(acModel.getTemperature()));

            Spinner modeDDL = getView().findViewById(R.id.ACModeDDL);
            modeDDL.setSelection(mViewModel.getModeInt(), true);

            Spinner fanSpeedDDL = getView().findViewById(R.id.ACFanSpeedDDL);
            fanSpeedDDL.setSelection(mViewModel.getFanSpeedInt(), true);

            Spinner horizMovDDL = getView().findViewById(R.id.ACHorizontalDDL);
            horizMovDDL.setSelection(mViewModel.getHorizontalSwingInt(), true);

            Spinner vertMovDDL = getView().findViewById(R.id.ACVerticalDDL);
            vertMovDDL.setSelection(mViewModel.getVerticalSwingInt(), true);

            Switch power = getView().findViewById(R.id.ACPower);
            power.setChecked(acModel.isPowered());

            ImageView imageView = getView().findViewById(R.id.ACImage);

            if (acModel.isPowered())
                imageView.setImageResource(R.drawable.ic_air_conditioner_on);
            else
                imageView.setImageResource(R.drawable.ic_air_conditioner_off);

            tempSlider.setEnabled(acModel.isPowered());
            fanSpeedDDL.setEnabled(acModel.isPowered());
            horizMovDDL.setEnabled(acModel.isPowered());
            modeDDL.setEnabled(acModel.isPowered());
            vertMovDDL.setEnabled(acModel.isPowered());
        });
    }
}
