package dev.rafaelbarragan.todo.domain.etiqueta.service;

import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaCrear;
import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaRespuesta;
import dev.rafaelbarragan.todo.domain.etiqueta.entity.Etiqueta;

import java.util.List;

public interface IEtiquetaService {

    EtiquetaRespuesta crear(EtiquetaCrear crear);

    List<Etiqueta> bsucarEtiquetas(List<Long> etiquetas);
}
