INSERT INTO tattoo_studio.user
VALUES
    (1,'adminEmail@test.com','Alex','Maksimovich','$2a$10$5TBQSyLUhDmepe1Li7M3/uIUg40dUsPqoRU01ENRlcU93.BEo0gCu','ADMIN'),
    (2,'masterEmail@test.com','Anton','Maksimovcih','$2a$10$5TBQSyLUhDmepe1Li7M3/uIUg40dUsPqoRU01ENRlcU93.BEo0gCu','MASTER'),
    (3,'clientEmail@test.com','Ilia','Lihtar','$2a$10$5TBQSyLUhDmepe1Li7M3/uIUg40dUsPqoRU01ENRlcU93.BEo0gCu','CLIENT');

INSERT INTO tattoo_studio.user_profile
VALUES
    (NULL,1,1,'Test bio 1'),
    (4.9,2,2,'Test bio 2'),
    (NULL,3,3,'Test bio 3');

INSERT INTO tattoo_studio.history
VALUES
    ('2023-10-01 12:00:00',3,1,2,'Simple tattoo');

INSERT INTO tattoo_studio.contact_details
VALUES
    (+375291234567,1,1,'adminEmail@test.com'),
    (+37529123456,2,2,'masterEmail@test.com'),
    (+375291234567,3,3,'userEmail@test.com');