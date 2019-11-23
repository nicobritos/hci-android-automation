package com.hci.StarkIndustries.ui.RecycleViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.data.Models.RegionModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewRegionsAdapter extends RecyclerView.Adapter<RecyclerViewRegionsAdapter.ViewHolder> {
    private List<RegionModel> regions = new ArrayList<>();
    private IClickableItem iClickableItem;
    private Context mContext;

    public RecyclerViewRegionsAdapter(IClickableItem iClickableItem, Context mContext) {
        this.mContext = mContext;
        this.iClickableItem = iClickableItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_region_miniature, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RegionModel region = regions.get(position);

        holder.regionName.setText(region.getName());

        GridLayoutManager layoutManager = new GridLayoutManager(holder.recyclerView.getContext(), 2, RecyclerView.HORIZONTAL, false);
        holder.recyclerView.setLayoutManager(layoutManager);
        RecyclerViewRoomsAdapter adapter = new RecyclerViewRoomsAdapter(holder.recyclerView.getContext(), iClickableItem);
        adapter.setData(region.getRooms());
        holder.recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return regions.size();
    }

    public void setData(List<RegionModel> regions) {
        this.regions = regions;

        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView regionName;
        public RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            regionName = itemView.findViewById(R.id.RegionName);
            recyclerView = itemView.findViewById(R.id.HouseRoomRecyclerView);
        }
    }
}
