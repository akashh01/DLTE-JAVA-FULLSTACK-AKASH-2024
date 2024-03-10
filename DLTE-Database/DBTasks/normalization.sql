//before normalization 
create table mobile_banking_before_norm(username VARCHAR(255) not null,
upi VARCHAR(255) not null,
mobile_number number(10) not null,
eamil varchar(255) not null,
wallet_type varchar(255) not null,
recharged_date date not null,
recharged_provider varchar(255) not null,
recharged_to VARCHAR(255) not null,
recharged_amount NUMBER(10) not null);

//after normalization

create table user_details_first_norm(username VARCHAR(255) not null,
mobile_number number(10) Primary key,
eamil varchar(255) not null);
create table usser_wallet_first_norm(
upi VARCHAR(255) primary key,
wallet_type varchar(255) not null,
mobile_number number(10) not null)

create table recharge_wallet_fist_norm(
upi VARCHAR(255) primary key,
recharged_date date not null,
recharged_provider varchar(255) not null,
recharged_to VARCHAR(255) not null,
recharged_amount NUMBER(10) not null

)

alter table usser_wallet_first_norm add foreign key(mobile_number) references user_details_first_norm(mobile_number);

alter table usser_wallet_first_norm add foreign key(upi) references recharge_wallet_fist_norm(upi);