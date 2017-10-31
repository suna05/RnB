select * from MEMBER;

insert into member(email,pw,name,mtype) values('ysung1223@nate.com','1234','여성','감독');

create sequence profileno_seq start with 1 increment by 1 maxvalue 99999;

create table member(
email varchar(45) primary key,
pw varchar(45) not null,
name varchar(20) not null,
mtype varchar(20) not null,
admin number default 0
);

create table profile(
profileno number primary key,
email varchar(45),
image varchar(100),
birth varchar(15),
height number,
weight number,
hobby varchar(40),
phone varchar(15)
);

create table career(
careerno number primary key,
email varchar(45),
type varchar(15),
title varchar(50),
roll varchar(20),
cdate varchar(15)
);