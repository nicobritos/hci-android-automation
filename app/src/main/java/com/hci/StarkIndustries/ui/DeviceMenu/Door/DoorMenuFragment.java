package com.hci.StarkIndustries.ui.DeviceMenu.Door;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceViewModel;

public class DoorMenuFragment extends DeviceFragment {
    private static final String TAG = "DoorMenuFragment";
    private DoorMenuViewModel mViewModel;

    public static DoorMenuFragment newInstance() {
        return new DoorMenuFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.door_menu_fragment, container, false);

        final ImageView doorOpenSwitcher = root.findViewById(R.id.IsDoorOpenImage);
        final ImageView doorLockSwitcher = root.findViewById(R.id.isDoorLockedImage);

        Switch openDoorButton = root.findViewById(R.id.OpenDoorBtn);

        openDoorButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                mViewModel.open();
            else
                mViewModel.close();
        });

        Switch lockDoorButton = root.findViewById(R.id.LockDoorBtn);

        lockDoorButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                mViewModel.lock();
            else
                mViewModel.unlock();
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DoorMenuViewModel.class);

        Log.d(TAG, "onActivityCreated: Por entrar al GetModel");

        mViewModel.getModel(this, getID()).observe(this, doorModel -> {
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

    @Override
    public DeviceViewModel getViewModel() {
        return this.mViewModel;
    }
}
