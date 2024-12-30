package dev.rafaelbarragan.todo.domain.etiqueta.service;

import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaBuscar;
import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaCrear;
import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaEditar;
import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaRespuesta;
import dev.rafaelbarragan.todo.domain.etiqueta.entity.Etiqueta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEtiquetaService {

    EtiquetaRespuesta crear(EtiquetaCrear crear);

    List<Etiqueta> bsucarEtiquetas(List<Long> etiquetas);

    EtiquetaBuscar buscar(Long id);

    Page<EtiquetaBuscar> buscarTodos(Pageable pageable);

    EtiquetaRespuesta editar(EtiquetaEditar editar);

    Etiqueta buscarEntidad(Long id);

    void eliminar(Long id);
}
