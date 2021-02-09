package com.rizieq.barangcrud.update;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.rizieq.barangcrud.GlobalActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class UpdatePresenter implements UpdateConstruct.Presenter{

    private UpdateConstruct.View view;

    public UpdatePresenter(UpdateConstruct.View view) {
        this.view = view;
    }

    @Override
    public void updateDate(String id, String nama, String jenis, String harga, String stock) {
        AndroidNetworking.post(GlobalActivity.BASE_URL + "updateBarang")
                .setPriority(Priority.HIGH)
                .addBodyParameter("id",id)
                .addBodyParameter("nama",nama)
                .addBodyParameter("jenis",jenis)
                .addBodyParameter("harga",harga)
                .addBodyParameter("stock",stock)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.getBoolean("status"));
                            view.onSuccess(response.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        view.onFailed(anError.toString());
                    }
                });
    }
}
