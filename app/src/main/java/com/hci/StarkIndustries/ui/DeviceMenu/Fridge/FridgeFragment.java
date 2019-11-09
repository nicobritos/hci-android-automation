package com.hci.StarkIndustries.ui.DeviceMenu.Fridge;

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
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.hci.StarkIndustries.Models.DeviceModels.FridgeModel;
import com.hci.StarkIndustries.R;

public class FridgeFragment extends Fragment {

    private FridgeViewModel mViewModel;

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
                ((TextView)getView().findViewById(R.id.FridgeViewTemp)).setText(String.valueOf(2 +progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        SeekBar SliderFreezer = root.findViewById(R.id.FridgeSliderFreezer);

        SliderFreezer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ((TextView)getView().findViewById(R.id.FridgeViewFreezerTemp)).setText(String.valueOf(-20 +progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        Spinner ddl = root.findViewById(R.id.FridgeModeDDL);

        ddl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mViewModel.setMode(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });



        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FridgeViewModel.class);
        // TODO: Use the ViewModel

        mViewModel.getModel("").observe(this, new Observer<FridgeModel>() {
            @Override
            public void onChanged(FridgeModel fridgeModel) {

                ((Spinner)getView().findViewById(R.id.FridgeModeDDL)).setSelection(fridgeModel.mode,true);

                TextView text = getView().findViewById(R.id.FridgeViewTemp);
                text.setText(String.valueOf(fridgeModel.temperature));

                TextView text2 = (getView().findViewById(R.id.FridgeViewFreezerTemp));
                text2.setText(String.valueOf(fridgeModel.freezerTemperature));

                //SeekBar seekBar2 =(getView().findViewById(R.id.FridgeSliderFreezer));
                //seekBar2.setProgress(fridgeModel.freezerTemperature,true);

                //SeekBar seekBar1 = getView().findViewById(R.id.FridgeSlidierTemperature);
                //seekBar1.setProgress(fridgeModel.temperature,true);

            }
        });


    }

}

















