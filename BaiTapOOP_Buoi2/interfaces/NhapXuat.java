package com.cybersoft.java10.interfaces;

import java.util.Scanner;

public interface NhapXuat {
	void nhapThongTin(Scanner scan);
	void inThongTin();
	
	default void sayHello() {
		System.out.println("Hello from the other side!");
	}
}
