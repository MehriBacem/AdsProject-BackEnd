package org.sid.AtsProject.Services;

import java.util.List;

import org.sid.AtsProject.entities.MessageOffre;
import org.sid.AtsProject.metier.IMembreMetier;
import org.sid.AtsProject.metier.IMessageMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicePrestation {
	ClassPathXmlApplicationContext app= new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"}) ;
	IMessageMetier MessageMetier= ( IMessageMetier) app.getBean("MessageMetier");
	public ServicePrestation() {
		super();
		
	}
	
	@RequestMapping(value="/Prestations",method=RequestMethod.GET, headers="Accept=application/json")
	public  List<MessageOffre> getAllPrestations(){
		return MessageMetier.getAllPrestations();
		
	}
}