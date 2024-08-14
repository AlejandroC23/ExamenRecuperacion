CREATE TABLE personas (
    per_id INT AUTO_INCREMENT PRIMARY KEY,
    per_nombre VARCHAR(250) NOT NULL,
    per_apellido VARCHAR(250) NOT NULL,
    per_cedula INT NOT NULL UNIQUE,
    per_calle VARCHAR(250) NOT NULL UNIQUE,
    per_ciudad VARCHAR(250) NOT NULL,
    per_codPostal INT NOT NULL,
    per_pais VARCHAR(250) NOT NULL,
    per_continente VARCHAR(250) NOT NULL
);

CREATE TABLE profesores (
    pro_id INT AUTO_INCREMENT PRIMARY KEY,
    pro_despacho VARCHAR(250) NOT NULL,
    per_id INT NOT NULL,
    FOREIGN KEY (per_id) REFERENCES personas(per_id)
);

CREATE TABLE estudiantes (
    est_id INT AUTO_INCREMENT PRIMARY KEY,
    per_id INT NOT NULL,
    FOREIGN KEY (per_id) REFERENCES personas(per_id)
);
