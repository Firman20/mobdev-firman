package com.example.firstoop;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    private TextView editName, editAlamat, editTelp, editEmail;
    private Button editButton, deleteButton;
    private  int position;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 300) {
            if (resultCode == Activity.RESULT_OK) {
                data.putExtra("posisi", position);
                setResult(3, data); // 3 untuk edit/update
                finish();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        editName = findViewById(R.id.textNama);
        editAlamat = findViewById(R.id.textAlamat);
        editTelp = findViewById(R.id.textTelp);
        editEmail = findViewById(R.id.textEmail);
        editButton = findViewById(R.id.editButton);
        deleteButton = findViewById(R.id.deleteButton);

        Intent intent = getIntent();
        Pengguna user = intent.getParcelableExtra("data");
        position = intent.getIntExtra("posisi", -1);

        editName.setText(user.getNama());
        editAlamat.setText(user.getUmur());
        editTelp.setText(user.getAlamat());

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.putExtra("posisi", position);
                setResult(4, intent1); // Code 4 = delete
                finish();
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getBaseContext(), Register.class);
                intent2.putExtra("data", user);
                intent2.putExtra("isEditted" ,true);
                startActivityForResult(intent2, 300);
            }
        });

    }
}