/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Tinh
 */
public class Student implements Serializable {

    public String name, major;
    public Double marks;

    public Student() {
    }

    public Student(String name, String major, Double marks) {
        this.name = name;
        this.major = major;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public String getGrade() {
        if (this.marks < 3) {
            return "Kém";
        }
        if (this.marks < 5) {
            return "Yếu";
        }
        if (this.marks < 6.5) {
            return "Trung bình";
        }
        if (this.marks < 8) {
            return "Khá";
        }
        if (this.marks < 9) {
            return "Giỏi";
        }
        return "Xuất sắc";
    }

    public boolean isBonus() {
        return this.marks >= 7.5;
    }

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Tuấn", "CNTT", 5.0));
        list.add(new Student("Bình", "TKW", 7.5));
        list.add(new Student("Đức", "Marketting", 8.5));

        XFile.writeObject("d:/student.dat", list);
        ArrayList<Student> list2 = (ArrayList<Student>) XFile.readObject("d:/student.dat");
        for (Student sv : list) {
            System.out.println(">Họ và tên: " + sv.name +" "+sv.getGrade());
        }
    }
}
