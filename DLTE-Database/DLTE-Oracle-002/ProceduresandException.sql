---procedure to insert value-----
create or replace procedure insert_transaction(
    t_id number,
    t_date date,
    t_to varchar2,
    t_amount number,
    t_remark varchar2,
    infos_op out varchar2
    )
as
begin 
 insert into TransactionsAnalysis(transaction_id,transaction_amount,transaction_date,transaction_to,transaction_remarks) values(t_id,t_amount,t_date,t_to,t_remark);
 infos_op:='done';
exception 
when OTHERS then 
infos_op:='not done'||SQLERRM;
end;
/

variable infos_op varchar2;
execute insert_transaction(TRANSACTION_SEQUENCE.nextval,'20-MAR-2013','John',500,'Friend',:infos_op);
print infos_op;


---procedure to delete transaction of given to date----
create or replace procedure delete_date(
  enter_date date,
  err_info out VARCHAR
  )
  as
  begin 
   delete from transactionsanalysis where transaction_date=enter_date;
   err_info:='no erroe';
  exception
   when others then
   err_info:='error due to'||SQLERRM;
END;
/

variable err_info varchar2;
execute delete_date('22-FEB-2022',:err_info);

----Filter based on remark when it is Education---

create or replace procedure filter_transactions(
   to_names out VARCHAR2,
   filter_err out VARCHAR2   
)
as 
 begin select transaction_to into to_names from transactionsanalysis where transaction_remarks='Education';
 filter_err:='done';
 exception
  when no_data_found then
  filter_err:='No data found';
  when others then
  filter_err:='error due to'||SQLERRM;
end;
/
variable to_name varchar;
variable filter_error varchar2;
execute filter_transactions(:to_name,:filter_error);
print to_name;
print filter_error;


