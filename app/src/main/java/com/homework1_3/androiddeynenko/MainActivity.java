package com.homework1_3.androiddeynenko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Система мониторинга здоровья Дейненко";
    EditText txtName;
    EditText txtAge;

    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        txtName = findViewById(R.id.nameUser);
        txtAge = findViewById(R.id.numAge);

        save();
        pressure();
        hp();
    }

    private void save(){
        Button saveInfo = findViewById(R.id.save);
        saveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Сохранение");
                String name = txtName.getText().toString();
                String newAge = txtAge.getText().toString();
                try{
                    age = Integer.parseInt(newAge);
                }catch (Exception e){
                    Toast toast = Toast.makeText(MainActivity.this,
                            getString(R.string.errorParseInt),
                            Toast.LENGTH_LONG);
                    toast.show();
                }

                SaveUser saveUser = new SaveUser(name, age);
                saveUser.saveNewUser(saveUser);

            }
        });
    }
    private void  pressure(){
        Button nextPressure = findViewById(R.id.recordPressure);
        nextPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пеход на экран записи давления");
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });
    }

    private void hp(){
        Button nextHp = findViewById(R.id.recordHp);
        nextHp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пеход на экран записи жизненных показателей");
                Intent intent = new Intent(MainActivity.this,
                        VitalStatisticsActivity.class);
                startActivity(intent);
            }
        });
    }


}
