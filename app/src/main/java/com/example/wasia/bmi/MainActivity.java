package com.example.wasia.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edWeight;
    private EditText edHeight;
    private Button btnHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
    }

    private void findViews() {
        edWeight = (EditText) findViewById(R.id.edWeight);
        edHeight = (EditText) findViewById(R.id.edHeight);
        btnHelp = (Button) findViewById(R.id.btnHelp);
    }

    public void calBmi (View v) {
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        double weight = Double.parseDouble(w);
        double height = Double.parseDouble(h);
        double bmi = weight/Math.pow(height,(double)2);
        Log.d("BMI",String.valueOf(bmi));
    }
}
