package org.sid.AtsProject.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sid.AtsProject.entities.Demande;
import org.sid.AtsProject.entities.DemandeMateriel;
import org.sid.AtsProject.entities.DemandeService;
import org.sid.AtsProject.entities.Membre;

public class DemandeDaoImpl implements IDemandeDao{
	
	public DemandeDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	@PersistenceContext
	 private EntityManager em ;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Demande> getAllDemande() {
		javax.persistence.Query req=em.createQuery("select d from Demande d");
		return (List<Demande>)req.getResultList();
	}
	
	@Override
	public DemandeMateriel addDemandeMateriel(DemandeMateriel dm) {
		em.persist(dm);
		return dm ;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DemandeMateriel> getAllDemandeMateriel() {
		javax.persistence.Query req=em.createQuery("select d from Demande d where d.categorie=:x");
		req.setParameter("x","materiel");
		return (List<DemandeMateriel>)req.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List getAllDemandesParFiltre(String x , String y) {
		javax.persistence.Query req=em.createQuery("select d from Demande d where d.categorie=:x and d.souscategorie=:y");
		req.setParameter("x",x);
		req.setParameter("y",y);
		return req.getResultList();
	}
	@Override
	public DemandeMateriel getDemandeMaterielById(int id) {
		DemandeMateriel dm=em.find(DemandeMateriel.class, id);
		if(dm==null) {
			throw new RuntimeException("element introuvable") ;
		}
		return dm;
		
	}
	@Override
	public DemandeService addDemandeService(DemandeService ds) {
		em.persist(ds);
		return ds ;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DemandeService> getAllDemandeService() {
		javax.persistence.Query req=em.createQuery("select d from Demande d where d.categorie=:x");
		req.setParameter("x","service");
		return (List<DemandeService>)req.getResultList();
	}
	@Override
	public DemandeService getDemandeServiceById(int id) {
		DemandeService ds=em.find(DemandeService.class, id);
		if(ds==null) {
			throw new RuntimeException("element introuvable") ;
		}
		return ds;
	}
	@Override
	public Demande addDemande(Demande d) {
		em.persist(d);
		return d;
	}
	@Override
	public Demande getDemandeById(int id) {
		Demande d=em.find(Demande.class, id);
		if(d==null) {
			throw new RuntimeException("element introuvable") ;
		}
		return d;		
	}

	@Override
	public List<DemandeMateriel> getDemandeMaterielBySousCategorie(String s) {
		javax.persistence.Query req=em.createQuery("select d from DemandeMateriel d where d.souscategorie=:x");
		req.setParameter("x",s);
		return (List<DemandeMateriel>)req.getResultList();
	}

	@Override
	public List<DemandeService> getDemandeServiceBySousCategorie(String s) {

			javax.persistence.Query req=em.createQuery("select d from DemandeService d where d.sousCategorie=:x");
			req.setParameter("x",s);
			return (List<DemandeService>)req.getResultList();
	}
	
	@Override
	public void deleteDemande(DemandeMateriel m) {
		em.remove(em.contains(m) ? m : em.merge(m));
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List getAllDemandeSorted(List l) {
		Collections.sort(l);
		return l;
	}


}
