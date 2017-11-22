package org.sid.AtsProject.metier;

import java.util.List;

import org.sid.AtsProject.dao.IMembreDao;
import org.sid.AtsProject.entities.*;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor=Exception.class)
public class MembreMetierImpl implements IMembreMetier{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public MembreMetierImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


private  IMembreDao dao ;

public MembreMetierImpl(IMembreDao dao) {
	super();
	this.dao = dao;
}

public IMembreDao getDao() {
	return dao;
}

public void setDao(IMembreDao dao) {
	this.dao = dao;
}

@Override
public Membre addMembre(Membre c) {
	
	return dao.addMembre(c);
}

@Override
public List<Membre> getAllMembre() {
	return dao.getAllMembre();
}

@Override
public Membre getMembreById(long id) {
	return dao.getMembreById(id);
}

@Override
public void deleteMembre(Membre m) {
	// TODO Auto-generated method stub
	dao.deleteMembre(m);
	
}

@Override
public Membre updateMembre(Membre m) {
	// TODO Auto-generated method stub
	return dao.updateMembre(m) ;
}


}
