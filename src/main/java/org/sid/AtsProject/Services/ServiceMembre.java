package org.sid.AtsProject.Services;
import java.util.List;

import org.sid.AtsProject.entities.Membre;
import org.sid.AtsProject.entities.Message;
import org.sid.AtsProject.entities.MessageOffre;
import org.sid.AtsProject.metier.IMembreMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceMembre {
	
  
	ClassPathXmlApplicationContext app= new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"}) ;
	IMembreMetier MembreMetier= ( IMembreMetier) app.getBean("MembreMetier");
	public ServiceMembre() {
		super();
		
	}
	@RequestMapping(value="/Membre",method=RequestMethod.POST, headers="Accept=application/json")
	public  Membre AjouterMembre(@RequestBody Membre m){
		MembreMetier.addMembre(m) ;
		return m ;
	}
	
	@RequestMapping(value="/Membres",method=RequestMethod.GET, headers="Accept=application/json")
	public List<Membre> listMembre(){
		return MembreMetier.getAllMembre() ;
	}
	@RequestMapping(value="/UpdateMembre",method=RequestMethod.PUT, headers="Accept=application/json")
	public  Membre UpdateMembre(@RequestBody Membre m){
		MembreMetier.updateMembre(m);
		return m;
	}
	@RequestMapping(value="/DeleteMembre",method=RequestMethod.DELETE, headers="Accept=application/json")
	public void DeleteMembre(@RequestBody Membre m){
		MembreMetier.deleteMembre(m);
		
	}
	

}
