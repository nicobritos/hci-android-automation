package com.hci.StarkIndustries.ui.RecycleViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.data.Models.RoomModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewRoomsAdapter extends RecyclerView.Adapter<RecyclerViewRoomsAdapter.ViewHolder> {

    private List<RoomModel> rooms = new ArrayList<>();
    private Context mContext;
    private IClickableItem clickableItem;

    public RecyclerViewRoomsAdapter(Context mContext, IClickableItem inter) {
        this.mContext = mContext;
        clickableItem = inter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_room_miniature, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        RoomModel room = rooms.get(position);

//        holder.name.setText(room.name);

    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    public void setData(List<RoomModel> rooms) {
        this.rooms = rooms;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.RoomName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clickableItem.onItemClick(rooms.get(getAdapterPosition()).getId());

                }
            });
        }
    }
}
