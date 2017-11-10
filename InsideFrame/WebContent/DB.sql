select * from MEMBER;
select * from board;
select * from movieno_comment;
select * from CAREER
select rownum NO,idx,writer,btitle,bdate,btype,content,bcount from board order by COMMENTNO desc;
select * from board_comment;
select rownum NO,commentno,comment_board,commentid,commentdate,commentcontent from board_comment where comment_board=28 order by commentno desc;
insert into member(email,pw,name,mtype) values('ysung1223@nate.com','1234','여성','감독');
insert into member(email,pw,name,mtype) values('','1234','여성','감독');
select * from movie;
select rownum NUM,mcommentno,comment_movieno,mcommentid,mcommentdate,mcommentcontent from movieno_comment where comment_movieno=9 ORDER BY mcommentno DESC;
insert into MOVIE(movieno,mtitle,director,actor,category,mdate,likeno,mcount) values(movie_seq.nextval,'섹스앤더시티','ysung1223@nate.com','여성이와아이들','comedy',sysdate,0,0);
insert into MOVIE(movieno,mtitle,director,actor,category,mdate,likeno,mcount) values(movie_seq.nextval,'여성이와아이들','ysung1223@nate.com','여성이와아이들','comedy',sysdate,0,0);
insert into MOVIE(movieno,mtitle,director,actor,category,mdate,likeno,mcount) values(movie_seq.nextval,'괴물','ysung1223@nate.com','여성이와아이들','actionAndThriller',sysdate,0,0);
insert into MOVIE(movieno,mtitle,director,actor,category,mdate,likeno,mcount) values(movie_seq.nextval,'밀정','ysung1223@nate.com','여성이와아이들','romance',sysdate,0,0);
insert into MOVIE(movieno,mtitle,director,actor,category,mdate,likeno,mcount) values(movie_seq.nextval,'변호인','ysung1223@nate.com','여성이와아이들','drama',sysdate,0,0);
insert into MOVIE(movieno,mtitle,director,actor,category,mdate,likeno,mcount) values(movie_seq.nextval,'택시기사','ysung1223@nate.com','여성이와아이들','drama',sysdate,0,0);
insert into MOVIE(movieno,mtitle,director,actor,category,mdate,likeno,mcount) values(movie_seq.nextval,'아이언맨','ysung1223@nate.com','여성이와아이들','actionAndThriller',sysdate,0,0);
insert into MOVIE(movieno,mtitle,director,actor,category,mdate,likeno,mcount) values(movie_seq.nextval,'토르','ysung1223@nate.com','여성이와아이들','actionAndThriller',sysdate,0,0);
insert into MOVIE(movieno,mtitle,director,actor,category,mdate,likeno,mcount) values(movie_seq.nextval,'삼육대학교','ysung1223@nate.com','여성이와아이들','horror',sysdate,0,0);

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

create table board_comment(
	commentNo number not null,
	comment_board number not null,
	commentid varchar(15),
	commentdate date,
	commentparent number,
	commentcontent varchar(1000) not null,
	constraint pk_comment primary key(commentNo),
	constraint fk_comment foreign key(comment_board) references board(idx)
);

create table movieno_comment(
	mcommentNo number not null,
	comment_movieno number not null,
	mcommentid varchar(15),
	mcommentdate date,
	mcommentcontent varchar(1000) not null,
	constraint pk_moviecomment primary key(mcommentNo),
	constraint fk_moviecomment foreign key(comment_movieno) references movie(movieno));
);

create sequence comment_seq ;
create sequence movie_seq;
insert into board_comment values(comment_seq.nextval,28,'ysung1223@nate.com',sysdate,'테스트댓글');
insert into board_comment values(comment_seq.nextval,28,'ysung1223@nate.com',sysdate,'테스트댓글');
insert into board_comment values(comment_seq.nextval,28,'ysung1223@nate.com',sysdate,'테스트댓글');
insert into board_comment values(comment_seq.nextval,28,'ysung1223@nate.com',sysdate,'테스트댓글');
insert into board_comment values(comment_seq.nextval,28,'ysung1223@nate.com',sysdate,'테스트댓글');
insert into board_comment values(comment_seq.nextval,28,'ysung1223@nate.com',sysdate,'테스트댓글');
insert into board_comment values(comment_seq.nextval,28,'ysung1223@nate.com',sysdate,'테스트댓글');

insert into movieno_comment values(movcomment_seq.nextval,9,'ysung1223@nate.com',sysdate,'테스트댓글');
insert into movieno_comment values(movcomment_seq.nextval,9,'ysung1223@nate.com',sysdate,'테스트댓글');
insert into movieno_comment values(movcomment_seq.nextval,9,'ysung1223@nate.com',sysdate,'테스트댓글');
insert into movieno_comment values(movcomment_seq.nextval,9,'ysung1223@nate.com',sysdate,'테스트댓글');
insert into movieno_comment values(movcomment_seq.nextval,9,'ysung1223@nate.com',sysdate,'테스트댓글');
create sequence movcomment_seq;
desc MOVIE;

alter table CAREER add constraint career_fk1 foreign key (email) references MEMBER(email);

alter table CAREER add constraint career_fk2 foreign key (movieno) references movie(movieno);

create sequence career_seq;

update movie set movieinfo='삼육대학교의 sda, 그 무서움을 알게되다' where movieno=9;

insert into career(careerno,email,roll,movieno) values(career_seq.nextval,'ysung1223@nate.com','감독','9');
insert into career(careerno,email,roll,movieno) values(career_seq.nextval,'1223yys@naver.com','행인','9');
insert into career(careerno,email,roll,movieno) values(career_seq.nextval,'aa@aa.com','감독','8');
insert into career(careerno,email,roll,movieno) values(career_seq.nextval,'bb@bb.com','행인','8');
insert into career(careerno,email,roll,movieno) values(career_seq.nextval,'cc@cc.com','감독','7');
insert into career(careerno,email,roll,movieno) values(career_seq.nextval,'dd@dd.com','행인','7');

select mv.youtubelink,mv.movieimage,mv.movieinfo,mv.mdate,mb.mimage,mb.mtype,mb.name,c.roll from member mb,movie mv, career c
where mb.email=c.email and mv.movieno=c.movieno and mv.movieno=9;

create sequence moviecomment_seq;







