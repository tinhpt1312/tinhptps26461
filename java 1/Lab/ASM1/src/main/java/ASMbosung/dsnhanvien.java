package ASMbosung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class dsnhanvien {
    ArrayList<nhanvien> list = new ArrayList<>();

    /**
     * 
     */
    public void nhap1() {
        Scanner sc = new Scanner(System.in);
        do {
            String tenNV;
            String maNV;
            Double luongCB;
            Double phongban;
            Double ThuNhap;
            nhanvienData dt = new nhanvienData();
            System.out.printf("Phong ban(1. Hanh chinh / 2. Tiep thi / 3. Truong phong): ");
            phongban = sc.nextDouble();
            sc.nextLine();
            if (phongban == 1) {
                do {
                    System.out.printf("Ten nhan vien: ");
                    tenNV = sc.nextLine();
                    if (dt.isName(tenNV)) {
                        break;
                    } else {
                        System.out.println("Vui long nhap ky tu Anphabet! ");
                    }
                } while (true);
                do {
                    System.out.printf("Ma nhan vien: ");
                    maNV = sc.nextLine();
                    if (dt.isID(maNV)) {
                        break;
                    } else {
                        System.out.println("Nhap it nhat 2 ky tu va chi nhap so!");
                    }
                } while (true);
                String str = null;
                while (true)
                    try {
                        System.out.printf("Luong co ban: ");
                        str = sc.nextLine();
                        luongCB = Double.parseDouble(str);
                        if (luongCB >= 5000000 && luongCB <= 20000000) {
                            break;
                        } else {
                            System.out.println("Muc luong khong hop le!");
                        }
                    } catch (Exception ex) {
                        System.out.println("Khong dung nhap lai!");
                    }
                nhanvien newNV = new nhanvienhanhchinh(tenNV, maNV, luongCB, "Hanh Chinh");
                list.add(newNV);
            } else if (phongban == 2) {
                do {
                    System.out.printf("Ten nhan vien: ");
                    tenNV = sc.nextLine();
                    if (dt.isName(tenNV)) {
                        break;
                    } else {
                        System.out.println("Vui long nhap ky tu Anphabet! ");
                    }
                } while (true);
                do {
                    System.out.printf("Ma nhan vien: ");
                    maNV = sc.nextLine();
                    if (dt.isID(maNV)) {
                        break;
                    } else {
                        System.out.println("Nhap it nhat 2 ky tu va chi nhap so!");
                    }
                } while (true);
                String str = null;
                while (true)
                    try {
                        System.out.printf("Luong co ban: ");
                        str = sc.nextLine();
                        luongCB = Double.parseDouble(str);
                        if (luongCB >= 5000000 && luongCB <= 20000000) {
                            break;
                        } else {
                            System.out.println("Muc luong khong hop le!");
                        }
                    } catch (Exception ex) {
                        System.out.println("Khong dung nhap lai!");
                    }
                Double hoaHong;
                Double doanhSo;
                do {
                    System.out.printf("Hoa Hong: ");
                    hoaHong = sc.nextDouble();
                    if (luongCB > 0) {
                        break;
                    } else {
                        System.out.println("Chua dung nhap lai!");
                    }
                } while (true);
                do {
                    System.out.printf("Doanh So: ");
                    doanhSo = sc.nextDouble();
                    if (luongCB > 0) {
                        break;
                    } else {
                        System.out.println("Chua dung nhap lai!");
                    }
                } while (true);
                nhanvien newNV = new nhanvientiepthi(tenNV, maNV, luongCB, "Tiep Thi", hoaHong, doanhSo);
                list.add(newNV);
            } else if (phongban == 3) {
                do {
                    System.out.printf("Ten nhan vien: ");
                    tenNV = sc.nextLine();
                    if (dt.isName(tenNV)) {
                        break;
                    } else {
                        System.out.println("Vui long nhap ky tu Anphabet! ");
                    }
                } while (true);
                do {
                    System.out.printf("Ma nhan vien: ");
                    maNV = sc.nextLine();
                    if (dt.isID(maNV)) {
                        break;
                    } else {
                        System.out.println("Nhap it nhat 2 ky tu va chi nhap so!");
                    }
                } while (true);
                String str = null;
                while (true)
                    try {
                        System.out.printf("Luong co ban: ");
                        str = sc.nextLine();
                        luongCB = Double.parseDouble(str);
                        if (luongCB >= 20000000 && luongCB <= 50000000) {
                            break;
                        }else{
                            System.out.println("Muc luong khong hop le!");
                        }
                    } catch (Exception ex) {
                        System.out.println("Khong dung nhap lai!");
                    }
                Double luongtrachnhiem;
                do {
                    System.out.printf("Luong trach nhiem: ");
                    luongtrachnhiem = sc.nextDouble();
                    if (luongCB > 0) {
                        break;
                    } else {
                        System.out.println("Chua dung nhap lai!");
                    }
                } while (true);
                nhanvien newNV = new truongphong(tenNV, maNV, luongCB, "Truong Phong", luongtrachnhiem);
                list.add(newNV);
            }
            sc.nextLine();
            System.out.printf("Ban co muon nhap them khong (Y/N): ");
            if (sc.nextLine().equalsIgnoreCase("N")) {
                break;
            }
        } while (true);
    }

    public void xuat() {
        System.out.println("Danh sach nhan vien: ");
        System.out.printf("\t%-20s %-20s %-20s %-20s %-20s %-20s\n", "Ho ten", "Ma NV", "Thu nhap", "Phong ban", "Thue TN", "Thu Nhap");
        for (nhanvien nv : list) {
            System.out.printf("\t%-20s %-20s %-20.2f %-20s %-20.2f\n", nv.getTenNV(), nv.getMaNV(), nv.getLuong(),
                    nv.getPhongBan(), nv.getThueTN());
        }
    }

    public void timNV() {
        System.out.println("Tim va hien thi nhan vien");
        System.out.println("----------------------------------------");
        System.out.printf("Nhap ma nhan vien ban muon tim: ");
        Scanner sc = new Scanner(System.in);
        String flag = sc.nextLine();
        boolean check = false;
        for (nhanvien nv : list) {
            if (flag.equalsIgnoreCase(nv.getMaNV())) {
                System.out.printf("\t%-20s %-20s %-20s %-20s %-20s\n", "Ho ten", "Ma NV", "Thu nhap", "Phong ban",
                        "Thue TN");
                System.out.printf("\t%-20s %-20s %-20.2f %-20s %-20.2f\n", nv.getTenNV(), nv.getMaNV(), nv.getLuong(),
                        nv.getPhongBan(), nv.getThueTN());
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("Khong co nhan vien ban can tim!");
        }
    }

    public void xoaNV() {
        System.out.println("Xoa nhan vien");
        System.out.println("----------------------------------------");
        System.out.printf("Nhap ma nhan vien ban muon xoa: ");
        Scanner sc = new Scanner(System.in);
        String flag = sc.nextLine();
        boolean check = false;
        for (nhanvien nv : list) {
            if (flag.equalsIgnoreCase(nv.getMaNV())) {
                list.remove(nv);
                check = true;
                break;
            }
        }
        if (check == true) {
            System.out.println("Xoa nhan vien thanh cong!");
            System.out.println("Danh sach nhan vien sau khi xoa: ");
            System.out.printf("\t%-20s %-20s %-20s %-20s %-20s\n", "Ho ten", "Ma NV", "Thu nhap", "Phong ban",
                    "Thue TN");
            for (nhanvien nv : list) {
                System.out.printf("\t%-20s %-20s %-20.2f %-20s %-20.2f\n", nv.getTenNV(), nv.getMaNV(), nv.getLuong(),
                        nv.getPhongBan(), nv.getThueTN());
            }
        } else {
            System.out.println("Khong co nhan vien ban muon xoa!");
        }
    }

    public void timtheoLuong() {
        System.out.printf("Nhap muc luong thap nhat: ");
        Scanner sc = new Scanner(System.in);
        Double min = sc.nextDouble();
        System.out.printf("Nhap muc luong cao nhat: ");
        Double max = sc.nextDouble();
        boolean check = false;
        for (nhanvien nv : list) {
            if (min <= nv.getLuong() && nv.getLuong() <= max) {
                System.out.printf("\t%-20s %-20s %-20s %-20s %-20s\n", "Ho ten", "Ma NV", "Thu nhap", "Phong ban",
                        "Thue TN");
                System.out.printf("\t%-20s %-20s %-20.2f %-20s %-20.2f\n", nv.getTenNV(), nv.getMaNV(), nv.getLuong(),
                        nv.getPhongBan(), nv.getThueTN());
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("Khong co nhan vien ban can tim!");
        }
    }

    /**
     * 
     */
    public void capnhatNV() {
        System.out.println("Cap nhat nhan vien");
        System.out.println("------------------------------");
        System.out.printf("Ma nhan vien: ");
        Scanner sc = new Scanner(System.in);
        String maTim = sc.nextLine();
        nhanvien found = null;
        int index = 0;
        for (nhanvien nv : list) {
            if (nv.getMaNV().equalsIgnoreCase(maTim)) {
                found = nv;
                index = list.indexOf(nv);
                break;
            }
        }
        if (found != null) {
            System.out.printf("Ten nhan vien: ");
            String tenNV = sc.nextLine();
            if (tenNV.equals("") || tenNV == null) {
                tenNV = found.getTenNV();
            }
            System.out.printf("Ma nhan vien: ");
            String maNV = sc.nextLine();
            if (maNV.equals("") || maNV == null) {
                maNV = found.getMaNV();
            }
            System.out.printf("Luong co ban: ");
            String luongCB = sc.nextLine();
            if (luongCB.equals("") || luongCB == null) {
                luongCB = String.valueOf(found.getLuongCB());
            }
            if (found instanceof nhanvienhanhchinh) {
                nhanvien newNV = new nhanvienhanhchinh(tenNV, maNV, Double.parseDouble(luongCB), "Hanh chinh");
                list.set(index, newNV);
            }
            if (found instanceof nhanvientiepthi) {
                System.out.printf("Hoa hong: ");
                String hoaHong = sc.nextLine();
                if (hoaHong.equals(" ") || hoaHong == null) {
                    hoaHong = String.valueOf(((nhanvientiepthi) found).getHoaHong());
                }
                System.out.printf("Doanh so: ");
                String doanhSo = sc.nextLine();
                if (doanhSo.equals(" ") || doanhSo == null) {
                    doanhSo = String.valueOf(((nhanvientiepthi) found).getDoanhSo());
                }
                nhanvien newNV = new nhanvientiepthi(tenNV, maNV, Double.parseDouble(luongCB), "Tiep thi",
                        Double.parseDouble(hoaHong), Double.parseDouble(doanhSo));
                list.set(index, newNV);
            }
            if (found instanceof truongphong) {
                System.out.printf("Luong trach nhhien: ");
                String luongTrachNhiem = sc.nextLine();
                if (luongTrachNhiem.equals("") || luongTrachNhiem == null) {
                    luongTrachNhiem = String.valueOf(((truongphong) found).getLuongTrachNhiem());
                }
                nhanvien newNV = new truongphong(tenNV, maNV, Double.parseDouble(luongCB), "Truong phong",
                        Double.parseDouble(luongTrachNhiem));
                list.set(index, newNV);
            }
            System.out.println("Cap nhat nhan vien thanh cong!");
        } else {
            System.out.println("Khong co nhan vien can tim!");
        }
    }

    public void sapxeptheoTen() {
        Comparator<nhanvien> comp = new Comparator<nhanvien>() {

            /*
             * (non-Javadoc)
             * 
             * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
             */
            @Override
            public int compare(nhanvien nv1, nhanvien nv2) {
                return nv1.getTenNV().compareTo(nv2.getTenNV());
            }
        };
        Collections.sort(list, comp);
        System.out.println("");
        System.out.println("Danh sach nhan vien da sap xep: ");
        System.out.printf("\t%-20s %-20s %-20s %-20s %-20s\n", "Ho ten", "Ma NV", "Thu nhap", "Phong ban", "Thue TN");
        for (nhanvien nv : list) {
            System.out.printf("\t%-20s %-20s %-20.2f %-20s %-20.2f\n", nv.getTenNV(), nv.getMaNV(), nv.getLuong(),
                    nv.getPhongBan(), nv.getThueTN());
        }
    }

    public void sapxeptheoLuong() {
        Comparator<nhanvien> comp = new Comparator<nhanvien>() {
            @Override
            public int compare(nhanvien nv1, nhanvien nv2) {
                if (nv1.getLuong() > nv1.getLuong())
                    return 1;
                else
                    return -1;
            }
        };
        Collections.sort(list, comp);
        System.out.println("");
        System.out.println("Danh sach nhan vien da sap xep: ");
        System.out.printf("\t%-20s %-20s %-20s %-20s %-20s\n", "Ho ten", "Ma NV", "Thu nhap", "Phong ban", "Thue TN");
        for (nhanvien nv : list) {
            System.out.printf("\t%-20s %-20s %-20.2f %-20s %-20.2f\n", nv.getTenNV(), nv.getMaNV(), nv.getLuong(),
                    nv.getPhongBan(), nv.getThueTN());
        }
    }

    public void xuattop5() {
        Collections.sort(list, (a, b) -> (int) (b.getLuong() - a.getLuong()));
        System.out.println("5 nhan vien co muc luong cao nhat la: ");
        System.out.printf("\t%-20s %-20s %-20s %-20s %-20s\n", "Ho ten", "Ma NV", "Thu nhap", "Phong ban", "Thue TN");
        for (int i = 0; i < 5; i++) {
            System.out.printf("\t%-20s %-20s %-20.2f %-20s %-20.2f\n", list.get(i).getTenNV(), list.get(i).getMaNV(),
                    list.get(i).getLuong(), list.get(i).getPhongBan(), list.get(i).getThueTN());

        }
    }

    public void menu() {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("");
            System.out.println("+------------------------Assignment final-------------------------+");
            System.out.println("+-----------------------------------------------------------------+");
            System.out.println("+   1. Nhap xuat danh sach nhan vien tu ban phim                  +");
            System.out.println("+   2. Xuat danh sach nhan vien ra man hinh                       +");
            System.out.println("+   3. Tim va hien thi nhan vien theo ma nhap tu ban phim         +");
            System.out.println("+   4. Xoa nhan vien theo ma nhap tu ban phim                     +");
            System.out.println("+   5. Cap nhat thong tin nhan vien theo ma nhap tu ban phim      +");
            System.out.println("+   6. Tim cac nhan vien theo khoan luong nhap tu ban phim        +");
            System.out.println("+   7. Sap xep nhan vien theo ho va ten                           +");
            System.out.println("+   8. Sap xep nhan vien theo thu nhap                            +");
            System.out.println("+   9. Xuat 5 nhan vien co thu nhap cao nhat                      +");
            System.out.println("+   0. Thoat                                                      +");
            System.out.println("+-----------------------------------------------------------------+");
            System.out.println("+--------------------Moi ban chon chuc nang!----------------------+");
            System.out.println("");
            System.out.printf("Chuc nang ban muon chon la: ");
            try {
                int so = sc.nextInt();
                switch (so) {
                    case 0:
                        System.out.println("Cam on ban da su dung chuong trinh cua chung toi!");
                        System.exit(1);
                        break;
                    case 1:
                        System.out.println("------------------");
                        nhap1();
                        break;
                    case 2:
                        System.out.println("--------------------");
                        xuat();
                        break;
                    case 3:
                        System.out.println("----------------------");
                        timNV();
                        break;
                    case 4:
                        System.out.println("------------------------");
                        xoaNV();
                        break;
                    case 5:
                        System.out.println("--------------------------");
                        capnhatNV();
                        break;
                    case 6:
                        System.out.println("-------------------------");
                        timtheoLuong();
                        break;
                    case 7:
                        System.out.println("-------------------------");
                        sapxeptheoTen();
                        break;
                    case 8:
                        System.out.println("-----------------------");
                        sapxeptheoLuong();
                        break;
                    case 9:
                        System.out.println("----------------------");
                        xuattop5();
                        break;
                    default:
                        System.out.println("Vui long nhap so 0 den 5");
                }
            } catch (Exception ex) {
                System.out.println("Vui long nhap so!");
            }
        } while (true);
    }
}
