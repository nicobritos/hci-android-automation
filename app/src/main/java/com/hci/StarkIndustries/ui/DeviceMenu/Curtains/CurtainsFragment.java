package com.hci.StarkIndustries.ui.DeviceMenu.Curtains;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceFragment;
import com.hci.StarkIndustries.ui.DeviceMenu.DeviceViewModel;

public class CurtainsFragment extends DeviceFragment {
    private CurtainsViewModel viewModel;

    public static CurtainsFragment newInstance() {
        return new CurtainsFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this).get(CurtainsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_courtains_menu, container, false);
        Button button = root.findViewById(R.id.curtainsButton);
        button.setOnClickListener(v -> viewModel.toggleState());

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CurtainsViewModel model = ViewModelProviders.of(this).get(CurtainsViewModel.class);
        model.getModel(this, getID()).observe(this, curtainsModel -> {
            Button button = getView().findViewById(R.id.curtainsButton);
            ImageView image = getView().findViewById(R.id.curtainsImage);

            if (curtainsModel.isOpen()) {
                image.setImageResource(R.drawable.ic_curtain_open);
                button.setText(R.string.CourtainsButtonClose);
            } else {
                image.setImageResource(R.drawable.ic_curtain_closed);
                button.setText(R.string.CourtainsButtonOpen);
            }
        });
    }

    @Override
    public DeviceViewModel getViewModel() {
        return this.viewModel;
    }
}
