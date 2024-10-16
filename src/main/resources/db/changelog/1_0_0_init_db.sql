--liquibase formatted sql

--changeset User:1
create table if not exists customers
(
    id    serial primary key,
    name  varchar(100) not null,
    city  varchar(100) default 'Portland',
    email varchar(255) unique,
    phone varchar(255) unique
);

--changeset User:2
insert into customers (name, email, phone)
values ('Ivan', 'ivan@ivan.co', '9731424784'),
       ('Sergey', 'shyam@example.com', '9988776655'),
       ('James', 'james@xmpl.com', '9998887776'),
       ('Smith', 'rajesh@example.com', '9876598765');

