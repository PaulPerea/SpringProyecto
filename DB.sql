create database ProyectoSpring
use ProyectoSpring
-- Tabla: Sedes
CREATE TABLE Sedes (
    id_sede INT AUTO_INCREMENT PRIMARY KEY,
    nombre_sede VARCHAR(100) NOT NULL,
    direccion VARCHAR(200),
    telefono VARCHAR(20)
);

-- Tabla: Carreras
CREATE TABLE Carreras (
    id_carrera INT AUTO_INCREMENT PRIMARY KEY,
    nombre_carrera VARCHAR(100) NOT NULL,
    descripcion VARCHAR(200),
    id_sede INT,
    FOREIGN KEY (id_sede) REFERENCES Sedes(id_sede)
);

-- Tabla: Ciclos
CREATE TABLE Ciclos (
    id_ciclo INT AUTO_INCREMENT PRIMARY KEY,
    nombre_ciclo VARCHAR(100) NOT NULL,
    fecha_inicio DATE,
    fecha_fin DATE
);

-- Tabla: Alumnos
CREATE TABLE Alumnos (
    id_alumno INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE,
    direccion VARCHAR(200),
    telefono VARCHAR(20),
    correo_electronico VARCHAR(100),
    id_carrera INT,
    FOREIGN KEY (id_carrera) REFERENCES Carreras(id_carrera)
);

-- Tabla: Cursos
CREATE TABLE Cursos (
    id_curso INT AUTO_INCREMENT PRIMARY KEY,
    nombre_curso VARCHAR(100) NOT NULL,
    descripcion VARCHAR(200),
    id_carrera INT,
    id_ciclo INT,
    FOREIGN KEY (id_carrera) REFERENCES Carreras(id_carrera),
    FOREIGN KEY (id_ciclo) REFERENCES Ciclos(id_ciclo)
);

-- Tabla: Matriculas
CREATE TABLE Matriculas (
    id_matricula INT AUTO_INCREMENT PRIMARY KEY,
    id_alumno INT,
    id_curso INT,
    fecha_matricula DATE,
    FOREIGN KEY (id_alumno) REFERENCES Alumnos(id_alumno),
    FOREIGN KEY (id_curso) REFERENCES Cursos(id_curso)
);

-- Insertar datos en la tabla Sedes
INSERT INTO Sedes (nombre_sede, direccion, telefono)
VALUES
    ('Sede Principal', 'Calle Principal 123', '+1 123-456-7890'),
    ('Sede Secundaria', 'Avenida Secundaria 456', '+1 987-654-3210'),
    ('Sede Norte', 'Calle Norte 789', '+1 555-123-4567'),
    ('Sede Sur', 'Avenida Sur 789', '+1 444-987-6543'),
    ('Sede Este', 'Calle Este 987', '+1 777-555-1234');

-- Insertar datos en la tabla Carreras
INSERT INTO Carreras (nombre_carrera, descripcion, id_sede)
VALUES
    ('Ingeniería Informática', 'Carrera de ingeniería en sistemas informáticos', 1),
    ('Administración de Empresas', 'Carrera de gestión empresarial', 1),
    ('Diseño Gráfico', 'Carrera de diseño y comunicación visual', 2),
    ('Contabilidad', 'Carrera de contabilidad y finanzas', 3),
    ('Ingeniería Civil', 'Carrera de ingeniería civil y construcción', 4);

-- Insertar datos en la tabla Ciclos
INSERT INTO Ciclos (nombre_ciclo, fecha_inicio, fecha_fin)
VALUES
    ('2023 Primer Ciclo', '2023-02-01', '2023-06-30'),
    ('2023 Segundo Ciclo', '2023-07-01', '2023-11-30'),
    ('2024 Primer Ciclo', '2024-02-01', '2024-06-30'),
    ('2024 Segundo Ciclo', '2024-07-01', '2024-11-30'),
    ('2025 Primer Ciclo', '2025-02-01', '2025-06-30');

-- Insertar datos en la tabla Alumnos
INSERT INTO Alumnos (nombre, apellido, fecha_nacimiento, direccion, telefono, correo_electronico, id_carrera)
VALUES
    ('Juan', 'Perez', '1995-05-15', 'Calle Avenida 456', '+1 987-654-3210', 'juan.perez@example.com', 1),
    ('María', 'Gómez', '1998-09-20', 'Avenida Principal 789', '+1 555-123-4567', 'maria.gomez@example.com', 2),
    ('Carlos', 'López', '1994-12-10', 'Calle Norte 321', '+1 444-987-6543', 'carlos.lopez@example.com', 3),
    ('Ana', 'Martínez', '1997-07-05', 'Avenida Sur 789', '+1 777-555-1234', 'ana.martinez@example.com', 4),
    ('Pedro', 'Rodríguez', '1996-03-25', 'Calle Este 654', '+1 666-888-9999', 'pedro.rodriguez@example.com', 5);

