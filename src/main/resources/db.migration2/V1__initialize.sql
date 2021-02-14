drop table IF exists clients;
create table clients (
  id                    bigserial,
  phone                 VARCHAR(30) NOT NULL,
  password              VARCHAR(80),
  email                 VARCHAR(50),
  first_name            VARCHAR(50),
  last_name             VARCHAR(50),
  UNIQUE (phone, email),
  PRIMARY KEY (id)
);

--DROP TABLE IF EXISTS roles;
--CREATE TABLE roles (
--  id                    serial,
--  name                  VARCHAR(50) NOT NULL,
--  PRIMARY KEY (id)
--);
--
--DROP TABLE IF EXISTS users_roles;
--CREATE TABLE users_roles (
--  user_id               INT NOT NULL,
--  role_id               INT NOT NULL,
--  PRIMARY KEY (user_id, role_id),
--  FOREIGN KEY (user_id)
--  REFERENCES users (id),
--  FOREIGN KEY (role_id)
--  REFERENCES roles (id)
--);
--
--INSERT INTO roles (name)
--VALUES
--('ROLE_CUSTOMER'), ('ROLE_MANAGER'), ('ROLE_ADMIN');
--
--INSERT INTO users (phone, password, first_name, last_name, email)
--VALUES
--('11111111','$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i','Admin','Admin','derden2000@mail.ru'),
--('22222222','$2y$10$knh2hFHVHAeHs4VwLBkkk.MfWAEDyb7UrmJKixcMdE4gaZ/iQirC2','Manager','Manager','222@222.ru');
--
--INSERT INTO users_roles (user_id, role_id)
--VALUES
--(1, 1),
--(1, 2),
--(1, 3),
--(2, 1),
--(2, 2);
--
--drop table if exists orders cascade;
--create table orders (id bigserial, order_date timestamp DEFAULT current_timestamp, user_id bigint, price numeric(8, 2), complete_status boolean default false, payment_status boolean default false, address text, primary key(id), constraint fk_user_id foreign key (user_id) references users (id));
--
--drop table if exists orders_items cascade;
--create table orders_items (id bigserial, order_id bigint, product_id bigint, quantity int, price numeric(8, 2), primary key(id), constraint fk_prod_id foreign key (product_id) references products (id), constraint fk_order_id foreign key (order_id) references orders (id));
--
--drop table if exists pass_tokens cascade;
--create table pass_tokens (id bigserial, token text, user_id bigint, expiry_date timestamp, primary key(id), constraint fk_user_id foreign key (user_id) references users (id));
--
--drop table if exists reviews cascade;
--create table reviews (id bigserial, review_text text, user_id bigint, product_id bigint, score smallint, primary key(id), constraint fk_user_id foreign key (user_id) references users (id), constraint fk_prod_id foreign key (product_id) references products (id));
