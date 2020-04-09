use web_labs;



create table customers
(
    id int(8) not null auto_increment PRIMARY KEY,
    name varchar(20) not null,
    login varchar(20) not null ,
    password varchar(20) not null
);

create table shopping_carts
(
    id int(8) not null auto_increment primary key,
    id_customer int(8) not null,
    foreign key (id_customer) references customers(id) on delete cascade
);

create table services
(
    service_name varchar(20) not null primary key,
    price int(8) not null
);


create table shopping_carts_services
(
    id_shopping_cart int(8) not null,
    service_name varchar(20) not null,
    count int(8) not null,
    foreign key (id_shopping_cart) references shopping_carts(id) on delete cascade,
    foreign key (service_name) references services(service_name) on delete cascade
);


insert into customers (id, name, login, password) VALUE (1,'Marushin', 'macrushin', '12345678');
insert into customers (name, login, password) values ('Mirkulov', 'mirkulov', '12341234'),
                                                     ('Avdeeva', 'avdeeva', '12312312'),
                                                     ('Muraviev', 'muraviev', '12344321'),
                                                     ('Shirnaev', 'loev', '12344322');


insert into services(service_name, price) VALUES ('haircut',500),
                                                 ('manicure',300),
                                                 ('massage',1000),
                                                 ('pedicure',1500),
                                                 ('polish',350),
                                                 ('conditioning',450),
                                                 ('waving',150),
                                                 ('curling',250);


insert into shopping_carts ( id_customer) VALUE (1);
insert into shopping_carts ( id_customer) VALUES (1),
                                                 (1),
                                                 (2),
                                                 (2),
                                                 (3),
                                                 (3),
                                                 (4),
                                                 (4),
                                                 (5),
                                                 (5),
                                                 (5);


insert into shopping_carts_services (id_shopping_cart, service_name, count) VALUES (1,'conditioning',2),
                                                                                   (1,'pedicure',2),
                                                                                   (1,'manicure',2),
                                                                                   (1,'massage',3),
                                                                                   (1,'polish',1),
                                                                                   (2,'waving',4),
                                                                                   (2,'waving',5),
                                                                                   (2,'massage',1),
                                                                                   (2,'manicure',2),
                                                                                   (2,'pedicure',3),
                                                                                   (3,'polish',4),
                                                                                   (3,'massage',3),
                                                                                   (3,'curling',4),
                                                                                   (3,'manicure',5),
                                                                                   (3,'pedicure',3),
                                                                                   (4,'waving',2),
                                                                                   (4,'waving',1),
                                                                                   (4,'massage',2),
                                                                                   (4,'waving',3),
                                                                                   (4,'polish',1),
                                                                                   (5,'manicure',2),
                                                                                   (5,'pedicure',1),
                                                                                   (5,'massage',3),
                                                                                   (5,'waving',2),
                                                                                   (5,'manicure',1),
                                                                                   (6,'polish',3),
                                                                                   (6,'curling',4),
                                                                                   (6,'curling',1),
                                                                                   (6,'manicure',2),
                                                                                   (6,'massage',1),
                                                                                   (7,'pedicure',2),
                                                                                   (7,'waving',3),
                                                                                   (7,'polish',4),
                                                                                   (7,'manicure',1),
                                                                                   (7,'massage',1),
                                                                                   (8,'waving',3),
                                                                                   (8,'pedicure',4),
                                                                                   (8,'manicure',1),
                                                                                   (8,'massage',3),
                                                                                   (8,'waving',1),
                                                                                   (9,'manicure',1),
                                                                                   (9,'pedicure',2),
                                                                                   (9,'curling',3),
                                                                                   (9,'polish',4),
                                                                                   (9,'waving',5),
                                                                                   (10,'manicure',1),
                                                                                   (10,'massage',2),
                                                                                   (10,'pedicure',2),
                                                                                   (10,'curling',1),
                                                                                   (10,'polish',1),
                                                                                   (11,'waving',1),
                                                                                   (11,'manicure',1),
                                                                                   (11,'massage',1),
                                                                                   (11,'pedicure',1),
                                                                                   (11,'polish',2),
                                                                                   (12,'curling',3),
                                                                                   (12,'manicure',1),
                                                                                   (12,'massage',1),
                                                                                   (12,'pedicure',3),
                                                                                   (12,'waving',1);
