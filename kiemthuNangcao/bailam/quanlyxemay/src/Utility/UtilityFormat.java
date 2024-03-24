/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author ADMIN
 */
public class UtilityFormat {

    public UtilityFormat() {
    }
    public static String DinhdangVnd(float x){
        float number = x;
        Locale locale = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        String formattedNumber = currencyFormatter.format(number);
        return formattedNumber;
    }
    public static float DinhdangVndToFloat(String vndString) {
        try {
            // Xác định locale cho Việt Nam
            Locale locale = new Locale("vi", "VN");

            // Lấy đối tượng NumberFormat để định dạng tiền tệ
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

            // Chuyển đổi chuỗi đã định dạng về kiểu Number
            Number number = currencyFormatter.parse(vndString);

            // Chuyển đối Number sang kiểu float
            float floatValue = number.floatValue();

            return floatValue;
        } catch (ParseException e) {
            e.printStackTrace();
            // Xử lý nếu có lỗi chuyển đổi
            return 0.0f; // hoặc giá trị mặc định khác
        }
    }
    public static String DinhdangVnd(double x){
        double number = x;
        Locale locale = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        String formattedNumber = currencyFormatter.format(number);
        return formattedNumber;
    }
    public static String DinhdangFloat(float x){
        float number = x;
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        String formattedNumber = decimalFormat.format(number);   
        return formattedNumber;
    }
    public static float DinhdangStringtoFloat(String x){
        String str = x;
        float number = Float.parseFloat(str.replace(",", ""));
        return number;        
    }
    
}
