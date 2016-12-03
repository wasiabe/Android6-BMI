package com.example.wasia.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView tvBmi;
    private Intent intent;
    private float bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        findViews();
        getBmi();
        tvBmi.setText(String.format("%.10f",(double)bmi));
    }

    private void getBmi() {
        intent = getIntent();
        bmi = intent.getFloatExtra("BMI_EXTRA", (float) 0.5);
    }

    private void findViews() {
        tvBmi = (TextView) findViewById(R.id.tvBmi);
    }
}
