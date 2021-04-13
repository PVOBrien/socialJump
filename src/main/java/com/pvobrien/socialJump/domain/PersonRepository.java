package com.pvobrien.socialJump.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository <Person, Long> {

    List<Person> findByUserName(String userName); // simple query
    List<Person> findByNumber(int aNumber); // simple query

    List<Person> findByUserNameAndNumber(String userName, int number); // with multiple reqs
    List<Person> findByUserNameOrNumber(String userName, int number); // with either/or option

    List<Person> findByNumberOrderByNumberAsc(int number); // ASC or DESC
}

// the var names ARE NOT potato, ALL parts of the above var names ARE IMPORTANT, *every* letter.
// @Query(SQL_QUERY) annotation allows for specific query calls.