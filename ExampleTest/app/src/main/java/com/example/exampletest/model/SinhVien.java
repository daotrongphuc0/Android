package com.example.exampletest.model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private int msv;
    private String ten,namSinh,queQuan,namHoc;

    public SinhVien(String ten, String namSinh, String queQuan, String namHoc) {
        this.ten = ten;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.namHoc = namHoc;
    }

    public SinhVien(int msv, String ten, String namSinh, String queQuan, String namHoc) {
        this.msv = msv;
        this.ten = ten;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.namHoc = namHoc;
    }

    public SinhVien() {
    }

    public int getMsv() {
        return msv;
    }

    public void setMsv(int msv) {
        this.msv = msv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "msv=" + msv +
                ", ten='" + ten + '\'' +
                ", namSinh='" + namSinh + '\'' +
                ", queQuan='" + queQuan + '\'' +
                ", namHoc='" + namHoc + '\'' +
                '}';
    }
}
