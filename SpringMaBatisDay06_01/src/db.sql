select * from emp;

create table dept(
	deptno int(2) primary key auto_increment,
	dname varchar(20) not null,
	address varchar(30)
);

insert into dept values(10,"研发部","南京");
insert into dept values(20,"市场部","苏州");
insert into dept values(30,"财务部","上海");

select * from dept;





