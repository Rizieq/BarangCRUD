package com.rizieq.barangcrud.tambah;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.rizieq.barangcrud.GlobalActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class TambahPresenter implements TambahConstruct.Presenter {

    private TambahConstruct.View view;

    public TambahPresenter(TambahConstruct.View view) {
        this.view = view;
    }


    @Override
    public void tambahBarang(String nama, String harga, String jenis, String stock) {

        if (nama.length() > 0 && harga.length() > 0 && jenis.length() > 0 && stock.length() > 0){
            AndroidNetworking.post(GlobalActivity.BASE_URL+"tambahBarang")
                    .setPriority(Priority.HIGH)
                    .addBodyParameter("nama",nama)
                    .addBodyParameter("harga",harga)
                    .addBodyParameter("jenis",jenis)
                    .addBodyParameter("stock",stock)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                if (response.getBoolean("status")){
                                view.onSucces(response.toString());
                                }
                            } catch (JSONException e) {
                                view.onFailure(response.toString());
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(ANError anError) {
                            view.onFailure(anError.toString());
                        }
                    });
        } else {
            view.showFromValidate();
        }

    }
}
