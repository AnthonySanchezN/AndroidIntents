package com.example.claseintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        Intent intent = new Intent(this, ActivityTwo.class);
        intent.putExtra("string", "String");
        intent.putExtra("int", 100);
        intent.putExtra("boolean", true);
        startActivity(intent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(!editText.getText().toString().equals("")){
                    GoToSecondActivity();
                }else {
                    Toast.makeText(MainActivity.this, "Ingrese un valor", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    private void GoToSecondActivity() {
        Intent intent = new Intent( this, ActivityTwo.class);
        intent.putExtra("name",editText.getText().toString() );
        startActivity(intent);
        finish();
    }


    }

