package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Slot {

    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional=false)
    private Date dateBegin;

    @Basic(optional=true)
    private Date dateEnd;

    @ManyToOne
    private Poll poll;

    public Slot(){

    }

    public Slot(Date dateBegin){
        this.dateBegin = dateBegin;
    }

    public Slot(Date dateBegin, Date dateEnd){
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }

    public Date getDateBegin(){
        return this.dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd(){
        return this.dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }
}
