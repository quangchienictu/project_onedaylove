package com.example.quangchien.one_day_love.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.quangchien.one_day_love.R;
import com.example.quangchien.one_day_love.activity.MainActivity;
import com.example.quangchien.one_day_love.adapter.Info_Nu_adapter;
import com.example.quangchien.one_day_love.model.Info_Nu;
import com.example.quangchien.one_day_love.server.server;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    ArrayList<Info_Nu> manginfo;
    Info_Nu_adapter info_nu_adapter;
    LinearLayout btn_nam,btn_nu;
    boolean temp=false ;
    Button btn0,btn1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frame_home,container,false);

        viewFlipper = (ViewFlipper)view.findViewById(R.id.viewfp);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_info);
        btn_nam = (LinearLayout)view.findViewById(R.id.btnnam);
        btn_nu = (LinearLayout)view.findViewById(R.id.btnnu);
        btn0=(Button)view.findViewById(R.id.btn0);
        btn1=(Button)view.findViewById(R.id.btn1);
        ActionViewFlipper();
        click();
        show();

        return view;

    }


    private void ActionViewFlipper() {

        ArrayList<String> slide = new ArrayList<>();
        slide.add(server.slide+"slide5.png");
        slide.add(server.slide+"slide6.jpg");
        slide.add(server.slide+"slide3.jpg");
        slide.add(server.slide+"slide2.jpg");
        slide.add(server.slide+"slide1.jpg");
        for (int i=0;i<slide.size();i++){
            ImageView imageView = new ImageView(getActivity());
            Picasso.with(getActivity()).load(slide.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
            viewFlipper.setFlipInterval(10000);
            viewFlipper.setAutoStart(true);
            Animation ani_slide_in = AnimationUtils.loadAnimation(getActivity(),R.anim.slide_in_right);
            Animation ani_out = AnimationUtils.loadAnimation(getActivity(),R.anim.slide_out);

            viewFlipper.setInAnimation(ani_slide_in);
            viewFlipper.setOutAnimation(ani_out);
        }
    }



    private void get_nu() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(server.info_nu, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response!=null){
                    int ID = 0;
                    String ten= "";
                    int namsinh =0;
                    String gioitinh ="";
                    String diachi ="";
                    String gia ="";
                    String avatar ="";
                    String hinh1 ="";
                    String hinh2 ="";
                    String hinh3 ="";
                    for(int i=0;i<response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            ID = jsonObject.getInt("id");
                            ten=jsonObject.getString("ten");
                            namsinh =jsonObject.getInt("namsinh");
                            gioitinh=jsonObject.getString("gioitinh");
                            diachi=jsonObject.getString("diachi");
                            gia=jsonObject.getString("gia");
                            avatar=jsonObject.getString("avatar");
                            hinh1=jsonObject.getString("hinh1");
                            hinh2=jsonObject.getString("hinh2");
                            hinh3=jsonObject.getString("hinh3");
                            manginfo.add(new Info_Nu(ID,namsinh,ten,gioitinh,diachi,gia,avatar,hinh1,hinh2,hinh3));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }
    private void get_nam() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(server.info_nam, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response!=null){
                    int ID = 0;
                    String ten= "";
                    int namsinh =0;
                    String gioitinh ="";
                    String diachi ="";
                    String gia ="";
                    String avatar ="";
                    String hinh1 ="";
                    String hinh2 ="";
                    String hinh3 ="";
                    for(int i=0;i<response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            ID = jsonObject.getInt("id");
                            ten=jsonObject.getString("ten");
                            namsinh =jsonObject.getInt("namsinh");
                            gioitinh=jsonObject.getString("gioitinh");
                            diachi=jsonObject.getString("diachi");
                            gia=jsonObject.getString("gia");
                            avatar=jsonObject.getString("avatar");
                            hinh1=jsonObject.getString("hinh1");
                            hinh2=jsonObject.getString("hinh2");
                            hinh3=jsonObject.getString("hinh3");
                            manginfo.add(new Info_Nu(ID,namsinh,ten,gioitinh,diachi,gia,avatar,hinh1,hinh2,hinh3));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void show(){
        manginfo = new ArrayList<>();
         info_nu_adapter= new Info_Nu_adapter(getActivity(),manginfo);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setAdapter(info_nu_adapter);
    }

   private void click(){
       get_nu();
       doimau();
        btn_nam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                get_nam();
                temp =true;
                doimau();
                show();
            }
        });

       btn_nu.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               get_nu();
               temp =false;
               doimau();
               show();
           }
       });



   }

   private void doimau(){
       if(temp==false){
           btn0.setBackgroundColor(Color.parseColor("#FFF6BBFD"));
           btn1.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
       }else
       {
           btn0.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
           btn1.setBackgroundColor(Color.parseColor("#90d6ff"));
       }
   }
}
