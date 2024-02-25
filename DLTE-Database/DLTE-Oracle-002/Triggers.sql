
-------TRIGGER------
create or replace trigger check_remarks 
before insert on transactionsanalysis
for each row
begin
  if:new.transaction_remarks is null then :new.transaction_remarks :='no';
  end if;
end;
/