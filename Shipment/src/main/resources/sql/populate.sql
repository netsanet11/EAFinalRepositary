 
INSERT INTO credentials(username,password,enabled) VALUES ('Sean','Sean', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','admin', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('Paul', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('Sean', 'ROLE_ADMIN');

INSERT INTO `USERINFO` (id, street, city, state, zipCode, userName) VALUES (1, 'N ST 4 1000', 'FairField', 'IOWA','51227','John');
INSERT INTO `USERINFO` (id, street, city, state, zipCode, userName) VALUES (2, 'N ST 4 1001', 'FairField', 'IOWA','51227','Jim');

INSERT INTO  `SINGLEORDER` VALUES (1, 1234566,12,1, 1);
INSERT INTO `SINGLEORDER` VALUES (2, 1235566,123,2, 2);



					