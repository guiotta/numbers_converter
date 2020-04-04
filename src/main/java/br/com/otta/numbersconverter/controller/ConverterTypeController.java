package br.com.otta.numbersconverter.controller;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.otta.numbersconverter.model.ItemType;
import br.com.otta.numbersconverter.service.ConverterTypeService;

/**
 * Componente para endpoint listando os tipos de conversores disponíveis.
 *
 * @author Guilherme
 *
 */
@RestController
@RequestMapping("/api/types")
public class ConverterTypeController {
    private final ConverterTypeService service;

    public ConverterTypeController(ConverterTypeService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<ItemType>> listAllValidConverterTypes() {
        return ResponseEntity.ok(service.listAllValidTypes());
    }
}
