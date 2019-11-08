package com.hci.cardtest.ui.DeviceMenu.Door;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.app.ActionBar.LayoutParams;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.ViewSwitcher;

import com.hci.cardtest.Models.DeviceModels.DoorModel;
import com.hci.cardtest.R;

public class DoorMenuFragment extends Fragment {

    private DoorMenuViewModel mViewModel;
    private static final String TAG = "DoorMenuFragment";

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

        openDoorButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
                mViewModel.getModel("").observe(getViewLifecycleOwner(), new Observer<DoorModel>() {
                    @Override
                    public void onChanged(DoorModel doorModel) {
                        if(!doorModel.islocked) {
                            if (isChecked) {
                                buttonView.setText(R.string.DoorButtonClose);
                                doorOpenSwitcher.setImageResource(R.drawable.ic_open_door);
                                mViewModel.open();

                            } else {
                                buttonView.setText(R.string.DoorButtonOpen);
                                mViewModel.close();
                                doorOpenSwitcher.setImageResource(R.drawable.ic_closed_door);
                            }
                            ((Switch)getView().findViewById(R.id.LockDoorBtn)).setEnabled(!isChecked);
                        }
                    }
                });
            }
        });

        Switch lockDoorButton = root.findViewById(R.id.LockDoorBtn);

        lockDoorButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
                mViewModel.getModel("").observe(getViewLifecycleOwner(), new Observer<DoorModel>() {
                    @Override
                    public void onChanged(DoorModel doorModel) {
                        if(!doorModel.isOpen) {
                            if (isChecked) {
                                buttonView.setText(R.string.DoorButtonUnlock);
                                mViewModel.lock();
                                doorLockSwitcher.setImageResource(R.drawable.ic_door_locked);
                            } else {
                                buttonView.setText(R.string.DoorButtonLock);
                                mViewModel.unlock();
                                doorLockSwitcher.setImageResource(R.drawable.ic_door_unlocked);
                            }
                            ((Switch)getView().findViewById(R.id.OpenDoorBtn)).setEnabled(!isChecked);
                        }
                    }
                });
            }
        });



        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DoorMenuViewModel.class);

        Log.d(TAG, "onActivityCreated: Por entrar al GetModel");

        mViewModel.getModel("").observe(this, new Observer<DoorModel>() {
            @Override
            public void onChanged(DoorModel doorModel) {
                Log.d(TAG, "onChanged: isOpen: "+doorModel.isOpen + " isLocked: " + doorModel.islocked);
                if(doorModel.isOpen) {
                    ((ImageView) getView().findViewById(R.id.IsDoorOpenImage)).setImageResource(R.drawable.ic_open_door);
                    ((Switch)getView().findViewById(R.id.OpenDoorBtn)).setText(R.string.DoorButtonClose);
                }
                else {
                    ((ImageView) getView().findViewById(R.id.IsDoorOpenImage)).setImageResource(R.drawable.ic_closed_door);
                    ((Switch)getView().findViewById(R.id.OpenDoorBtn)).setText(R.string.DoorButtonOpen);
                }

                if(doorModel.islocked) {
                    ((ImageView) getView().findViewById(R.id.isDoorLockedImage)).setImageResource(R.drawable.ic_door_locked);
                    ((Switch) getView().findViewById(R.id.LockDoorBtn)).setText(R.string.DoorButtonUnlock);
                }
                else {
                    ((ImageView) getView().findViewById(R.id.isDoorLockedImage)).setImageResource(R.drawable.ic_door_unlocked);
                    ((Switch) getView().findViewById(R.id.LockDoorBtn)).setText(R.string.DoorButtonLock);
                }
            }
        });
    }

}
