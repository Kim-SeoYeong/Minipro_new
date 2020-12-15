package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

public class NumberVO {
	//필드
	
	//메소드
	//txt 안에 내용을 읽어오는 메소드
	public void readTxt(ArrayList<Number> nList) throws IOException{
		Reader rd = new FileReader("C:\\javaStudy\\미니프로젝트\\PhoneDB_new.txt");
		BufferedReader br = new BufferedReader(rd);
		
		while(true) {
			String str = br.readLine();
			
			if(str == null) {
				break;
			}
			
			String[] strarr = str.split(",");
			Number n01 = new Number(strarr[0], strarr[1], strarr[2]);
			
			nList.add(n01);
		}
		br.close();
	}
	
	//데이터를 write 하는 메소드
	public void writeTxt(ArrayList<Number> nList) throws IOException {
		Writer wr = new FileWriter("C:\\javaStudy\\미니프로젝트\\PhoneDB_new.txt");
		BufferedWriter bw = new BufferedWriter(wr);
		
		for(int i = 0; i < nList.size(); i++) {
			bw.write(nList.get(i).getName() + "," + nList.get(i).getHp() + 
					"," + nList.get(i).getCompany());
			bw.newLine();
		}
		bw.close();
	}
}
