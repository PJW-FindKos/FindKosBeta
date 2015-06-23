package com.example.hermawan.mahasiswaonline.entities;

/**
 * Created by Adi Prasetyo on 6/19/2015.
 */
public class Kos {
    private int id;
    private String namaPemilik;
    private String alamat;
    private String harga;
    private String noHP;
    private String longitude;
    private String latitude;
    private String fasilitas;

    public Kos(){super();}

    public Kos(int id, String namaPemilik, String alamat, String harga, String noHP, String longitude, String latitude, String fasilitas){
        this.namaPemilik = namaPemilik;
        this.alamat = alamat;
        this.harga = harga;
        this.noHP = noHP;
        this.longitude = longitude;
        this.latitude = latitude;
        this.fasilitas = fasilitas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getLongitude () {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }
}
