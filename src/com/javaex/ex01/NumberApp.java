package com.javaex.ex01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NumberApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String name;
		String hp;
		String company;
		
		int num;
		
		System.out.println("******************************************");
		System.out.println("*         전화번호 관리 프로그램         *");
		System.out.println("******************************************");
		
		ArrayList<Number> nList = new ArrayList<Number>();
		NumberVO nv = new NumberVO();
		
		nList.clear();
		nv.readTxt(nList);
		
		while(true) {
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("-----------------------------------------");
			System.out.print(">> 메뉴번호 : ");
			//메뉴 번호 입력
			num = sc.nextInt();
			//5번을 입력하면 프로그램 종료
			if (num == 5) {
				System.out.println("******************************************");
				System.out.println("*               감사합니다               *");
				System.out.println("******************************************");
				break;
			}
			//1번을 입력하면 리스트 불러오기
			if (num == 1) {
				System.out.println("<1. 리스트>");
				
				for (int i = 0; i < nList.size(); i++) {
					System.out.println((i+1) + ".\t" + nList.get(i).getName() +
										"\t" + nList.get(i).getHp() + "\t" + nList.get(i).getCompany());
					
				}
				System.out.println("");
				
			} else if (num == 2) {	//2번을 입력시 목록 등록
				System.out.println("<2. 등록>");
				
				System.out.print("> 이름 : ");
				name = sc.next();
				System.out.print("> 휴대전화 : ");
				hp = sc.next();
				System.out.print("> 회사전화 : ");
				company = sc.next();
				
				Number n02 = new Number(name, hp, company);
				nList.add(n02);

				nv.writeTxt(nList);
				
				System.out.println("[등록되었습니다.]");
				System.out.println("");

			} else if (num == 3) {	//3번을 입력시 원하는 번호 삭제

				System.out.print(">> 번호 : ");
				int number = sc.nextInt();
								
				for(int i=0; i < nList.size(); i++) {
					if((number-1) == i) {
						nList.remove(i);
					}
				}
				
				nv.writeTxt(nList);
				
				System.out.println("삭제되었습니다.");
				System.out.println("");

			} else if(num == 4) {	//4번을 입력하면 해당 단어가 이름에 포함되있는 사람을 검색
				System.out.println("<4. 검색>");

				System.out.print(">> 이름 : ");
				String str = sc.next();
				
				for(int i = 0; i < nList.size(); i++) {
					//indexof 함수로 해당 문자열이 있는지 찾아본다. (-1이 나오면 없는것)
					if((nList.get(i).getName().indexOf(str)) != -1) {
						System.out.println((i+1) + ".\t" + nList.get(i).getName() +
								"\t" + nList.get(i).getHp() + "\t" + nList.get(i).getCompany());
					}
				}
			} else {
				System.out.println("[다시 입력해 주세요.]");
				System.out.println("");
			}
		}	
		sc.close();
	}

}
