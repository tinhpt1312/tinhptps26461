package ASMbosung;

public class nhanvienData {
    public Boolean isName(String str){
        String pattern = "[a-zA-Z ]+";
        return str.matches(pattern);
    } 
    public Boolean isID(String str){
        String pattern = "[0-9]{2,5}";
        return str.matches(pattern);
    }
}
