package com.rizieq.barangcrud.tambah;

public interface TambahConstruct {

    interface View{
        void onSucces(String message);
        void onFailure(String message);
        void showFromValidate();
    }

    interface Presenter{

        void tambahBarang(String nama, String harga, String jenis, String stock);

    }
}
