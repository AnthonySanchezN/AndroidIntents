package com.example.claseintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);


        TextView textView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        String string = intent.getStringExtra("string");
        int value = intent.getIntExtra("int", 100);
        boolean bool = intent.getBooleanExtra("boolean", false);
        textView.setText(string);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) !=
                PackageManager.PERMISSION_GRANTED){
            Toast.makeText(ActivityTwo.this, "Se solicita permiso de llamada", Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        } else{
            Intent my_callIntent = new Intent(Intent.ACTION_CALL);
            my_callIntent.setData(Uri.parse("tel: " + string));
            startActivity(my_callIntent);
        }

    }
}