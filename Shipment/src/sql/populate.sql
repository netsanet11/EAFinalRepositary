 
INSERT INTO credentials(username,password,enabled) VALUES ('guest','guest', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','admin', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO  `SINGLEORDER` (orderNumber, quantity,status) VALUES ('O123-4566',12,'Delivering');
INSERT INTO `SINGLEORDER` (orderNumber, quantity, status) VALUES ('O123-5566',123,'Preparing');

INSERT INTO 'USERINFO' (street, city, state, zipCode, userName) VALUES ('N ST 4 1000', 'FairField', 'IOWA','51227','John');
INSERT INTO 'USERINFO' (street, city, state, zipCode, userName) VALUES ('N ST 4 1001', 'FairField', 'IOWA','51227','Jim');


					