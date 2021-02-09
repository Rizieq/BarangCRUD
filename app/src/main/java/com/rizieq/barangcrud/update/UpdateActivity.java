package com.rizieq.barangcrud.update;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rizieq.barangcrud.R;
import com.rizieq.barangcrud.model.BarangItem;

public class UpdateActivity extends AppCompatActivity implements UpdateConstruct.View {

    EditText nama, harga, stock, jenis;
    Button update;
    private UpdatePresenter updatePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        final BarangItem barangItem = (BarangItem) getIntent().getSerializableExtra("barang");

        nama = findViewById(R.id.edt_nama_update);
        harga = findViewById(R.id.edt_harga_update);
        stock = findViewById(R.id.edt_stock_update);
        jenis = findViewById(R.id.edt_jenis_update);

        nama.setText(barangItem.getNamaBarang());
        jenis.setText(barangItem.getJenisBarang());
        harga.setText(barangItem.getHarga());
        stock.setText(barangItem.getStock());

        updatePresenter = new UpdatePresenter(this);

        update = findViewById(R.id.btn_update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePresenter.updateDate(barangItem.getId(),nama.getText().toString(),harga.getText().toString(),jenis.getText().toString(),stock.getText().toString());
            }
        });
    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, "Update Succes", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onFailed(String message) {
        Toast.makeText(this, "Update Failed", Toast.LENGTH_SHORT).show();

    }
}
