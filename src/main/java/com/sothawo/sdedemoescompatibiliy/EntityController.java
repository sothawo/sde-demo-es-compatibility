/*
 * (c) Copyright 2022 sothawo
 */
package com.sothawo.sdedemoescompatibiliy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

/**
 * @author P.J. Meisch (pj.meisch@sothawo.com)
 */
@RestController
@RequestMapping("/entities")
public class EntityController {

	private final EntityRepository repository;

	public EntityController(EntityRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/load")
	public void load() {

		var entities = IntStream.range(1, 11).boxed().map(i -> new Entity(String.valueOf(i), "text-" + i)).toList();

		entities.forEach(repository::save);

		// saveAll fails, as the returned bulk response is not compatible.
//		repository.saveAll(entities);
	}

	@GetMapping
	public Iterable<Entity> all() {
		return repository.findAll();
	}
}
