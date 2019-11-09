package com.hci.StartIndustries.ui.DeviceMenu.Oven;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

import com.hci.StarkIndustries.R;
import com.hci.StartIndustries.Models.DeviceModels.OvenModel;

public class OvenFragment extends Fragment {

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
                // BACKEND
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        Spinner heatSource = root.findViewById(R.id.OvenHeatSourceDDL);
        heatSource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // BACK END
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        Spinner grillMode = root.findViewById(R.id.OvenGrillDDL);
        grillMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // BACKEND
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        Spinner convectionMode = root.findViewById(R.id.OvenConvectionDDL);
        convectionMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //BACKEND
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        Switch power = root.findViewById(R.id.OvenPower);

        power.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // BACKEND
                SeekBar temperatureSlider = getView().findViewById(R.id.OvenTemperatureSlider);
                temperatureSlider.setEnabled(isChecked);

                Spinner heatSource = getView().findViewById(R.id.OvenHeatSourceDDL);
                heatSource.setEnabled(isChecked);

                Spinner grillMode = getView().findViewById(R.id.OvenGrillDDL);
                grillMode.setEnabled(isChecked);

                Spinner convectionMode = getView().findViewById(R.id.OvenConvectionDDL);
                convectionMode.setEnabled(isChecked);

                ImageView OvenImage = getView().findViewById(R.id.OvenImage);

                if(isChecked)
                    OvenImage.setImageResource(R.drawable.ic_oven_on);
                else
                    OvenImage.setImageResource(R.drawable.ic_oven_off);
            }
        });


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OvenViewModel.class);
        // TODO: Use the ViewModel


        mViewModel.getModel("id").observe(this, new Observer<OvenModel>() {
            @Override
            public void onChanged(OvenModel ovenModel) {

                SeekBar temperatureSlider = getView().findViewById(R.id.OvenTemperatureSlider);
                temperatureSlider.setProgress(ovenModel.temperature-90,true);

                Spinner heatSource = getView().findViewById(R.id.OvenHeatSourceDDL);
                heatSource.setSelection(ovenModel.heatSource,true);

                Spinner grillMode = getView().findViewById(R.id.OvenGrillDDL);
                grillMode.setSelection(ovenModel.grillMode,true);

                Spinner convectionMode = getView().findViewById(R.id.OvenConvectionDDL);
                convectionMode.setSelection(ovenModel.convectionMode,true);

                TextView tempView = getView().findViewById(R.id.OventTemperatureView);
                tempView.setText(String.valueOf(ovenModel.temperature));

                ImageView OvenImage = getView().findViewById(R.id.OvenImage);

                if(ovenModel.isOn)
                    OvenImage.setImageResource(R.drawable.ic_oven_on);
                else
                    OvenImage.setImageResource(R.drawable.ic_oven_off);


                Switch power = getView().findViewById(R.id.OvenPower);
                power.setChecked(ovenModel.isOn);




            }
        });

    }

}
