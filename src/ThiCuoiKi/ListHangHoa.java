package ThiCuoiKi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ListHangHoa {
    private Node head, tail;
    HangHoa hangHoa = new HangHoa();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date ngayNhap = new Date();
    Scanner sc = new Scanner(System.in);
    public ListHangHoa()
    {
        hangHoa.autoId = 1;
        this.head = null;
        this.tail = null;
    }
    public boolean isEmpty()
    {
        return this.head == null;
    }
    public void ThemHangHoa(HangHoa hangHoa)
    {
        if(isEmpty())
        {
            this.head = this.tail = new Node(hangHoa);
            return;
        }
        Node newNode = new Node(hangHoa);
        this.tail.setNext(newNode);
        this.tail = newNode;

    }
    public void HienThiHangHoa()
    {
        System.out.println("------------------------------------------THÔNG TIN HÀNG HOÁ-------------------------------------------");
        System.out.printf("%-20S %-20S %-20S %-20S %-20S %-20S\n", "mã hàng", "tên hàng", "số lượng", "giá hàng", "loại hàng", "ngày nhập kho");
        Node node = this.head;
        while(node != null){
            System.out.printf("%-20d %-20S %-15d %-7.3fVNĐ %20S %20S\n", node.getHangHoa().iD, node.getHangHoa().tenHangHoa, node.getHangHoa().soLuong, node.getHangHoa().giaHang, node.getHangHoa().getLoai(),df.format(node.getHangHoa().ngayNhap)); 
            node = node.getNext();
        }
    }
    public void ThemNhieuHangHoa(HangHoa...hangHoas)
    {
        for(HangHoa hangHoa : hangHoas)
        {
            ThemHangHoa(hangHoa);
        }
    }
    public boolean XoaHangHoa(int id)
    {
        Node node = this.head;
        if(this.head.getHangHoa().getiD() == id){
            this.head = this.head.getNext();
            System.out.println("Đã Xoá Đối Tượng Đầu Tiên!!");
            return true;
        }
        else{
            System.out.println("Đối Tượng Đã Được Xóa");
        }
        while(node != null)
        {
            if(node.getNext().getHangHoa().getiD() == id){
                node.setNext(node.getNext().getNext());
                System.out.println("Xoá Thành Công!!!");
                return true;
            }
            else{
                System.out.println("ID Không Tồn Tại!!");
            }
            node = node.getNext();
        }
        System.out.println("Xoá Không Thành Công!!!");
        return false;
    }
    public boolean SuaThongTin(int id){
        Node node = this.head;
        while(node != null)
        {
            if(node.getHangHoa().getiD() == id)
            {
                String loaiHh = null;
                System.out.println("Nhập Tên Hàng:");
                String ten = sc.nextLine();
                System.out.println("Nhập Số Lượng:");
                int soLuong = sc.nextInt();
                System.out.println("Nhập Giá:");
                float gia = sc.nextFloat();
                System.out.println("Nhập Loại Hàng [1: Thực Phẩm; 2: Sành Sứ; 3: Điện Máy]");
                int l = sc.nextInt();
                switch(l)
                {
                    case 1: loaiHh = "Thực Phẩm";
                    break;
                    case 2: loaiHh = "Sành Sứ";
                    break;
                    case 3: loaiHh = "Điện Máy";
                    break;
                    default: System.out.println("Loại Không Hợp Lệ!!!");
                    break;
                }
                sc.nextLine();
                try {
                    System.out.println("Nhập Ngày Vào Kho [dd/MM/yyyy]");
                    ngayNhap = df.parse(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Ngày Không Hợp Lệ!!!!");
                }
                node.getHangHoa().setTenHangHoa(ten);
                node.getHangHoa().setSoLuong(soLuong);
                node.getHangHoa().setGiaHang(gia);
                node.getHangHoa().setLoai(loaiHh);
                node.getHangHoa().setNgayNhap(ngayNhap);
                return true;
            }
            node = node.getNext();
        }
        System.out.println("Không Thể Sửa!!!");
        return false;
    }  
    public void SapXepTangDan(){
        Node node = this.head, node2 = null;
        float temp;
        while(node != null){
            node2 = node.getNext();
            while(node2 != null){
                if(node.getHangHoa().getGiaHang() > node2.getHangHoa().getGiaHang()){
                    temp = node.getHangHoa().giaHang;
                    node.getHangHoa().giaHang = node2.getHangHoa().giaHang;
                    node2.getHangHoa().giaHang = temp; 
                }
                node2 = node2.getNext();
            }
            node = node.getNext();
        }
        System.out.println("vui long xem lai"); 
    }
    public void SapXepGiamDan(){
        Node node = this.head, node2 = null;
        float temp;
        while(node != null){
            node2 = node.getNext();
            while(node2 != null){
                if(node.getHangHoa().getGiaHang() < node2.getHangHoa().getGiaHang()){
                    temp = node.getHangHoa().giaHang;
                    node.getHangHoa().giaHang = node2.getHangHoa().giaHang;
                    node2.getHangHoa().giaHang = temp; 
                }
                node2 = node2.getNext();
            }
            node = node.getNext();
        }
        System.out.println("Vui long xem lai");

    }
    public void ThongKe(){
        Node node = this.head;
        int sLtemp = 0;
        float gTtemp = 0;
        while(node != null){
            sLtemp += node.getHangHoa().getSoLuong();
            gTtemp += node.getHangHoa().getGiaHang();
            node = node.getNext();
        }
        System.out.println("Thong tin thong ke");
        System.out.printf("%-30S %-30S\n", "tổng số lượng", "tổng giá trị");
        System.out.printf("%-30d %-30.3fVNĐ\n", sLtemp, gTtemp);
    }
    public boolean TimKiemTheoLoai(String l){
        System.out.println("THÔNG TIN");
        System.out.printf("%-20S %-20S %-20S %-20S %-20S %-20S\n", "mã hàng", "tên hàng", "số lượng", "giá hàng", "loại hàng", "ngày nhập kho");
        boolean isFound = false;
        Node node = this.head;
        while(node != null)
        {
            if(node.getHangHoa().getLoai().contains(l))
            {
                System.out.printf("%-20d %-20S %-15d %-7.3fVND %20S %20S\n", node.getHangHoa().iD, node.getHangHoa().tenHangHoa, node.getHangHoa().soLuong, node.getHangHoa().giaHang, node.getHangHoa().getLoai(),df.format(node.getHangHoa().ngayNhap)); 
                isFound = true;
            }
            node = node.getNext();
        }
        if(!isFound)
        {
            System.out.println("Loại Muốn Tìm Không Hợp Lệ!");
            return false;
        }
        return true;
    }
}