-- Insertar datos en la tabla Cursos
INSERT INTO Cursos (nombre_curso, descripcion, id_carrera, id_ciclo)
VALUES
    ('Programación Avanzada', 'Curso de programación orientada a objetos', 1, 1),
    ('Gestión Empresarial', 'Curso de administración de empresas', 2, 2),
    ('Diseño Web', 'Curso de diseño y desarrollo de páginas web', 3, 1),
    ('Contabilidad Básica', 'Curso de principios básicos de contabilidad', 4, 2),
    ('Diseño Estructural', 'Curso de diseño y cálculo estructural', 5, 3);

-- Insertar datos en la tabla Matriculas
INSERT INTO Matriculas (id_alumno, id_curso, fecha_matricula)
VALUES
    (1, 1, '2023-03-15'),
    (2, 3, '2023-02-28'),
    (3, 2, '2023-01-20'),
    (4, 4, '2023-04-10'),
    (5, 5, '2023-05-05');
------------------------------------
-- Insertar datos adicionales en la tabla Sedes
INSERT INTO Sedes (nombre_sede, direccion, telefono)
VALUES
    ('Sede Oeste', 'Avenida Oeste 456', '+1 222-333-4444'),
    ('Sede Central', 'Calle Central 789', '+1 888-777-6666'),
    ('Sede Universitaria', 'Avenida Universitaria 321', '+1 999-888-7777'),
    ('Sede Tecnológica', 'Calle Tecnológica 654', '+1 333-444-5555');

-- Insertar datos adicionales en la tabla Carreras
INSERT INTO Carreras (nombre_carrera, descripcion, id_sede)
VALUES
    ('Arquitectura', 'Carrera de diseño y planificación de edificaciones', 5),
    ('Derecho', 'Carrera de derecho y legislación', 3),
    ('Psicología', 'Carrera de ciencias de la mente y el comportamiento', 2),
    ('Ingeniería Eléctrica', 'Carrera de ingeniería eléctrica y electrónica', 1),
    ('Marketing', 'Carrera de mercadotecnia y estrategias de ventas', 4);

-- Insertar datos adicionales en la tabla Ciclos
INSERT INTO Ciclos (nombre_ciclo, fecha_inicio, fecha_fin)
VALUES
    ('2025 Segundo Ciclo', '2025-07-01', '2025-11-30'),
    ('2026 Primer Ciclo', '2026-02-01', '2026-06-30'),
    ('2026 Segundo Ciclo', '2026-07-01', '2026-11-30'),
    ('2027 Primer Ciclo', '2027-02-01', '2027-06-30'),
    ('2027 Segundo Ciclo', '2027-07-01', '2027-11-30');

-- Insertar datos adicionales en la tabla Alumnos
INSERT INTO Alumnos (nombre, apellido, fecha_nacimiento, direccion, telefono, correo_electronico, id_carrera)
VALUES
    ('Laura', 'García', '1999-08-10', 'Calle Universidad 123', '+1 666-555-4444', 'laura.garcia@example.com', 4),
    ('Manuel', 'Hernández', '1998-11-25', 'Avenida Tecnología 789', '+1 777-666-5555', 'manuel.hernandez@example.com', 5),
    ('Sofía', 'López', '2000-02-18', 'Calle Universitaria 456', '+1 444-333-2222', 'sofia.lopez@example.com', 2),
    ('Daniel', 'Martínez', '1997-06-05', 'Avenida Central 321', '+1 999-888-7777', 'daniel.martinez@example.com', 3),
    ('Luis', 'Gómez', '2001-03-30', 'Calle Tecnológica 654', '+1 333-444-5555', 'luis.gomez@example.com', 1);

-- Insertar datos adicionales en la tabla Cursos
INSERT INTO Cursos (nombre_curso, descripcion, id_carrera, id_ciclo)
VALUES
    ('Diseño Interior', 'Curso de diseño de interiores y espacios', 3, 3),
    ('Derecho Penal', 'Curso de derecho penal y procesos judiciales', 4, 2),
    ('Psicología del Desarrollo', 'Curso de psicología del desarrollo humano', 5, 1),
    ('Electrónica Digital', 'Curso de electrónica y sistemas digitales', 1, 4),
    ('Gestión de Redes Sociales', 'Curso de marketing digital y redes sociales', 2, 5);

-- Insertar datos adicionales en la tabla Matriculas
INSERT INTO Matriculas (id_alumno, id_curso, fecha_matricula)
VALUES
    (1, 2, '2023-03-20'),
    (2, 1, '2023-02-15'),
    (3, 4, '2023-01-25'),
    (4, 3, '2023-04-05'),
    (5, 5, '2023-05-10');

 alter table sedes
  drop email;
  
  
use proyectospring
select * from sedes