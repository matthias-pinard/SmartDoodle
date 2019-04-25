package org.acme.quickstart.domain;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class GiftService {

    @Inject
    private EntityManager em;

    @Transactional
    public void set(Gift gift) {
        em.persist(gift);
    }

    public List<Gift> list() {
        return em.createQuery("from Gift").getResultList();
    }
}
