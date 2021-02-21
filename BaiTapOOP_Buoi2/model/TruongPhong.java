package com.cybersoft.java10.model;

public class TruongPhong extends NhanSu {
	/* properties */
	private int soNhanVien;

	/* getters/ setters */

	/* constructors */
	public TruongPhong() {
		super();
		this.soNhanVien = 0;
	}

	public TruongPhong(int soNhanVien) {
		super();
		this.soNhanVien = soNhanVien;
	}

	public TruongPhong(String maSo, String hoTen, String sdt, float soNgayLamViec, float luongMotNgay, int soNhanVien) {
		super(maSo, hoTen, sdt, soNgayLamViec, luongMotNgay);
		this.soNhanVien = soNhanVien;
	}

	/* methods */
	@Override
	public float tinhLuong() {
		return super.tinhLuong() + (100 * soNhanVien);
	}

	@Override
	public String getChucVu() {
		return "Trưởng phòng";
	}

	@Override
	public String getThongTinThem() {
		return Integer.toString(soNhanVien);
	}

}
