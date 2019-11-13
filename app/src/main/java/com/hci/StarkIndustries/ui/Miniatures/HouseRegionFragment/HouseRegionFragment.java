package com.hci.StarkIndustries.ui.Miniatures.HouseRegionFragment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hci.StarkIndustries.R;

public class HouseRegionFragment extends Fragment {

    private HouseRegionViewModel mViewModel;

    public static HouseRegionFragment newInstance() {
        return new HouseRegionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.house_region_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HouseRegionViewModel.class);
        // TODO: Use the ViewModel
    }

}
