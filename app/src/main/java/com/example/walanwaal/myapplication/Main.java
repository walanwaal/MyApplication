package com.example.walanwaal.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sms();
        Call();
        Email();
    }

    private void sms() {
        Button mybtn= (Button) findViewById(R.id.button2);
        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Main.this, SMS.class);
                startActivity(myintent);
            }
        });

    }
    private void Call() {
        Button mybtn= (Button) findViewById(R.id.button1);
        mybtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent myintent = new Intent(Main.this,MainActivity.class);
                startActivity(myintent);
            }
        } );
    }
    private void Email() {
        Button mybtn= (Button) findViewById(R.id.button3);
        mybtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent myintent = new Intent(Main.this,Email.class);
                startActivity(myintent);
            }
        } );
    }

}
