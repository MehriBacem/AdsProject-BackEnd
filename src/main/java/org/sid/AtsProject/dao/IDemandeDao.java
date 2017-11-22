package org.sid.AtsProject.dao;

import java.io.Serializable;
import java.util.List;

import org.sid.AtsProject.entities.Demande;
import org.sid.AtsProject.entities.DemandeMateriel;
import org.sid.AtsProject.entities.DemandeService;
import org.sid.AtsProject.entities.Membre;

public interface IDemandeDao extends Serializable {
	public Demande addDemande( Demande d);
	public List<Demande> getAllDemande();
	public Demande getDemandeById(int id);
	public DemandeMateriel addDemandeMateriel( DemandeMateriel dm);
	public List<DemandeMateriel> getAllDemandeMateriel();
	public List<DemandeMateriel> getDemandeMaterielBySousCategorie(String s);
	public List<DemandeService> getDemandeServiceBySousCategorie(String s);
	public DemandeMateriel getDemandeMaterielById(int id);
	public DemandeService addDemandeService( DemandeService dm);
	public List<DemandeService> getAllDemandeService();
	public DemandeService getDemandeServiceById(int id);
	public void deleteDemande(DemandeMateriel m);
	public List getAllDemandesParFiltre(String x, String y);
	public List getAllDemandeSorted(List l);
	
	
}
