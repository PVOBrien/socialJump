package com.pvobrien.socialJump.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Long> {

    List<Location> findByPlace(String place);
    List<Location> findById(long id);

}
