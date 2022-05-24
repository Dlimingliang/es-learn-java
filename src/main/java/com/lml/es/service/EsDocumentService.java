package com.lml.es.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.lml.es.model.EsDocument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class EsDocumentService {

    public static final String INDEX_NAME = "es-test";

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    public void testGetDocument() throws IOException {
        GetResponse<EsDocument> getResponse = elasticsearchClient.get(getRequest -> getRequest.index(INDEX_NAME).id("1"), EsDocument.class);
        log.info("== document source: {}, response: {}", getResponse.source(), getResponse);
    }

    public void testAddDocument() throws IOException {

        IndexResponse indexResponse = elasticsearchClient.index(indexRequest ->
                indexRequest.index(INDEX_NAME).document(EsDocument.builder().name("lml").age(21)));

        log.info("== response: {}, responseStatus: {}", indexResponse, indexResponse.result());
    }
}
