import java.util.ArrayList;
import java.util.Scanner;




public class SinhvienDS {
    ArrayList<Sinhvien> list = new ArrayList<>();

    public void nhap(){
        while(true){
            Sinhvien sv = new Sinhvien();
            sv.nhap();
            list.add(sv);
            Scanner sc = new Scanner(System.in);
            System.out.printf("Ban co muon nhap them khong (Y/N): ");
            if(sc.nextLine().equalsIgnoreCase("N")){
                System.out.println("Nhap du lieu thanh cong!");
                break;
            }
        }
    }

    public void xuat(){
        System.out.println("-----------------------");
        System.out.println("Danh sach sinh vien: ");
        for(Sinhvien sv: list){
            sv.xuat();
        }
    }
}
