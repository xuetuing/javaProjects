use videocms;
/*��Ա��*/
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
	
/*����Ա*/	
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
insert into role values(null,'������·Ա');
insert into role values(null,'�û���·Ա');
insert into role values(null,'��Ʒ��·Ա');

select * from role;
/*������*/
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
/*id=1��������Ϣ������ɫ��Ϣ*/
select * from admin where id=1;
select r.* from admin_role ar join role r on ar.role_id=r.id where ar.admin_id=1;

select a.*,r.* from admin a,admin_role ar,role r where a.id=ar.admin_id and r.id=ar.role_id limit 0,2;


create table privilege(
	id int primary key auto_increment,
	name varchar(30)
);
insert into privilege values(null,'�鿴��Ա����');
insert into privilege values(null,'�鿴����Ա����');
insert into privilege values(null,'�鿴��ɫ����');
insert into privilege values(null,'�鿴��Ƶ�ϴ�����');
insert into privilege values(null,'�鿴��Ƶ�б����');
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

/*��Ʒ���*/
/*�γ̷��� course*/
create table course(
	id int primary key auto_increment,
	name varchar(30)
);
insert into course values(null,'JAVA');
insert into course values(null,'PYTHON');
insert into course values(null,'WEB');
insert into course values(null,'UID');
select * from course;
/*�γ�����*/
create table lore(
	id int primary key auto_increment,
	name varchar(30),
	course_id int
);
insert into lore values(null,'java��',1);
insert into lore values(null,'Oracle',1);

insert into lore values(null,'�滭��',2);
insert into lore values(null,'ps',2);

insert into lore values(null,'js�߼�',3);
insert into lore values(null,'vue',3);

insert into lore values(null,'python��',4);
insert into lore values(null,'����',4);
select * from lore;
/*��Ʒ*/
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
//�����Ʒ�б�������Ϣ
select p.*,c.name cname from product p join course c on p.course_id=c.id limit 0,2;
select count(*) from product p join course c on p.course_id=c.id;
//��ѯ�γ̷���Ϊuid�ĵ�һҳ�Ĳ�Ʒ��Ϣ
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

select d.*,e.* from dept d join emp e on d.deptno=e.deptno where d.deptno=10;


/*
  year:2018
  time:11:12:12
  date:2018-8-22
  timestamp:2018-8-22 11:23:14 (1970~2037)
  datatime:2018-8-22 11:23:14 (1970~9999)
*/