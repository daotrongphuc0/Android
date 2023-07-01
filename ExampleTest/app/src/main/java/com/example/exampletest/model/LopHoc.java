package com.example.exampletest.model;

import java.io.Serializable;

public class LopHoc implements Serializable {
    private int maLop;
    private String tenLop,moTa;

    public LopHoc() {
    }

    public LopHoc(int maLop, String tenLop, String moTa) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.moTa = moTa;
    }

    public LopHoc(String tenLop, String moTa) {
        this.tenLop = tenLop;
        this.moTa = moTa;
    }

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "LopHoc{" +
                "maLop=" + maLop +
                ", tenLop='" + tenLop + '\'' +
                ", moTa='" + moTa + '\'' +
                '}';
    }
}
