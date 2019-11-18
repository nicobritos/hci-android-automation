package com.hci.StarkIndustries.ui.DeviceMenu.AC;

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

import com.hci.StarkIndustries.Models.DeviceModels.ACModel;
import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.ui.DeviceMenu.IPassableID;

public class ACFragment extends Fragment implements IPassableID {

    private AcViewModel mViewModel;
    private String id = "";

    protected ACFragment(){}

    public static ACFragment newInstance() {
        ACFragment f = new ACFragment();

        return f;
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
                tempView.setText(String.valueOf(18 + progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mViewModel.setTemperature(18 + seekBar.getProgress());
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
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        final Spinner fanSpeedDDL = root.findViewById(R.id.ACFanSpeedDDL);
        fanSpeedDDL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mViewModel.selectFanSpeed(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        final Spinner horizMovDDL = root.findViewById(R.id.ACHorizontalDDL);
        horizMovDDL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // API
                mViewModel.selectHorizontalMovement(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        final Spinner vertMovDDL = root.findViewById(R.id.ACVerticalDDL);
        vertMovDDL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mViewModel.selectVerticalMovement(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        Switch power = root.findViewById(R.id.ACPower);
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
        mViewModel = ViewModelProviders.of(this).get(AcViewModel.class);

        mViewModel.getModel(getID()).observe(this, new Observer<ACModel>() {
            @Override
            public void onChanged(ACModel acModel) {

                TextView tempView = getView().findViewById(R.id.ACTemperatureView);
                SeekBar tempSlider = getView().findViewById(R.id.ACTemperatureSlider);

                tempSlider.setProgress(acModel.temperature-18,true);
                tempView.setText(String.valueOf(acModel.temperature));

                Spinner modeDDL = getView().findViewById(R.id.ACModeDDL);
                modeDDL.setSelection(acModel.mode,true);

                Spinner fanSpeedDDL = getView().findViewById(R.id.ACFanSpeedDDL);
                fanSpeedDDL.setSelection(acModel.fanSpeed,true);

                Spinner horizMovDDL = getView().findViewById(R.id.ACHorizontalDDL);
                horizMovDDL.setSelection(acModel.horizontalMov,true);

                Spinner vertMovDDL = getView().findViewById(R.id.ACVerticalDDL);
                vertMovDDL.setSelection(acModel.verticalMov,true);

                Switch power = getView().findViewById(R.id.ACPower);
                power.setChecked(acModel.power);

                ImageView imageView = getView().findViewById(R.id.ACImage);

                if(acModel.power)
                    imageView.setImageResource(R.drawable.ic_air_conditioner_on);
                else
                    imageView.setImageResource(R.drawable.ic_air_conditioner_off);

                tempSlider.setEnabled(acModel.power);
                fanSpeedDDL.setEnabled(acModel.power);
                horizMovDDL.setEnabled(acModel.power);
                modeDDL.setEnabled(acModel.power);
                vertMovDDL.setEnabled(acModel.power);

            }
        });



    }


    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public void setID(String id) {
        this.id = id;
    }
}
