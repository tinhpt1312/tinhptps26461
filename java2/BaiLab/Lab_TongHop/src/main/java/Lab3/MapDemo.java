/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Tinh
 */
public class MapDemo {
    public static void main(String[] args) {
        HashMap<String, Student> map = new HashMap<String, Student>();
        Student sv1 = new Student();
        sv1.name = "Tuan";
        sv1.major = "CNTT";
        sv1.marks = 7.0;
        map.put(sv1.name, sv1);
        
        Set<String> keys = map.keySet();
        for(String name : keys){
            Student sv = map.get(name);
            System.out.println("Ho ten: " + sv.name);
            System.out.println("Hoc luc: " + sv.getGrade());
        
    }
    
    }
}
