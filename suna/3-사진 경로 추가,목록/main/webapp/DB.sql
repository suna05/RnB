CREATE TABLE MEMBER (
	M_ID VARCHAR2(25) PRIMARY KEY,
	M_PW VARCHAR2(15) NOT NULL,
	M_NAME VARCHAR2(15),
	M_PHONE VARCHAR2(20),
	M_BIRTH VARCHAR2(10),
	M_ADDRESS VARCHAR2(50)
);

SELECT * FROM MEMBER;

create table Photo(
	P_NO Number(5) PRIMARY KEY,
	P_TITLE varchar2(25),
	P_WRITER varchar2(15),
	P_DATE varchar2(15),
	P_COUNT number,
	bp_fullpath varchar2(100)
);

create table boardphoto (
	bp_fullpath varchar2(100) PRIMARY KEY,
	p_no number(5),
	constraint fk_boardphoto foreign key(p_no) references photo(p_no) on delete cascade
)

alter table photo modify p_count number(5) default 0;


create table Write(
	W_NO Number(5) PRIMARY KEY,
	W_TITLE varchar2(25),
	W_Content varchar2(1000),
	W_WRITER varchar2(15),
	W_DATE varchar2(15),
	W_COUNT number(5)
);
alter table write modify w_count number(5) default 0;