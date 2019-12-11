package org.udg.pds.springtodo.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.udg.pds.springtodo.entity.Plats;
import org.udg.pds.springtodo.entity.Recomanacio;
import org.udg.pds.springtodo.repository.PlatsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatsService {

  private final PlatsRepository platsRepository;

  final int PRIMERS = 1;
  final int SEGONS = 2;
  final int POSTRES = 3;
  final int PRIMERS_E = 11;
  final int SEGONS_E = 22;
  final int POSTRES_E = 33;

  public PlatsService(PlatsRepository platsRepository) {
    this.platsRepository = platsRepository;
  }

  public PlatsRepository crud() {
    return platsRepository;
  }

  public Recomanacio seleccionaPlats(ArrayList<String> estilsCuina, ArrayList<String> restriccions) {
    Sort sort = new Sort(Sort.Direction.DESC, "Popularitat");
    ArrayList<Plats> primers;
    ArrayList<Plats> segons;
    ArrayList<Plats> postres;
    List<Plats> primersRecomanats;
    List<Plats> segonsRecomanats;
    List<Plats> postresRecomanats;
    if (estilsCuina.isEmpty()) {
      if (restriccions.size() == 7) { //S'activa la combinació per mostrar l'Easter Egg
        primers = platsRepository.buscarPlatsTotsEstilsCuina(restriccions,PRIMERS_E,sort);
        segons = platsRepository.buscarPlatsTotsEstilsCuina(restriccions,SEGONS_E,sort);
        postres = platsRepository.buscarPlatsTotsEstilsCuina(restriccions,POSTRES_E,sort);
      }
      else {
        primers = platsRepository.buscarPlatsTotsEstilsCuina(restriccions,PRIMERS,sort);
        segons = platsRepository.buscarPlatsTotsEstilsCuina(restriccions,SEGONS,sort);
        postres = platsRepository.buscarPlatsTotsEstilsCuina(restriccions,POSTRES,sort);
      }
    }
    else {
      primers = platsRepository.buscarPlats(estilsCuina,restriccions,PRIMERS,sort);
      segons = platsRepository.buscarPlats(estilsCuina,restriccions,SEGONS,sort);
      postres = platsRepository.buscarPlats(estilsCuina,restriccions,POSTRES,sort);
    }
    if (primers.size()>5) primersRecomanats = primers.subList(0,5);
    else primersRecomanats = primers;
    if (segons.size()>5) segonsRecomanats = segons.subList(0,5);
    else segonsRecomanats = segons;
    if (postres.size()>5) postresRecomanats = postres.subList(0,5);
    else postresRecomanats = postres;
    return new Recomanacio(primersRecomanats,segonsRecomanats,postresRecomanats);
  }

}
