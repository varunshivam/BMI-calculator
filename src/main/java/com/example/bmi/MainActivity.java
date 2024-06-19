package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        EditText edtweight,edtHeightFt,edtHeightIN;
        Button btncalculate;
        TextView txtresult;
        edtweight=findViewById(R.id.edtweight);
        edtHeightFt=findViewById(R.id.edtHeightFt);
        edtHeightIN=findViewById(R.id.edtHeightIN);
        btncalculate=findViewById(R.id.btncalculate);
        txtresult=findViewById(R.id.txtResult);

        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int wt= Integer.parseInt( edtweight.getText().toString());
              int ft=Integer.parseInt( edtHeightFt.getText().toString());
            int IN=Integer.parseInt( edtHeightIN.getText().toString());
            int totalIN=ft*12 + IN;
            double totalCm=totalIN * 2.53;
            double totalM= totalCm/100;
            double bmi=wt/(totalM*totalM);
            double roundBMI=Math.round(bmi*100)/100.0;
            if (bmi>25){

               txtresult.setText("you are overweight!\n your BMI is: "+ roundBMI);
            } else if (bmi<18) {
                txtresult.setText("you are underweight!\n your BMI is: "+ roundBMI);
            }
            else {
                txtresult.setText("you are healthy!\nyour BMI is: "+roundBMI);
            }

            }
        });


    }
}