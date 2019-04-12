package com.example.quangchien.one_day_love.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.quangchien.one_day_love.Dangky;
import com.example.quangchien.one_day_love.R;
import com.example.quangchien.one_day_love.full;
import com.example.quangchien.one_day_love.server.Checkconnect;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    private EditText user,pass;
    private Button login;
    final String Url_login="http://192.168.198.2:8080/one_love/login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Checkconnect.haveNetworkConnection(getApplicationContext())){
            anhxa();
            dangnhap();
            dangky();
          //  dangnhap();
        }else
        {
            Checkconnect.show_short(getApplicationContext(),"Kiểm tra lại đường truyền  !!!");

        }




    }

  /*  private void dangnhap() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String m_user = user.getText().toString().trim();
                 String m_pass = pass.getText().toString().trim();
                if(!m_user.isEmpty()||!m_pass.isEmpty()){
                   guidulieu(m_user,m_pass);
                }else
                    Toast.makeText(MainActivity.this, "Vui lòng điền đầy đủ thông tin !", Toast.LENGTH_SHORT).show();

            }
        });
    }*/

    private void anhxa() {
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.dangnhap);

    }



   private void dangnhap() {
        findViewById(R.id.dangnhap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String m_user = user.getText().toString().trim();
                 String m_pass = pass.getText().toString().trim();
                if(!m_user.isEmpty()||!m_pass.isEmpty()){
                   if(m_user.equals("admin")&&m_pass.equals("admin")){
                             Intent i = new Intent(MainActivity.this,full.class);
                startActivity(i);
                   }else  Toast.makeText(MainActivity.this, "Sai thông tin !", Toast.LENGTH_SHORT).show();

                }else
                    Toast.makeText(MainActivity.this, "Vui lòng điền đầy đủ thông tin !", Toast.LENGTH_SHORT).show();


            }
        });
    }


    void dangky(){
        findViewById(R.id.dangky).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Dangky.class);
                startActivity(i);
            }
        });
    }

    private void guidulieu(final String user, final String pass){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Url_login, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("login");
                    if(success.equals("1")){
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject object = jsonArray.getJSONObject(i);
                            String user = object.getString("user");
                            Toast.makeText(MainActivity.this, "Xin chào !"+user, Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Lỗi đăng nhập !"+e, Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Thất bại !"+error, Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("user",user);
                params.put("password",pass);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
