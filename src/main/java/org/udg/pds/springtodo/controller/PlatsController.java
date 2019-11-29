package org.udg.pds.springtodo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.udg.pds.springtodo.controller.exceptions.ControllerException;
import org.udg.pds.springtodo.entity.Plats;
import org.udg.pds.springtodo.entity.Views;
import org.udg.pds.springtodo.service.PlatsService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

// This class is used to process all the authentication related URLs
@RequestMapping(path="/users")
@RestController
public class PlatsController extends BaseController {

  @Autowired
  PlatsService platsService;


  @GetMapping(path="/{id}")
  @JsonView(Views.Public.class)
  public Plats getPlat(HttpSession session, @PathVariable("id") Long id) {

    getLoggedUser(session);

    return platsService.getUser(id);
  }


  @GetMapping(path="/check")
  public String checkLoggedIn(HttpSession session) {

    getLoggedUser(session);

    return BaseController.OK_MESSAGE;
  }


  static class LoginUser {
    @NotNull
    public String username;
    @NotNull
    public String password;
  }

  static class RegisterUser {
    @NotNull
    public String username;
    @NotNull
    public String email;
    @NotNull
    public String password;
  }

  static class ID {
    public Long id;

    public ID(Long id) {
      this.id = id;
    }
  }

}
