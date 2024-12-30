package dev.rafaelbarragan.todo.domain.etiqueta.service;

import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaBuscar;
import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaCrear;
import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaEditar;
import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaRespuesta;
import dev.rafaelbarragan.todo.domain.etiqueta.entity.Etiqueta;
import dev.rafaelbarragan.todo.domain.etiqueta.repository.EtiquetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EtiquetaService implements IEtiquetaService{

    private final EtiquetaRepository repository;

    @Autowired
    public EtiquetaService(EtiquetaRepository repository){
        this.repository = repository;
    }

    @Override
    public EtiquetaRespuesta crear(EtiquetaCrear crear) {
        Etiqueta etiqueta = new Etiqueta(crear);
        repository.save(etiqueta);
        return new EtiquetaRespuesta(etiqueta);
    }

    @Override
    public List<Etiqueta> bsucarEtiquetas(List<Long> etiquetas) {
        List<Etiqueta> etiquetas1 = new java.util.ArrayList<>(Collections.emptyList());
        for(Long id : etiquetas){
            Etiqueta etiqueta = repository.findById(id).orElseThrow(() ->
                    new RuntimeException("La etiqueta " + id + " no existe"));
            etiquetas1.add(etiqueta);
        }
        return etiquetas1;
    }

    @Override
    public EtiquetaBuscar buscar(Long id) {
        Etiqueta etiqueta = buscarEntidad(id);
        return new EtiquetaBuscar(etiqueta);
    }

    @Override
    public Page<EtiquetaBuscar> buscarTodos(Pageable pageable) {
        return repository.findAll(pageable).map(EtiquetaBuscar::new);
    }

    @Override
    public EtiquetaRespuesta editar(EtiquetaEditar editar) {
        Etiqueta etiqueta = buscarEntidad(editar.id());
        etiqueta.editar(editar);
        repository.save(etiqueta);
        return new EtiquetaRespuesta(etiqueta);
    }

    @Override
    public Etiqueta buscarEntidad(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Etiqueta no encontrada"));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
