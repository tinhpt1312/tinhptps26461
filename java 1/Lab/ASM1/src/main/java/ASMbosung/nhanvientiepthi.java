package ASMbosung;

public class nhanvientiepthi extends nhanvien { 
    double hoaHong;
    double doanhSo;
    public nhanvientiepthi(String tenNV, String maNV, double luongCB, String phongBan, double hoaHong, double doanhSo) {
        super(tenNV, maNV, luongCB, phongBan);
        this.hoaHong = hoaHong;
        this.doanhSo = doanhSo;
    }
    public double getHoaHong() {
        return hoaHong;
    }
    public void setHoaHong(double hoaHong) {
        this.hoaHong = hoaHong;
    }
    public double getDoanhSo() {
        return doanhSo;
    }
    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }
    @Override
    double getLuong(){
        return super.getLuongCB() + doanhSo + hoaHong;
    }
    @Override
    public double getThueTN(){
        return super.getThueTN();
    }
    /* (non-Javadoc)
     * @see ASMbosung.nhanvien#getThueTN()
     */

}
