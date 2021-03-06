package com.hci.StarkIndustries.ui.DeviceMenu.Fridge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.data.Models.devices.DeviceModels.FridgeModel;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceViewModel;

public class FridgeFragment extends DeviceFragment {
    private FridgeViewModel mViewModel;
    private boolean loaded;

    public static FridgeFragment newInstance() {
        return new FridgeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(com.hci.StarkIndustries.R.layout.fridge_fragment, container, false);

        SeekBar SliderTemp = root.findViewById(R.id.FridgeSlidierTemperature);
        SliderTemp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (loaded)
                    ((TextView) getView().findViewById(R.id.FridgeViewTemp)).setText(String.valueOf(FridgeModel.MIN_TEMPERATURE + progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (loaded)
                    mViewModel.setTemperature(seekBar.getProgress());
            }
        });

        SeekBar SliderFreezer = root.findViewById(R.id.FridgeSliderFreezer);
        SliderFreezer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (loaded)
                    ((TextView) getView().findViewById(R.id.FridgeViewFreezerTemp)).setText(String.valueOf(FridgeModel.MIN_FREEZER_TEMPERATURE + progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (loaded)
                    mViewModel.setFreezerTemperature(seekBar.getProgress());
            }
        });

        Spinner ddl = root.findViewById(R.id.FridgeModeDDL);
        ddl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (loaded)
                    mViewModel.setMode(position);
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
        mViewModel = ViewModelProviders.of(this).get(FridgeViewModel.class);

        mViewModel.getModel(this, getID()).observe(this, fridgeModel -> {
            ((Spinner) getView().findViewById(R.id.FridgeModeDDL)).setSelection(mViewModel.getModeInt(), true);

            TextView text = getView().findViewById(R.id.FridgeViewTemp);
            text.setText(String.valueOf(fridgeModel.getTemperature()));

            TextView text2 = (getView().findViewById(R.id.FridgeViewFreezerTemp));
            text2.setText(String.valueOf(fridgeModel.getFreezerTemperature()));

            SeekBar seekBar2 = (getView().findViewById(R.id.FridgeSliderFreezer));
            seekBar2.setProgress(fridgeModel.getFreezerTemperature() - FridgeModel.MIN_FREEZER_TEMPERATURE, true);

            SeekBar seekBar1 = getView().findViewById(R.id.FridgeSlidierTemperature);
            seekBar1.setProgress(fridgeModel.getTemperature() - FridgeModel.MIN_TEMPERATURE, true);

            if (!loaded)
                loaded = true;
        });
    }

    @Override
    public DeviceViewModel getViewModel() {
        return this.mViewModel;
    }
}
