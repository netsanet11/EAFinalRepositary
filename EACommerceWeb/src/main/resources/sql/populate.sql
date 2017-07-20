INSERT INTO product VALUES(1,'brand new','Shoe',23.99,'p123');
INSERT INTO product VALUES(2,'brand new','Cloth',40.00,'p145');
INSERT INTO product VALUES(3,'brand new','Shorts',25.99,'p321');

 INSERT INTO usercredential VALUES ('Paul','','$2a$10$cbn04TjztMMe9iQiIk3tT.sv3HBDg8FGnlO8UIlaKtP5PtiNVqPka',NULL);
 INSERT INTO usercredential VALUES ('Sean','','$2a$10$q2mJubO41mryHffrWrEi6e63BDdCgcadq36pXUXnBunZUxDq96Atu',NULL);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('Paul', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('Sean', 'ROLE_ADMIN');
 

INSERT INTO user VALUES (1,30,'Paul','Bearer', 7,"",'Paul'); 
INSERT INTO user VALUES (2, 45, 'Sean','Smith',1,"",'Sean');

INSERT INTO address VALUES (1, 'Fairfield', 'Iowa', '1000 4th st', 52557, 1)
INSERT INTO address VALUES (2, 'Fairfield', 'Iowa', '422 4th st', 52557, 1)
INSERT INTO address VALUES (3, 'Ottuma', 'Iowa', '500 4th st', 52557, 2)



					