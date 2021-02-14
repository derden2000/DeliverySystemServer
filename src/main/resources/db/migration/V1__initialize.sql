drop table IF exists addresses cascade;
create table addresses (
    id  bigserial not null,
    region varchar(255),
    area varchar(255),
    city varchar(255),
    settlement varchar(255),
    house varchar(255),
    street varchar(255),
    primary key (id)
);

drop table IF exists wallets cascade;
create table wallets (
    id  bigserial not null,
    balance numeric(10, 2) not null,
    primary key (id)
    );

insert into wallets (balance) values (0);

drop table IF exists roles cascade;
create table roles (
    id  bigserial not null,
    title varchar(255),
    primary key (id)
    );

insert into roles (title)
values
('ROLE_CUSTOMER'),
('ROLE_COURIER'),
('ROLE_MANAGER'),
('ROLE_ADMIN');

drop table IF exists clients cascade;
create table clients (
    id  bigserial not null,
    email varchar(255) not null,
    first_name varchar(255),
    last_name varchar(255),
    password varchar(255),
    phone varchar(255) not null,
    role_id int8,
    wallet_id int8,
    primary key (id),
    foreign key (role_id) references roles,
    foreign key (wallet_id) references wallets
    );

insert into clients (
    email,
    first_name,
    last_name,
    password,
    phone,
    role_id,
    wallet_id)
values (
    'derden2000@mail.ru',
    'Anton',
    'Shushliakov',
    '$2y$12$o2xrva7qgszsvPeQyXvgFu9THyVZbCGOz0ClnhDFgtlCu3L3xDzcW',
    '111',
    1,
    1);

drop table IF exists cars cascade;
create table cars (
    id  bigserial not null,
    number varchar(255),
    payload float8 not null,
    volume float8 not null,
    owner_id int8,
    primary key (id),
    foreign key (owner_id) references clients (id)
);

drop table IF exists couriers cascade;
create table couriers (
    id int8 not null,
    primary key (id),
    foreign key (id) references clients
    );

drop table IF exists customers cascade;
create table customers (
    id int8 not null,
    primary key (id),
    foreign key (id) references clients
    );

drop table IF exists order_status cascade;
create table order_status (
    id  bigserial not null,
    title varchar(255),
    primary key (id)
    );

drop table IF exists orders cascade;
create table orders (
    id  bigserial not null,
    complete_date timestamp,
    create_date timestamp,
    address_id int8,
    status_id int8,
    owner_id int8,
    primary key (id),
    foreign key (address_id) references addresses,
    foreign key (status_id) references order_status,
    foreign key (owner_id) references customers
    );


drop table IF exists pass_tokens cascade;
create table pass_tokens (
    id  bigserial not null,
    expiry_date timestamp,
    token varchar(255),
    client_id int8 not null,
    primary key (id),
    foreign key (client_id) references clients
    );
