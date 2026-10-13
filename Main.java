import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Chuong trinh OOP: Ke thua, dong goi, da hinh va lop truu tuong.
abstract class NguoiLaoDong {
    private String ma;
    private String hoTen;
    private int tuoi;

    public NguoiLaoDong(String ma, String hoTen, int tuoi) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
    }

    public String getMa() { return ma; }
    public void setMa(String ma) { this.ma = ma; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public int getTuoi() { return tuoi; }
    public void setTuoi(int tuoi) { this.tuoi = tuoi; }

    public abstract double tinhLuong();
    public abstract String getLoai();

    public void hienThi() {
        System.out.printf("%-8s | %-22s | %-5d | %-12s | %,14.0f VND%n",
                ma, hoTen, tuoi, getLoai(), tinhLuong());
    }
}

class QuanLy extends NguoiLaoDong {
    private double luongCoBan;
    private double phuCap;

    public QuanLy(String ma, String hoTen, int tuoi, double luongCoBan, double phuCap) {
        super(ma, hoTen, tuoi);
        this.luongCoBan = luongCoBan;
        this.phuCap = phuCap;
    }

    public double getLuongCoBan() { return luongCoBan; }
    public void setLuongCoBan(double luongCoBan) { this.luongCoBan = luongCoBan; }
    public double getPhuCap() { return phuCap; }
    public void setPhuCap(double phuCap) { this.phuCap = phuCap; }
    @Override public String getLoai() { return "Quan ly"; }
    @Override public double tinhLuong() { return luongCoBan + phuCap; }
}

class NhanVien extends NguoiLaoDong {
    private double luongCoBan;
    private double thuong;

    public NhanVien(String ma, String hoTen, int tuoi, double luongCoBan, double thuong) {
        super(ma, hoTen, tuoi);
        this.luongCoBan = luongCoBan;
        this.thuong = thuong;
    }

    public double getLuongCoBan() { return luongCoBan; }
    public void setLuongCoBan(double luongCoBan) { this.luongCoBan = luongCoBan; }
    public double getThuong() { return thuong; }
    public void setThuong(double thuong) { this.thuong = thuong; }
    @Override public String getLoai() { return "Nhan vien"; }
    @Override public double tinhLuong() { return luongCoBan + thuong; }
}

class CongNhan extends NguoiLaoDong {
    private int soSanPham;
    private double donGiaSanPham;

    public CongNhan(String ma, String hoTen, int tuoi, int soSanPham, double donGiaSanPham) {
        super(ma, hoTen, tuoi);
        this.soSanPham = soSanPham;
        this.donGiaSanPham = donGiaSanPham;
    }

