/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi1;

/**
 *
 * @author Tinh
 */
public class MayTinh {
    
        static public int tong( int x, int y ){
            return x + y ;
        }
        
        static public int tong( int x, int y, int z ){
            return x + y + z;
        }
        
        static public int tong( int a[]){
            int s = 0;
            for (int d : a){
                s += d;
            }
            return s;
        }
        public static void main(String[] args) {
        /* tổng 2 số 7 và 9 */
            System.out.println(tong(7,9));
            
        /* Tổng 3 số 8 + 100 + 13*/
            System.out.println(tong(8, 100, 13));
            
        /* Tổng dãy số tùy ý*/
        int[] a = {1, 2, 4, 100, 13, 99, 45};
            System.out.println(tong(a));
    }
}
