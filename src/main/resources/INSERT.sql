USE ADOPCIONES;

#Roles
INSERT INTO ROLES (rol_nombre) VALUES ('ROLE_ADMIN');
INSERT INTO ROLES (rol_nombre) VALUES ('ROLE_USER');
INSERT INTO ROLES (rol_nombre) VALUES ('ROLE_REPT');

#Especies
INSERT INTO DETALLES (especie,raza) VALUES ('PERRO','SAN BERNARDO');
INSERT INTO DETALLES (especie,raza) VALUES ('PERRO','BEAGLE');
INSERT INTO DETALLES (especie,raza) VALUES ('PERRO','LABRADOR');

INSERT INTO DETALLES (especie,raza) VALUES ('GATO','PERSA');
INSERT INTO DETALLES (especie,raza) VALUES ('GATO','PERUANO');
INSERT INTO DETALLES (especie,raza) VALUES ('GATO','SIAMES');

INSERT INTO DETALLES (especie,raza) VALUES ('HAMSTERS','BLANCO');
INSERT INTO DETALLES (especie,raza) VALUES ('HAMSTERS','OREJAS');
INSERT INTO DETALLES (especie,raza) VALUES ('HAMSTERS','SIBERIANO');


COMMIT;