package org.udg.pds.springtodo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Data
@Document
public class Plats implements Serializable {
  /**
   * Default value included to remove warning. Remove or modify at will. *
   */
  private static final long serialVersionUID = 1L;

  public Plats(String nom) {
    this.nom = nom;
  }

  @Id
  private String id;

  private String nom;

}
