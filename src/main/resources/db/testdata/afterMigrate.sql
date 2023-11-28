set foreign_key_checks = 0;

delete from car;
delete from customer;
delete from booking;

set foreign_key_checks = 1;

alter table car
    auto_increment = 1;
alter table customer
    auto_increment = 1;
alter table booking
    auto_increment = 1;

insert into car (id, is_available, rental_price_per_day, plate, brand, model, type)
values (1, true, 50.00, 'BRA1B23', 'Toyota', 'Corolla', 'COMBUSTION'),
       (2, true, 70.00, 'BRA2E19', 'Tesla', 'Model S', 'ELECTRIC'),
       (3, true, 60.00, 'AOB1C23', 'Honda', 'Civic', 'HYBRID');

-- Inserting a customer with explicitly specified id
INSERT INTO customer (id, age, email, first_name, last_name)
VALUES (1, 25, 'john.doe@example.com', 'John', 'Doe'),
       (2, 30, 'jane.smith@example.com', 'Jane', null),
       (3, 22, 'alice.jones@example.com', 'Alice', 'Jones');