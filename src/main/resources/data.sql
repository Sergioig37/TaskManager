
INSERT INTO Usuario(username, password, correo)
VALUES ('sergio', '$2a$10$Dfj8wFJqzpuNm57jxQlB.ehRr8bXWWo9yKXQPxSHlMVGLzG/NZ3mG', 'sergio@example.com'),
('daniel', '$2a$10$Dfj8wFJqzpuNm57jxQlB.ehRr8bXWWo9yKXQPxSHlMVGLzG/NZ3mG', 'daniel@example.com'),
('diego', '$2a$10$Dfj8wFJqzpuNm57jxQlB.ehRr8bXWWo9yKXQPxSHlMVGLzG/NZ3mG', 'diego@example.com');

INSERT INTO Categoria (nombre, creador_id) VALUES ('Categoría 1', 1), ('Categoría 2', 2),('Categoría 3', 3);

INSERT INTO Lista_Tarea (propietario_id, categoria_id, nombre) VALUES
(1, 1, 'Trabajo'),
(2, 2, 'Casa'),
(3, 3, 'Escuela');

INSERT INTO Tarea (descripcion, prioridad, lista_id) VALUES
('Tarea 1 de alta prioridad', 1, 1),
('Tarea 2 de prioridad media',2, 2),
('Tarea 3 de baja prioridad', 3, 3);
