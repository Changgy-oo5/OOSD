package com.quanly.model;

public class GraduationJobInfo {
    private String soCMND;
    private String hoTen;
    private String maNganhTotNghiep;
    private String maTruong;
    private String maNganhCongTy;
    private String tenCongTy;
    private int thoiGianLamViec;

    public GraduationJobInfo() {}

    // Getters and Setters
    public String getSoCMND() { return soCMND; }
    public void setSoCMND(String soCMND) { this.soCMND = soCMND; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getMaNganhTotNghiep() { return maNganhTotNghiep; }
    public void setMaNganhTotNghiep(String maNganhTotNghiep) { this.maNganhTotNghiep = maNganhTotNghiep; }

    public String getMaTruong() { return maTruong; }
    public void setMaTruong(String maTruong) { this.maTruong = maTruong; }

    public String getMaNganhCongTy() { return maNganhCongTy; }
    public void setMaNganhCongTy(String maNganhCongTy) { this.maNganhCongTy = maNganhCongTy; }

    public String getTenCongTy() { return tenCongTy; }
    public void setTenCongTy(String tenCongTy) { this.tenCongTy = tenCongTy; }

    public int getThoiGianLamViec() { return thoiGianLamViec; }
    public void setThoiGianLamViec(int thoiGianLamViec) { this.thoiGianLamViec = thoiGianLamViec; }
}