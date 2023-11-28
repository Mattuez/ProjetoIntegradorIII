create table booking
(
    car_id      bigint not null,
    customer_id bigint not null,
    id          bigint not null auto_increment,
    status      enum ('OPENED','CLOSED'),

    primary key (id),
    constraint fk_booking_car_car_id
        foreign key (car_id) references car (id),
    constraint fk_booking_customer_customer_id
        foreign key (customer_id) references customer (id)
) engine = InnoDB;