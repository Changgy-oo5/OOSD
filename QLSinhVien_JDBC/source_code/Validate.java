package util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class Validate {

    // Kiểm tra điểm
    public static boolean isValidDiem(double diem) {
        return diem >= 0.0 && diem <= 10.0;
    }

    // Kiểm tra ngành
    public static boolean isValidNganh(String nganh) {
        return nganh.equals("CNTT") || nganh.equals("KTPM");
    }

    // Kiểm tra mã sinh viên
    public static boolean isValidMaSV(String maSV, String nganh) {

        if (!maSV.matches("\\d{10}")) return false;

        if (nganh.equals("CNTT") && maSV.startsWith("455105"))
            return true;

        if (nganh.equals("KTPM") && maSV.startsWith("455109"))
            return true;

        return false;
    }

    // Kiểm tra tuổi
    public static boolean isValidTuoi(Date ngaySinh) {

        LocalDate birth = ngaySinh.toLocalDate();
        LocalDate now = LocalDate.now();

        int tuoi = Period.between(birth, now).getYears();

        return tuoi >= 15 && tuoi <= 110;
    }

    // Chuẩn hóa họ tên
    public static String chuanHoaTen(String ten) {

        ten = ten.trim().toLowerCase();
        String[] parts = ten.split("\\s+");

        StringBuilder sb = new StringBuilder();

        for (String p : parts) {
            sb.append(Character.toUpperCase(p.charAt(0)))
              .append(p.substring(1))
              .append(" ");
        }

        return sb.toString().trim();
    }
}