package ASMbosung;

public class truongphong extends nhanvien {
    double luongTrachNhiem;

    public truongphong(String tenNV, String maNV, double luongCB, String phongBan, double luongTrachNhiem) {
        super(tenNV, maNV, luongCB, phongBan);
        this.luongTrachNhiem = luongTrachNhiem;
    }

    public double getLuongTrachNhiem() {
        return luongTrachNhiem;
    }

    public void setLuongTrachNhiem(double luongTrachNhiem) {
        this.luongTrachNhiem = luongTrachNhiem;
    }
    @Override
    double getLuong(){
        return super.getLuongCB() + luongTrachNhiem;
    }
    @Override
    public double getThueTN(){
        return super.getThueTN();
    }
    
}
