package com.example.walanwaal.myapplication;
import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMS extends AppCompatActivity {
    EditText message,phone;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        message=(EditText) findViewById(R.id.mess);
        phone=(EditText)findViewById(R.id.phone);
        btn=(Button)findViewById(R.id.button2);

        // permession u ogolanaaya in uu la diro message
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED )
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.SEND_SMS)){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
            }else {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
            }
        }else {


        }

        // end permision



        // btn click
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // button click shaqada la qabanaayo
                String ph=phone.getText().toString();
                String ms=message.getText().toString();


                sendsms(ph,ms);
            }
        });
    }

    // function kaan waxaa uu diraaya emailka
    public void sendsms(String pho,String mes){
        try {

            SmsManager sm =  SmsManager.getDefault();
            sm.sendTextMessage(pho,null,mes,null,null);

            Toast.makeText(getApplicationContext(),"Your Message Has been Sent.....",Toast.LENGTH_LONG).show();
            phone.setText("");

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }


    }


    // waa function overidle ah waxaa uu la shaqaynaa permessionks akor ku qoron
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:{
                if (grantResults.length < 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_PHONE_STATE)==PackageManager.PERMISSION_GRANTED){

                    }

                }
            }
        }
        //   super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
