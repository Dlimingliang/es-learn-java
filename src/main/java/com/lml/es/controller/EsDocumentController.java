package com.lml.es.controller;

import com.lml.es.service.EsDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("es-documents")
public class EsDocumentController {

    @Autowired
    private EsDocumentService esDocumentService;

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
