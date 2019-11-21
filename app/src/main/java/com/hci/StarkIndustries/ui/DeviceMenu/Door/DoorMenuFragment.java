package com.hci.StarkIndustries.ui.DeviceMenu.Door;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.data.Models.devices.DeviceModels.DoorModel;

public class DoorMenuFragment extends Fragment {

    private DoorMenuViewModel mViewModel;
    private static final String TAG = "DoorMenuFragment";

    protected DoorMenuFragment() {
    }

    public static DoorMenuFragment newInstance(String id) {

        DoorMenuFragment f = new DoorMenuFragment();
        Bundle args = new Bundle();
        args.putString("id", id);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.door_menu_fragment, container, false);


        final ImageView doorOpenSwitcher = root.findViewById(R.id.IsDoorOpenImage);

        final ImageView doorLockSwitcher = root.findViewById(R.id.isDoorLockedImage);

        Switch openDoorButton = root.findViewById(R.id.OpenDoorBtn);

        openDoorButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
                if (isChecked)
                    mViewModel.open();
                else
                    mViewModel.close();
            }
        });

        Switch lockDoorButton = root.findViewById(R.id.LockDoorBtn);

        lockDoorButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
                if (isChecked)
                    mViewModel.lock();
                else
                    mViewModel.unlock();
            }
        });


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DoorMenuViewModel.class);

        Log.d(TAG, "onActivityCreated: Por entrar al GetModel");

        mViewModel.getModel(getID()).observe(this, doorModel -> {
            Log.d(TAG, "onChanged: isOpen: " + doorModel.isOpen() + " isLocked: " + doorModel.isLocked());
            if (doorModel.isOpen()) {
                ((ImageView) getView().findViewById(R.id.IsDoorOpenImage)).setImageResource(R.drawable.ic_open_door);
                ((Switch) getView().findViewById(R.id.OpenDoorBtn)).setText(R.string.DoorButtonClose);

            } else {
                ((ImageView) getView().findViewById(R.id.IsDoorOpenImage)).setImageResource(R.drawable.ic_closed_door);
                ((Switch) getView().findViewById(R.id.OpenDoorBtn)).setText(R.string.DoorButtonOpen);
            }
            getView().findViewById(R.id.LockDoorBtn).setEnabled(!doorModel.isOpen());

            if (doorModel.isLocked()) {
                ((ImageView) getView().findViewById(R.id.isDoorLockedImage)).setImageResource(R.drawable.ic_door_locked);
                ((Switch) getView().findViewById(R.id.LockDoorBtn)).setText(R.string.DoorButtonUnlock);
            } else {
                ((ImageView) getView().findViewById(R.id.isDoorLockedImage)).setImageResource(R.drawable.ic_door_unlocked);
                ((Switch) getView().findViewById(R.id.LockDoorBtn)).setText(R.string.DoorButtonLock);
            }
            getView().findViewById(R.id.OpenDoorBtn).setEnabled(!doorModel.isLocked());

        });
    }

    private String getID() {
        return getArguments().getString("id");
    }


}
