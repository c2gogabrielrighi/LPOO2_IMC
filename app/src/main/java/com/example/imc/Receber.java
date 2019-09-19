package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;



public class Receber extends AppCompatActivity {


    TextView mostra1;
    TextView mostra2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receber);


        mostra1 = findViewById(R.id.textViewMostra1);
        mostra2 = findViewById(R.id.textViewMostra2);


        Intent intent = getIntent();


        String result = intent.getStringExtra("result");
        String desc = intent.getStringExtra("desc");


        mostra1.setText(result+"");
        mostra2.setText(desc+"");


    }
}
