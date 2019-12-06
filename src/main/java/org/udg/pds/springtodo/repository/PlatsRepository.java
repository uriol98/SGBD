package org.udg.pds.springtodo.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.udg.pds.springtodo.entity.Plats;

import java.util.ArrayList;
import java.util.Collection;

@Component
public interface PlatsRepository extends CrudRepository<Plats, Long> {

    @Query(value = "{$and: [ {'Restriccions': {$nin: ?1} }, {'Ordre': {$eq: ?2} }, {'Tipus': {$in: ?0} } ] }")
    ArrayList<Plats> buscarPlats(ArrayList<String> estilsCuina, ArrayList<String> restriccions, int tipusPlat, Sort sort);

    @Query(value = "{$and: [ {'Restriccions': {$nin: [?0]} }, {'Ordre': {$eq: ?1} } ] }")
    ArrayList<Plats> buscarPlatsTotsEstilsCuina(ArrayList<String> restriccions, int tipusPlat, Sort sort);

}
