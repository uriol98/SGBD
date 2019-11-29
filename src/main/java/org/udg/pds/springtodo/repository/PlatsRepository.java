package org.udg.pds.springtodo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.udg.pds.springtodo.entity.Plats;

@Component
public interface PlatsRepository extends CrudRepository<Plats, Long> {

}
