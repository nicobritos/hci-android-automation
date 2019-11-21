package com.hci.StarkIndustries.ui.Miniatures.FavoriteRoutines;

import androidx.lifecycle.ViewModelProviders;

import com.hci.StarkIndustries.ui.Miniatures.Routines.RoutinesListFragment;

public class FavoriteRoutinesListFragment extends RoutinesListFragment {
    public void LoadViewModel() {
        mViewModel = ViewModelProviders.of(this).get(FavoriteRoutinesListViewModel.class);
    }
}
