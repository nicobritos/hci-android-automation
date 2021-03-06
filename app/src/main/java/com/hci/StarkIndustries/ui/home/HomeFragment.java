package com.hci.StarkIndustries.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.data.Models.RegionModel;
import com.hci.StarkIndustries.data.Models.Result;
import com.hci.StarkIndustries.ui.APIReloadingFragment;
import com.hci.StarkIndustries.ui.ChangeEndpointFragment;
import com.hci.StarkIndustries.ui.RecycleViewAdapters.IClickableItem;
import com.hci.StarkIndustries.ui.RecycleViewAdapters.RecyclerViewRegionsAdapter;

import java.util.ArrayList;

public class HomeFragment extends APIReloadingFragment implements IClickableItem {
    private static final String TAG = "HomeFragment";
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        RecyclerView recyclerView = root.findViewById(R.id.HouseRegionsRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewRegionsAdapter adapter = new RecyclerViewRegionsAdapter(this, this.getContext());
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel.getModel().observe(this, arrayListResult -> {
            RecyclerView recyclerView = getView().findViewById(R.id.HouseRegionsRecyclerView);

            if (arrayListResult.ok()) {
                ((RecyclerViewRegionsAdapter) recyclerView.getAdapter()).setData(arrayListResult.getResult());
                if (arrayListResult.getResult().size() == 0) {
                    getView().findViewById(R.id.NoRegionsView).setVisibility(View.VISIBLE);
                } else {
                    getView().findViewById(R.id.NoRegionsView).setVisibility(View.GONE);
                }
            } else {
                // TODO: ERROR
            }
        });
    }

    @Override
    public void onItemClick(String id) {
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        Bundle args = new Bundle();
        args.putString("id", id);
        navController.navigate(R.id.action_navigation_home_to_room, args);
    }


    @Override
    protected void reloadPage() {
        RecyclerView recyclerView = getView().findViewById(R.id.HouseRegionsRecyclerView);
        Result<ArrayList<RegionModel>> temp= homeViewModel.getModel().getValue();
        ArrayList<RegionModel> arr = new ArrayList<>();

        if(temp != null && temp.ok()) {
            arr = temp.getResult();
        }
        ((RecyclerViewRegionsAdapter) recyclerView.getAdapter()).setData(arr);

        if (arr.size() == 0) {
            getView().findViewById(R.id.NoRegionsView).setVisibility(View.VISIBLE);
        } else {
            getView().findViewById(R.id.NoRegionsView).setVisibility(View.GONE);
        }



    }
}