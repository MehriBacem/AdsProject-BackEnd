package org.sid.AtsProject.metier;

import java.io.Serializable;
import java.util.List;

import org.sid.AtsProject.entities.Demande;
import org.sid.AtsProject.entities.DemandeMateriel;
import org.sid.AtsProject.entities.DemandeService;
import org.sid.AtsProject.entities.Membre;
import org.sid.AtsProject.entities.Message;
import org.sid.AtsProject.entities.MessageOffre;



public interface IMembreMetier extends Serializable{
	
	public Membre addMembre( Membre c);
	public void deleteMembre(Membre m);
	public Membre updateMembre(Membre m);
	public List<Membre> getAllMembre();
	public Membre getMembreById(long id);

}
