package com.rizieq.barangcrud.delete;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.rizieq.barangcrud.GlobalActivity;
import com.rizieq.barangcrud.tampil.TampilActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class DeletePresenter implements DeleteConstruct.Presenter {


    private DeleteConstruct.View view;
    TampilActivity tampilActivity;

    public DeletePresenter(DeleteConstruct.View view) {
        this.view = view;
    }

    @Override
    public void deleteData(final String id) {
        AndroidNetworking.post(GlobalActivity.BASE_URL+"deleteBarang")
                .setPriority(Priority.HIGH)
                .addBodyParameter("id",id)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            if (response.getBoolean("status"));
                            view.onSucces(response.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        view.onFailde(anError.toString());
                    }
                });
    }
}
