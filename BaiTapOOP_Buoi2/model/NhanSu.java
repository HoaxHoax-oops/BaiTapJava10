package com.cybersoft.java10.model;

import java.util.Scanner;

public class NhanSu {
	/* properties */
	protected String 	maSo;
	protected String 	hoTen;
	protected String 	sdt;
	protected float 	soNgayLamViec;
	protected float 	luongMotNgay;

	/* getters/ setters */
	public String getMaSo() {
		return this.maSo;
	}
	
	public String getHoTen() {
		return this.hoTen;
	}

	/* constructors */
	public NhanSu() {
		this.maSo			= "";
		this.hoTen			= "";
		this.sdt			= "";
		this.soNgayLamViec	= 22;
		this.luongMotNgay	= 100;
	}

	public NhanSu(String maSo, String hoTen, String sdt, float soNgayLamViec, float luongMotNgay) {
		this.maSo			= maSo;
		this.hoTen			= hoTen;
		this.sdt			= sdt;
		this.soNgayLamViec	= soNgayLamViec;
		this.luongMotNgay	= luongMotNgay;
	}

	/* methods */
	public void nhapThongTin(Scanner scan) {
		System.out.println("NHẬP THÔNG TIN NHÂN SỰ");
		System.out.print("Mã số: ");
		this.maSo = scan.nextLine();
		System.out.print("Họ tên: ");
		this.hoTen = scan.nextLine();
		System.out.print("Số điện thoại: ");
		this.sdt = scan.nextLine();
		System.out.print("Số ngày làm việc: ");
		this.soNgayLamViec = Float.parseFloat(scan.nextLine());
		System.out.print("Lương một ngày: ");
		this.luongMotNgay = Float.parseFloat(scan.nextLine());
	}

	public float tinhLuong() {
		return soNgayLamViec * luongMotNgay;
	}

	public void xuatThongTin() {
		System.out.println(String.format("%10s |", maSo) + String.format("%16s |", hoTen) + String.format("%16s |", sdt)
				+ String.format("%12.2f |", soNgayLamViec) + String.format("%16.2f |", luongMotNgay)
				+ String.format("%17.2f |", tinhLuong()) + String.format("%16s |", getChucVu())
				+ String.format("%25s |", getThongTinThem()));
	}

	public String getThongTinThem() {
		return "";
	}

	public String getChucVu() {
		return "Nhân sự";
	}

}
