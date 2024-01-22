/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab7;

import buoi14.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Tinh
 */
public class UDPSever {

    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(6789);
        
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        
        while (true) {
            //Tạo datagram nhận dữ liệu
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            //nhận dữ liệu
            serverSocket.receive(receivePacket);

            //Dữ liệu sau khi nhận thì chuyển thành chuỗi
            String sentence = new String(receivePacket.getData());

            //Nhận địa chỉ IP của bên gửi
            InetAddress IPAddress = receivePacket.getAddress();

            //nhận cổng của bên gửi
            int port = receivePacket.getPort();
            
            String capitalizedSentence = sentence.toUpperCase();
            
            sendData = capitalizedSentence.getBytes();

            //Tạo datagram để gửi tới client
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

            //Gửi dữ liệu đi
            serverSocket.send(sendPacket);
        }
    }
}
