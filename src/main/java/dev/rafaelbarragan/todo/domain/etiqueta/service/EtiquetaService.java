package dev.rafaelbarragan.todo.domain.etiqueta.service;

import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaCrear;
import dev.rafaelbarragan.todo.domain.etiqueta.dto.EtiquetaRespuesta;
import dev.rafaelbarragan.todo.domain.etiqueta.entity.Etiqueta;
import dev.rafaelbarragan.todo.domain.etiqueta.repository.EtiquetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
