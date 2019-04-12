package com.example.quangchien.one_day_love.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quangchien.one_day_love.R;
import com.example.quangchien.one_day_love.model.Info_Nu;
import com.squareup.picasso.Picasso;

public class chitiet extends AppCompatActivity {
    ImageView avatar,hinh1,hinh2,hinh3;
    TextView ten,gt,ns,dc,gia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet);
        anhxa();
        getData();

    }


    private void getData() {
        String avata_d ="";
        String hinh1_d="";
        String hinh2_d="";
        String hinh3_d="";
        String ten_d="";
        String gt_d ="";
        String gia_d="";
        int ns_d=0;
        String dc_d ="";
        Info_Nu info = (Info_Nu) getIntent().getSerializableExtra("thongtin");
        avata_d = info.getAvatar();
        hinh1_d = info.getHinh1();
        hinh2_d = info.getHinh2();
        hinh3_d=info.getHinh3();
        ten_d=info.getTen();
        gt_d=info.getGioitinh();
        dc_d=info.getDiachi();
        ns_d = info.getNamsinh();
        gia_d=info.getGia();
        ten.setText(ten_d);
        gt.setText("Giới tính :"+gt_d);
        dc.setText("Địa chỉ :"+dc_d);
        ns.setText("Năm sinh :"+ns_d);
        gia.setText(gia_d+"đ/1h");
        Picasso.with(getApplicationContext()).load(avata_d).placeholder(R.drawable.daylove).error(R.drawable.er).into(avatar);
        Picasso.with(getApplicationContext()).load(hinh1_d).placeholder(R.drawable.daylove).error(R.drawable.er).into(hinh1);
        Picasso.with(getApplicationContext()).load(hinh2_d).placeholder(R.drawable.daylove).error(R.drawable.er).into(hinh2);
        Picasso.with(getApplicationContext()).load(hinh3_d).placeholder(R.drawable.daylove).error(R.drawable.er).into(hinh3);
    }


    private void anhxa() {
        avatar = (ImageView)findViewById(R.id.img_ct);
        hinh1 = (ImageView)findViewById(R.id.img_1);
        hinh2 =(ImageView)findViewById(R.id.img_2);
        hinh3 =(ImageView)findViewById(R.id.img_3);
        ten = (TextView)findViewById(R.id.ten_ct);
        gt=(TextView)findViewById(R.id.gt_ct);
        dc=(TextView)findViewById(R.id.dc_ct);
        ns=(TextView)findViewById(R.id.ns_ct);
        gia=(TextView)findViewById(R.id.gia_ct);
    }


}
