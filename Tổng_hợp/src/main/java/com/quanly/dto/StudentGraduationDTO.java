package com.quanly.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

public class StudentGraduationDTO {
    @NotBlank(message = "CMND không được để trống")
    private String soCMND;

    private String hoTen;
    private String email;
    private String soDT;
    private String diaChi;

    @NotBlank(message = "Mã trường không được để trống")
    private String maTruong;

    @NotBlank(message = "Mã ngành không được để trống")
    private String maNganh;

    private String heTN;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Ngày tốt nghiệp phải là ngày trong quá khứ")
    private Date ngayTN;

    private String loaiTN;

    // Constructors
    public StudentGraduationDTO() {}

    public StudentGraduationDTO(String soCMND, String hoTen, String email, String soDT, String diaChi,
                                String maTruong, String maNganh, String heTN, Date ngayTN, String loaiTN) {
        this.soCMND = soCMND;
        this.hoTen = hoTen;
        this.email = email;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.maTruong = maTruong;
        this.maNganh = maNganh;
        this.heTN = heTN;
        this.ngayTN = ngayTN;
        this.loaiTN = loaiTN;
    }

    // Getters and Setters
    public String getSoCMND() { return soCMND; }
    public void setSoCMND(String soCMND) { this.soCMND = soCMND; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSoDT() { return soDT; }
    public void setSoDT(String soDT) { this.soDT = soDT; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public String getMaTruong() { return maTruong; }
    public void setMaTruong(String maTruong) { this.maTruong = maTruong; }

    public String getMaNganh() { return maNganh; }
    public void setMaNganh(String maNganh) { this.maNganh = maNganh; }

    public String getHeTN() { return heTN; }
    public void setHeTN(String heTN) { this.heTN = heTN; }

    public Date getNgayTN() { return ngayTN; }
    public void setNgayTN(Date ngayTN) { this.ngayTN = ngayTN; }

    public String getLoaiTN() { return loaiTN; }
    public void setLoaiTN(String loaiTN) { this.loaiTN = loaiTN; }
}