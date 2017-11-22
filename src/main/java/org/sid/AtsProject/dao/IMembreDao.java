package org.sid.AtsProject.dao;

import java.io.Serializable;
import java.util.List;

import org.sid.AtsProject.entities.Demande;
import org.sid.AtsProject.entities.DemandeMateriel;
import org.sid.AtsProject.entities.DemandeService;
import org.sid.AtsProject.entities.Membre;
import org.sid.AtsProject.entities.Message;
import org.sid.AtsProject.entities.MessageOffre;


public interface IMembreDao extends Serializable{
public Membre addMembre( Membre c);
public Membre getMembreById(long id);
public List<Membre> getAllMembre();
public void deleteMembre(Membre m);
public Membre updateMembre(Membre m);

}
