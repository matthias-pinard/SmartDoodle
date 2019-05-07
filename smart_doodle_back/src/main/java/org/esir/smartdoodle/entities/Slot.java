package org.esir.smartdoodle.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Slot extends PanacheEntity{


    @Basic(optional=false)
    public Date dateBegin;

    @Basic(optional=true)
    public Date dateEnd;

    @ManyToOne
    public Poll poll;

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
