create database FuramaResort;
use FuramaResort;

create table ViTri(
	idViTri int,
    TenViTri varchar(45) not null,
    constraint pk_idViTri primary key ViTri(idViTri)
);

create table TrinhDo(
	idTrinhDo int,
    TrinhDo varchar(45) not null,
    constraint pk_idTrinhDo primary key TrinhDo(idTrinhDo)
);

create table BoPhan(
	idBoPhan int,
    TenBoPhan varchar(45) not null,
    constraint pk_idBoPhan primary key BoPhan(idBoPhan)
);

create table LoaiKhach(
	idLoaiKhach int,
    TenLoaiKhach varchar(45) not null,
    constraint pk_idLoaiKhach primary key LoaiKhach(idLoaiKhach)
);

create table LoaiDichVu(
	idLoaiDichVu int,
    TenLoaiDichVu varchar(45) not null,
    constraint pk_idLoaiDichVu primary key LoaiDichVu(idLoaiDichVu)
);

create table KieuThue(
	idKieuThue int,
    TenKieuThue varchar(45) not null,
    Gia int not null,
    constraint pk_idKieuThue primary key KieuThue(idKieuThue)
);

create table DichVuDiKem(
	idDichVuDiKem int,
    TenDichVuDiKem varchar(45) not null,
    Gia int not null,
    DonVi int not null,
    TrangThaiKhaDung varchar(45) not null,
    constraint pk_idDichVuDiKem primary key DichVuDiKem(idDichVuDiKem)
);

create table NhanVien(
	idNhanVien int,
    HoTen varchar(45) not null,
    idBoPhan int not null,
    idTrinhDo int not null,
    idViTri int not null,
    NgaySinh date not null,
    CMND varchar(45) not null,
    Luong varchar(45) not null,
    SDT varchar(45) not null,
    Email varchar(45) not null,
    DiaChi varchar(45) not null,   
    constraint fk_idBoPhan_NhanVien foreign key(idBoPhan) references BoPhan(idBoPhan),
    constraint fk_idTrinhDo_NhanVien foreign key(idTrinhDo) references TrinhDo(idTrinhDo),
    constraint fk_idViTri_NhanVien foreign key(idViTri) references ViTri(idViTri),
	constraint pk_idNhanVien primary key NhanVien(idNhanVien)
);

create table KhachHang(
	idKhachHang int,
    idLoaiKhach int not null,
    HoTen varchar(45) not null,
    NgaySinh date not null,
    CMND varchar(45) not null,
    SDT varchar(45) not null,
    Email varchar(45) not null,
    DiaChi varchar(45) not null,    
    constraint fk_idLoaiKhach_KhachHang foreign key(idLoaiKhach) references LoaiKhach(idLoaiKhach),
    constraint pk_idKhachHang primary key KhachHang(idKhachHang)
);

create table DichVu(
	idDichVu int,
    TenDichVu varchar(45) not null,
    DienTich int not null,
    SoTang int not null,
    SoNguoiToiDa varchar(45) not null,
    ChiPhiThue varchar(45) not null,
    idLoaiDichVu int not null,
    idKieuThue int not null,
    
    constraint fk_idLoaiDichVu_DichVu foreign key(idLoaiDichVu) references LoaiDichVu(idLoaiDichVu),
    constraint fk_idKieuThue_DichVu foreign key(idKieuThue) references KieuThue(idKieuThue),
    constraint pk_idDichVu primary key DichVu(idDichVu)
);


create table HopDong(
	idHopDong int,
    NgayLamHopDong date not null,
    NgayKetThuc date not null,
    TienDatCoc int not null,
    TongTien int not null,
    idNhanVien int not null,
    idDichVu int not null,
    idKhachHang int not null,
    
    constraint fk_idNhanVien_HopDong foreign key(idNhanVien) references NhanVien(idNhanVien),
    constraint fk_idDichVu_HopDong foreign key(idDichVu) references DichVu(idDichVu),
	constraint fk_idKhachHang_HopDong foreign key(idKhachHang) references KhachHang(idKhachHang),
    constraint pk_idHopDong primary key HopDong(idHopDong)
);

create table HopDongChiTiet(
	idHopDongChiTiet int,
    SoLuong int not null,
    idHopDong int not null,
    idDichVuDiKem int not null,
    
    constraint fk_idHopDong_HopDongChiTiet foreign key (idHopDong) references HopDong(idHopDong),
    constraint fk_idDichVuDiKem_HopDongChiTiet foreign key(idDichVuDiKem) references DichVuDiKem(idDichVuDiKem),
    constraint pk_idHopDongChiTiet primary key HopDongChiTiet(idHopDongChiTiet)
);




