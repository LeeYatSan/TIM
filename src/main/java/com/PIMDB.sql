create database TIM;
use TIM;
create table TicketInfo(
id varchar(20),
scity varchar(20),
tcity varchar(20),
date varchar(20),
num int,
price int,
PRIMARY KEY(id));

create table Purchase(
id int auto_increment,
route_id varchar(20),
date varchar(20),
pay varchar(20),
money varchar(20),
PRIMARY KEY(id))auto_increment=1;

drop table TicketInfo;
drop table Purchase;
select * from TicketInfo;
select * from Purchase;
delete from TicketInfo where id = '6';
insert into TicketInfo values('6','Xi\'an','Suzhou','2018/12/05',1,600);
