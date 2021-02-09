package com.rizieq.barangcrud.delete;

public interface DeleteConstruct {

    interface View{
        void onSucces(String message);
        void onFailde(String message);
    }
    interface Presenter{
        void deleteData(String id);
    }
}
