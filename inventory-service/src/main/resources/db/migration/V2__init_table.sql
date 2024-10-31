create table reservations
(
    created_at     timestamp(6),
    expired_at     timestamp(6),
    quantity       bigint not null,
    updated_at     timestamp(6),
    order_id       uuid,
    product_id     uuid,
    reservation_id uuid   not null
        primary key,
    status         varchar(255)
);

CREATE INDEX IF NOT EXISTS reservations_by_order_id_idx on reservations (order_id);
CREATE INDEX IF NOT EXISTS reservations_by_product_id_idx on reservations (product_id);


create table stock_levels
(
    created_at        timestamp(6),
    reserved_quantity bigint not null,
    total_quantity    bigint not null,
    updated_at        timestamp(6),
    product_id        uuid,
    stock_id          uuid   not null primary key
);

CREATE INDEX IF NOT EXISTS stock_levels_by_product_id_idx on stock_levels (product_id);

create table transactions
(
    balance_after  bigint not null,
    created_at     timestamp(6),
    quantity       bigint not null,
    order_id       uuid,
    product_id     uuid,
    transaction_id uuid   not null
        primary key,
    type           varchar(255)
);

CREATE INDEX IF NOT EXISTS transactions_by_order_id_idx on transactions (order_id);
CREATE INDEX IF NOT EXISTS transactions_by_product_id_idx on transactions (product_id);



