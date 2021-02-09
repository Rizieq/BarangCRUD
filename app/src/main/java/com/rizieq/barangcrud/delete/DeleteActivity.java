package com.rizieq.barangcrud.delete;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rizieq.barangcrud.R;
import com.rizieq.barangcrud.tampil.TampilActivity;

public class DeleteActivity extends AppCompatActivity implements DeleteConstruct.View{

    EditText id;
    Button delete;
    private DeletePresenter deletePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        deletePresenter = new DeletePresenter(this);
        delete = findViewById(R.id.btn_delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletePresenter.deleteData(id.getText().toString());
            }
        });
    }

    @Override
    public void onSucces(String message) {
        Toast.makeText(this, "Delete Successfuly", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(DeleteActivity.this, TampilActivity.class));
        finish();
    }

    @Override
    public void onFailde(String message) {
        Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show();
    }
}
