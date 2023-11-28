create table customer
(
    age        integer      not null,
    id         bigint       not null auto_increment,
    email      varchar(255) not null,
    first_name varchar(75) not null,
    last_name  varchar(75),

    primary key (id),
    constraint UQ_customer_email unique (email)
) engine = InnoDB;