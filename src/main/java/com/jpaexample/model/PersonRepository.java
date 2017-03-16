package com.jpaexample.model;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface PersonRepository extends CrudRepository<Person, Long> {

}