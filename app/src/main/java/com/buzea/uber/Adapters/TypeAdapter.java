package com.buzea.uber.Adapters;

import android.content.Context;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buzea.uber.Objects.LocationObject;
import com.buzea.uber.Objects.TypeObject;
import com.buzea.uber.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


/**
 * Adapter responsible for displaying type of cars in the CustomerActivity.class
 */

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.viewHolders> {

    private Context context;
    private TypeObject selectedItem;
    private List<TypeObject> itemArrayList;
    private ArrayList<Double> data;
    private LocationObject startLocation;

    private Location locationStart;
    private Location locationEnd;

    public TypeAdapter(List<TypeObject> itemArrayList, Context context, ArrayList<Double> data) {
        this.itemArrayList = itemArrayList;
        selectedItem = itemArrayList.get(0);
        this.context = context;
        this.data = data;
    }

    @NotNull
    @Override
    public TypeAdapter.viewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);
        return new viewHolders(layoutView);
    }

    /**
     * Bind view to holder, setting the text to
     * the design elements
     *
     * @param position - current position of the recyclerView
     */
    @Override
    public void onBindViewHolder(final @NonNull viewHolders holder, int position) {
        holder.mName.setText(itemArrayList.get(position).getName());
        holder.mPeople.setText(String.valueOf(itemArrayList.get(position).getPeople()));
        holder.mImage.setImageDrawable(itemArrayList.get(position).getImage());

        if (locationStart != null && locationEnd != null) {
            final float distance = locationStart.distanceTo(locationEnd) / 1000;
            final float inKm = distance / 1000;

            final double price = 12 + inKm * (itemArrayList.get(position).getId().equals("type_1") ? 2.5 : 3.5);
            holder.mPrice.setText(String.format("%.2f RON", price));
        }

        if (selectedItem.equals(itemArrayList.get(position))) {
            holder.mLayout.setBackgroundColor(context.getResources().getColor(R.color.lightGrey));
        } else {
            holder.mLayout.setBackgroundColor(context.getResources().getColor(R.color.white));
        }

        holder.mLayout.setOnClickListener(v -> {
            selectedItem = itemArrayList.get(holder.getAdapterPosition());
            notifyDataSetChanged();
        });

    }

    public TypeObject getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(TypeObject selectedItem) {
        this.selectedItem = selectedItem;
    }

    @Override
    public int getItemCount() {
        return this.itemArrayList.size();
    }


    public void setData(ArrayList<Double> data) {
        this.data = data;

        locationEnd = new Location("");
        locationEnd.setLatitude(data.get(0));
        locationEnd.setLongitude(data.get(1));
    }

    public void setLocation(LocationObject location) {
        this.startLocation = location;

        locationStart = new Location("");
        locationStart.setLatitude(location.getCoordinates().latitude);
        locationStart.setLongitude(location.getCoordinates().longitude);
    }

    /**
     * Responsible for handling the data of each view
     */
    static class viewHolders extends RecyclerView.ViewHolder {

        TextView mName;
        TextView mPeople;
        ImageView mImage;
        TextView mPrice;
        LinearLayout mLayout;

        viewHolders(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mPeople = itemView.findViewById(R.id.people);
            mName = itemView.findViewById(R.id.name);
            mPrice = itemView.findViewById(R.id.price);
            mLayout = itemView.findViewById(R.id.layout);
        }
    }
}