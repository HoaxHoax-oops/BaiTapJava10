package com.cybersoft.java10.controller;

import java.util.ArrayList;
import java.util.List;

import com.cybersoft.java10.model.GiamDoc;
import com.cybersoft.java10.model.NhanSu;
import com.cybersoft.java10.model.NhanVien;
import com.cybersoft.java10.model.TruongPhong;

public class QuanLyNhanSu {
	/* properties */
	private List<NhanSu>		dsNhanSu;
	private List<NhanVien>		dsNhanVien;
	private List<TruongPhong>	dsTruongPhong;
	private List<GiamDoc>		dsGiamDoc;

	/* constructors */
	public QuanLyNhanSu() {
		dsNhanSu		= new ArrayList<NhanSu>();
		dsNhanVien		= new ArrayList<NhanVien>();
		dsTruongPhong	= new ArrayList<TruongPhong>();
		dsGiamDoc		= new ArrayList<GiamDoc>();
	}

	/* methods */
	public void inDanhSachNhanSu() {
		int num = 72;

		Helper.inDanhSach(dsNhanSu, "DANH SÁCH NHÂN SỰ");

		System.out.println(String.format(" %10s  ", "") + String.format("%16s  ", "") + String.format("%16s  ", "")
				+ String.format("%30s  ", "Tổng lương") + String.format("%17.2f  ", tinhTongLuong())
				+ String.format("%16s", "") + String.format("%25s  |", ""));
		Helper.drawLine(num);
		System.out.println();
	}

	public void xuatTongThuNhapTungGiamDoc(double doanhThuThang) {
		int num = 72;
		String heading = "DANH SÁCH GIÁM ĐỐC";

		System.out.println();
		System.out.println(String.format("%" + (num * 2 - heading.length()) / 2 + "s", "") + heading
				+ String.format("%" + (num * 2 - heading.length()) / 2 + "s", ""));
		Helper.drawLine(num);
		System.out.println();
		System.out.println(String.format(" %10s  ", "Mã số") + String.format("%16s  ", "Họ tên")
				+ String.format("%16s  ", "Số điện thoại") + String.format("%12s  ", "Ngày làm")
				+ String.format("%16s  ", "Lương cơ bản") + String.format("%17s  ", "Thu nhập")
				+ String.format("%16s", "Chức vụ") + String.format("%25s  |", "Số nhân viên/ Cổ phần"));
		Helper.drawLine(num);
		System.out.println();
		for (GiamDoc node : dsGiamDoc) {
			node.xuatThongTinGiamDoc(doanhThuThang);
		}

		Helper.drawLine(num);
		System.out.println();
	}

	public void inDanhSachGiamDocCoPhanCaoNhat() {
		ArrayList<GiamDoc> temp = new ArrayList<GiamDoc>();

		for (GiamDoc gd : dsGiamDoc) {
			if (gd.getCoPhan() == timCoPhanCaoNhatNhanVien())
				temp.add(gd);
		}

		Helper.inDanhSach(temp, "DANH SÁCH GIÁM ĐỐC CÓ CỔ PHẦN CAO NHẤT");
	}

	private float timCoPhanCaoNhatNhanVien() {
		float max = 0;

		for (GiamDoc gd : dsGiamDoc) {
			if (max < gd.getCoPhan())
				max = gd.getCoPhan();
		}

		return max;
	}

	public void inDanhSachNhanVienLuongCaoNhat() {
		ArrayList<NhanVien> temp = new ArrayList<NhanVien>();

		for (NhanVien nv : dsNhanVien) {
			if (nv.tinhLuong() == timLuongCaoNhatNhanVien())
				temp.add(nv);
		}

		Helper.inDanhSach(temp, "DANH SÁCH NHÂN VIÊN CÓ LƯƠNG CAO NHẤT");
	}

	private float timLuongCaoNhatNhanVien() {
		float max = 0;

		for (NhanVien nv : dsNhanVien) {
			if (max < nv.tinhLuong())
				max = nv.tinhLuong();
		}

		return max;
	}

	private float tinhTongLuong() {
		float tongLuong = 0;

		for (NhanSu nhanSu : dsNhanSu) {
			tongLuong += nhanSu.tinhLuong();
		}
		return tongLuong;
	}

	public boolean them(NhanSu nv) {
		if (nv == null)
			return false;

		if (kiemTraTrungMaSo(nv.getMaSo()))
			return false;

		return dsNhanSu.add(nv);
	}

	// return true nếu trùng mã số
	private boolean kiemTraTrungMaSo(String maSo) {
		for (NhanSu nhanSu : dsNhanSu) {
			if (nhanSu.getMaSo().equals(maSo))
				return true;
		}

		return false;
	}

	public boolean xoa(String maSo) {
		for (NhanSu nhanSu : dsNhanSu) {
			if (nhanSu.getMaSo().equals(maSo))
				return dsNhanSu.remove(nhanSu);
		}

		return false;
	}

	public boolean locNhanVien() {
		for (NhanSu nhanSu : dsNhanSu) {
			if (nhanSu instanceof NhanVien)
				dsNhanVien.add((NhanVien) nhanSu);
		}

		if (dsNhanVien.size() < 1)
			return false;

		return true;
	}

	public boolean locTruongPhong() {
		for (NhanSu nhanSu : dsNhanSu) {
			if (nhanSu instanceof TruongPhong)
				dsTruongPhong.add((TruongPhong) nhanSu);
		}

		if (dsTruongPhong.size() < 1)
			return false;

		return true;
	}

	public boolean locGiamDoc() {
		for (NhanSu nhanSu : dsNhanSu) {
			if (nhanSu instanceof GiamDoc)
				dsGiamDoc.add((GiamDoc) nhanSu);
		}

		if (dsGiamDoc.size() < 1)
			return false;

		return true;
	}

	public void sapXepNhanSuTheoABC() {
		Helper.bubbleSort(dsNhanSu);
	}

}
