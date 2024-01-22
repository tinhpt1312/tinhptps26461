package ASMbosung;

public class nhanvienhanhchinh extends nhanvien {

    public nhanvienhanhchinh(String tenNV, String maNV, double luongCB, String phongBan) {
        super(tenNV, maNV, luongCB, phongBan);
    }
    @Override
    double getLuong(){
        return super.luongCB;
    }
    @Override
    public double getThueTN(){
        return super.getThueTN();
    }
    public void nhap() {
    }
}
