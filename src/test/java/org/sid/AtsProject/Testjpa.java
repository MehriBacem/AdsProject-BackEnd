package org.sid.AtsProject;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Before;
import org.junit.Test;
import org.sid.AtsProject.entities.Conversation;
import org.sid.AtsProject.entities.Demande;
import org.sid.AtsProject.entities.DemandeMateriel;
import org.sid.AtsProject.entities.DemandeService;
import org.sid.AtsProject.entities.Membre;
import org.sid.AtsProject.entities.Message;
import org.sid.AtsProject.entities.MessageNormal;
import org.sid.AtsProject.entities.MessageOffre;
import org.sid.AtsProject.metier.IDemandeMetier;
import org.sid.AtsProject.metier.IMembreMetier;
import org.sid.AtsProject.metier.IMessageMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.github.javafaker.PhoneNumber;

public class Testjpa {
	
	@Before public void setUp() {
	   }
 
  @Test
	public void test() {
	  ClassPathXmlApplicationContext app= new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"}) ;
		IMembreMetier aa= ( IMembreMetier) app.getBean("MembreMetier");
		IDemandeMetier aaaa= ( IDemandeMetier) app.getBean("DemandeMetier");
		IMessageMetier mm= (IMessageMetier) app.getBean("MessageMetier");
		
	MessageOffre mo = mm.addMessageOffre( new	MessageOffre("MessageOffre", false, true,null,null,1000,false,null)) ;
		Faker faker = new Faker();
		
			


		for(int a=0;a<10;a++){
			String  prenom = faker.name().fullName(); // Miss Samanta Schmidt
			String  adresse= faker.name().firstName(); // Emory
		String  ville= faker.name().lastName(); // Barton

			String email = faker.internet().emailAddress() ;
			
			String tel = faker.address().streetAddress();
			String msgpresentation= faker.name().lastName();
			Membre membre=aa.addMembre(new Membre(prenom,adresse,"Tunis",email,tel,msgpresentation)) ;

			}
	}
  
	@Test
	public void test1() {
	  ClassPathXmlApplicationContext app= new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"}) ;
		IMembreMetier aa= ( IMembreMetier) app.getBean("MembreMetier");
		IDemandeMetier aaaa= ( IDemandeMetier) app.getBean("DemandeMetier");
		IMessageMetier mm= (IMessageMetier) app.getBean("MessageMetier");
		
		Faker faker = new Faker();
	

		for(int b=0;b<10;b++){
		String  intitule = faker.name().fullName(); // Miss Samanta Schmidt
		String   categorie= faker.name().firstName(); // Emory
		String  message= faker.name().lastName(); // Barton

		String souscategorie = faker.address().streetAddress();
		long budget = faker.hashCode();
		String lieu = faker.address().streetAddress();
		String nbJours= faker.name().lastName();
		int a =ThreadLocalRandom.current().nextInt(1, 10);
		System.out.println(a);
		Membre random = aa.getMembreById(a);
		DemandeMateriel aaa=aaaa.addDemandeMateriel(new DemandeMateriel(intitule,"materiel",message,souscategorie,budget,"Sousse",random,nbJours)) ;

		}
		for(int c=0;c<10;c++){
			
			System.out.println("done");
			String  intitule = faker.name().fullName(); // Miss Samanta Schmidt
			String   categorie= faker.name().firstName(); // Emory
			String  message= faker.name().lastName(); // Barton

			String souscategorie = faker.address().streetAddress();
			long budget = faker.hashCode();
			String lieu = faker.address().streetAddress();
			int typologie= 1;
			int a =ThreadLocalRandom.current().nextInt(1,10);
			System.out.println(a);
			Membre random = aa.getMembreById(a);
			DemandeService aaa=aaaa.addDemandeService(new DemandeService(intitule,"service",message,"Cars",1000,"Sousse",random,typologie)) ;

			}
		 //   Conversation cc=mm.addConversation(new Conversation());
		 //   MessageOffre mo=mm.addMessageOffre(new MessageOffre("cd", false, false, null, aaa, 0, null, cc)) ;
		//Membre membre = aa.getMembreById(1);
		//	DemandeService aaa=aaaa.addDemandeService(new DemandeService("a","b","c","d",1100,"w",membre,1)) ;
	     //    MessageNormale msgoffre= mm.addMessageNormale(new MessageNormale("a", true, true,null,null,"aaa",null)) ;
	       
} 
		//Membre a=aa.addMembre(new Membre("selim","taxi","menthe","aaa","msg","blabla"));
	    //DemandeService b=aaaa.addDemandeService(new DemandeService("service","ok","hkh","jkjkj",50,"kjkj",a,1));
		 //   Conversation cc=mm.addConversation(new Conversation());
		 //   MessageOffre mo=mm.addMessageOffre(new MessageOffre("cd", false, false, null, aaa, 0, null, cc)) ;
  }

