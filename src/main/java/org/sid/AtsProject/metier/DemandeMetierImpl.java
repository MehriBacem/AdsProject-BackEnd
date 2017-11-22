package org.sid.AtsProject.metier;

import java.util.List;

import org.sid.AtsProject.dao.IDemandeDao;
import org.sid.AtsProject.dao.IMembreDao;
import org.sid.AtsProject.entities.Demande;
import org.sid.AtsProject.entities.DemandeMateriel;
import org.sid.AtsProject.entities.DemandeService;
import org.springframework.transaction.annotation.Transactional;
@Transactional(rollbackFor=Exception.class)
public class DemandeMetierImpl implements IDemandeMetier{
	private  IDemandeDao dao ;
	
	
	public DemandeMetierImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemandeMetierImpl(IDemandeDao dao) {
		super();
		this.dao = dao;
	}

	public IDemandeDao getDao() {
		return dao;
	}

	public void setDao(IDemandeDao dao) {
		this.dao = dao;
	}

	@Override
	public Demande addDemande(Demande d) {
		return dao.addDemande(d);
	}

	@Override
	public List<Demande> getAllDemande() {
		return dao.getAllDemande();
	}
	public List getAllDemandesParFiltre(String x, String y){
		return dao.getAllDemandesParFiltre(x, y);
	}
	@Override
	public Demande getDemandeById(int id) {
		return dao.getDemandeById(id);
	}

	@Override
	public DemandeMateriel addDemandeMateriel(DemandeMateriel dm) {
		return dao.addDemandeMateriel(dm);
	}

	@Override
	public List<DemandeMateriel> getAllDemandeMateriel() {
		return dao.getAllDemandeMateriel();
	}

	@Override
	public DemandeMateriel getDemandeMaterielById(int id) {
		return dao.getDemandeMaterielById(id);
	}

	@Override
	public DemandeService addDemandeService(DemandeService ds) {
		return dao.addDemandeService(ds);
	}

	@Override
	public List<DemandeService> getAllDemandeService() {
		return dao.getAllDemandeService();
	}

	@Override
	public DemandeService getDemandeServiceById(int id) {
		return dao.getDemandeServiceById(id);
	}

	@Override
	public List<DemandeMateriel> getDemandeMaterielBySousCategorie(String s) {
		// TODO Auto-generated method stub
		return dao.getDemandeMaterielBySousCategorie(s);
	}
	@Override
	public List<DemandeService> getDemandeServiceBySousCategorie(String s) {
		// TODO Auto-generated method stub
		return dao.getDemandeServiceBySousCategorie(s);
	}

	

	@Override
	public void deleteDemande(DemandeMateriel m) {
		// TODO Auto-generated method stub
		dao.deleteDemande(m);
	}
	public List getAllDemandeSorted(List L){
	return	dao.getAllDemandeSorted(L);
	}

}
