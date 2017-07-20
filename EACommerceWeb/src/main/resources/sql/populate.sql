INSERT INTO product VALUES(1,'brand new','Shoe',23.99,'p123');
INSERT INTO product VALUES(2,'brand new','Cloth',40.00,'p145');
INSERT INTO product VALUES(3,'brand new','Shorts',25.99,'p321');
INSERT INTO product VALUES(4,'brand new','Make Up',10.99,'p222');


 INSERT INTO usercredential VALUES ('Paul','','$2a$10$cbn04TjztMMe9iQiIk3tT.sv3HBDg8FGnlO8UIlaKtP5PtiNVqPka',NULL);
 INSERT INTO usercredential VALUES ('Sean','','$2a$10$q2mJubO41mryHffrWrEi6e63BDdCgcadq36pXUXnBunZUxDq96Atu',NULL);
 INSERT INTO usercredential VALUES ('Guest','','Guest',NULL);

 INSERT INTO user VALUES (1,30,'nmtame11@gmail.com','Paul','Bearer',"",'Paul'); 
INSERT INTO user VALUES (2, 45,'nmtame11@gmail.com', 'Sean','Smith',"",'Sean');
INSERT INTO user VALUES (3,30,'nmtame11@gmail.com','Guest','Guest',"",'Guest'); 

INSERT INTO authority  VALUES (1, 'ROLE_USER','guest', 'Guest');
INSERT INTO authority  VALUES (2, 'ROLE_USER','Paul', 'Paul');
INSERT INTO authority  VALUES (3, 'ROLE_ADMIN','Sean', 'Sean');
INSERT INTO authority  VALUES (4, 'ROLE_USER','Sean', 'Sean');

INSERT INTO address VALUES (1, 'Fairfield', 'IA', '1000 4th st', 52557, 1);
INSERT INTO address VALUES (2, 'Fairfield', 'IA', '422 4th st', 52557, 1);
INSERT INTO address VALUES (3, 'Ottuma', 'IA', '500 4th st', 52557, 2);
