package com.example.firstoop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import AppsInterface.OnCardListener;

public class RecyclerViewActivity extends AppCompatActivity implements OnCardListener {

    private TextView text_data;
    private RecyclerView data_RV;
    private DataRVAdapter adapter;
    private FloatingActionButton ActionButton;
    private ArrayList<Pengguna> listPengguna;
    private int ActionButton_RequestCode = 100;
    private int ShowData_RequestCode = 200;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ActionButton_RequestCode) {
            if (resultCode == Activity.RESULT_OK) {
                Pengguna penggunaBaru = data.getParcelableExtra("data");
                listPengguna.add(penggunaBaru);
                adapter.notifyDataSetChanged();
            }
        }else if (requestCode == ShowData_RequestCode){
            if (resultCode == 4){
                int position = data.getIntExtra("posisi", -1);
                listPengguna.remove(position);
                adapter.notifyDataSetChanged();
            } else if (resultCode == 3) {
                Pengguna penggunaEdit = data.getParcelableExtra("data");
                int position = data.getIntExtra("posisi", -1);
                listPengguna.set(position, penggunaEdit);
                adapter.notifyDataSetChanged();
            }
        }
    }

    public void hide(View view){
        text_data.setVisibility(View.GONE);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        text_data = findViewById(R.id.text_data);
        ActionButton = findViewById(R.id.ActionButton);
        data_RV = findViewById(R.id.data_RV);
        listPengguna = new ArrayList<>();
        adapter = new DataRVAdapter(listPengguna, this);


        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());

        data_RV.setLayoutManager(manager);
        data_RV.setAdapter(adapter);



        ActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Register.class);
                startActivityForResult(intent, ActionButton_RequestCode);
                text_data.setVisibility(View.GONE);

            }
        });
    }


    @Override
    public void onCardClick(int position) {
        Intent intent = new Intent(getBaseContext(), ShowActivity.class);
        Pengguna showPengguna = listPengguna.get(position);
        intent.putExtra("data", showPengguna);
        intent.putExtra("posisi", position);
        startActivityForResult(intent, ShowData_RequestCode);
    }


}
