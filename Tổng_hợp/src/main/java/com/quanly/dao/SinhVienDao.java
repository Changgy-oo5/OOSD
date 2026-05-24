package com.quanly.dao;

import com.quanly.model.GraduationJobInfo;
import com.quanly.model.SinhVien;
import com.quanly.model.TotNghiep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SinhVienDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Lưu sinh viên
    public int saveSinhVien(SinhVien sv) {
        String sql = "INSERT INTO SINHVIEN(SoCMND, HoTen, Email, SoDT, DiaChi) VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(sql, sv.getSoCMND(), sv.getHoTen(),
                sv.getEmail(), sv.getSoDT(), sv.getDiaChi());
    }

    // Kiểm tra sinh viên đã tồn tại chưa
    public boolean existsBySoCMND(String soCMND) {
        String sql = "SELECT COUNT(*) FROM SINHVIEN WHERE SoCMND = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, soCMND);
        return count != null && count > 0;
    }

    // Lưu tốt nghiệp
    public int saveTotNghiep(TotNghiep tn) {
        String sql = "INSERT INTO TOT_NGHIEP(SoCMND, MaTruong, MaNganh, HeTN, NgayTN, LoaiTN) " +
                "VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, tn.getSoCMND(), tn.getMaTruong(),
                tn.getMaNganh(), tn.getHeTN(), tn.getNgayTN(), tn.getLoaiTN());
    }

    // Tìm kiếm cơ bản (yêu cầu 3.1)
    public List<SinhVien> searchSinhVien(String keyword) {
        String sql = "SELECT * FROM SINHVIEN WHERE HoTen LIKE ? OR SoCMND LIKE ?";
        String searchKey = "%" + keyword + "%";
        return jdbcTemplate.query(sql, new SinhVienRowMapper(), searchKey, searchKey);
    }

    // Tìm kiếm thông tin tốt nghiệp và việc làm (yêu cầu 3.2)
    public List<GraduationJobInfo> searchGraduationJobInfo(String keyword) {
        String sql = "SELECT sv.SoCMND, sv.HoTen, tn.MaNganh as MaNganhTotNghiep, " +
                "tn.MaTruong, cv.MaNganh as MaNganhCongTy, cv.TenCongTy, cv.ThoiGianLamViec " +
                "FROM SINHVIEN sv " +
                "JOIN TOT_NGHIEP tn ON sv.SoCMND = tn.SoCMND " +
                "LEFT JOIN CONG_VIEC cv ON sv.SoCMND = cv.SoCMND " +
                "WHERE sv.HoTen LIKE ? OR sv.SoCMND LIKE ?";
        String searchKey = "%" + keyword + "%";
        return jdbcTemplate.query(sql, new GraduationJobInfoRowMapper(), searchKey, searchKey);
    }

    // RowMapper cho SinhVien
    private static class SinhVienRowMapper implements RowMapper<SinhVien> {
        @Override
        public SinhVien mapRow(ResultSet rs, int rowNum) throws SQLException {
            SinhVien sv = new SinhVien();
            sv.setSoCMND(rs.getString("SoCMND"));
            sv.setHoTen(rs.getString("HoTen"));
            sv.setEmail(rs.getString("Email"));
            sv.setSoDT(rs.getString("SoDT"));
            sv.setDiaChi(rs.getString("DiaChi"));
            return sv;
        }
    }

    // RowMapper cho GraduationJobInfo
    private static class GraduationJobInfoRowMapper implements RowMapper<GraduationJobInfo> {
        @Override
        public GraduationJobInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            GraduationJobInfo info = new GraduationJobInfo();
            info.setSoCMND(rs.getString("SoCMND"));
            info.setHoTen(rs.getString("HoTen"));
            info.setMaNganhTotNghiep(rs.getString("MaNganhTotNghiep"));
            info.setMaTruong(rs.getString("MaTruong"));
            info.setMaNganhCongTy(rs.getString("MaNganhCongTy"));
            info.setTenCongTy(rs.getString("TenCongTy"));
            info.setThoiGianLamViec(rs.getInt("ThoiGianLamViec"));
            return info;
        }
    }
}
