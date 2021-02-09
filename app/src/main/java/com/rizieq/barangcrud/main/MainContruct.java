package com.rizieq.barangcrud.main;

public interface MainContruct {

    interface View {
        void goBarangList();
        void goTambahBarang();
    }

    interface Presenter {
        void seeAllBarang();
        void tambahBarang();
    }
}