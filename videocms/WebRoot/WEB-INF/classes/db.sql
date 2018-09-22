use videocms;
/*会员表*/
create table user(
  id int primary key auto_increment,
  username varchar(30),
  email varchar(30),
  registdate datetime
);
insert into user values(
	null,'joy','joy123@qq.com',now());
insert into user values(
	null,'jack','jack123@qq.com',now());
insert into user values(
	null,'rose','rose123@qq.com',now());
select * from user limit 0,2;	
	
/*管理员*/	
create table admin(
	id int primary key auto_increment,
	username varchar(30),
	password varchar(30),
	realname varchar(30)
);
insert into admin values(null,'user01','1234','jack');
insert into admin values(null,'user02','1234','john');
insert into admin values(null,'user03','1234','weilic');

select * from admin where username='user01';

create table role(
	id int primary key auto_increment,
	name varchar(30)
);
insert into role values(null,'超级管路员');
insert into role values(null,'用户管路员');
insert into role values(null,'产品管路员');

select * from role;
/*关联表*/
create table admin_role(
	id int primary key auto_increment,
	admin_id int,
	role_id int
);
insert into admin_role values(null,1,1);
insert into admin_role values(null,1,2);
insert into admin_role values(null,2,2);
insert into admin_role values(null,3,3);

select * from admin_role;
/*id=1的所有信息包括角色信息*/
select * from admin where id=1;
select r.* from admin_role ar join role r on ar.role_id=r.id where ar.admin_id=1;

create table privilege(
	id int primary key auto_increment,
	name varchar(30)
);
insert into privilege values(null,'查看会员界面');
insert into privilege values(null,'查看管理员界面');
insert into privilege values(null,'查看角色界面');
insert into privilege values(null,'查看视频上传界面');
insert into privilege values(null,'查看视频列表界面');
select * from privilege;

create table role_priv(
	id int primary key auto_increment,
	role_id int,
	priv_id int
);
insert into role_priv values(null,1,1);
insert into role_priv values(null,1,2);
insert into role_priv values(null,2,2);
insert into role_priv values(null,3,3);
select * from role_priv limit 0,2;

select p.* from privilege p join role_priv rp on p.id=rp.priv_id where rp.role_id=1;
select * from role limit 0,2;

/*产品相关*/
/*课程方向 course*/
create table course(
	id int primary key auto_increment,
	name varchar(30)
);
insert into course values(null,'JAVA');
insert into course values(null,'PYTHON');
insert into course values(null,'WEB');
insert into course values(null,'UID');
select * from course;
/*课程内容*/
create table lore(
	id int primary key auto_increment,
	name varchar(30),
	course_id int
);
insert into lore values(null,'java基础',1);
insert into lore values(null,'Oracle',1);

insert into lore values(null,'绘画基础',2);
insert into lore values(null,'ps',2);

insert into lore values(null,'js高级',3);
insert into lore values(null,'vue',3);

insert into lore values(null,'python基础',4);
insert into lore values(null,'爬虫',4);
select * from lore;
/*产品*/
create table product(
	id int primary key auto_increment,
	name varchar(30),
	course_id int,
	lore_id int,
	discription varchar(50),
	status char(1),
	price double(7,2),
	image varchar(30),
	video varchar(30),
	creater varchar(30),
	create_time datetime
);
desc product;
select * from product;
select * from lore where course_id=1;
//查出产品列表所有信息
select p.*,c.name cname from product p join course c on p.course_id=c.id limit 0,2;
select count(*) from product p join course c on p.course_id=c.id;
//查询课程方向为uid的第一页的产品信息
select p.*,c.name cname from product p join course c 
		on p.course_id=c.id 
		where 1 = 1
		and c.name='JAVA' 
		and p.name like
		and p.creater
		and p.createtime like
		limit 0,2;

select * from product;
select p.*,c.name cname from product p join course c on p.course_id=c.id where p.id=1;
/*
  year:2018
  time:11:12:12
  date:2018-8-22
  timestamp:2018-8-22 11:23:14 (1970~2037)
  datatime:2018-8-22 11:23:14 (1970~9999)
*/