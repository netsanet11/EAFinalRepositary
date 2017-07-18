 
INSERT INTO credentials(username,password,enabled) VALUES ('guest','guest', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','admin', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO  `SINGLEORDER` (productName, quantity,status) VALUES ('Curious',12,'Suspend');
INSERT INTO `SINGLEORDER` (productName, quantity, status) VALUES ('Allen',123,'Suspend');


					