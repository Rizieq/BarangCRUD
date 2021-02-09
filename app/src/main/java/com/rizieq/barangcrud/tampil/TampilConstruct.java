package com.rizieq.barangcrud.tampil;

import com.rizieq.barangcrud.model.BarangItem;

import java.util.List;

public interface TampilConstruct {

    interface View{
        void showMakanan(List makanan);
        void onGetSucces(String message);
        void onGetFailed(String message);
        void goUpdateBarang(BarangItem barangItem);


        // delete
        void showDeleteSucces(String message);
        void showDeleteFailed(String message);
        void showDeletetion(String id);
    }

    interface Presenter{
        void GetMakanan();
        void goUpdate(BarangItem barangItem);

        // delete
        void deleteBarang(String id);
        void confirmBarang(String id);
    }
}
