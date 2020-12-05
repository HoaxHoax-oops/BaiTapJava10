package com.cybersoft.java10.model;

import java.util.Scanner;

public class GiamDoc extends NhanSu {
	/* properties */
	private float coPhanCongTy;

	/* getters/ setters */
	public float getCoPhan() {
		return this.coPhanCongTy;
	}

	/* constructors */
	public GiamDoc() {
		super();
		this.coPhanCongTy = 0;
	}

	public GiamDoc(float coPhanCongTy) {
		super();
		this.coPhanCongTy = coPhanCongTy;
	}

	public GiamDoc(String maSo, String hoTen, String sdt, float soNgayLamViec, float luongMotNgay, float coPhanCongTy) {
		super(maSo, hoTen, sdt, soNgayLamViec, luongMotNgay);
		this.coPhanCongTy = coPhanCongTy;
	}

	/* methods */
	private double tinhTongThuNhap(double doanhThuThang) {
		return tinhLuong() + (coPhanCongTy * doanhThuThang);
	}

	@Override
	public String getChucVu() {
		return "Giám đốc";
	}

	@Override
	public String getThongTinThem() {
		return Float.toString(coPhanCongTy) + "%";
	}

	@Override
	public void nhapThongTin(Scanner scan) {
		super.nhapThongTin(scan);
		System.out.print("Cổ phần công ty: ");
		this.soNgayLamViec = Float.parseFloat(scan.nextLine());
	}

	public void xuatThongTinGiamDoc(double doanhThuThang) {
		System.out.println(String.format("%10s |", maSo) + String.format("%16s |", hoTen) + String.format("%16s |", sdt)
				+ String.format("%12.2f |", soNgayLamViec) + String.format("%16.2f |", luongMotNgay)
				+ String.format("%17.2f |", tinhTongThuNhap(doanhThuThang)) + String.format("%16s |", getChucVu())
				+ String.format("%25s |", getThongTinThem()));
	}
}
