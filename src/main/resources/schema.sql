DROP TABLE IF EXISTS PERSON;

CREATE TABLE PERSON (
    id INTEGER PRIMARY KEY,
    name VARCHAR,
    age INTEGER,
);

INSERT INTO PERSON(id, name, age) values (1, 'Marcelo Ortiz de Santana', 36);
INSERT INTO PERSON(id, name, age) values (2, 'André Ortiz de Sanana', 38);
INSERT INTO PERSON(id, name, age) values (3, 'Heriton Arantes', 36);