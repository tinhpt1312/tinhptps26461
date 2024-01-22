/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Tinh
 */
public class XDate {
    private static SimpleDateFormat sdf = new SimpleDateFormat();
    public static Date parse(String text, String pattern) throws ParseException{
        sdf.applyPattern(pattern);
        return sdf.parse(text);
    }
    
    public static Date parse(String text) throws ParseException{
        return XDate.parse(text, "dd-MM-yyyy");
    }
    
}
