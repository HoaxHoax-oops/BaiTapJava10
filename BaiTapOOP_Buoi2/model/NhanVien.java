package com.cybersoft.java10.model;

public class NhanVien extends NhanSu {
	/* properties */
	private String maTruongPhong;

	/* getters/ setters */

	/* constructors */
	public NhanVien() {
		super();
		this.maTruongPhong = "";
	}

	public NhanVien(String maTruongPhong) {
		super();
		this.maTruongPhong = maTruongPhong;
	}

	public NhanVien(String maSo, String hoTen, String sdt, float soNgayLamViec, float luongMotNgay,
			String maTruongPhong) {
		super(maSo, hoTen, sdt, soNgayLamViec, luongMotNgay);
		this.maTruongPhong = maTruongPhong;
	}

	/* methods */
	@Override
	public String getChucVu() {
		return "Nhân viên";
	}

	@Override
	public String getThongTinThem() {
		return maTruongPhong;
	}

}
