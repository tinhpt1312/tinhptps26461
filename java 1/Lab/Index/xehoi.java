


public class xehoi extends xe {
    double dunggtichbinhxang;

    public xehoi() {
    }

    public xehoi(String tenXe, int tocDo, double dunggtichbinhxang) {
        super(tenXe, tocDo);
        this.dunggtichbinhxang = dunggtichbinhxang;
    }

    public double getDunggtichbinhxang() {
        return dunggtichbinhxang;
    }

    public void setDunggtichbinhxang(double dunggtichbinhxang) {
        this.dunggtichbinhxang = dunggtichbinhxang;
    }
    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Dung tich binh xang (l): " +dunggtichbinhxang);
    }

}
