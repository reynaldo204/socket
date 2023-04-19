CREATE TABLE Ciudades ( 
    ciud_id INT, 
    ciud_nombre VARCHAR(255),
    PRIMARY KEY (ciud_id)); 
CREATE TABLE Personas ( 
        dir_tel INT, dir_tipo_tel INT, 
        dir_nombre VARCHAR(255), 
        dir_direccion VARCHAR(255), 
        dir_ciud_id INT, PRIMARY KEY (dir_tel, dir_ciud_id), 
        FOREIGN KEY (dir_ciud_id) REFERENCES Ciudades(ciud_id) ); 
SELECT * FROM Personas INNER JOIN Ciudades ON Personas.dir_ciud_id = Ciudades.ciud_id;