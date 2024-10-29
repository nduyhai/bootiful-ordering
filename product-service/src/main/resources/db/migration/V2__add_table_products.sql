create table products
(
    product_id  uuid not null
        primary key,
    category    varchar(255),
    description varchar(255),
    name        varchar(255),
    sku         varchar(255),
    created_at  timestamp(6),
    updated_at  timestamp(6)

);

CREATE UNIQUE INDEX products_sku_idx on products (sku);
