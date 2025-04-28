INSERT INTO tattoo_salon.user
VALUES
    (1,'adminEmail@test.com','Alex','Maksimovich','$2a$10$5TBQSyLUhDmepe1Li7M3/uIUg40dUsPqoRU01ENRlcU93.BEo0gCu','ADMIN'),
    (2,'masterEmail@test.com','Anton','Maksimovcih','$2a$10$5TBQSyLUhDmepe1Li7M3/uIUg40dUsPqoRU01ENRlcU93.BEo0gCu','MASTER'),
    (3,'clientEmail@test.com','Ilia','Lihtar','$2a$10$5TBQSyLUhDmepe1Li7M3/uIUg40dUsPqoRU01ENRlcU93.BEo0gCu','CLIENT');

INSERT INTO tattoo_salon.user_profile
VALUES
    (2, 'Test bio 2',4.9,3);

INSERT INTO tattoo_salon.history
VALUES
    (1,'2023-10-01 12:00:00','Simple tattoo',3, 2);

INSERT INTO tattoo_salon.contact_details
VALUES
    (1,'adminEmail@test.com','+375291234567',1),
    (2,'masterEmail@test.com','+37529123456',2),
    (3,'userEmail@test.com','+375291234567',3);