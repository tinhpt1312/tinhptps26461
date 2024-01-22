/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab7;

import buoi14.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Tinh
 */
public class UDPClient {

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        // Đọc dữ liệu do người dùng nhập vào từ bàn phím
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress IPAddress = InetAddress.getByName("127.0.0.1");

        //Tạo 2 mảng chứa dữ liệu gửi và chứa dữ liệu nhận
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        //Đọc dữ liệu người dùng nhập từ bàn phím
        System.out.printf("Nhap chuoi ki tu: ");
        String sentence = inFromUser.readLine();

        //gán dữ liệu cho mảng dùng để gửi dữ liệu
        sendData = sentence.getBytes();

        //Tạo datagram cùng với dữ liệu, độ dài, địa chỉ ip cổng
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 6789);

        //Gửi datagram tới Server
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

        //Đọc dữ liệu từ Server gửi tới
        clientSocket.receive(receivePacket);

        //Chuyển dữ liệu nhận được về kiểu chuỗi
        String modifiedSentence = new String(receivePacket.getData());

        System.out.println("From Server: " + modifiedSentence);
        clientSocket.close();
    }
}
