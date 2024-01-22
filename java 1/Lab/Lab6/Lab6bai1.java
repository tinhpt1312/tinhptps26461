import java.util.Scanner;

public class Lab6bai1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap ho ten: ");
        String hoTen = sc.nextLine();
        hoTen.trim();
        String ho = hoTen.substring(0, hoTen.indexOf(" "));
        String tenDem = hoTen.substring(hoTen.indexOf(" "), hoTen.lastIndexOf(" "));
        String ten = hoTen.substring(hoTen.lastIndexOf(" "));
        System.out.printf("\t %s %s %s ", ho.toUpperCase(), tenDem , ten.toUpperCase());
    }
}