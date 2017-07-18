 
INSERT INTO credentials(username,password,enabled) VALUES ('guest','guest', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','admin', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO  `SINGLEORDER` (orderNumber, quantity,status) VALUES ('O123-4566',12,'Delivering');
INSERT INTO `SINGLEORDER` (orderNumber, quantity, status) VALUES ('O123-5566',123,'Preparing');


					