package com.rizieq.barangcrud.tampil;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.rizieq.barangcrud.R;
import com.rizieq.barangcrud.adapter.AdapterBarang;
import com.rizieq.barangcrud.model.BarangItem;
import com.rizieq.barangcrud.update.UpdateActivity;

import java.util.List;

public class TampilActivity extends AppCompatActivity implements TampilConstruct.View{

    private TampilPresenter presenter;
    private RecyclerView recyclerView;
    private AdapterBarang adapterBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        recyclerView = findViewById(R.id.rv_tampil);
        presenter = new TampilPresenter(this);

        presenter.GetMakanan();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

    }

    @Override
    public void showMakanan(List makanan) {
        adapterBarang = new AdapterBarang(makanan,presenter);
        recyclerView.setAdapter(adapterBarang);
        if (makanan.size() >1){
            Toast.makeText(this, "Data sudah tampil", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Data tidak tampil", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onGetSucces(String message) {
        Toast.makeText(this, "Succesfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetFailed(String message) {
        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goUpdateBarang(BarangItem barangItem) {
        Intent intent = new Intent(TampilActivity.this, UpdateActivity.class);
        intent.putExtra("barang",barangItem);
        startActivity(intent);
    }

    @Override
    public void showDeleteSucces(String message) {
        Toast.makeText(this, "Delete Successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDeleteFailed(String message) {
        Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDeletetion(final String id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(TampilActivity.this)
                .setMessage("Anda Yakin Hapus Barang Ini?")
                .setNegativeButton("tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        presenter.deleteBarang(id);
                    }
                });
        AlertDialog build = builder.create();
        build.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.GetMakanan();
    }
}
