package com.pvobrien.socialJump.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository <User, Long> {

    List<User> findByUserName(String userName); // simple query
    List<User> findByNumber(int aNumber); // simple query

    List<User> findByUserNameAndNumber(String userName, int number); // with multiple reqs
    List<User> findByUserNameOrNumber(String userName, int number); // with either/or option

    List<User> findByNumberOrderByNumberAsc(int number); // ASC or DESC
}

// the var names ARE NOT potato, ALL parts of the above var names ARE IMPORTANT, *every* letter.
// @Query(SQL_QUERY) annotation allows for specific query calls.