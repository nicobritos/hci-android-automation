package com.hci.StarkIndustries.ui.RecycleViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hci.StarkIndustries.data.Models.RoomModel;
import com.hci.StarkIndustries.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewRoomsAdapter extends RecyclerView.Adapter<RecyclerViewRoomsAdapter.ViewHolder> {

    private List<RoomModel> rooms = new ArrayList<>();
    private Context mContext;

    public RecyclerViewRoomsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // CAMBIAR
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_device_miniature,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    public void setData(List<RoomModel>rooms){
        this.rooms = rooms;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
