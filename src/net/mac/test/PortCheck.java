package net.mac.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class PortCheck {

	public static void main(String[] args) {
		String strIP="115.239.210.27";
		try{
		    boolean status =InetAddress.getByName(strIP).isReachable(3000);
		    if (status) {
		        for(int port=0; port<65535; port++){
		            try {
		                Socket s = new Socket(strIP, port);
		                System.out.println(strIP+":"+port+" is open");
		                s.close();
		            } catch (Exception e) {
		              System.out.println(strIP+":"+port+" is not open");
		            }
		        }
		    } else {
		        System.out.println(strIP+" connect failure");
		    }
		} catch (UnknownHostException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}

	}

}
