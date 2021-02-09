package com.rizieq.barangcrud.main;

public class MainPresenter implements MainContruct.Presenter{

private MainContruct.View view;

    public MainPresenter(MainContruct.View view) {
        this.view = view;

    }

    @Override
    public void seeAllBarang() {
        view.goBarangList();
    }

    @Override
    public void tambahBarang() {
        view.goTambahBarang();
    }
}
