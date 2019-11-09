package com.hci.StarkIndustries.ui.DeviceMenu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.ui.DeviceMenu.Curtains.CurtainsFragment;

public class DeviceMenuContainerFragment extends Fragment {

    private static final String TAG = "DeviceMenuContainerFrag";

    private DeviceMenuContainerViewModel viewModel;

    public DeviceMenuContainerFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(DeviceMenuContainerViewModel.class);

        View root = inflater.inflate(R.layout.fragment_device_menu_container, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton backButton =  view.findViewById(R.id.GoBackDeviceMenuBtn);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Volviendo para atras");
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.popBackStackImmediate();
            }
        });

        DisplayFragment();
    }

    public static DeviceMenuContainerFragment newInstance() {

        Bundle args = new Bundle();

        DeviceMenuContainerFragment fragment = new DeviceMenuContainerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void DisplayFragment(){

        Fragment fragment = CurtainsFragment.newInstance();

        // Get the FragmentManager and start a transaction.
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        // Add the SimpleFragment.
        fragmentTransaction.add(R.id.fragmentContainer, fragment).addToBackStack(null).commit();



    }
}
