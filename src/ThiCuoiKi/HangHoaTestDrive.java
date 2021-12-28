package ThiCuoiKi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HangHoaTestDrive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Date ngayNhap = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        ListHangHoa listHangHoa = new ListHangHoa();
        do{
            System.out.println("|--------------------------MENU--------------------------|");
            System.out.println("|1 Them Hang Hoa                                         |");
            System.out.println("|2 Xoa Hang Hoa                                          |");
            System.out.println("|3 Sua Hang Hoa                                          |");
            System.out.println("|4 Sap Xep Hang Hoa                                      |");
            System.out.println("|5 Thong Ke Hang Hoa                                     |");
            System.out.println("|6 Xem Danh Sach Hang Hoa                                |");
            System.out.println("|7 Tim Kiem Hang Hoa                                     |");
            System.out.println("|9 THOAT                                                 |");
            System.out.println("|--------------------------------------------------------|");
            System.out.println("Lua chon cua ban:");
            int lc = sc.nextInt();
            switch(lc)
            {
                case 1:
                String loaiHh = null;
                sc.nextLine();
                System.out.println("Nhập Tên Hàng:");
                String ten = sc.nextLine();
                System.out.println("Nhập Số Lượng:");
                int soLuong = sc.nextInt();
                System.out.println("Nhập Giá:");
                float gia = sc.nextFloat();
                System.out.println("Nhập Loại Hàng [1: Thưc Pham; 2: Sanh Su; 3: Dien May]");
                int l = sc.nextInt();
                switch(l)
                {
                    case 1: loaiHh = "Thuc Pham";
                    break;
                    case 2: loaiHh = "Sanh Su";
                    break;
                    case 3: loaiHh = "Dien May";
                    break;
                    default: System.out.println("Loai Khong Hop Le!");
                    break;
                }
                sc.nextLine();
                try {
                    System.out.println("Nhap Ngay Vao Kho [dd/MM/yyyy]");
                    ngayNhap = df.parse(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Ngày Khong Dung!!");
                }
                HangHoa hangHoa = new HangHoa(soLuong, ten, loaiHh, gia, ngayNhap);
                listHangHoa.ThemHangHoa(hangHoa);
                    break;
                case 2:
                System.out.println("Nhap loai can xoa:");
                int id1 = sc.nextInt();
                listHangHoa.XoaHangHoa(id1);
                    break;
                case 3:
                System.out.println("Nhap ID can sua:");
                int id = sc.nextInt();
                listHangHoa.SuaThongTin(id);
                    break;
                case 4:
                System.out.println("Muon sap xep [1: Tang Dan ];[2: Giam Dan ]");
                    int llll_ = sc.nextInt();
                    switch(llll_){
                        case 1:
                        listHangHoa.SapXepTangDan();
                        break;
                        case 2:
                        listHangHoa.SapXepGiamDan();
                        break;
                        default: System.out.println("Lựa Chọn Không Hợp Lệ");
                    }
                    break;
                case 5:
                listHangHoa.ThongKe();
                    break;
                case 6:
                listHangHoa.HienThiHangHoa();
                    break;
                case 7:
                System.out.println("Muốn Tìm Theo Loại [1]");
                int lll = sc.nextInt();
                switch(lll)
                {
                    case 1:
                    System.out.println("Nhập Loại Muốn Tìm [1: Thực Phẩm; 2: Sành Sứ; 3: Điện Máy]");
                    System.out.println("Nhập Loại Muốn Tìm:");
                    int l1 = sc.nextInt();
                    String ll = null;
                    switch(l1){
                        case 1: ll = "Thực Phẩm";
                        break;
                        case 2: ll = "Sành Sứ";
                        break;
                        case 3: ll = "Điện Máy";
                        break;
                        default: System.out.println("Loại Không Hợp Lệ!!");
                        break;
                    }
                    listHangHoa.TimKiemTheoLoai(ll);
                    break;
                       
                }
                break;
            }
           
        }while(true);
    }
}
