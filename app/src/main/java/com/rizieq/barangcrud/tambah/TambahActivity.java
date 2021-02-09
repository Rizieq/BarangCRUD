package com.rizieq.barangcrud.tambah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rizieq.barangcrud.R;
import com.rizieq.barangcrud.main.MainActivity;

public class TambahActivity extends AppCompatActivity implements TambahConstruct.View {

    private TambahPresenter tambahPresenter;
    EditText nama, harga, jenis, stock;
    Button simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        nama = findViewById(R.id.edt_nama);
        harga = findViewById(R.id.edt_harga);
        jenis = findViewById(R.id.edt_jenis);
        stock = findViewById(R.id.edt_stock);

        tambahPresenter = new TambahPresenter(this);
        simpan = findViewById(R.id.btn_tambah);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahPresenter.tambahBarang(nama.getText().toString(),
                        harga.getText().toString(),
                        jenis.getText().toString(),
                        stock.getText().toString());
            }
        });


    }

    @Override
    public void onSucces(String message) {
        Toast.makeText(this, "Tambah Succesfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(TambahActivity.this, MainActivity.class));
        finish();

    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(this, "Tambah Delete", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFromValidate() {
        Toast.makeText(this, "From must be valid", Toast.LENGTH_SHORT).show();
    }
}
