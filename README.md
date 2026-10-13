# Quản lý người lao động – Java OOP

Bài tập lập trình hướng đối tượng theo sơ đồ kế thừa:

```text
                 NguoiLaoDong (abstract)
                  /       |       \
             QuanLy    NhanVien   CongNhan
```

## Tính năng

- Constructor, getter/setter, thuộc tính `private` (đóng gói).
- Kế thừa (`extends`), phương thức trừu tượng và ghi đè (`@Override`), đa hình.
- Menu: thêm, xem danh sách, tìm, sửa, xóa, tính tổng lương.
- Kiểm tra dữ liệu đầu vào và tránh trùng mã.
- Chạy trong **một file `Main.java`**, không cần thư viện ngoài.

## Yêu cầu

JDK 8 trở lên.

## Chạy chương trình

Mở terminal trong thư mục này:

```bash
javac -encoding UTF-8 Main.java
java Main
```

Các file `.class` được tạo tự động khi biên dịch và không cần đưa lên GitHub.

## Công thức lương minh họa

| Loại | Công thức |
| --- | --- |
| Quản lý | Lương cơ bản + phụ cấp |
| Nhân viên | Lương cơ bản + thưởng |
| Công nhân | Số sản phẩm × đơn giá/sản phẩm |

**Lưu ý:** Phần chữ trên ảnh bảng hơi mờ, nên công thức tính lương và menu trên là phần triển khai mẫu, có thể sửa theo yêu cầu cụ thể của giáo viên. Dữ liệu hiện chỉ lưu trong RAM; thoát chương trình sẽ mất dữ liệu.

## Đẩy lên GitHub

Tạo một repository trống trên GitHub (không tích sẵn README). Chạy trong thư mục project:

```bash
git init
git add .
git commit -m "Initial commit: Java OOP employee management"
git branch -M main
git remote add origin https://github.com/USERNAME/QuanLyNguoiLaoDong.git
git push -u origin main
```

Thay `USERNAME` bằng tên tài khoản GitHub của bạn. Nếu Git yêu cầu thiết lập danh tính, chạy `git config --global user.name "Ten cua ban"` và `git config --global user.email "email@example.com"` trước khi commit. GitHub có thể yêu cầu xác thực qua trình duyệt hoặc credential manager.
