package com.ImanYarahmadi.car.data;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ImanYarahmadi.car.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.RvViewHolder> {

    private List<Car> cars;
    private Context context;

    public CarAdapter(List<Car> cars, Context context) {
        this.cars = cars;
        this.context = context;
    }

    @NonNull
    @Override
    public RvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RvViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RvViewHolder holder, int position) {
        holder.Bind(cars.get(position));
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class RvViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tvTitle;
        private TextView tvContent;

        public RvViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_main);
            tvTitle = itemView.findViewById(R.id.tv_main_title);
            tvContent = itemView.findViewById(R.id.tv_main_content);
        }

        public void Bind(Car car) {
            Picasso.get().load(car.getImage()).into(iv);
            tvTitle.setText(car.getTitle());
            tvContent.setText(car.getContent());
        }
    }
}
