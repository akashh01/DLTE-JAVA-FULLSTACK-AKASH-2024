--USER 1-AJAY , GRANTED SELECT--
SQL> create user Ajay identified by ajay123;

User created.

SQL> grant select on transactionsanalysis to ajay;

Grant succeeded.


SQL> grant connect to Ajay;
Grant succeeded

SQL> alter session set current_schema=system;


--USER 2 -ABHISHEK GRANTED DELETE--
SQL> create user Abhishek identified by abhi123 ;

User created.

SQL> grant delete on transactionsanalysis to abhishek;

Grant succeeded.

SQL> grant connect to Abhishek;
Grant succeeded.

SQL> alter session set current_schema=system;

Session altered.

--USER 3 HARITH,GRANT SELECT--
SQL> create user Harith identified by hari123;

User created.

SQL> grant select on transactionsanalysis to harith;

Grant succeeded.

SQL> grant connect to harith;

Grant succeeded.

SQL> alter session set current_schema=system;

Session altered.

---USER 4 AKSHAY GRANT INSERT---
SQL> create user akshay identified by akshay1234;

User created.

SQL> grant insert on transactionsanalysis to akshay;

Grant succeeded.

SQL> grant connect to akshay;

Grant succeeded.

SQL> alter session set current_schema=system;

Session altered.

--USER 5 NANDU,GRANT UPDATE--
SQL> create user nandu identified by nandu1234;

User created.

SQL> grant update on transactionsanalysis to nandu;

Grant succeeded.

SQL> grant connect to nandu;

Grant succeeded.

SQL> alter session set current_schema=system;

Session altered.
