
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lab5bai2 {
    ArrayList<String> list = new ArrayList<>();
    public void nhap(){
        System.out.println("Nhap danh sach ho ten: ");
        while(true){
            System.out.printf("Nhap ten: ");
            Scanner sc = new Scanner(System.in);
            String ten = sc.nextLine();
            list.add(ten);
            System.out.printf("Ban co muon nhap them khong (Y/N): ");
            if(sc.nextLine().equalsIgnoreCase("N") ){
                break;
            }
        }
    }
    public void xuat(){
        System.out.println("");
        System.out.println("Danh sach ho ten: ");
        for(String hoTen: list){
            System.out.println(hoTen);
        }
    }
    /**
     * 
     */
    public void xuatngaunhien(){
        Collections.shuffle(list);
        xuat();
    }
    
    public void sapxep(){
        Collections.sort(list);
        Collections.reverse(list);
        xuat();    
    }

    public void timvaxoaNV(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap ten ban muon xoa: ");
        String tenXoa = sc.nextLine();
        boolean kCo = false;
        for(String flag: list){
            if(flag.equalsIgnoreCase(tenXoa)){
                System.out.println(flag);
                kCo = true;
                break;
            }
        }
        if(kCo == false){
            System.out.println("Khong co ten ban can tim");
        }else{
            for(String flag: list){
                if(flag.equalsIgnoreCase(tenXoa)){
                    list.remove(tenXoa);
                    System.out.println("Xoa ten thanh cong!");
                    break;
                }
            }
            for(String flag: list){
                System.out.println("Danh sach sau khi xoa: ");
                System.out.println(flag);
                break;
            }
        }
    }
    public void menu(){
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("");
            System.out.println("--------------------------------");
            System.out.println("1. Nhap ten");
            System.out.println("2. Xuat ten");
            System.out.println("3. Xuat ngau nhien");
            System.out.println("4. Sap xep");
            System.out.println("5. Tim va xoa");
            System.out.println("0. Thoat");
            System.out.printf("Chuong trinh ban muon chon la: ");
            try{
                int so = sc.nextInt();
                switch(so){
                    case 0:
                        System.out.println("Cam on ban da su dung chuong trinh cua chung toi!"); 
                        System.exit(1);
                        break;
                    case 1:
                        System.out.println("------------------");
                        nhap();
                        break;
                    case 2:
                        System.out.println("--------------------");
                        xuat();
                        break;
                    case 3:
                        System.out.println("");
                        System.out.println("--------------------");
                        System.out.println("Xuat ngau nhien");
                        xuatngaunhien();
                        break;
                    case 4:
                        System.out.println("");
                        System.out.println("-----------------------");
                        System.out.println("Sap xep ten");
                        sapxep();
                        break;
                    case 5:
                        System.out.println("");
                        System.out.println("--------------------");
                        System.out.println("Tim va xoa ho ten");
                        timvaxoaNV();
                        break;
                    default:
                        System.out.println("Vui long nhap so 0 den 5");
                }
            }catch (Exception ex){
                System.out.println("Vui long nhap so!");
            }
        }while(true);
    }
}
