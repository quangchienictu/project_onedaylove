package com.example.quangchien.one_day_love;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.quangchien.one_day_love.activity.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Dangky extends AppCompatActivity {
    private EditText user,pass,pass2;
    private Button dk;
    public static String Url_regist ="http://192.168.198.2:8080/one_love/register.php";
    private ProgressBar loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        anhxa();
        loadmain();
    }

    private void anhxa() {
        user = (EditText)findViewById(R.id.username);
        pass= (EditText)findViewById(R.id.password1);
        pass2=(EditText)findViewById(R.id.password2);
        dk=(Button)findViewById(R.id.dk);
        loading =(ProgressBar)findViewById(R.id.loading);

        dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();

            }
        });
    }

    private void loadmain() {
        findViewById(R.id.quaylai).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dangky.this,MainActivity.class);
                startActivity(i);
            }
        });
    }


    private  void register(){
        loading.setVisibility(View.VISIBLE);
        dk.setVisibility(View.GONE);
        final String user = this.user.getText().toString().trim();
        final String pass=this.pass.getText().toString().trim();
        final String pass2=this.pass2.getText().toString().trim();
        if(pass.equals(pass2)==false){
            Toast.makeText(this, "Mật khẩu không trùng ! Vui lòng kiểm tra lại", Toast.LENGTH_SHORT).show();
        }else
        {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Url_regist, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try{
                        JSONObject jsonObject = new JSONObject(response);
                        String succes = jsonObject.getString("success");
                        if(succes.equals("1")){
                            Toast.makeText(Dangky.this, "Đăng ký thành công !", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(Dangky.this, "Đăng ký thất bại !"+e.toString(), Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                        dk.setVisibility(View.VISIBLE);
                    }
                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Dangky.this, "Đăng ký thất bại !"+error.toString(), Toast.LENGTH_SHORT).show();
                            loading.setVisibility(View.GONE);
                            dk.setVisibility(View.VISIBLE);
                        }
                    })
            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("user",user);
                    params.put("pass",pass);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        }
    }
}
