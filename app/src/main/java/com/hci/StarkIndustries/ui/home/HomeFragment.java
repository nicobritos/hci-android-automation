package com.hci.StarkIndustries.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hci.StarkIndustries.Models.CommonDeviceModel;
import com.hci.StarkIndustries.Models.DeviceType;
import com.hci.StarkIndustries.Models.RegionModel;
import com.hci.StarkIndustries.Models.RoutineModel;
import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.ui.RecycleViewAdapters.RecyclerViewDevicesAdapter;
import com.hci.StarkIndustries.ui.RecycleViewAdapters.RecyclerViewRegionsAdapter;
import com.hci.StarkIndustries.ui.RecycleViewAdapters.RecyclerViewRoutinesAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment  {
    private HomeViewModel homeViewModel;

    private static final String TAG = "HomeFragment";

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL,false);
        RecyclerView recyclerView =  root.findViewById(R.id.HouseRegionsRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewRegionsAdapter adapter = new RecyclerViewRegionsAdapter(this.getContext());
        recyclerView.setAdapter(adapter);

        return root;
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel.getModels().observe(this, new Observer<List<RegionModel>>() {
            @Override
            public void onChanged(List<RegionModel> regionModels) {
                ((RecyclerViewRegionsAdapter) ((RecyclerView)getView().findViewById(R.id.HouseRegionsRecyclerView))
                        .getAdapter()).setData(regionModels);
            }
        });

    }


}