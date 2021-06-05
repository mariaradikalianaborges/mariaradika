package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Dinas implements Parcelable {

    private Integer photo;
    private String nama;
    private String deskripsi;

    public Dinas(){}

    protected Dinas(Parcel in) {
        nama = in.readString();
        if (in.readByte() == 0) {
            photo = null;
        } else {
            photo = in.readInt();
        }
        deskripsi = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        if (photo == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(photo);
        }
        dest.writeString(deskripsi);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Dinas> CREATOR = new Creator<Dinas>() {
        @Override
        public Dinas createFromParcel(Parcel in) {
            return new Dinas(in);
        }

        @Override
        public Dinas[] newArray(int size) {
            return new Dinas  [size] ;
        }
    };

    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
