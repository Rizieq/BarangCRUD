package com.rizieq.barangcrud.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class BarangItem implements Serializable {

	@SerializedName("harga")
	private String harga;

	@SerializedName("nama_barang")
	private String namaBarang;

	@SerializedName("id")
	private String id;

	@SerializedName("stock")
	private String stock;

	@SerializedName("jenis_barang")
	private String jenisBarang;

	public void setHarga(String harga){
		this.harga = harga;
	}

	public String getHarga(){
		return harga;
	}

	public void setNamaBarang(String namaBarang){
		this.namaBarang = namaBarang;
	}

	public String getNamaBarang(){
		return namaBarang;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setStock(String stock){
		this.stock = stock;
	}

	public String getStock(){
		return stock;
	}

	public void setJenisBarang(String jenisBarang){
		this.jenisBarang = jenisBarang;
	}

	public String getJenisBarang(){
		return jenisBarang;
	}
}