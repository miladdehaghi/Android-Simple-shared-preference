package com.ghsoft.simplesharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    Button btnSave, btnShow;
    TextView txtResult;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        btnSave = findViewById(R.id.btnSave);
        btnShow = findViewById(R.id.btnShow);
        txtResult = findViewById(R.id.txtResult);

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);

        btnSave.setOnClickListener(v -> {
            String name = edtName.getText().toString();
            sharedPreferences.edit().putString("name", name).apply();
        });

        btnShow.setOnClickListener(v -> {
            String savedName = sharedPreferences.getString("name", "نامی ذخیره نشده");
            txtResult.setText("نام ذخیره شده: " + savedName);
        });
    }
}
