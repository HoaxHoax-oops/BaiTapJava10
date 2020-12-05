package com.cybersoft.java10.main;

import java.util.ArrayList;
import java.util.List;

import com.cybersoft.java10.model.GiamDoc;
import com.cybersoft.java10.model.NhanSu;
import com.cybersoft.java10.model.NhanVien;
import com.cybersoft.java10.model.TruongPhong;

public class TestMain {

	public static void main(String[] args) {
		/*
		 * Chương trình test
		 */
		List<NhanSu> dsNhanSu = new ArrayList<NhanSu>();
		
		taoDummyData(dsNhanSu);
		xuatThongTin(dsNhanSu);
		System.out.println(dsNhanSu);
		
		System.out.println();
		
		List<NhanSu> dsNhanVien = locNhanVien(dsNhanSu);
		xuatThongTin(dsNhanVien);
		System.out.println(dsNhanVien);
		
	}
	
	private static void taoDummyData(List<NhanSu> dsNhanSu) {
		dsNhanSu.add(new NhanVien("MS01", "Tuấn", "0909000113", 22, 100, ""));
		dsNhanSu.add(new NhanVien("MS02", "Hùng", "0909000113", 22, 100, ""));
		dsNhanSu.add(new NhanVien("MS03", "Hưng", "0909000113", 22, 100, ""));
		dsNhanSu.add(new NhanVien("MS04", "Sinh", "0909000113", 22, 100, ""));
		
		dsNhanSu.add(new TruongPhong("MS05", "Huy", "0909000113", 22, 200, 0));
		dsNhanSu.add(new TruongPhong("MS06", "Nguyệt", "0909000113", 22, 200, 0));
		
		dsNhanSu.add(new GiamDoc("MS07", "Thông", "0909000113", 22, 300, 4.2f));
		dsNhanSu.add(new GiamDoc("MS08", "Linh", "0909000113", 22, 300, 9.8f));
	}
	
	private  static ArrayList<NhanSu> locNhanVien(List<NhanSu> dsNhanSu){
		ArrayList<NhanSu> dsTam = new ArrayList<NhanSu>();
		
		for (NhanSu ns : dsNhanSu) {
			dsTam.add(ns);
		}
		return dsTam;
	}
	
	public static void xuatThongTin(List<NhanSu> dsNhanSu) {
		for (NhanSu nhanSu : dsNhanSu) {
			nhanSu.xuatThongTin();
		}
	}

}
