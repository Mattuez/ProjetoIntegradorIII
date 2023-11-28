create table car
(
    is_available         bit                                     not null,
    rental_price_per_day decimal(10, 2)                          not null,
    plate                char(7)                                 not null,
    id                   bigint                                  not null auto_increment,
    brand                varchar(50),
    model                varchar(100)                            not null,
    type                 enum ('COMBUSTION','ELECTRIC','HYBRID') not null,
    primary key (id)
) engine = InnoDB;
