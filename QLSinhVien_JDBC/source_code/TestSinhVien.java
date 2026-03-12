package test;

import dao.SinhVienDAO;
import model.SinhVien;
import util.Validate;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class TestSinhVien {

    public static void main(String[] args) {

        SinhVienDAO dao = new SinhVienDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== QUẢN LÝ SINH VIÊN ===");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Cập nhật sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Xem danh sách tất cả sinh viên");
            System.out.println("5. Tìm sinh viên theo ngành");
            System.out.println("6. Sắp xếp theo điểm giảm dần");
            System.out.println("7. Thống kê xếp loại");
            System.out.println("8. In danh sách sinh viên theo lớp");
            System.out.println("9. In sinh viên theo tháng sinh");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Nhập mã SV: ");
                    String maSV = sc.nextLine();

                    System.out.print("Nhập họ tên: ");
                    String hoTen = sc.nextLine();

                    System.out.print("Nhập ngày sinh (yyyy-mm-dd): ");
                    Date ngaySinh = Date.valueOf(sc.nextLine());

                    System.out.print("Nhập ngành: ");
                    String nganh = sc.nextLine();

                    System.out.print("Nhập điểm: ");
                    double diem = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Nhập lớp: ");
                    String lop = sc.nextLine();

                    // VALIDATE
                    if (!Validate.isValidNganh(nganh)
                            || !Validate.isValidMaSV(maSV, nganh)
                            || !Validate.isValidDiem(diem)
                            || !Validate.isValidTuoi(ngaySinh)) {
                        System.out.println("Dữ liệu không hợp lệ ❌");
                        break;
                    }

                    hoTen = Validate.chuanHoaTen(hoTen);

                    SinhVien sv = new SinhVien(maSV, hoTen, ngaySinh, nganh, diem, lop);

                    if (dao.insertSinhVien(sv))
                        System.out.println("Thêm thành công ✅");
                    else
                        System.out.println("Thêm thất bại ❌");

                    break;

                case 2:
                    System.out.print("Nhập mã SV cần cập nhật: ");
                    String maUpdate = sc.nextLine();

                    System.out.print("Nhập điểm mới: ");
                    double diemMoi = sc.nextDouble();
                    sc.nextLine();

                    if (!Validate.isValidDiem(diemMoi)) {
                        System.out.println("Điểm không hợp lệ ❌");
                        break;
                    }

                    // Lấy danh sách để tìm SV
                    List<SinhVien> list = dao.getAllSinhVien();
                    for (SinhVien s : list) {
                        if (s.getMaSV().equals(maUpdate)) {
                            s.setDiemTB(diemMoi);
                            dao.updateSinhVien(s);
                            System.out.println("Cập nhật thành công ✅");
                            break;
                        }
                    }

                    break;

                case 3:
                    System.out.print("Nhập mã SV cần xóa: ");
                    String maDelete = sc.nextLine();

                    if (dao.deleteSinhVien(maDelete))
                        System.out.println("Xóa thành công ✅");
                    else
                        System.out.println("Xóa thất bại ❌");

                    break;

                case 4:
                    List<SinhVien> ds = dao.getAllSinhVien();
                    for (SinhVien s : ds)
                        System.out.println(s);
                    break;
                    
                case 5: {
                    System.out.print("Nhập ngành cần tìm: ");
                    String nganhTim = sc.nextLine();

                    List<SinhVien> listNganh = dao.getAllSinhVien();

                    boolean found = false;

                    for (SinhVien s : listNganh) {
                        if (s.getNganh().equalsIgnoreCase(nganhTim)) {
                            System.out.println(s);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy sinh viên thuộc ngành này!");
                    }

                    break;
                }

                case 6: {
                    List<SinhVien> listSort = dao.getAllSinhVien();

                    listSort.sort((a, b) -> Double.compare(b.getDiemTB(), a.getDiemTB()));

                    System.out.println("Danh sách sau khi sắp xếp giảm dần theo điểm:");

                    for (SinhVien s : listSort) {
                        System.out.println(s);
                    }

                    break;
                }
                    
                case 7: {
                    List<SinhVien> listTK = dao.getAllSinhVien();

                    int gioi = 0;
                    int kha = 0;
                    int trungBinh = 0;
                    int yeu = 0;

                    for (SinhVien s : listTK) {
                        double diemTK = s.getDiemTB();

                        if (diemTK >= 8) {
                            gioi++;
                        } else if (diemTK >= 6.5) {
                            kha++;
                        } else if (diemTK >= 5) {
                            trungBinh++;
                        } else {
                            yeu++;
                        }
                    }

                    System.out.println("== THỐNG KÊ ==");
                    System.out.println("Giỏi: " + gioi);
                    System.out.println("Khá: " + kha);
                    System.out.println("Trung bình: " + trungBinh);
                    System.out.println("Yếu: " + yeu);

                    break;
                }
                
                case 8: {
                    System.out.print("Nhập lớp cần tìm: ");
                    String lopTim = sc.nextLine();

                    List<SinhVien> listLop = dao.getAllSinhVien();
                    boolean found = false;

                    for (SinhVien s : listLop) {
                        if (s.getLop().equalsIgnoreCase(lopTim)) {
                            System.out.println(s);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Không có sinh viên thuộc lớp này!");
                    }

                    break;
                }
                
                case 9: {
                    System.out.print("Nhập tháng cần tìm (1-12): ");
                    int thang = sc.nextInt();
                    sc.nextLine();

                    if (thang < 1 || thang > 12) {
                        System.out.println("Tháng không hợp lệ!");
                        break;
                    }

                    List<SinhVien> listThang = dao.getAllSinhVien();
                    boolean found = false;

                    for (SinhVien s : listThang) {
                    	Date ns = s.getNgaySinh();
                    	
                        int thangSinh = ns.toLocalDate().getMonthValue();

                        if (thangSinh == thang) {
                            System.out.println(s);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Không có sinh viên sinh vào tháng này!");
                    }

                    break;
                }
                    
                case 0:
                    System.out.println("Thoát chương trình...");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);

        sc.close();
    }
}
