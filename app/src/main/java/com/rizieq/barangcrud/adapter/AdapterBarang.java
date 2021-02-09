package com.rizieq.barangcrud.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rizieq.barangcrud.R;
import com.rizieq.barangcrud.model.BarangItem;
import com.rizieq.barangcrud.tampil.TampilPresenter;


import java.util.List;


// todo selanjutnya

public class AdapterBarang extends RecyclerView.Adapter<AdapterBarang.MyViewHolder> {

    private List<BarangItem> barangItems;

    private TampilPresenter tampilPresenter;

    public AdapterBarang(List<BarangItem> barangItems, TampilPresenter tampilPresenter) {
        this.barangItems = barangItems;
        this.tampilPresenter = tampilPresenter;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_barang, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {


        myViewHolder.nama.setText(barangItems.get(i).getNamaBarang());
        myViewHolder.stock.setText(barangItems.get(i).getStock());
        myViewHolder.harga.setText(barangItems.get(i).getHarga());
        myViewHolder.jenis.setText(barangItems.get(i).getJenisBarang());

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tampilPresenter.goUpdate(barangItems.get(i));
            }
        });

        myViewHolder.hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tampilPresenter.confirmBarang(barangItems.get(i).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return barangItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nama, jenis, harga, stock;
        ImageButton hapus;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.itm_nama_makanan);
            jenis = itemView.findViewById(R.id.itm_jenis_makanan);
            harga = itemView.findViewById(R.id.itm_harga_makanan);
            stock = itemView.findViewById(R.id.itm_stock_makanan);

            hapus = itemView.findViewById(R.id.delete);
        }
    }
}
