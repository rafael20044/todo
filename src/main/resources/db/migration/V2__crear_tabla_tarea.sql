CREATE TABLE tareas (
    id BIGINT PRIMARY KEY,
    usuario_id INTEGER REFERENCES usuarios(id),
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT,
    fecha_creacion TIMESTAMP,
    fecha_vencimiento TIMESTAMP,
    completada BOOLEAN
);
