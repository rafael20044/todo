CREATE TABLE tarea_etiquetas (
    tarea_id BIGINT REFERENCES tareas(id),
    etiqueta_id BIGINT REFERENCES etiquetas(id),
    PRIMARY KEY (tarea_id, etiqueta_id)
);
