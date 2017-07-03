// Products

INSERT INTO product (id, name, description, parent_product_id) VALUES (0001, 'Java 1.6', 'DESCRICAO', null);
INSERT INTO product (id, name, description, parent_product_id) VALUES (0002, 'Python 2.7', 'DESCRICAO', null);
INSERT INTO product (id, name, description, parent_product_id) VALUES (0003, 'Java 1.7', 'DESCRICAO', 0001);
INSERT INTO product (id, name, description, parent_product_id) VALUES (0004, 'Java 1.8', 'DESCRICAO', 0003);
INSERT INTO product (id, name, description, parent_product_id) VALUES (0005, 'Python 3.4', 'DESCRICAO', 0002);
INSERT INTO product (id, name, description, parent_product_id) VALUES (0006, 'MatLAB', 'DESCRICAO', null);
INSERT INTO product (id, name, description, parent_product_id) VALUES (0007, 'Scala', 'DESCRICAO', null);
INSERT INTO product (id, name, description, parent_product_id) VALUES (0008, 'R', 'DESCRICAO', null);
INSERT INTO product (id, name, description, parent_product_id) VALUES (0009, 'C#', 'DESCRICAO', null);
INSERT INTO product (id, name, description, parent_product_id) VALUES (0010, 'C++', 'DESCRICAO', 0009);

// Images

INSERT INTO image (id, type, product_id) VALUES (0001, 'Cool', 0001);
INSERT INTO image (id, type, product_id) VALUES (0002, 'Fancy', 0005);
INSERT INTO image (id, type, product_id) VALUES (0003, 'Nice', 0007);
INSERT INTO image (id, type, product_id) VALUES (0004, 'Pragmatic', 0010);
INSERT INTO image (id, type, product_id) VALUES (0005, 'Proprietary', 0006);
