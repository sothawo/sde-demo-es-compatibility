/*
 * (c) Copyright 2022 sothawo
 */
package com.sothawo.sdedemoescompatibiliy;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author P.J. Meisch (pj.meisch@sothawo.com)
 */
public interface EntityRepository extends ElasticsearchRepository<Entity, String> {
}
