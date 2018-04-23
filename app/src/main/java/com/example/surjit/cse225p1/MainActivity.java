package com.example.surjit.cse225p1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;
    EditText e1, e2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences sharedPreferences = getSharedPreferences("my_pref", MODE_PRIVATE);
        checkBox = findViewById(R.id.rem);
        e1 = findViewById(R.id.uname);
        e2 = findViewById(R.id.pass);
        button = findViewById(R.id.btn);

        checkBox.setChecked(sharedPreferences.getBoolean("Remember", false));

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("Remember", checkBox.isChecked());
                editor.commit();

                Toast.makeText(MainActivity.this, "A "+checkBox.isChecked(), Toast.LENGTH_SHORT).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Successfully Submitted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
