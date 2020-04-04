package br.com.otta.numbersconverter.controller;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.otta.numbersconverter.model.api.ConverterRequest;
import br.com.otta.numbersconverter.model.api.ConverterResponse;
import br.com.otta.numbersconverter.service.ConverterService;

/**
 * Controller para as requisições de conversão.
 *
 * @author Guilherme
 *
 */
@RestController
@RequestMapping("/api/converter")
public class ConverterController {
    private final ConverterService service;

    public ConverterController(ConverterService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConverterResponse> convert(@Valid @RequestBody ConverterRequest request) {
        return ResponseEntity.ok(service.executeConverter(request.getUserInput(), request.getItemType()));
    }
}
