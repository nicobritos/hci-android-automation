package com.hci.StarkIndustries.ui.Miniatures;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hci.StarkIndustries.Models.RoutineModel;
import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.ui.RecycleViewAdapters.RecyclerViewRoutinesAdapter;

import java.util.ArrayList;
import java.util.List;

public class RoutinesListFragment extends Fragment {

    private RoutinesListViewModel mViewModel;

    public static RoutinesListFragment newInstance() {
        return new RoutinesListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.routines_list_fragment, container, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL,false);
        RecyclerView recyclerView =  view.findViewById(R.id.RecyclerViewRoutines);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewRoutinesAdapter adapter = new RecyclerViewRoutinesAdapter(this.getRoutineModels(),this.getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RoutinesListViewModel.class);
        // TODO: Use the ViewModel
    }

    private List<RoutineModel> getRoutineModels(){
        List<RoutineModel> models = new ArrayList<>();

        models.add(new RoutineModel("Routine 1","Description 1"));
        models.add(new RoutineModel("Routine 2","Description 2"));
        models.add(new RoutineModel("Routine 3","Description 3"));
        models.add(new RoutineModel("Routine 4","Description 4"));


        return models;
    }


}
