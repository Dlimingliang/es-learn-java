package com.lml.es.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.JsonData;
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

    public void testSearchDocument() throws IOException {
        SearchResponse<EsDocument> searchResponse = elasticsearchClient
                .search(s -> s.index(INDEX_NAME).query(
                        q -> q.term(
                                t -> t.field("name.keyword").value(v -> v.stringValue("iPhone"))
                        )
                ), EsDocument.class);
        for (Hit<EsDocument> hit: searchResponse.hits().hits()) {
            log.info("== hit: source: {}, id: {}", hit.source(), hit.id());
        }
    }

    public void testMultipleCondition() throws IOException {

        SearchRequest request = SearchRequest.of(searchRequest -> searchRequest.index(INDEX_NAME)
                .from(0)
                .size(2)
                .sort(s -> s.field(f -> f.field("age").order(SortOrder.Desc)))
                .query(query ->
                        query.bool(boolQuery ->
                                boolQuery
                                        .must(must -> must.range(e -> e.field("age").gte(JsonData.of(21)).lte(JsonData.of(25))))
                                        .mustNot(mustNot -> mustNot.term(e -> e.field("name.keyword").value(value -> value.stringValue("lml"))))
                        )
                )
        );

        SearchResponse<EsDocument> searchResponse = elasticsearchClient.search(request, EsDocument.class);
        log.info("返回的总条数有：{}", searchResponse.hits().total().value());
        for (Hit<EsDocument> hit: searchResponse.hits().hits()) {
            log.info("== hit: source: {}, id: {}", hit.source(), hit.id());
        }
    }

    public void testGetDocument() throws IOException {
        GetResponse<EsDocument> getResponse = elasticsearchClient.get(getRequest -> getRequest.index(INDEX_NAME).id("zai4-IABG4mBIrNBqRxZ"), EsDocument.class);
        log.info("== document source: {}, response: {}", getResponse.source(), getResponse);
    }

    public void testAddDocument() throws IOException {

        IndexResponse indexResponse = elasticsearchClient.index(indexRequest ->
                indexRequest.index(INDEX_NAME).document(new EsDocument("iPhone", 25)));

        log.info("== response: {}, responseStatus: {}", indexResponse, indexResponse.result());
    }
}
