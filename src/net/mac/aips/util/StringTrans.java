package net.mac.aips.util;

import java.io.UnsupportedEncodingException;

public class StringTrans {
	
	
	public String tranA(String chi){
		String result = null;
		byte temp[];
		try {
			temp=chi.getBytes("GBK");
			result = new String(temp);					
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.toString());
		}
		return result;
	}
	public String tranB(String chB){
		String result = null;
		byte temp[];
		try {
			temp=chB.getBytes("UTF-8");
			result = new String(temp, "GBK");					
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.toString());
		}
		return result;
	}
	public String tranC(String chB){
		String result = null;
		byte temp[];
		try {
			temp=chB.getBytes("GBK");
			result = new String(temp, "UTF-8");					
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.toString());
		}
		return result;
	}
}
