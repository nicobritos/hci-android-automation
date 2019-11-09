package com.hci.cardtest.ui.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hci.cardtest.Models.RoutineModel;
import com.hci.cardtest.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewRoutinesAdapter extends RecyclerView.Adapter<RecyclerViewRoutinesAdapter.ViewHolder> {

    private List<RoutineModel> routines = new ArrayList<>();
    private Context mContext;
    private static final String TAG = "RecyclerViewRoutinesAdapter";

    public RecyclerViewRoutinesAdapter(List<RoutineModel> routines, Context mContext) {
        this.routines = routines;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_routine_miniature,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Called");

        final RoutineModel model = routines.get(position);

        holder.name.setText(model.Name);
        holder.description.setText(model.Description);
        holder.playImage.setImageResource(R.drawable.ic_play_arrow_white_48dp);

        if(model.isFavorite)
            holder.favImage.setImageResource(R.drawable.ic_star_white_48dp);
        else
            holder.favImage.setImageResource(R.drawable.ic_star_black_24dp);

        holder.playImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Play routine
                Toast.makeText(mContext,"Running routine",Toast.LENGTH_LONG);
            }
        });

        holder.favImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageView imageView = (ImageView) v;

                if(model.isFavorite)
                    imageView.setImageResource(R.drawable.ic_star_black_24dp);
                else
                    imageView.setImageResource(R.drawable.ic_star_white_48dp);

                model.isFavorite = !model.isFavorite;
            }
        });


    }

    @Override
    public int getItemCount() {
        return routines.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView favImage;
        public ImageView playImage;
        public TextView name;
        public  TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.favImage = itemView.findViewById(R.id.FavRoutine);
            this.playImage = itemView.findViewById(R.id.PlayRoutine);
            this.name = itemView.findViewById(R.id.RoutineName);
            this.description = itemView.findViewById(R.id.RoutineDescription);
        }
    }
}
