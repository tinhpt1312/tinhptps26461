/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class UtilityDate {

    public UtilityDate() {
    }

    public static String DateToString(Date x) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").format(x);
        } catch (Exception e) {
            return null;
        }
        
    }

    public static Date StringToDate(String x) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(x);
        } catch (ParseException ex) {
            return null;
        }
    }

    public static int tinhTuoi(Date ngaySinh) {
        Date ngayHienTai = new Date();
        long milliGiayMoiNam = 1000L * 60 * 60 * 24 * 365;
        long tuoiMilliseconds = ngayHienTai.getTime() - ngaySinh.getTime();
        return (int) (tuoiMilliseconds / milliGiayMoiNam);
    }

    public static LocalDate StringToLocalDate(String ngayString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            LocalDate localDate = LocalDate.parse(ngayString, formatter);

            return localDate;
        } catch (Exception e) {
            return null;
        }

    }
}
