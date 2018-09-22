select * from user;

update emp set deptno=40 where empno=1004;
select * from dept;

select e.*,d.* from emp e join dept d on e.deptno=d.deptno where e.empno=1001;
select e.*,d.* from emp e join dept d on e.deptno=d.deptno;
