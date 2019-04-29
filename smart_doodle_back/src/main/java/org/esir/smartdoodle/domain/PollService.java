package org.esir.smartdoodle.domain;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.esir.smartdoodle.entities.Poll;

@ApplicationScoped
public class PollService {

    @Inject
    private EntityManager em;

    @Transactional
    public void set(Poll poll) {
        em.persist(poll);
    }

    public List<Poll> list() {
        return em.createQuery("from Poll").getResultList();
    }
}
