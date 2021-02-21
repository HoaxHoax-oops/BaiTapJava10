package com.cybersoft.java10.view;

import java.util.Scanner;

import com.cybersoft.java10.controller.QuanLyNhanSu;
import com.cybersoft.java10.model.GiamDoc;
import com.cybersoft.java10.model.NhanVien;
import com.cybersoft.java10.model.TruongPhong;

public class CongTy {
	/* properties */
	private QuanLyNhanSu quanLyNhanSu;
	private String tenCongTy;
	private String maSoThue;
	private double doanhThuThang;

	/* constructors */
	public CongTy() {
		quanLyNhanSu = new QuanLyNhanSu();
		tenCongTy = "Grey và những người bạn";
		maSoThue = "1024357962";
		doanhThuThang = 2000000000;
		
		taoDummyData();
	}
	
	/* methods */
	public void mainFunc(Scanner scan) {
		/*
		 * Ứng dụng quản lý nhân sự
		 */
		boolean tiepTucChay = true;
		int luaChon;

		do {
			inMenu();
			luaChon = Integer.parseInt(scan.nextLine());

			switch (luaChon) {
			case 1:// nhập thông tin công ty
				nhapThongTinCongTy(scan);
				break;
				
			case 2:// phân bổ nhân viên
				break;
				
			case 3:// thêm nhân sự
				System.out.println("Chọn loại nhân sự: \n\t1. Nhân viên.\n\t2. Trưởng phòng.\n\t3. Giám đốc.");
				switch (Integer.parseInt(scan.nextLine())) {
				case 1:
					NhanVien nv = new NhanVien();
					nv.nhapThongTin(scan);
					if (quanLyNhanSu.them(nv))
						System.out.println("Thêm nhân viên thành công.");
					else
						System.out.println("Thêm nhân viên thất bại.");
					break;
				case 2:
					TruongPhong tp = new TruongPhong();
					tp.nhapThongTin(scan);
					if (quanLyNhanSu.them(tp))
						System.out.println("Thêm trưởng phòng thành công.");
					else
						System.out.println("Thêm trưởng phòng thất bại.");
					break;
				case 3:
					GiamDoc gd = new GiamDoc();
					gd.nhapThongTin(scan);
					if (quanLyNhanSu.them(gd))
						System.out.println("Thêm giám đốc thành công.");
					else
						System.out.println("Thêm giám đốc thất bại.");
					break;
				default:
					break;
				}
				break;
				
			case 4:// xóa nhân sự
				System.out.print("Mã số nhân sự muốn xóa: ");
				if (quanLyNhanSu.xoa(scan.nextLine()))
					System.out.println("Xóa nhân sự thành công.");
				else
					System.out.println("Xóa nhân sự thất bại.");
				break;
				
			case 5:// in danh sách nhân sự
				inThongTinCongTy();
				quanLyNhanSu.inDanhSachNhanSu();
				break;
				
			case 6: // tìm nhân viên thường có lương cao nhất
				if(quanLyNhanSu.locNhanVien())
					quanLyNhanSu.inDanhSachNhanVienLuongCaoNhat();
				else
					System.out.println("Không có nhân viên thường trong danh sách công ty.");
				break;
				
			case 7:// tìm trưởng phòng có số nhân viên nhiều nhất
				break;
				
			case 8:// sắp xếp toàn bộ nhân sự theo thứ tự abc
				quanLyNhanSu.sapXepNhanSuTheoABC();
				quanLyNhanSu.inDanhSachNhanSu();
				break;
				
			case 9:// sắp xếp toàn bộ nhân sự theo thứ tự lương giảm dần
				break;
				
			case 10:// tìm giám đốc có cổ phần nhiều nhất
				if(quanLyNhanSu.locGiamDoc())
					quanLyNhanSu.inDanhSachGiamDocCoPhanCaoNhat();
				else
					System.out.println("Không có giám đốc trong danh sách công ty.");
				break;
				
			case 11:// tính và xuất tổng thu nhập của từng giám đốc
				if(quanLyNhanSu.locGiamDoc())
					quanLyNhanSu.xuatTongThuNhapTungGiamDoc(doanhThuThang);
				else
					System.out.println("Không có giám đốc thường trong danh sách công ty.");
				break;
				
			case 0:
				tiepTucChay = false;
				System.out.println("Đang thoát chương trình...");
				break;
				
			default:
				System.out.println("Lựa chọn không hợp lệ.");
				break;
			}

			scan.nextLine();
		} while (tiepTucChay);
	}

