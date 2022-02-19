/*
 * (c) Copyright 2022 sothawo
 */
package com.sothawo.sdedemoescompatibiliy;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.http.HttpHeaders;

/**
 * @author P.J. Meisch (pj.meisch@sothawo.com)
 */
@Configuration
public class DemoConfiguration extends AbstractElasticsearchConfiguration {

	@Override
	public RestHighLevelClient elasticsearchClient() {

		HttpHeaders compatibilityHeaders = new HttpHeaders();
		compatibilityHeaders.add("Accept", "application/vnd.elasticsearch+json;compatible-with=7");
		compatibilityHeaders.add("Content-Type", "application/vnd.elasticsearch+json;"
			+ "compatible-with=7");

		ClientConfiguration clientConfiguration = ClientConfiguration.builder()
			.connectedTo("localhost:9200")
			.withProxy("localhost:8080")
			.withBasicAuth("elastic","********")
			.withDefaultHeaders(compatibilityHeaders)
			.build();

		return RestClients.create(clientConfiguration).rest();
	}
}
