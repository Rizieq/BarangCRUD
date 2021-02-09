package com.rizieq.barangcrud.tampil;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.rizieq.barangcrud.GlobalActivity;
import com.rizieq.barangcrud.model.BarangItem;
import com.rizieq.barangcrud.model.ResponseBarang;

import org.json.JSONException;
import org.json.JSONObject;

public class TampilPresenter implements TampilConstruct.Presenter{


    private TampilConstruct.View view;
    public TampilPresenter(TampilConstruct.View view) {
        this.view = view;
    }

    @Override
    public void GetMakanan() {

        AndroidNetworking.get(GlobalActivity.BASE_URL+"getBarang")
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(ResponseBarang.class, new ParsedRequestListener<ResponseBarang>() {
                    @Override
                    public void onResponse(ResponseBarang response) {
                        view.showMakanan(response.getBarang());
                        view.onGetSucces(response.getPesan());
                    }

                    @Override
                    public void onError(ANError anError) {
                        view.onGetFailed(anError.toString());
                    }
                });
    }

    @Override
    public void goUpdate(BarangItem barangItem) {
        view.goUpdateBarang(barangItem);

    }

    @Override
    public void deleteBarang(String id) {
        AndroidNetworking.post(GlobalActivity.BASE_URL + "deleteBarang")
                .setPriority(Priority.HIGH)
                .addUrlEncodeFormBodyParameter("id",id)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        GetMakanan();
                        try {
                            if (response.getBoolean("status")){
                                view.showDeleteSucces(response.toString());
                            }
                        } catch (JSONException e) {
                            view.showDeleteFailed(e.toString());
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        view.showDeleteFailed(anError.toString());
                    }
                });
    }

    @Override
    public void confirmBarang(String id) {
        view.showDeletetion(id);

    }


}
