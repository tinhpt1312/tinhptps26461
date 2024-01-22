import java.util.ArrayList;
import java.util.Scanner;

public class Lab6bai2_1 {
    public static void main(String[] args){
        ArrayList<Lab6bai2> list = new ArrayList<>();
        while(true){
            Lab6bai2 ds = new Lab6bai2();
            ds.nhap();
            list.add(ds);
            Scanner sc = new Scanner(System.in);
            System.out.printf("Ban co muon nhap them san pham (Y/N): ");
            if(sc.nextLine().equalsIgnoreCase("N")){
                System.out.println("Nhap du lieu thanh cong!");
                break;
            }
        }
        for(Lab6bai2 sp: list){
            if(sp.getHangSp().equalsIgnoreCase("nokia")){
                sp.xuat();
                System.out.println(" ");
            }
        }
    }
}
