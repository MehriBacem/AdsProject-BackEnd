package org.sid.AtsProject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.sid.AtsProject.entities.Membre;



public class MembreDaoImpl implements IMembreDao{
public MembreDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

@PersistenceContext
 private EntityManager em ;
	@Override
	public Membre addMembre(Membre c)
	{
		em.persist(c);
		return c ;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Membre> getAllMembre() {
		javax.persistence.Query req=em.createQuery("select m from Membre m");
		return (List<Membre>)req.getResultList();
	}
	@Override
	public Membre getMembreById(long id) {
		Membre m=em.find(Membre.class, id);
		if(m==null) {
			throw new RuntimeException("element introuvable") ;
		}
		return m;
	}
	@Override
	public Membre updateMembre(Membre m) {
		em.merge(m);
		return m;	}
	
	@Override
	public void deleteMembre(Membre m) {
		em.remove(em.contains(m) ? m : em.merge(m));
		
	}
}
