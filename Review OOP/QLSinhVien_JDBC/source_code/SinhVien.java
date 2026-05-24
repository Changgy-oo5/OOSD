package model;

import java.sql.Date;

public class SinhVien {

    private String maSV;
    private String hoTen;
    private Date ngaySinh;
    private String nganh;
    private double diemTB;
    private String lop;

    public SinhVien() {
    }

    public SinhVien(String maSV, String hoTen, Date ngaySinh, String nganh, double diemTB, String lop) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.nganh = nganh;
        this.diemTB = diemTB;
        this.lop = lop;
    }

    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public Date getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(Date ngaySinh) { this.ngaySinh = ngaySinh; }

    public String getNganh() { return nganh; }
    public void setNganh(String nganh) { this.nganh = nganh; }

    public double getDiemTB() { return diemTB; }
    public void setDiemTB(double diemTB) { this.diemTB = diemTB; }

    public String getLop() { return lop; }
    public void setLop(String lop) { this.lop = lop; }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSV='" + maSV + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", nganh='" + nganh + '\'' +
                ", diemTB=" + diemTB +
                ", lop='" + lop + '\'' +
                '}';
    }
}