	private void nhapThongTinCongTy(Scanner sc) {
		System.out.println("NHẬP THÔNG TIN CÔNG TY");
		System.out.print("Tên công ty: ");
		this.tenCongTy = sc.nextLine();
		System.out.print("Mã số thuế: ");
		this.maSoThue = sc.nextLine();
		System.out.print("Doanh thu: ");
		this.doanhThuThang = Double.parseDouble(sc.nextLine());
	}

	private void taoDummyData() {
		quanLyNhanSu.them(new NhanVien("MS01", "Tuấn", "0909000113", 22, 100, ""));
		quanLyNhanSu.them(new NhanVien("MS02", "Hưng", "0909000113", 10, 100, ""));
		quanLyNhanSu.them(new NhanVien("MS03", "Hiếu", "0909000113", 22, 100, ""));
		quanLyNhanSu.them(new NhanVien("MS04", "Sinh", "0909000113", 8, 100, ""));
		quanLyNhanSu.them(new NhanVien("MS05", "Cường", "0909000113", 8, 100, ""));
		
		quanLyNhanSu.them(new TruongPhong("MS06", "Huy", "0909000113", 22, 200, 0));
		quanLyNhanSu.them(new TruongPhong("MS07", "Duyên", "0909000113", 22, 200, 0));
		
		quanLyNhanSu.them(new GiamDoc("MS08", "Thông", "0909000113", 22, 300, 4.2f));
		quanLyNhanSu.them(new GiamDoc("MS09", "Linh", "0909000113", 22, 300, 9.8f));
	}

	private void inMenu() {
		int spaceNum = 20;
		System.out.println(String.format("%" + spaceNum + "s", "") + "QUẢN LÝ NHÂN SỰ" + String.format("%" + spaceNum + "s", ""));
		System.out.println("Menu:");
		System.out.println("\t1. Nhập thông tin công ty");
		System.out.println("\t2. Phân bổ Nhân viên vào Trưởng phòng");
		System.out.println("\t3. Thêm thông tin một nhân sự");
		System.out.println("\t4. Xóa thông tin một nhân sự");
		System.out.println("\t5. Xuất ra thông tin toàn bộ người trong công ty");
		System.out.println("\t6. Tìm Nhân viên thường có lương cao nhất");
		System.out.println("\t7. Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất");
		System.out.println("\t8. Sắp xếp nhân viên toàn công ty theo thứ tự abc");
		System.out.println("\t9. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần");
		System.out.println("\t10. Tìm Giám Đốc có số lượng cổ phần nhiều nhất");
		System.out.println("\t11. Tính và Xuất tổng THU NHẬP của từng Giám Đốc");
		System.out.println("\t0. Thoát.");
		System.out.print("Lựa chọn: ");
	}
	
	private void inThongTinCongTy() {
		int num = 72;
		String ttCongTy = "THÔNG TIN CÔNG TY";
		
		System.out.println();
		System.out.println(String.format("%" + (num*2 - ttCongTy.length())/2 + "s", "") 
				+ ttCongTy + String.format("%" + (num*2 - ttCongTy.length())/2 + "s", ""));
		System.out.println("Tên công ty: " + String.format("%28s", tenCongTy));
		System.out.println("Mã số thuế: " + String.format("%29s", maSoThue));
		System.out.println("Doanh thu: " + String.format("%30.2f", doanhThuThang));
		
		System.out.println();
	}
}
