package com.example.wasia.bmi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edWeight;
    private EditText edHeight;
    private Button btnHelp;
    private Bundle bag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.calculate_bmi)
                        .setMessage(R.string.bmi_definition)
                        .setPositiveButton(R.string.ok, null)
                        .show();
            }
        });

    }

    private void findViews() {
        edWeight = (EditText) findViewById(R.id.edWeight);
        edHeight = (EditText) findViewById(R.id.edHeight);
        btnHelp = (Button) findViewById(R.id.btnHelp);
    }

    public void calBmi (View v) throws Exception{
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        try {
            double weight = Double.parseDouble(w);
            double height = Double.parseDouble(h);
            double bmi = weight / Math.pow(height, (double) 2);
            Log.d("BMI", String.valueOf(bmi));
            String msgBmi = "Your BMI is " + String.valueOf((bmi));

            Toast.makeText(this, msgBmi, Toast.LENGTH_LONG).show();

            Bundle bag =   new Bundle();
            bag.putFloat("BMI_EXTRA", (float)bmi);
            bag.putString("WEIGHT_EXTRA", String.valueOf(weight));
            bag.putDouble("HEIGHT_EXTRA", height);

            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtras(bag);
            startActivity(intent);

        } catch (Exception e) {
            String msgErr = e.getMessage();
            Toast.makeText(this, msgErr, Toast.LENGTH_LONG).show();
        }

    }
}
