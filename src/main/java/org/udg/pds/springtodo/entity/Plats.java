package org.udg.pds.springtodo.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


@Data
@Document(collection = "Plats")
public class Plats implements Serializable {
  /**
   * Default value included to remove warning. Remove or modify at will. *
   */
  private static final long serialVersionUID = 1L;

  public Plats(String nom, String descripcio, String tipus, int ordre, ArrayList<String> ingredients, ArrayList<String> restriccions, String url, int popularitat) {
    this.nom = nom;
    this.descripcio = descripcio;
    this.tipus = tipus;
    this.ordre = ordre;
    this.ingredients = ingredients;
    this.restriccions = restriccions;
    this.url = url;
    this.popularitat = popularitat;
  }

  @Id
  private String id;

  @JsonView(Views.Private.class)
  private String nom;

  @JsonView(Views.Private.class)
  private String descripcio;

  @JsonView(Views.Private.class)
  private String tipus;

  @JsonView(Views.Private.class)
  private int ordre;

  @JsonView(Views.Private.class)
  private Collection<String> ingredients;

  @JsonView(Views.Private.class)
  private Collection<String> restriccions;

  @JsonView(Views.Private.class)
  private String url;

  @JsonView(Views.Private.class)
  private int popularitat;

}
