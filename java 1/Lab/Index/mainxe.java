import java.util.ArrayList;

public class mainxe {
    public static void main(String[] args) {
        ArrayList <xe> list = new ArrayList<>();
        xe newXe = new xe("MazDa", 100);
        list.add(newXe);
        xe newXe1 = new xehoi("MazDa", 100, 13.2);
        list.add(newXe1);
        xe newXe2 = new xetai("HonDa", 100, 1000);
        list.add(newXe2);
        for(xe flag: list){
            flag.xuatThongTin();
        }
    }
}
