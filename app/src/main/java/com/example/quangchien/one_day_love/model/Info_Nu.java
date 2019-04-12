package com.example.quangchien.one_day_love.model;

import java.io.Serializable;

public class Info_Nu implements Serializable{
    public int ID;
    public int namsinh;
    public String ten;
    public String gioitinh;
    public String diachi;
    public String gia;
    public String avatar;
    public String hinh1;
    public String hinh2;
    public String hinh3;

    public Info_Nu(int ID, int namsinh, String ten, String gioitinh, String diachi, String gia, String avatar, String hinh1, String hinh2, String hinh3) {
        this.ID = ID;
        this.namsinh = namsinh;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.gia = gia;
        this.avatar = avatar;
        this.hinh1 = hinh1;
        this.hinh2 = hinh2;
        this.hinh3 = hinh3;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getHinh1() {
        return hinh1;
    }

    public void setHinh1(String hinh1) {
        this.hinh1 = hinh1;
    }

    public String getHinh2() {
        return hinh2;
    }

    public void setHinh2(String hinh2) {
        this.hinh2 = hinh2;
    }

    public String getHinh3() {
        return hinh3;
    }

    public void setHinh3(String hinh3) {
        this.hinh3 = hinh3;
    }
}
