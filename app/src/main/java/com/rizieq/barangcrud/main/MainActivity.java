package com.rizieq.barangcrud.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rizieq.barangcrud.R;
import com.rizieq.barangcrud.tambah.TambahActivity;
import com.rizieq.barangcrud.tampil.TampilActivity;

public class MainActivity extends AppCompatActivity implements MainContruct.View{

    Button tampil_data, tambah_data;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tambah_data = findViewById(R.id.btn_tambah_data);
        tampil_data = findViewById(R.id.btn_tampil);

        presenter = new MainPresenter(this);

        tampil_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.seeAllBarang();
            }
        });
        tambah_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.tambahBarang();
            }
        });

    }

    @Override
    public void goBarangList() {
        startActivity(new Intent(MainActivity.this, TampilActivity.class));
    }

    @Override
    public void goTambahBarang() {
        startActivity(new Intent(MainActivity.this, TambahActivity.class));

    }
}