-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” 
-- và có tối đa 15 ký tự.
select * from nhanvien
where HoTen like "H%" or HoTen like "T%" or HoTen like "K%"
group by idNhanVien
having LENGTH(HoTen) <= 15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select * from khachhang
where diachi in ("Da Nang", "Quang Tri")
group by idKhachHang
having ((year(curdate()) - year(ngaysinh)) >= 18) and (year(curdate()) - year(ngaysinh) < 50);

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo 
-- số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select HoTen, sum(SoLuong) as TongSoLanDatPhong
from khachhang join loaikhach on khachhang.idLoaiKhach = loaikhach.idLoaiKhach 
join hopdong on hopdong.idKhachHang = khachhang.idKhachHang
join hopdongchitiet on hopdong.idHopDong = hopdongchitiet.idHopDong
where TenLoaiKhach = "Diamond"
group by khachhang.idKhachHang
order by sum(SoLuong)


-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
-- cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chua từng đặt phòng cũng phải hiển thị ra).
;

select khachhang.idKhachHang, HoTen, TenLoaiKhach, hopdong.idHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, 
(ChiPhiThue + SoLuong*Gia) as TongTien
from khachhang left join loaikhach on khachhang.idLoaiKhach = loaikhach.idLoaiKhach
left join hopdong on khachhang.idKhachHang = hopdong.idKhachHang
left join dichvu on hopdong.idDichVu = dichvu.idDichVu
left join hopdongchitiet on hopdong.idHopDong = hopdongchitiet.idHopDong
left join dichvudikem on hopdongchitiet.idDichVuDiKem = dichvudikem.idDichVuDiKem

-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng 
-- thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).  
;

select dichvu.idDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu, NgayLamHopDong
from dichvu left join loaidichvu on dichvu.idLoaiDichVu = loaidichvu.idLoaiDichVu
left join hopdong on dichvu.idDichVu = hopdong.idDichVu
group by dichvu.idDichVu
having year(NgayLamHopDong) < 2019 or isnull(NgayLamHopDong) = 1;

-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ 
-- đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
;
select dichvu.idDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu, NgayLamHopDong
from dichvu join loaidichvu on dichvu.idLoaiDichVu = loaidichvu.idLoaiDichVu
join hopdong on dichvu.idDichVu = hopdong.idDichVu
group by dichvu.idDichVu
having year(NgayLamHopDong) = 2018 and year(NgayLamHopDong) <> 2019;

-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoTenKhachHang không trùng nhau.
-- Cach 1
select idKhachHang, HoTen 
from khachhang
group by HoTen;

-- Cach 2
select distinct HoTen 
from khachhang;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có 
-- bao nhiêu khách hàng thực hiện đặt phòng.
select year(NgayLamHopDong) as Nam, sum(TongTien) as TongDoanhThu
from hopdong
group by year(NgayLamHopDong)
order by year(NgayLamHopDong);

-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm 
-- IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).
select hopdong.idHopDong, NgayLamHopDong, NgayKetThuc, TienDatCoc, count(idHopDongChiTiet) as SoLuongDichVuDiKem
from hopdong join hopdongchitiet on hopdong.idHopDong = hopdongchitiet.idHopDong
join dichvudikem on hopdongchitiet.idDichVuDiKem = dichvudikem.idDichVuDiKem
group by hopdong.idHopDong;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và 
-- có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select TenDichVuDiKem
from dichvudikem join hopdongchitiet on dichvudikem.idDichVuDiKem = hopdongchitiet.idDichVuDiKem
join hopdong on hopdong.idHopDong = hopdongchitiet.idHopDong
join khachhang on khachhang.idKhachHang = hopdong.idKhachHang
join loaikhach on khachhang.idLoaiKhach = loaikhach.idLoaiKhach
where TenLoaiKhach = "Diamond" and (DiaChi = "Vinh" or DiaChi = "Quang Ngai");

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
-- (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3
-- tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.

select hopdong.idHopDong, nhanvien.HoTen as TenNhanVien, khachhang.HoTen as TenKhachHang, khachhang.SDT, TenDichVu, soluong,
 TienDatCoc, NgayLamHopDong, dichvu.idDichVu
from hopdong join nhanvien on hopdong.idNhanVien = nhanvien.idNhanVien
join khachhang on hopdong.idKhachHang = khachhang.idKhachHang
join dichvu on hopdong.idDichVu = dichvu.idDichVu
join hopdongchitiet on hopdong.idHopDong = hopdongchitiet.idHopDong
where month(Ngaylamhopdong) in(10,11,12)
and hopdong.idDichvu not in
(select hopdong.idDichvu
from hopdong
where year(NgayLamHopDong) = 2020 and month(NgayLamHopDong) in (1, 2, 3, 4, 5, 6));

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

select SoLuong, hopdongchitiet.idDichVuDiKem, TenDichVuDiKem
from hopdongchitiet 
join dichvudikem on hopdongchitiet.idDichVuDiKem = dichvudikem.idDichVuDiKem
join (select max(SoLuong) as maxSL from hopdongchitiet) x
on x.maxSL = hopdongchitiet.SoLuong




