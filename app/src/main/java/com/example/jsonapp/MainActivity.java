package com.example.jsonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private Button search;
    private EditText email;
    private EditText pwd;

    private String url= "https://run.mocky.io/v3/3854a8e8-f13f-4a51-92c7-684b5856cb51";

    private RequestQueue queue;
    private StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login= (Button) findViewById(R.id.login);
        search= (Button) findViewById(R.id.search);

        email= (EditText)  findViewById(R.id.getEmail);
        pwd= (EditText) findViewById(R.id.getPwd);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(email.getText().toString()=="alessioprelati@gmail.com" && pwd.getText().toString()=="JSONapp"){
                    search.setVisibility(View.VISIBLE); //SHOW the button
                }

                getData();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vai ad una nuova ACTIVITY
                Toast.makeText(getApplicationContext(), "AUTENTICAZIONE RIUSCITA", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getData(){

        //CREARE UNA NUOVA RICHIESTA HTTP DA ASSOCIARE ALLA ACTIVITY
        //RequestQueue initializated
        queue= Volley.newRequestQueue(this);

         stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
             @Override
             public void onResponse(String response) {

                 Toast.makeText(getApplicationContext(), "Response: " + response.toString(), Toast.LENGTH_LONG).show();
             }
         }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {
             }
         });

         queue.add(stringRequest);
    }
}

