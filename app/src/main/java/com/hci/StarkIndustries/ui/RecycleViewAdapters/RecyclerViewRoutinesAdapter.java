package com.hci.StarkIndustries.ui.RecycleViewAdapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.hci.StarkIndustries.R;
import com.hci.StarkIndustries.data.Models.RoutineModel;
import com.hci.StarkIndustries.data.domain.RoutineRepository;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewRoutinesAdapter extends RecyclerView.Adapter<RecyclerViewRoutinesAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewRoutinesAdapter";

    private List<RoutineModel> routines = new ArrayList<>();
    private LifecycleOwner lifecycleOwner;
    private Context mContext;

    public RecyclerViewRoutinesAdapter(Context mContext, LifecycleOwner lifecycleOwner) {
        this.mContext = mContext;
        this.lifecycleOwner = lifecycleOwner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_routine_miniature, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Called");

        final RoutineModel model = routines.get(position);

        holder.name.setText(model.getName());
        holder.description.setText(model.getDescription());
        holder.playImage.setImageResource(R.drawable.ic_play_arrow_white_48dp);

        if (model.isFavourite())
            holder.favImage.setImageResource(R.drawable.ic_star_black_24dp);
        else
            holder.favImage.setImageResource(R.drawable.ic_star_white_48dp);

        holder.playImage.setOnClickListener(v -> {
            RoutineRepository.get().executeRoutine(model.getId());
            Toast.makeText(mContext, "Running routine", Toast.LENGTH_LONG);
        });

        holder.favImage.setOnClickListener(v -> {
            ImageView imageView = (ImageView) v;

            RoutineRepository
                    .get()
                    .setFavourite(model.getId(), model.toJSON(), !model.isFavourite())
                    .observe(this.lifecycleOwner, result -> {
                        if (result.ok() && result.getResult()) {
                            model.setFavourite(!model.isFavourite());
                            if (model.isFavourite())
                                imageView.setImageResource(R.drawable.ic_star_black_24dp);
                            else
                                imageView.setImageResource(R.drawable.ic_star_white_48dp);
                        } else {
                            Log.e(TAG, result.getError().getDescription().toString());
                        }
                    }
            );
        });
    }

    public void setData(List<RoutineModel> routines) {
        this.routines = routines;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return routines.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView favImage;
        public ImageView playImage;
        public TextView name;
        public TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.favImage = itemView.findViewById(R.id.FavRoutine);
            this.playImage = itemView.findViewById(R.id.PlayRoutine);
            this.name = itemView.findViewById(R.id.RoutineName);
            this.description = itemView.findViewById(R.id.RoutineDescription);
        }
    }
}
