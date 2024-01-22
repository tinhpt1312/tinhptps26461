/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sof2041slide3;

/**
 *
 * @author teo
 */
public class ThamSoBienDoi {
    int tong(int a, int b){
        return a+b;
    }
    int tong(int a, int b, int c){
        return a+b+c;
    }
    //....
    static int cong(int ...args){
        int tong=0;
//        for(int x:args){
//            tong +=x;
//        }
//        return tong;
        for(int i=0;i<args.length;i++){
            tong = tong + args[i];
        }
        return tong;
    }
    public static void main(String[] args) {
        int[]a={1,2,3,4,5};       
        int t1=cong(1,2);
        int t2=cong(1,2,3);
        int t3=cong(2,4,3,5);
        int t4=cong(a);
        System.out.printf("t1=%d, t2=%d, t3=%d, t4=%d",t1,t2,t3,t4);
    }
}
