package com.rizieq.barangcrud.update;

public interface UpdateConstruct {

    interface View{
        void onSuccess(String message);
        void onFailed(String message);

    }

    interface Presenter{
        void updateDate(String id, String nama, String jenis, String harga, String stock);

    }



}
