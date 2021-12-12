package com.vel.magicidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etId;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);
        tvResult.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(view -> {
            String idNumber = etId.getText().toString().trim();
            String dob = idNumber.substring(0, 6);

            int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));
            String sGender;
            if (gender < 5) {
                sGender = getString(R.string.female);
            } else  {
                sGender = getString(R.string.male);
            }

            int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));
            String sNationality;
            if (nationality == 0) {
                sNationality = getString(R.string.citizen);
            } else {
                sNationality = getString(R.string.resident);
            }

            String textResult = getString(R.string.dob) + formatDate(dob) + getString(R.string.newLine) +
                    getString(R.string.gender) + sGender + getString(R.string.newLine) +
                    getString(R.string.nationality) + sNationality;

            tvResult.setText(textResult);
            tvResult.setVisibility(View.VISIBLE);
        });
    }

    private String formatDate(String data) {
        StringBuilder sb = new StringBuilder();
        sb.append(data.substring(4));
        sb.append(".");
        sb.append(data.substring(2,4));
        sb.append(".");
        sb.append(data.substring(0,2));
        return sb.toString();
    }
}