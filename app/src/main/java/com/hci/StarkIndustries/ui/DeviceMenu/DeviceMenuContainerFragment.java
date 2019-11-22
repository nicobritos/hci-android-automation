package com.hci.StarkIndustries.ui.DeviceMenu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.data.Models.devices.CommonDeviceModel;
import com.hci.StarkIndustries.data.Models.devices.DeviceTypeEnum;
import com.hci.StarkIndustries.ui.DeviceMenu.AC.ACFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.Curtains.CurtainsFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.Door.DoorMenuFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.Fridge.FridgeFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.Lamp.LampFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.Oven.OvenFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.Speaker.SpeakerFragment;

public class DeviceMenuContainerFragment extends DialogFragment {

    private static final String TAG = "DeviceMenuContainerFrag";

    private DeviceMenuContainerViewModel viewModel;

    public static DeviceMenuContainerFragment newInstance(CommonDeviceModel deviceModel) {
        Bundle args = new Bundle();
        args.putString("deviceId", deviceModel.getId());
        args.putString("deviceType", deviceModel.getDeviceType().toString());
        args.putString("deviceName", deviceModel.getName());

        DeviceMenuContainerFragment f = new DeviceMenuContainerFragment();
        f.setArguments(args);
        return f;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Sets view size
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_device_menu_container, null);

        // Sets view of the device
        Fragment fragment = getCorrectFragment();
        FragmentTransaction ft = this.getChildFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainer123, fragment);
        ft.commit();

        String name = getArguments().getString("deviceName");

        // Sets name of the device
        TextView nameText = view.findViewById(R.id.DeviceName);
        nameText.setText(name);

        // Sets controllers of the view (Mostly returns)
        ImageButton backButton = view.findViewById(R.id.GoBackDeviceMenuBtn);
        backButton.setOnClickListener(new OnClickExitDialog());


        ImageButton favoriteButton = view.findViewById(R.id.ContainerFavButton);
        favoriteButton.setOnClickListener(v -> {
            // Marcar como favorito
        });

        return view;
    }

    private Fragment getCorrectFragment() {
        IdentifiableFragment fragment;
        switch (DeviceTypeEnum.valueOf(getArguments().getString("deviceType"))) {
            case AC:
                fragment = ACFragment.newInstance();
                break;
            case Door:
                fragment = DoorMenuFragment.newInstance();
                break;
            case Curtains:
                fragment = CurtainsFragment.newInstance();
                break;
            case Lamp:
                fragment = LampFragment.newInstance();
                break;
            case Fridge:
                fragment = FridgeFragment.newInstance();
                break;
            case Oven:
                fragment = OvenFragment.newInstance();
                break;
            case Speaker:
                fragment = SpeakerFragment.newInstance();
                break;
            default:
                Log.d(TAG, "getCorrectFragment: FRAGMENT NOT FOUND");
                return null;
        }

        fragment.setID(getArguments().getString("deviceId"));
        return fragment;
    }


    private class OnClickExitDialog implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            getDialog().cancel();
        }
    }
}





