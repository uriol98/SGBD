package org.udg.pds.springtodo.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

public class Recomanacio implements Serializable {
    @NotNull
    @JsonView(Views.Public.class)
    Collection<Plats> primers;

    @NotNull
    @JsonView(Views.Public.class)
    Collection<Plats> segons;

    @NotNull
    @JsonView(Views.Public.class)
    Collection<Plats> postres;

    public Recomanacio(Collection<Plats> primers, Collection<Plats> segons, Collection<Plats> postres) {
        this.primers = primers;
        this.segons = segons;
        this.postres = postres;
    }
}
