package com.example.quangchien.one_day_love.adapter;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quangchien.one_day_love.R;
import com.example.quangchien.one_day_love.activity.chitiet;
import com.example.quangchien.one_day_love.model.Info_Nu;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class Info_Nu_adapter extends RecyclerView.Adapter<Info_Nu_adapter.Item> {
    Context context;
    ArrayList<Info_Nu> arrayInfo;

    public Info_Nu_adapter(Context context, ArrayList<Info_Nu> arrayInfo) {
        this.context = context;
        this.arrayInfo = arrayInfo;
    }

    @NonNull
    @Override
    public Item onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_info1,null);
        Item item = new Item(v);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull Item holder, int position) {
            Info_Nu info_nu = arrayInfo.get(position);
            holder.txtTen.setText(info_nu.getTen());
            holder.txtGia.setText(info_nu.getGia()+"đ/1h");
        Picasso.with(context).load(info_nu.getAvatar()).placeholder(R.drawable.love).error(R.drawable.er).into(holder.imgif);
    }

    @Override
    public int getItemCount() {
        return arrayInfo.size();
    }

    public class Item extends RecyclerView.ViewHolder{
        public ImageView imgif;
        public TextView txtTen,txtGia;

        public Item(View itemView) {
            super(itemView);
            imgif = (ImageView) itemView.findViewById(R.id.imgif);
            txtGia = itemView.findViewById(R.id.gia);
            txtTen =itemView.findViewById(R.id.ten);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showitem(getAdapterPosition());

                }
            });
        }
    }

    private void showitem(int position){
       Info_Nu infp = arrayInfo.get(position);
        Intent intent = new Intent(context, chitiet.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("thongtin",infp);
        context.startActivity(intent);


    }

}
