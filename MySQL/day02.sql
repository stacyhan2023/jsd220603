    创建数据库newdb1, 字符集utf8并使用
create database newbd1 charset=utf8;
use newdb1;
    在数据库中创建员工表emp 字段:id,name,sal(工资),deptId(部门id) 字符集utf8
create table emp(id int,name varchar(50),sal int,deptId int) charset=utf8;
    创建部门表dept 字段:id,name,loc(部门地址) 字符集utf8
create table dept(id int, name varchar(50),loc varchar(200) );
    部门表插入以下数据: 1 神仙部 天庭       2 妖怪部  盘丝洞
insert into dept values(1,"神仙部","天庭"),(2,'妖怪部','盘丝洞');
    员工表插入一下数据:  1 悟空 5000 1  ,   2 八戒  2000  1  ,3 蜘蛛精 8000  2  ,  4 白骨精 9000  2
insert into emp values(1,'悟空',5000,1),(2,'八戒',2000,1),(3,'蜘蛛精',8000,2),
                      (4,'白骨精',9000,2);
    查询工资6000以下的员工姓名和工资
select name,sal from emp where sal<6000;
    修改神仙部的名字为取经部
update dept set name="取经部" where name="神仙部";
    给员工表添加奖金comm字段
alter table emp add comm int;
    修改员工表中部门id为1的 奖金为500
update emp set comm=500 where deptId=1;
    把取经部的地址改成五台山
update dept set loc='五台山' where name="取经部";
    修改奖金字段为性别gender字段 类型为varchar(5)
alter table emp change comm gender varchar(5);
    修改孙悟空和猪八戒性别为男
    update emp set gender='男' where deptId=1;
-- update emp set gender='男' where name='悟空';
-- update emp set gender='男' where name='八戒';
    删除没有性别的员工
delete from emp where gender is null;
    删除性别字段
alter table emp drop gender;
    删除表  和 删除数据库
drop table emp;
drop table dept;
drop database newdb1;



select * from emp where dept_id=2 and sal>1000;
select * from emp where dept_id=3 or sal=5000;
select name,sal from emp where sal between 1000 and 2000;
select * from emp where sal not in(3000,5000);
select distinct job from emp where dept_id=3;
select name from emp where dept_id=1 and manager is null;
select * from emp where job in('人事','销售','程序员');
select sal from emp where name in('刘备','张飞','关羽');



