package org.udg.pds.springtodo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.udg.pds.springtodo.entity.Plats;
import org.udg.pds.springtodo.entity.Recomanacio;
import org.udg.pds.springtodo.entity.Views;
import org.udg.pds.springtodo.service.PlatsService;

import java.util.ArrayList;

@RequestMapping(path="/plats")
@RestController
public class PlatsController extends BaseController {

  @Autowired
  PlatsService platsService;

  @GetMapping(path="/suggest", consumes = "application/json")
  @ResponseBody
  @JsonView(Views.Private.class)
  public Recomanacio seleccionaPlats (@RequestBody R_Opcions opcions) {
    return platsService.seleccionaPlats(opcions.estilsCuina,opcions.restriccions);
  }

  static class R_Opcions {
    public ArrayList<String> estilsCuina;
    public ArrayList<String> restriccions;
  }

}
