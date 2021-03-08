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
	constraint pk_idNhanVien primary key NhanVien(idNhanVien, idBoPhan, idTrinhDo, idViTri)
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
    constraint pk_idKhachHang primary key KhachHang(idKhachHang, idLoaiKhach)
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
    constraint pk_idDichVu primary key DichVu(idDichVu, idLoaiDichVu, idKieuThue)
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
    constraint pk_idHopDong primary key HopDong(idHopDong, idNhanVien, idDichVu, idKhachHang)
);

create table HopDongChiTiet(
	idHopDongChiTiet int,
    SoLuong int not null,
    idHopDong int not null,
    idDichVuDiKem int not null,
    
    constraint fk_idHopDong_HopDongChiTiet foreign key (idHopDong) references HopDong(idHopDong),
    constraint fk_idDichVuDiKem_HopDongChiTiet foreign key(idDichVuDiKem) references DichVuDiKem(idDichVuDiKem),
    constraint pk_idHopDongChiTiet primary key HopDongChiTiet(idHopDongChiTiet, idHopDong, idDichVuDiKem)
);




-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” 
-- và có tối đa 15 ký tự.
select * from nhanvien
where HoTen like "H%" or HoTen like "T%" or HoTen like "K%"
group by idNhanVien
having LENGTH(HoTen) <= 15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khachhang
where diachi = "Da Nang" or diachi = "Quang Tri"
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

select khachhang.idKhachHang, HoTen, TenLoaiKhach, hopdong.idHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, 
(ChiPhiThue + SoLuong*Gia) as TongTien
from khachhang left join loaikhach on khachhang.idLoaiKhach = loaikhach.idLoaiKhach
join hopdong on khachhang.idKhachHang = hopdong.idHopDong
join dichvu on hopdong.idDichVu = dichvu.idDichVu
join hopdongchitiet on hopdong.idHopDong = hopdongchitiet.idHopDong
join dichvudikem on hopdongchitiet.idDichVuDiKem = dichvudikem.idDichVuDiKem

