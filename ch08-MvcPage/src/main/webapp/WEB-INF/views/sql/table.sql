--회원관리
create table zmember(
	mem_num number not null,
	id varchar2(12) unique not null,
	auth number(1) default 2 not null, --회원등급:0.탈퇴/1.정지/2.일반/3.관리자
	constraint zmember_pk primary key (mem_num)
);
--회원관리 상세
create table zmember_detail(
	mem_num number not null,
	name varchar2(30) not null,
	passwd varchar2(12) not null,
	phone varchar2(15) not null,
	email varchar2(50) not null,
	zipcode varchar2(5) not null,
	address1 varchar2(90) not null,
	address2 varchar2(90) not null,
	photo varchar2(150),
	reg_date date default sysdate not null,
	modify_date date,
	constraint zmember_detail_pk primary key (mem_num),
	constraint zmember_detail_fk foreign key (mem_num) references zmember (mem_num)
);
create sequence zmember_seq;