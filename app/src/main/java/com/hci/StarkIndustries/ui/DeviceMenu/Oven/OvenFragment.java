package com.hci.StarkIndustries.ui.DeviceMenu.Oven;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.data.Models.devices.DeviceModels.OvenModel;
import com.hci.StarkIndustries.ui.DeviceMenu.IdentifiableFragment;

public class OvenFragment extends IdentifiableFragment {
    private OvenViewModel mViewModel;

    public static OvenFragment newInstance() {
        return new OvenFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.oven_fragment, container, false);

        final TextView tempView = root.findViewById(R.id.OventTemperatureView);

        SeekBar temperatureSlider = root.findViewById(R.id.OvenTemperatureSlider);

        temperatureSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tempView.setText(String.valueOf(90 + progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mViewModel.setTemperature(seekBar.getProgress() + OvenModel.MIN_TEMPERATURE);
            }
        });

        Spinner heatSource = root.findViewById(R.id.OvenHeatSourceDDL);
        heatSource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mViewModel.setHeatSource(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Spinner grillMode = root.findViewById(R.id.OvenGrillDDL);
        grillMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mViewModel.setGrillMode(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Spinner convectionMode = root.findViewById(R.id.OvenConvectionDDL);
        convectionMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mViewModel.setConvectionMode(position);
                //BACKEND
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Switch power = root.findViewById(R.id.OvenPower);

        power.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mViewModel.setPower(isChecked);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OvenViewModel.class);
        // TODO: Use the ViewModel

        mViewModel.getModel(this, getID()).observe(this, ovenModel -> {
            SeekBar temperatureSlider = getView().findViewById(R.id.OvenTemperatureSlider);
            temperatureSlider.setProgress(ovenModel.getTemperature() - OvenModel.MIN_TEMPERATURE, true);
            temperatureSlider.setEnabled(ovenModel.isPowered());

            Spinner heatSource = getView().findViewById(R.id.OvenHeatSourceDDL);
            heatSource.setSelection(mViewModel.getHeatInt(), true);
            heatSource.setEnabled(ovenModel.isPowered());

            Spinner grillMode = getView().findViewById(R.id.OvenGrillDDL);
            grillMode.setSelection(mViewModel.getGrillInt(), true);
            grillMode.setEnabled(ovenModel.isPowered());

            Spinner convectionMode = getView().findViewById(R.id.OvenConvectionDDL);
            convectionMode.setSelection(mViewModel.getConvectionInt(), true);
            convectionMode.setEnabled(ovenModel.isPowered());

            TextView tempView = getView().findViewById(R.id.OventTemperatureView);
            tempView.setText(String.valueOf(ovenModel.getTemperature()));

            ImageView OvenImage = getView().findViewById(R.id.OvenImage);

            if (ovenModel.isPowered())
                OvenImage.setImageResource(R.drawable.ic_oven_on);
            else
                OvenImage.setImageResource(R.drawable.ic_oven_off);

            Switch power = getView().findViewById(R.id.OvenPower);
            power.setChecked(ovenModel.isPowered());
        });
    }
}
