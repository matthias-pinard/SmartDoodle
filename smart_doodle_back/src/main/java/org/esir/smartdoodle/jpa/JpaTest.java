package jpa;

import entities.Poll;
import entities.Slot;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

public class JpaTest {
	
	private EntityManager manager;
	
	public JpaTest() {
		this.manager = EntityManagerHelper.getEntityManager();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JpaTest jpa = new JpaTest();
		EntityManager manager = jpa.getManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();


		try {
			Poll paul = new Poll();

			paul.setTitle("Test de paul.");
			paul.setSummary("Résumé de paul.");

			Slot slot = new Slot();

			slot.setDateBegin(new Date());
			slot.setDateEnd(new Date());
			slot.setPoll(paul);

			paul.addSlot(slot);

			manager.persist(paul);
			manager.persist(slot);

			manager.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		jpa.listPolls();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close()	;
	}
	
	public EntityManager getManager() {
		return manager;
	}

	private void listPolls() {
		EntityManager manager = EntityManagerHelper.getEntityManager();
		
		List<Poll> lPolls = manager.createQuery("SELECT p FROM Poll p", Poll.class).getResultList();
		
		for(Poll p : lPolls) {
			System.out.println(p.getId() + ": " + p.getTitle());
		}
	}


}
