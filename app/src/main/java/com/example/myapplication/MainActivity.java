package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText text;
    Button button;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        LayoutInflater layout=getLayoutInflater();
//        View view=layout.inflate(R.layout.activity_main,null);
        text=findViewById(R.id.textView4);
        button=findViewById(R.id.button);
        s=text.getText().toString();
        button.setOnClickListener(v -> {
            Log.d(" EditText", "onClick: "+s);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        });
    }
}