package org.sid.AtsProject.metier;

import java.io.Serializable;
import java.util.List;

import org.sid.AtsProject.entities.Demande;
import org.sid.AtsProject.entities.DemandeMateriel;
import org.sid.AtsProject.entities.DemandeService;


public interface IDemandeMetier extends Serializable{

	public Demande addDemande( Demande d);
	public List<Demande> getAllDemande();
	public Demande getDemandeById(int id);
	public void deleteDemande(DemandeMateriel m);
	public DemandeMateriel addDemandeMateriel( DemandeMateriel dm);
	public List<DemandeMateriel> getAllDemandeMateriel();
	public DemandeMateriel getDemandeMaterielById(int id);
	
	public DemandeService addDemandeService( DemandeService ds);
	public List<DemandeService> getAllDemandeService();
	public DemandeService getDemandeServiceById(int id);
	public List<DemandeMateriel> getDemandeMaterielBySousCategorie(String s);
	public List<DemandeService> getDemandeServiceBySousCategorie(String s);
	public List getAllDemandesParFiltre(String x, String y);
	public List getAllDemandeSorted(List l) ;
}
