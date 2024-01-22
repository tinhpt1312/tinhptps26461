


public class SinhvienData {
    public Boolean isEmail(String str){
        String pattern = "\\w+@\\w+(\\.\\w+){1,2}";
        return str.matches(pattern);
    } 
    public Boolean isPhone(String str){
        String pattern = "0\\d{9,10}";
        return str.matches(pattern);
    } 
    public Boolean isCCCD(String str){
        String pattern = "\\d{12}";
        return str.matches(pattern);
    }
}
