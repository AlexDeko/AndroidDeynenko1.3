package com.homework1_3.androiddeynenko;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDateTime;

public class PressureActivity extends AppCompatActivity {

    private static final String TAG_PRESSURE = "Запись давления";
    int upPressure;
    EditText newUpPressure;
    int downPressure;
    EditText newDownPressure;
    int pulse;
    EditText newPulse;
    CheckBox checkBox;
    LocalDateTime localeDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        newUpPressure = findViewById(R.id.infoUpPressure);
        try{
            upPressure = Integer.parseInt(newUpPressure.getText().toString());
        }catch (Exception e){
            Toast toast = Toast.makeText(PressureActivity.this,
                    getString(R.string.errorParseInt),
                    Toast.LENGTH_LONG);
            toast.show();
        }

        newDownPressure = findViewById(R.id.infoDownPressure);
        try{
            downPressure  = Integer.parseInt(newDownPressure.getText().toString());
        }catch (Exception e){
            Toast toast = Toast.makeText(PressureActivity.this,
                    getString(R.string.errorParseInt),
                    Toast.LENGTH_LONG);
            toast.show();
        }

        newPulse = findViewById(R.id.infoPulse);
        try{
            pulse = Integer.parseInt(newPulse.getText().toString());
        }catch (Exception e){
            Toast toast = Toast.makeText(PressureActivity.this,
                    getString(R.string.errorParseInt),
                    Toast.LENGTH_LONG);
            toast.show();
        }

        checkBox = findViewById(R.id.checkTachycardia);
        localeDate = LocalDateTime.now();

        SavePressure();
    }

    private void SavePressure(){
        Button saveInfo = findViewById(R.id.saveInfoPressure);
        saveInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i(TAG_PRESSURE, "Сохранение");
                PressureUser pressureUser = new PressureUser(upPressure, downPressure, pulse,
                        checkBox.toString(), localeDate);
                pressureUser.userList.add(pressureUser);
            }
        });

        //сначал думал сделать HashMap с ключом saveUser,
        // но для ускорения сдачи работы решил не искать решение
        // как передовать saveUser ключом и множество значений
    }
}
