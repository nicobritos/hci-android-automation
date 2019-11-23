package com.hci.StarkIndustries.ui.Miniatures.HouseRegionFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.data.Models.RegionModel;
import com.hci.StarkIndustries.ui.RecycleViewAdapters.RecyclerViewRoomsAdapter;

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

        mViewModel.getModel("").observe(this, new Observer<RegionModel>() {
            @Override
            public void onChanged(RegionModel regionModel) {
                if (regionModel.getRooms().size() != 0) {
                    ((RecyclerViewRoomsAdapter) ((RecyclerView) getView().findViewById(R.id.HouseRoomRecyclerView))
                            .getAdapter()).setData(regionModel.getRooms());
                    getView().findViewById(R.id.NoRoomsOnRegionView).setVisibility(View.GONE);

                } else {

                    getView().findViewById(R.id.NoRoomsOnRegionView).setVisibility(View.VISIBLE);

                }
            }
        });

    }

}
