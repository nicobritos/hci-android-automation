package com.hci.StartIndustries.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hci.StartIndustries.Models.CommonDeviceModel;
import com.hci.StartIndustries.Models.DeviceType;
import com.hci.StartIndustries.Models.RoutineModel;
import com.hci.StarkIndustries.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;

    private static final String TAG = "HomeFragment";

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initDevicesView();
        initRoutinesView();
    }



    private List<CommonDeviceModel> getModels(){
        List<CommonDeviceModel> models = new ArrayList<>();

        models.add(new CommonDeviceModel("Device 1","id1","ROOM1", DeviceType.Speaker));
        models.add(new CommonDeviceModel("Device 2","id1","ROOM1", DeviceType.Speaker));
        models.add(new CommonDeviceModel("Device 3","id1","ROOM1", DeviceType.Speaker));
        models.add(new CommonDeviceModel("Device 4","id1","ROOM1", DeviceType.Speaker));
        models.add(new CommonDeviceModel("Device 5","id1","ROOM1", DeviceType.Speaker));

        return models;
    }

    private List<RoutineModel> getRoutineModels(){
        List<RoutineModel> models = new ArrayList<>();

        models.add(new RoutineModel("Routine 1","Description 1"));
        models.add(new RoutineModel("Routine 2","Description 2"));
        models.add(new RoutineModel("Routine 3","Description 3"));
        models.add(new RoutineModel("Routine 4","Description 4"));


        return models;
    }

    private void initDevicesView(){
        Log.d(TAG, "initRecycleView: Init Recycle");

        GridLayoutManager layoutManager = new GridLayoutManager(this.getContext(),2,RecyclerView.HORIZONTAL,false);
        RecyclerView recyclerView =  getView().findViewById(R.id.RecyclerViewDevices);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewDevicesAdapter adapter = new RecyclerViewDevicesAdapter(this.getModels(),this.getContext());
        recyclerView.setAdapter(adapter);

    }
    private void initRoutinesView(){
        Log.d(TAG, "initRoutinesView: Init Recycle");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(),RecyclerView.VERTICAL,false);
        RecyclerView recyclerView =  getView().findViewById(R.id.RecyclerViewRoutines);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewRoutinesAdapter adapter = new RecyclerViewRoutinesAdapter(this.getRoutineModels(),this.getContext());
        recyclerView.setAdapter(adapter);

    }
}