package org.udg.pds.springtodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.udg.pds.springtodo.controller.exceptions.ServiceException;
import org.udg.pds.springtodo.entity.Plats;
import org.udg.pds.springtodo.repository.PlatsRepository;

import java.util.Optional;

@Service
public class PlatsService {

  private final PlatsRepository platsRepository;

  public PlatsService(PlatsRepository platsRepository) {
    this.platsRepository = platsRepository;
  }

  public PlatsRepository crud() {
    return platsRepository;
  }


  public Plats register(String nom) {

   Plats plats = new Plats(nom);
    platsRepository.save(plats);
    return plats;
  }

  public Plats getUser(Long id) {
    Optional<Plats> uo = platsRepository.findById(id);
    if (uo.isPresent())
      return uo.get();
    else
      throw new ServiceException(String.format("User with id = % dos not exists", id));
  }


}
