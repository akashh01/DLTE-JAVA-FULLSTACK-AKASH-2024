--DDL : TO CREATE TABLE---
create table TransactionsAnalysis(transaction_id number primary key, transaction_date date not null, transaction_to varchar(255) not null, transaction_amount number not null, transaction_remarks varchar(255) not null

--DDL- CREATE AN AUTOINCREMENT SEQUENCE--
create sequence transaction_sequence start with 65400 increment by 1;

--DML: TO INSERT VALUES TO TABLE--
insert into TransactionsAnalysis(transaction_id,transaction_amount,transaction_date,transaction_to,transaction_remarks) values(transaction_sequence.nextval,2000,'22-feb-2022','Ajay','Friend');

insert into TransactionsAnalysis(transaction_id,transaction_amount,transaction_date,transaction_to,transaction_remarks) values(transaction_sequence.nextval,23000,'15-Mar-2024','Ankit','Family');

insert into TransactionsAnalysis(transaction_id,transaction_amount,transaction_date,transaction_to,transaction_remarks) values(transaction_sequence.nextval,50000,'18-Jan-2024','Abhishek','Emergency');

insert into TransactionsAnalysis(transaction_id,transaction_amount,transaction_date,transaction_to,transaction_remarks) values(transaction_sequence.nextval,50000,'19-Jan-2024','Harith','Family');

insert into TransactionsAnalysis(transaction_id,transaction_amount,transaction_date,transaction_to,transaction_remarks) values(transaction_sequence.nextval,20000,'30-Jan-2024','Jeni','Friend');

--QUERY TO Filter based on given ranges of date--

select * from TransactionsAnalysis where transaction_date between '15-Jan-2024' and '30-Jan-2024'

--QUERY FOR least amount transferred---
select min(transaction_amount) from TransactionsAnalysis;

--QUERY FOR maximum amount transferred--
 select max(transaction_amount) from TransactionsAnalysis;

--QUERY FOR number of transaction made to particular beneficiary--
 select count(transaction_to) from TransactionsAnalysis where transaction_to='Abhishek';

--QUERY FOR filter based on particular remarks--
select * from TransactionsAnalysis where transaction_remarks='Family';