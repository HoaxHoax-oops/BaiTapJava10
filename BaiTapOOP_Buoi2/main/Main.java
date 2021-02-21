package com.cybersoft.java10.main;

import java.util.Scanner;
import com.cybersoft.java10.view.CongTy;

public class Main {
	public static void main(String[] args) {
		/*
		 * Thực thi chương trình
		 */
		Scanner scan = new Scanner(System.in);
		CongTy congTy = new CongTy();
		
		congTy.mainFunc(scan);
	}
}
