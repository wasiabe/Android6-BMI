package com.example.wasia.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView tvBmi;
    private Intent intent;
    private float bmi;
    private String weight;
    private String height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        findViews();
        getValues();
        tvBmi.setText("Your weight is " + weight + ", height is " + height + ", and you BMI is " + String.format("%.10f",(double)bmi));
    }

    private void getValues() {
        intent = getIntent();
        Bundle bag = intent.getExtras();
        bmi = bag.getFloat("BMI_EXTRA");
        weight = bag.getString("WEIGHT_EXTRA");
        height = String.valueOf(bag.getDouble("HEIGHT_EXTRA"));
    }

    private void findViews() {
        tvBmi = (TextView) findViewById(R.id.tvBmi);
    }
}
