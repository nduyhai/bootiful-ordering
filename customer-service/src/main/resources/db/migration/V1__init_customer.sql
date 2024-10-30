create table customers
(
    customer_id  uuid not null primary key,
    display_name varchar(100),
    created_at   timestamp(6),
    updated_at   timestamp(6)
);

insert into customers
values ('aa0c6c97-04ac-4b20-8c6c-9704aceb20ec', 'Bronn', now(), now())
