package com.rizieq.barangcrud.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ResponseBarang{

	@SerializedName("barang")
	private List<BarangItem> barang;

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("status")
	private boolean status;



	public List<BarangItem> getBarang(){
		return barang;
	}
	public String getPesan(){
		return pesan;
	}

	public boolean isStatus(){
		return status;
	}
}