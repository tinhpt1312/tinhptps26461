





public class xe {
    String tenXe;
    int tocDo;
    public xe() {
        tenXe = "chuacoten";
        tocDo = 0;
    }
    public xe(String tenXe, int tocDo) {
        this.tenXe = tenXe;
        this.tocDo = tocDo;
    }
    public String getTenXe() {
        return tenXe;
    }
    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }
    public int getTocDo() {
        return tocDo;
    }
    public void setTocDo(int tocDo) {
        this.tocDo = tocDo;
    }

    public void xuatThongTin(){
        System.out.println("");
        System.out.println("Ten xe: " +tenXe);
        System.out.println("Toc do: " +tocDo);
    }
}
