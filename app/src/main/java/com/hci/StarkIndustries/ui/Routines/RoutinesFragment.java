package com.hci.StarkIndustries.ui.Routines;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.hci.StarkIndustries.MainActivity;
import com.hci.StarkIndustries.Models.CommonDeviceModel;
import com.hci.StarkIndustries.Models.DeviceType;
import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceMenuContainerFragment;

public class RoutinesFragment extends Fragment {

    private static final String TAG = "RoutinesFragment";

    private RoutinesViewModel routinesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        routinesViewModel =
                ViewModelProviders.of(this).get(RoutinesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_routines, container, false);

        Button btn = root.findViewById(R.id.BotonAbrir);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CommonDeviceModel dev = new CommonDeviceModel("NOMBRE","123","RRRR", DeviceType.Lamp);

                DeviceMenuContainerFragment containerFragment = DeviceMenuContainerFragment.newInstance(dev);
                containerFragment.show(getFragmentManager(),"dialog");



            }
        });

        Button btn2 = root.findViewById(R.id.BotonAbrir2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonDeviceModel dev = new CommonDeviceModel("NOMBRE","123","RRRR", DeviceType.AC);

                DeviceMenuContainerFragment containerFragment = DeviceMenuContainerFragment.newInstance(dev);
                containerFragment.show(getFragmentManager(),"dialog");


            }
        });

        Button btn3 = root.findViewById(R.id.BotonCerrar);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();


                fragmentManager.popBackStack();




            }
        });




        return root;
    }
}