    public int getSoSanPham() { return soSanPham; }
    public void setSoSanPham(int soSanPham) { this.soSanPham = soSanPham; }
    public double getDonGiaSanPham() { return donGiaSanPham; }
    public void setDonGiaSanPham(double donGiaSanPham) { this.donGiaSanPham = donGiaSanPham; }
    @Override public String getLoai() { return "Cong nhan"; }
    @Override public double tinhLuong() { return soSanPham * donGiaSanPham; }
}

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<NguoiLaoDong> danhSach = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========== QUAN LY NGUOI LAO DONG ==========");
            System.out.println("1. Them nguoi lao dong");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim theo ma");
            System.out.println("4. Sua thong tin");
            System.out.println("5. Xoa theo ma");
            System.out.println("6. Tong quy luong");
            System.out.println("0. Thoat");
            int chon = nhapInt("Chon chuc nang: ", 0);
            switch (chon) {
                case 1: them(); break;
                case 2: hienThi(); break;
                case 3: tim(); break;
                case 4: sua(); break;
                case 5: xoa(); break;
                case 6: tongLuong(); break;
                case 0: System.out.println("Da thoat chuong trinh."); return;
                default: System.out.println("Vui long chon tu 0 den 6.");
            }
        }
    }

    private static String nhapChuoi(String nhac) {
        while (true) {
            System.out.print(nhac);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Khong duoc bo trong.");
        }
    }

    private static int nhapInt(String nhac, int min) {
        while (true) {
            try {
                System.out.print(nhac);
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n >= min) return n;
            } catch (NumberFormatException e) {
                // Thong bao chung ben duoi.
            }
            System.out.println("Vui long nhap so nguyen >= " + min + ".");
        }
    }

    private static double nhapDouble(String nhac) {
        while (true) {
            try {
                System.out.print(nhac);
                double n = Double.parseDouble(sc.nextLine().trim());
                if (Double.isFinite(n) && n >= 0) return n;
            } catch (NumberFormatException e) {
                // Thong bao chung ben duoi.
            }
            System.out.println("Vui long nhap so hop le >= 0 (vi du: 5000000).");
        }
    }

    private static NguoiLaoDong timTheoMa(String ma) {
        for (NguoiLaoDong n : danhSach) {
            if (n.getMa().equalsIgnoreCase(ma)) return n;
        }
        return null;
    }

    private static void them() {
        System.out.println("1. Quan ly | 2. Nhan vien | 3. Cong nhan");
        int loai = nhapInt("Chon loai: ", 1);
        if (loai > 3) {
            System.out.println("Loai khong hop le.");
            return;
        }
        String ma = nhapChuoi("Ma: ");
        if (timTheoMa(ma) != null) {
            System.out.println("Ma da ton tai!");
            return;
        }
        String ten = nhapChuoi("Ho ten: ");
        int tuoi = nhapInt("Tuoi: ", 1);
        NguoiLaoDong n;
        if (loai == 1) {
            n = new QuanLy(ma, ten, tuoi, nhapDouble("Luong co ban: "), nhapDouble("Phu cap: "));
        } else if (loai == 2) {
            n = new NhanVien(ma, ten, tuoi, nhapDouble("Luong co ban: "), nhapDouble("Thuong: "));
        } else {
            n = new CongNhan(ma, ten, tuoi, nhapInt("So san pham: ", 0), nhapDouble("Don gia/san pham: "));
        }
        danhSach.add(n);
        System.out.println("Them thanh cong!");
    }

    private static void tieuDe() {
        System.out.printf("%-8s | %-22s | %-5s | %-12s | %s%n",
                "Ma", "Ho ten", "Tuoi", "Loai", "Luong");
        System.out.println("-------------------------------------------------------------------------------");
    }

    private static void hienThi() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach dang trong.");
            return;
        }
        tieuDe();
        for (NguoiLaoDong n : danhSach) n.hienThi();
    }

    private static void tim() {
        NguoiLaoDong n = timTheoMa(nhapChuoi("Nhap ma can tim: "));
        if (n == null) System.out.println("Khong tim thay.");
        else { tieuDe(); n.hienThi(); }
    }

    private static void sua() {
        NguoiLaoDong n = timTheoMa(nhapChuoi("Nhap ma can sua: "));
        if (n == null) { System.out.println("Khong tim thay."); return; }
        n.setHoTen(nhapChuoi("Ho ten moi: "));
        n.setTuoi(nhapInt("Tuoi moi: ", 1));
        if (n instanceof QuanLy) {
            QuanLy q = (QuanLy) n;
            q.setLuongCoBan(nhapDouble("Luong co ban moi: "));
            q.setPhuCap(nhapDouble("Phu cap moi: "));
        } else if (n instanceof NhanVien) {
            NhanVien v = (NhanVien) n;
            v.setLuongCoBan(nhapDouble("Luong co ban moi: "));
            v.setThuong(nhapDouble("Thuong moi: "));
        } else if (n instanceof CongNhan) {
            CongNhan c = (CongNhan) n;
            c.setSoSanPham(nhapInt("So san pham moi: ", 0));
            c.setDonGiaSanPham(nhapDouble("Don gia moi: "));
        }
        System.out.println("Sua thanh cong!");
    }

    private static void xoa() {
        NguoiLaoDong n = timTheoMa(nhapChuoi("Nhap ma can xoa: "));
        if (n == null) System.out.println("Khong tim thay.");
        else { danhSach.remove(n); System.out.println("Xoa thanh cong!"); }
    }

    private static void tongLuong() {
        double tong = 0;
        for (NguoiLaoDong n : danhSach) tong += n.tinhLuong();
        System.out.printf("Tong luong %d nguoi: %,.0f VND%n", danhSach.size(), tong);
    }
}
