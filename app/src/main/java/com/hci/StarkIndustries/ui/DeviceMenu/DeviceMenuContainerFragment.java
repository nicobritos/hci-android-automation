package com.hci.StarkIndustries.ui.DeviceMenu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.hci.StarkIndustries.MainActivity;
import com.hci.StarkIndustries.Models.CommonDeviceModel;
import com.hci.StarkIndustries.Models.DeviceModels.SpeakerModel;
import com.hci.StarkIndustries.Models.DeviceType;
import com.hci.StarkIndustries.R;
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

    protected DeviceMenuContainerFragment(){}

    public static DeviceMenuContainerFragment newInstance(CommonDeviceModel deviceModel) {
        Bundle args = new Bundle();
        args.putParcelable("device", deviceModel);
        args.putString("deviceType", deviceModel.type.name());

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
        ft.replace(R.id.fragmentContainer123,fragment );
        ft.commit();

        CommonDeviceModel model = getArguments().getParcelable("device");

        // Sets name of the device
        TextView nameText = view.findViewById(R.id.DeviceName);
        nameText.setText(model.Name);

        // Sets controllers of the view (Mostly returns)
        ImageButton backButton = view.findViewById(R.id.GoBackDeviceMenuBtn);
        backButton.setOnClickListener(new OnClickExitDialog());


        ImageButton favoriteButton = view.findViewById(R.id.ContainerFavButton);
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Marcar como favorito
            }
        });



        return view;
    }

    private Fragment getCorrectFragment() {
        DeviceType type = DeviceType.valueOf(getArguments().getString("deviceType"));
        CommonDeviceModel model = getArguments().getParcelable("device");

        MainActivity act = (MainActivity) getActivity();
        IPassableID fragment = null;

        switch (type){
            case AC:
                fragment = act.getFragment("AC");
                break;
            case Door:
                fragment = act.getFragment("Door");
                break;
            case Curtains:
                fragment = act.getFragment("Curtains");
                break;
            case Lamp:
                fragment =  act.getFragment("Lamp");
                break;
            case Fridge:
                fragment = act.getFragment("Fridge");
                break;
            case Oven:
                fragment = act.getFragment("Oven");
                break;
            case Speaker:
                fragment =  act.getFragment("Speaker");
                break;
        }

        if(fragment != null){
            fragment.setID(model.Id);
        }

        return (Fragment) fragment;

    }



    private class OnClickExitDialog implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            getDialog().cancel();
        }
    }
}





