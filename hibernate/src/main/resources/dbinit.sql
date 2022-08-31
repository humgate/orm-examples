create table accounts (
   id  bigserial not null,
   description varchar(255),
   number int8 not null,
   primary key (id)
);

create table transactions (
   id  bigserial not null,
   amount numeric(19, 2) not null,
   timestamp timestamp not null,
   source int8 not null,
   target int8 not null,
   primary key (id)
);

alter table public.transactions add constraint fk_target_account_id foreign key (target) references accounts(id);
alter table public.transactions add constraint fk_source_account_id foreign key ("source") references accounts(id);

insert into accounts (description, number) values('Acc 111', 111);
insert into accounts (description, number) values('Acc 112', 112);
insert into accounts (description, number) values('Acc 113', 113);
insert into accounts (description, number) values('Acc 114', 114);
insert into accounts (description, number) values('Acc 115', 115);

insert into transactions (source, target, amount, "timestamp") values (1,2,100.00, '2022-01-08 04:05:06');
insert into transactions (source, target, amount, "timestamp") values (1,3,200.00, '2022-02-08 04:05:06');
insert into transactions (source, target, amount, "timestamp") values (1,4,200.00, '2022-03-08 04:05:06');
insert into transactions (source, target, amount, "timestamp") values (2,1,100.00, '2022-04-08 04:05:06');
insert into transactions (source, target, amount, "timestamp") values (2,3,200.00, '2022-05-08 04:05:06');
insert into transactions (source, target, amount, "timestamp") values (2,4,200.00, '2022-06-08 04:05:06');
insert into transactions (source, target, amount, "timestamp") values (3,1,200.00, '2022-07-08 04:05:06');