package com.example.exampletest.model;

public class LopDuocDangKi {
    private int id;
    private int maSinhVien;
    private int maLopHoc;
    private String kiHoc;
    private int soTinChi;

    public LopDuocDangKi() {
    }

    public LopDuocDangKi(int maSinhVien, int maLopHoc, String kiHoc, int soTinChi) {
        this.maSinhVien = maSinhVien;
        this.maLopHoc = maLopHoc;
        this.kiHoc = kiHoc;
        this.soTinChi = soTinChi;
    }

    public LopDuocDangKi(int id, int maSinhVien, int maLopHoc, String kiHoc, int soTinChi) {
        this.id = id;
        this.maSinhVien = maSinhVien;
        this.maLopHoc = maLopHoc;
        this.kiHoc = kiHoc;
        this.soTinChi = soTinChi;
    }

    @Override
    public String toString() {
        return "LopDuocDangKi{" +
                "id=" + id +
                ", msv=" + maSinhVien +
                ", maLop=" + maLopHoc +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public int getMaLopHoc() {
        return maLopHoc;
    }

    public void setMaLopHoc(int maLopHoc) {
        this.maLopHoc = maLopHoc;
    }

    public String getKiHoc() {
        return kiHoc;
    }

    public void setKiHoc(String kiHoc) {
        this.kiHoc = kiHoc;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }
}
