select * from MEMBER;
select * from board;
select rownum NO,idx,writer,btitle,bdate,btype,content,bcount from board order by NO desc;

insert into member(email,pw,name,mtype) values('ysung1223@nate.com','1234','여성','감독');
insert into board values(board_seq.nextval,'윤여성','테스트게시판','2017.11.06'
,'배우구함','테스트게시판',0);
insert into board values(board_seq.nextval,'윤여성','테스트게시판','2017.11.06'
,'배우구함','테스트게시판',0);
insert into board values(board_seq.nextval,'윤여성','테스트게시판','2017.11.06'
,'배우구함','테스트게시판',0);
insert into board values(board_seq.nextval,'윤여성','테스트게시판','2017.11.06'
,'배우구함','테스트게시판',0);
insert into board values(board_seq.nextval,'윤여성','테스트게시판','2017.11.06'
,'배우구함','테스트게시판',0);
insert into board values(board_seq.nextval,'윤여성','테스트게시판','2017.11.06'
,'배우구함','테스트게시판',0);
insert into board values(board_seq.nextval,'윤여성','테스트게시판','2017.11.06'
,'배우구함','테스트게시판',0);
insert into board values(board_seq.nextval,'윤여성','테스트게시판','2017.11.06'
,'배우구함','테스트게시판',0);
insert into board values(board_seq.nextval,'윤여성','테스트게시판','2017.11.06'
,'배우구함','테스트게시판',0);
insert into board values(board_seq.nextval,'윤여성','테스트게시판','2017.11.06'
,'배우구함','테스트게시판',0);

create sequence profileno_seq start with 1 increment by 1 maxvalue 99999;
create sequence board_seq start with 1 increment by 1 maxvalue 99999;

create table member(
email varchar(45) primary key,
pw varchar(45) not null,
name varchar(20) not null,
mtype varchar(20) not null,
admin number default 0,
mimage varchar(100),
birth varchar(20),
height number,
weight number,
phone varchar(20),
sex varchar(10)
);

create table career(
careerno number primary key,
email varchar(45),
type varchar(15),
title varchar(50),
roll varchar(20),
cdate varchar(15)
);

create table movie(
movieno number primary key,
mtitle varchar(30) not null,
movieimage varchar(100),
director varchar(20) not null,
actor varchar(50) not null,
youtubelink varchar(100),
category varchar(20),
mdate varchar(20),
likeno number,
mcount number
);

create table board(
idx number primary key,
writer varchar(20) not null,
btitle varchar(100) not null,
bdate varchar(20) not null,
btype varchar(20) not null,
content clob,
bcount number
);

update MEMBER set sex='남성' where email='ysung1223@nate.com';

update member set pw='12345',name='여성이',phone='010-6611-8156' where email='ysung1223@nate.com';


















