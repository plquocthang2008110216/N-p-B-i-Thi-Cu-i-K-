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
            return true;
        }
        else{
            System.out.println("Doi Tuong Da Duoc Xoa");
        }
        while(node != null)
        {
            if(node.getNext().getHangHoa().getiD() == id){
                node.setNext(node.getNext().getNext());
                System.out.println("Xoa Thanh Cong");
                return true;
            }
            else{
                System.out.println("Mat Hang Khong Co");
            }
            node = node.getNext();
        }
        System.out.println("Xoa Khong Thanh Cong");
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
                    case 1: loaiHh = "Thuc Pham";
                    break;
                    case 2: loaiHh = "Sanh Su";
                    break;
                    case 3: loaiHh = "Dien May";
                    break;
                    default: System.out.println("Khong Hop Le");
                    break;
                }
                sc.nextLine();
                try {
                    System.out.println("Nhap Ngay Vao Kho [dd/MM/yyyy]");
                    ngayNhap = df.parse(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Ngay Khong Hop Le");
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
        System.out.println("Khong the sua");
        return false;
    }  
    public void SapXepTangDan(){
        Node node = this.head, node2 = null;
        HangHoa tempHangHoa;
        if(head == null)
        return;
        else{
            while(node != null){
                node2 = node.next;
                while(node2 != null){
                    if(node.hangHoa.giaHang < node2.hangHoa.giaHang){
                        tempHangHoa = node.hangHoa;
                        node.hangHoa = node2.hangHoa;
                        node2.hangHoa = tempHangHoa;
                    }
                    node2 = node2.next;
                }
                node = node.next;
            }
        }
        HienThiHangHoa();
    }
    
    public void SapXepGiamDan(){
        Node node = this.head, node2 = null;
        HangHoa tempHangHoa;
        if(head == null)
        return;
        else{
            while(node != null){
                node2 = node.next;
                while(node2 != null){
                    if(node.hangHoa.giaHang > node2.hangHoa.giaHang){
                        tempHangHoa = node.hangHoa;
                        node.hangHoa = node2.hangHoa;
                        node2.hangHoa = tempHangHoa;
                    }
                    node2 = node2.next;
                }
                node = node.next;
            }
        }
        HienThiHangHoa();
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
            System.out.println("Loai Muon Tim Khong Hop Le");
            return false;
        }
        return true;
    }
    public void DuLieuMacDinh(){
        try {
            String sDate1 = "01/02/1999";  
            String sDate2 = "01/06/1997";  
            String sDate3 = "08/05/1999";  
            String sDate4 = "07/07/1997";  
            String sDate5 = "21/12/2021";  
            String sDate6 = "12/12/2012";  
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");  
            Date date1=formatter1.parse(sDate1);  
            Date date2=formatter1.parse(sDate2);  
            Date date3=formatter1.parse(sDate3);  
            Date date4=formatter1.parse(sDate4);  
            Date date5=formatter1.parse(sDate5);  
            Date date6=formatter1.parse(sDate6); 
            HangHoa hangHoa1 = new HangHoa(50, "binh", "Sanh Su", 200, date4);
            HangHoa hangHoa2 = new HangHoa(10, "cai xanh", "Thuc Pham", 500, date5);
            HangHoa hangHoa3 = new HangHoa(20, "quat", "Dien May", 500, date3);
            HangHoa hangHoa4 = new HangHoa(56, "dien thoai", "Dien May", 10, date3);
            HangHoa hangHoa5 = new HangHoa(45, "rau muong", "Thuc Pham", 5000, date2);
            HangHoa hangHoa6 = new HangHoa(78, "bi dao", "Thuc Pham", 300, date5);
            HangHoa hangHoa7 = new HangHoa(97, "may giat", "Dien May", 100, date4);
            HangHoa hangHoa8 = new HangHoa(152, "my ly", "Thuc Pham", 600, date1);
            HangHoa hangHoa9 = new HangHoa(150, "chen", "Sanh Su", 150, date3);
            HangHoa hangHoa10 = new HangHoa(15500, "bep dien", "Dien May", 200, date5);
            ThemHangHoa(hangHoa1);
            ThemHangHoa(hangHoa2);
            ThemHangHoa(hangHoa3);
            ThemHangHoa(hangHoa4);
            ThemHangHoa(hangHoa5);
            ThemHangHoa(hangHoa6);
            ThemHangHoa(hangHoa7);
            ThemHangHoa(hangHoa8);
            ThemHangHoa(hangHoa9);
            ThemHangHoa(hangHoa10);
        } catch (Exception e) {
            e.getCause();
        }
    }
}
