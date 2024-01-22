




public class xetai extends xe {
    int taitrong;

    public int getTaitrong() {
        return taitrong;
    }

    public void setTaitrong(int taitrong) {
        this.taitrong = taitrong;
    }

    public xetai() {
    }

    public xetai(String tenXe, int tocDo, int taitrong) {
        super(tenXe, tocDo);
        this.taitrong = taitrong;
    }
     @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Tai trong (kg): " +taitrong);
    }
}
