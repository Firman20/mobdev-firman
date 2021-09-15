package com.example.firstoop;

import android.os.Parcel;
import android.os.Parcelable;

public class Pengguna implements Parcelable {

    private String nama;
    private String umur;
    private String alamat;

    public Pengguna() {
        this.nama = "";
        this.umur = "";
        this.alamat = "";
    }

    public Pengguna(String nama, String umur, String alamat) {
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
    }

    protected Pengguna(Parcel in) {
        nama = in.readString();
        umur = in.readString();
        alamat = in.readString();
    }

    public static final Creator<Pengguna> CREATOR = new Creator<Pengguna>() {
        @Override
        public Pengguna createFromParcel(Parcel in) {
            return new Pengguna(in);
        }

        @Override
        public Pengguna[] newArray(int size) {
            return new Pengguna[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(umur);
        dest.writeString(alamat);
    }
}
