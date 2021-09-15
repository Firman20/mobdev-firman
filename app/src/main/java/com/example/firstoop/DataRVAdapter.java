package com.example.firstoop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import AppsInterface.OnCardListener;

public class DataRVAdapter extends RecyclerView.Adapter<DataRVAdapter.DataViewHolder> {

    private ArrayList<Pengguna> listPengguna;
    private OnCardListener listener;

    public DataRVAdapter(ArrayList<Pengguna> listPengguna, OnCardListener listener){
        this.listPengguna = listPengguna;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DataRVAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.data_cardview, parent, false);
        return new DataViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull DataRVAdapter.DataViewHolder holder, int position) {
        holder.cardview_nama.setText(listPengguna.get(position).getNama());
        holder.cardview_alamat.setText(listPengguna.get(position).getUmur());
        holder.cardview_telepon.setText(listPengguna.get(position).getAlamat());
    }

    @Override
    public int getItemCount() {
        return listPengguna.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        private TextView cardview_nama, cardview_alamat, cardview_telepon;
        private OnCardListener listener1;

        public DataViewHolder(@NonNull View itemView, OnCardListener listener1) {
            super(itemView);
            cardview_nama = itemView.findViewById(R.id.cardview_nama);
            cardview_alamat = itemView.findViewById(R.id.cardview_alamat);
            cardview_telepon = itemView.findViewById(R.id.cardview_telepon);
            this.listener1 =listener1;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener1.onCardClick(getAdapterPosition());

                }
            });
        }
    }
}
