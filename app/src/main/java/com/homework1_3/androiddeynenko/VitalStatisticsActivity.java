package com.homework1_3.androiddeynenko;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VitalStatisticsActivity extends AppCompatActivity {

    private static final String TAG_VS = "Запись жизненных показателей";
    EditText newWeight;
    double weight;
    EditText newStep;
    int step;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vital_statistics);


        //жизненые показатели
        saveVS();
    }

    private void saveVS(){
        Button saveInfo = findViewById(R.id.saveInfoPressure2);
        saveInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                newWeight = findViewById(R.id.infoWeight);
                try{
                    weight = Double.parseDouble(newWeight.getText().toString());
                }catch (Exception e){
                    Toast toast = Toast.makeText(VitalStatisticsActivity.this,
                            getString(R.string.errorParseInt),
                            Toast.LENGTH_LONG);
                    toast.show();
                }

                newStep = findViewById(R.id.infoStep);
                try{
                    step = Integer.parseInt(newStep.getText().toString());
                }catch (Exception e){
                    Toast toast = Toast.makeText(VitalStatisticsActivity.this,
                            getString(R.string.errorParseInt),
                            Toast.LENGTH_LONG);
                    toast.show();
                }

                Log.i(TAG_VS, "Сохранение");

                VitalStatisticsUser vitalStatisticsUser = new VitalStatisticsUser(weight, step);
            }
        });
    }
}
