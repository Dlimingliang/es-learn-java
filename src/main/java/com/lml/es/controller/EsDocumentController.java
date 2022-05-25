package com.lml.es.controller;

import com.lml.es.service.EsDocumentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("es-documents")
public class EsDocumentController {

    private final EsDocumentService esDocumentService;

    public EsDocumentController(EsDocumentService esDocumentService) {
        this.esDocumentService = esDocumentService;
    }

    @GetMapping("search")
    public String search() throws IOException {
        esDocumentService.testSearchDocument();
        return "search";
    }

    @GetMapping("multipleCondition")
    public String multipleCondition() throws IOException {
        esDocumentService.testMultipleCondition();
        return "multipleCondition";
    }

    @GetMapping("get")
    public String get() throws IOException {
        esDocumentService.testGetDocument();
        return "get";
    }

    @GetMapping("create")
    public String create() throws IOException {
        esDocumentService.testAddDocument();
        return "create";
    }
}
