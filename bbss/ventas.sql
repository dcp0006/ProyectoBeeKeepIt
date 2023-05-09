create schema Ventas;
CREATE TABLE usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  correo VARCHAR(255) NOT NULL,
  contraseña VARCHAR(255) NOT NULL
);

CREATE TABLE productos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  precio DECIMAL(10,2) NOT NULL,
  cantidad INT NOT NULL,
  idP_user int not null,
  FOREIGN KEY (idP_user) REFERENCES usuarios(id)
);
select * from usuarios

CREATE TABLE ventas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  idV_usuario INT NOT NULL,
  idV_producto INT NOT NULL,
  fecha DATE NOT NULL,
  cantidad INT NOT NULL,
  total DECIMAL(10,2) NOT NULL,
  FOREIGN KEY (idV_usuario) REFERENCES usuarios(id),
  FOREIGN KEY (idV_producto) REFERENCES productos(id)
);

/*CONSULTAR CON CHAVA ES DARLE UNA VUELTA PROFUNDA*/
CREATE TABLE inventario (
  id INT AUTO_INCREMENT PRIMARY KEY,
  id_producto INT NOT NULL,
  cantidad INT NOT NULL,
  FOREIGN KEY (id_producto) REFERENCES productos(id)
);
select * from usuarios

