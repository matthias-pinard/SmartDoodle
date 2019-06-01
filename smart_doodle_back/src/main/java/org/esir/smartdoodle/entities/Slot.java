package org.esir.smartdoodle.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Slot extends PanacheEntity{


    @Basic(optional=false)
    public Date dateBegin;

    @Basic(optional=true)
    public Date dateEnd;

    @ManyToOne
    @JsonbTransient
    public Poll poll;

    @ManyToMany
    @JsonbTransient
    public List<Guest> guests = new ArrayList<>();

    public Slot(){

    }

    public Slot(Date dateBegin){
        this.dateBegin = dateBegin;
    }

    public Slot(Date dateBegin, Date dateEnd){
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }
}
