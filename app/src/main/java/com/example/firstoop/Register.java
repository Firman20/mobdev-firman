package com.example.firstoop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    private EditText editName, editAlamat, editTelp;
    private Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editName = findViewById(R.id.editName);
        editAlamat = findViewById(R.id.editAlamat);
        editTelp = findViewById(R.id.editTelp);
        Submit = findViewById(R.id.Submit);

        //Untuk mengisi form dengan data yang sudah ada
        Intent intent1 = getIntent();
        Boolean isEdited = intent1.getBooleanExtra("isEditted", false);
        if (isEdited == true){
            Pengguna user = intent1.getParcelableExtra("data");
            editName.setText(user.getNama());
            editAlamat.setText(user.getUmur());
            editTelp.setText(user.getAlamat());
        }

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pengguna user = new Pengguna();
                user.setNama(editName.getText().toString().trim());
                user.setUmur(editAlamat.getText().toString().trim());
                user.setAlamat(editTelp.getText().toString().trim());

                Intent intent = new Intent();
                intent.putExtra("data", user);
                setResult(Activity.RESULT_OK, intent);
                finish();


            }
        });
    }
}