package dao;

import model.SinhVien;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {

    // Thêm sinh viên
    public boolean insertSinhVien(SinhVien sv) {
    	String sql = "INSERT INTO SinhVien VALUES (?, ?, ?, ?, ?, ?)";
    	
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

        	ps.setString(1, sv.getMaSV());
        	ps.setString(2, sv.getHoTen());
        	ps.setDate(3, sv.getNgaySinh());
        	ps.setString(4, sv.getNganh());
        	ps.setDouble(5, sv.getDiemTB());
        	ps.setString(6, sv.getLop());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy danh sách sinh viên
    public List<SinhVien> getAllSinhVien() {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM SinhVien";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
            	SinhVien sv = new SinhVien(
            	        rs.getString("maSV"),
            	        rs.getString("hoTen"),
            	        rs.getDate("ngaySinh"),
            	        rs.getString("nganh"),
            	        rs.getDouble("diemTB"),
            	        rs.getString("lop")
            	);
                list.add(sv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
 // Xóa sinh viên theo mã
    public boolean deleteSinhVien(String maSV) {
        String sql = "DELETE FROM SinhVien WHERE maSV = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maSV);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
 // Cập nhật sinh viên
    public boolean updateSinhVien(SinhVien sv) {
        String sql = "UPDATE SinhVien SET hoTen=?, ngaySinh=?, nganh=?, diemTB=?, lop=? WHERE maSV=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sv.getHoTen());
            ps.setDate(2, sv.getNgaySinh());
            ps.setString(3, sv.getNganh());
            ps.setDouble(4, sv.getDiemTB());
            ps.setString(5, sv.getLop());
            ps.setString(6, sv.getMaSV());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
