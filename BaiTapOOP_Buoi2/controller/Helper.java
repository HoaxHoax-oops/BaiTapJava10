package com.cybersoft.java10.controller;

import java.util.Collections;
import java.util.List;
import com.cybersoft.java10.model.NhanSu;

/*
 * This class provides some useful function
 */

final class Helper {
	/*
	 * helper method for draw line
	 */
	static void drawLine(int num) {
		for (int i = 0; i < num; i++) {
			System.out.print("- ");
		}
	}

	/*
	 * helper method for showing information of a particular List
	 */
	static <T extends NhanSu> void inDanhSach(List<T> ds, String heading) {
		int num = 72;

		System.out.println();
		System.out.println(String.format("%" + (num * 2 - heading.length()) / 2 + "s", "") + heading
				+ String.format("%" + (num * 2 - heading.length()) / 2 + "s", ""));
		drawLine(num);
		System.out.println();
		System.out.println(String.format(" %10s  ", "Mã số") + String.format("%16s  ", "Họ tên")
				+ String.format("%16s  ", "Số điện thoại") + String.format("%12s  ", "Ngày làm")
				+ String.format("%16s  ", "Lương cơ bản") + String.format("%17s  ", "Lương")
				+ String.format("%16s", "Chức vụ") + String.format("%25s  |", "Số nhân viên/ Cổ phần"));
		drawLine(num);
		System.out.println();
		for (T node : ds) {
			node.xuatThongTin();
		}

		drawLine(num);
		System.out.println();
	}

	/*
	 * bubble sort
	 */
	static <T extends NhanSu> List<T> bubbleSort(List<T> ds) {
		for (int i = 0, size = ds.size(); i < size; ++i) {
			boolean swapped = false;
			for (int j = 0; j < size - 1 - i; ++j) {
				swapped = compareName(ds.get(j), ds.get(j + 1)) && swap(ds, j, j + 1);
			}
			if (!swapped) {
				break;
			}
		}
		
		Collections.reverse(ds);
		
		return ds;
	}

	/*
	 * this method checks if first element is less than the other element
	 */
	static <T extends NhanSu> boolean compareName(T v, T w) {
		String temp1 = v.getHoTen();
		String temp2 = w.getHoTen();
		
		return temp1.compareToIgnoreCase(temp2) < 0;
	}

	/*
	 * helper method for swapping places in array
	 */
	static <T extends NhanSu> boolean swap(List<T> ds, int idx, int idy) {
		Collections.swap(ds, idx, idy);
		return true;
	}
	
}
