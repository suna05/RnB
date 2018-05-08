<1.멤버테이블>
CREATE TABLE MEMBER (
	M_ID VARCHAR2(25) PRIMARY KEY,
	M_PW VARCHAR2(15) NOT NULL,
	M_NAME VARCHAR2(25),
	M_PHONE VARCHAR2(20),
	M_BIRTH VARCHAR2(10),
	M_ADDRESS VARCHAR2(100)
);
alter table member modify m_address varchar2(250);
<2.글 게시판 테이블>
create table Write(
	W_NO Number(5) PRIMARY KEY,
	W_TITLE varchar2(25),
	W_Content varchar2(1000),
	W_WRITER varchar2(15),
	W_DATE varchar2(15),
	W_COUNT number(5) default 0
);
alter table write modify w_title varchar2(100);
<글번호 시퀀스넘버>
create sequence seq_write start with 1 increment by 1 nomaxvalue;

<3.사진 게시판 테이블>
create table Photo(
	P_NO Number(5) PRIMARY KEY,
	P_TITLE varchar2(25),
	P_WRITER varchar2(15),
	P_DATE varchar2(15),
	P_COUNT number(5) default 0,
	bp_fullpath varchar2(360)
);
alter table photo modify p_title varchar2(100);
<사진번호 시퀀스넘버>
create sequence seq_photo start with 1 increment by 1 nomaxvalue;

<4.글게시판 댓글 테이블>
create table reply (
	r_no number(5) primary key,
	r_writer varchar2(15),
	r_content varchar2(500),
	r_date varchar2(15),
	w_no number(5)
);
<글게시판 외래키관계>
alter table reply add CONSTRAINT FK_Reply FOREIGN KEY(w_no)	REFERENCES Write(w_no) on delete cascade;
create sequence seq_reply start with 1 increment by 1 nomaxvalue;

<5.채팅 테이블>
CREATE TABLE CHAT(
	SEQ_NO NUMBER(5) PRIMARY KEY,
	M_ID VARCHAR2(25),
	MESSAGE VARCHAR2(4000),
	PP_FULLPATH VARCHAR2(360),
	C_DATE VARCHAR2(40)
);

<6.TODOLIST 테이블>
CREATE TABLE TODOLIST(
	T_NO VARCHAR2(5) PRIMARY KEY,
	T_CONTENT VARCHAR2(100),
	T_WRITER VARCHAR2(25),
	T_DATE VARCHAR2(40) DEFAULT SYSDATE,
	OBTAIN VARCHAR2(2) DEFAULT 0,
	M_ID VARCHAR2(25)
);
CREATE SEQUENCE todolist_seq START WITH 1 INCREMENT BY 1 NOMAXVALUE;

<7.PROFILEPHOTO 테이블>
create table profilephoto(
	pp_fullpath varchar2(360) primary key,
	m_id varchar2(25),
	constraint fk_profilephoto foreign key(m_id) references member(m_id) on delete cascade
); 

<8.REPLYPHOTO 테이블>
create table replyphoto (
	r_no number(5) primary key,
	r_writer varchar2(25),
	r_content varchar2(500),
	r_date varchar2(15),
	p_no number(5)
);
alter table replyPhoto add CONSTRAINT FK_replyPhoto FOREIGN KEY(p_no)	REFERENCES Photo(p_no) on delete cascade;
create sequence seq_replyPhoto start with 1 increment by 1 nomaxvalue;



SELECT * FROM TODOLIST;


create table replyPhoto (
   r_no number(5) primary key,
   r_writer varchar2(15),
   r_content varchar2(50),
   r_date varchar2(15),
   p_no number(5)
);

DELETE FROM MEMBER;
DELETE FROM WRITE;
DELETE FROM PHOTO;
DELETE FROM CHAT;
DELETE FROM TODOLIST
select * from member;
SELECT * FROM REPLYPHOTO
SELECT * FROM CHAT;
SELECT * FROM REPLY
select * from profilephoto
SELECT * FROM PHOTO
UPDATE PHOTO SET P_COUNT=(SELECT P_COUNT FROM PHOTO WHERE P_NO=1)+1 WHERE P_NO=1

alter table photo drop column curpage
create table boardPhoto(
	bp_fullpath varchar2(360) primary key,
	p_no number(5),
	constraint fk_boardPhoto foreign key(p_no) references photo(p_no) on delete cascade
)
alter table photo add curpage number(5);
alter table photo modify p_count number(5) default 0;

SELECT * FROM PHOTO;
SELECT * FROM WRITE;
INSERT INTO WRITE VALUES(SEQ_WRITE.NEXTVAL,'테스트','테스트','aa@aa.com',SYSDATE,0);
INSERT INTO WRITE VALUES(SEQ_WRITE.NEXTVAL,'테스트','테스트','aa@aa.com',SYSDATE,0);
INSERT INTO WRITE VALUES(SEQ_WRITE.NEXTVAL,'테스트','테스트','aa@aa.com',SYSDATE,0);
INSERT INTO WRITE VALUES(SEQ_WRITE.NEXTVAL,'테스트','테스트','aa@aa.com',SYSDATE,0);
INSERT INTO WRITE VALUES(SEQ_WRITE.NEXTVAL,'테스트','테스트','aa@aa.com',SYSDATE,0);
INSERT INTO WRITE VALUES(SEQ_WRITE.NEXTVAL,'테스트','테스트','aa@aa.com',SYSDATE,0);
INSERT INTO WRITE VALUES(SEQ_WRITE.NEXTVAL,'테스트','테스트','aa@aa.com',SYSDATE,0);
INSERT INTO WRITE VALUES(SEQ_WRITE.NEXTVAL,'테스트','테스트','aa@aa.com',SYSDATE,0);
INSERT INTO WRITE VALUES(SEQ_WRITE.NEXTVAL,'테스트','테스트','aa@aa.com',SYSDATE,0);
INSERT INTO WRITE VALUES(SEQ_WRITE.NEXTVAL,'테스트','테스트','aa@aa.com',SYSDATE,0);

INSERT INTO PHOTO VALUES(SEQ_PHOTO.NEXTVAL,'테스트','윤여성',SYSDATE,0,)

ALTER TABLE CHAT ADD C_DATE VARCHAR2(15);
ALTER TABLE CHAT MODIFY C_DATE VARCHAR2(40);
DELETE FROM CHAT;
SELECT * FROM MEMBER;
SELECT * FROM CHAT;
CREATE SEQUENCE SEQ_PF START WITH 1 INCREMENT BY 1 NOMAXVALUE;
select * from user_sequences;
delete from member;
<oracle>

<mysql>
create table profilephoto(
	pp_fullpath varchar(360) primary key,
	m_id varchar(25)
); 

INSERT INTO PROFILEPHOTO VALUES('AAAA','aa@aa.com');

SELECT * FROM PROFILEPHOTO;



alter table todolist add m_id varchar2(25);
alter table todolist add constraint fk_todolist foreign key(m_id) references member(m_id) on delete cascade;

SELECT * FROM PHOTO WHERE ROWNUM <=6 ORDER BY P_COUNT DESC;
SELECT * FROM (SELECT * FROM PHOTO ORDER BY P_COUNT DESC) WHERE ROWNUM<=6;
SELECT * FROM (SELECT * FROM WRITE ORDER BY W_COUNT DESC) WHERE ROWNUM<=6;
SELECT * FROM WRITE;
SELECT * FROM REPLY;