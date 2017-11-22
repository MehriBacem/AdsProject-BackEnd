package org.sid.AtsProject.Services;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.sid.AtsProject.entities.Demande;
import org.sid.AtsProject.entities.DemandeMateriel;
import org.sid.AtsProject.entities.DemandeService;
import org.sid.AtsProject.entities.Membre;
import org.sid.AtsProject.metier.IDemandeMetier;
import org.sid.AtsProject.metier.IMembreMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class ServiceDemande {
	ClassPathXmlApplicationContext app= new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"}) ;
	IDemandeMetier DemandeMetier= ( IDemandeMetier) app.getBean("DemandeMetier");
	IMembreMetier MembreMetier = ( IMembreMetier) app.getBean("MembreMetier");

	public ServiceDemande() {
		super();
		
	}
	public static float distance(String x,String y){
		  x=x.replaceAll("\\s","%20");
		  y=y.replaceAll("\\s","%20");
		  
		  String str="https://maps.googleapis.com/maps/api/directions/json?origin="+x+"&destination="+y+"&key=AIzaSyDq3PagcRAoqTLlGq8vxa1m6xP4iXMOfBQ";
		  String output  = getUrlContents(str); 

	  	  float distance = 10000;
		try {
			int a=nthoccurence(output,":",19);
			  int b=nthoccurence(output,",",14);
			  
			  distance = Float.parseFloat(output.substring(a+3,b-4).replaceAll("\\s",""));
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  //System.out.println(output.substring(a+3,b-4));
		  return distance;
		  //return 0;    
	  }
	  public static int nthoccurence(String str, String substr, int n) {
		    int pos = str.indexOf(substr);
		    while (--n > 0 && pos != -1)
		        pos = str.indexOf(substr, pos + 1);
		    return pos;
		}
	  

	  private static String getUrlContents(String theUrl)
	  {
	    StringBuilder content = new StringBuilder();

	   
	    try
	    {
	   
	      URL url = new URL(theUrl);

	     
	      URLConnection urlConnection = url.openConnection();

	  
	      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

	      String line;

	    
	      while ((line = bufferedReader.readLine()) != null)
	      {
	        content.append(line + "\n");
	      }
	      bufferedReader.close();
	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	    }
	    return content.toString();
	  }
	  @RequestMapping(value="/",method=RequestMethod.GET, headers="Accept=application/json")
		public  void Home(){
			
		}
	@RequestMapping(value="/DemandeMateriel",method=RequestMethod.POST, headers="Accept=application/json")
	public  DemandeMateriel AjouterDemandeMateriel(@RequestBody DemandeMateriel dm){
		DemandeMetier.addDemandeMateriel(dm);
		return dm ;
	}
	@RequestMapping(value="/DeleteDemande",method=RequestMethod.DELETE, headers="Accept=application/json")
	public void DeleteMembre(@RequestBody DemandeMateriel m){
		DemandeMetier.deleteDemande(m);
		
	}
	@RequestMapping(value="/DemandeService",method=RequestMethod.POST, headers="Accept=application/json")
	public  DemandeService AjouterDemandeService(@RequestBody DemandeService dm){
		DemandeMetier.addDemandeService(dm);
		return dm ;
	}

	@RequestMapping(value="/Demandes/{categorie}",method=RequestMethod.GET, headers="Accept=application/json")
	public List listDemandes(@PathVariable String categorie){
		
		if(categorie.equals("Materiel")){
		return DemandeMetier.getAllDemandeMateriel();}
		else {
			return DemandeMetier.getAllDemandeService();}
	}
	
	@RequestMapping(value="/Demandes/{categorie}/{souscategorie}/{id}/{distance}/{triPrix}/{triDate}",method=RequestMethod.GET, headers="Accept=application/json")
	public List listDemandes(@PathVariable String categorie,@PathVariable String souscategorie,@PathVariable long distance,@PathVariable long id,@PathVariable String triPrix,@PathVariable String triDate){
		List  ListDemandes =new ArrayList();
		if(souscategorie.equals("tout"))
		{
			if(categorie.equals("materiel")){
				ListDemandes =DemandeMetier.getAllDemandeMateriel();}
				else {
					ListDemandes = DemandeMetier.getAllDemandeService();
			
		}}
		else{
		 ListDemandes = DemandeMetier.getAllDemandesParFiltre(categorie, souscategorie);}
		
		if(triPrix.equals("true"))
		{ 
			  ListDemandes= DemandeMetier.getAllDemandeSorted(ListDemandes);
		}
		if(triDate.equals("true"))
		{
		 Collections.reverse(ListDemandes);
		}
		List NewListDemande = new ArrayList() ;
		
		for (Iterator<Demande> i = ListDemandes.iterator(); i.hasNext();) {
		    Demande item = i.next();
		    float d = distance(item.getLieu(),MembreMetier.getMembreById(id).getVille()) ;
		    if(d <= distance) { 
		    NewListDemande.add(item) ;
		    }}
		return NewListDemande ;
	}
	@RequestMapping(value="/Demandes",method=RequestMethod.GET, headers="Accept=application/json")
	public List<Demande> listDemandes(){
		return DemandeMetier.getAllDemande();
	}
	
	@RequestMapping(value="/DemandeById/{id}",method=RequestMethod.GET, headers="Accept=application/json")
	public Demande DemandeById(@PathVariable int id){
		return DemandeMetier.getDemandeById(id);
	}
	@RequestMapping(value="/DemandeMaterielById/{id}",method=RequestMethod.GET, headers="Accept=application/json")
	public DemandeMateriel DemandeMaterielById(@PathVariable int id){
		return DemandeMetier.getDemandeMaterielById(id);
	}
	@RequestMapping(value="/DemandeServiceById/{id}",method=RequestMethod.GET, headers="Accept=application/json")
	public DemandeService DemandeServiceById(@PathVariable int id){
		return DemandeMetier.getDemandeServiceById(id);
	}
	
	@RequestMapping(value="/DemandeByLocalisation/{id}/{distance}",method=RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody List<Demande> getDemandeByLocalisation(@PathVariable long distance,@PathVariable long id)
	{      List<Demande> NewListDemande = new ArrayList();
		List<Demande> ListDemandes = DemandeMetier.getAllDemande() ;
		for (Iterator<Demande> i = ListDemandes.iterator(); i.hasNext();) {
		    Demande item = i.next();
		    float d = distance(item.getLieu(),MembreMetier.getMembreById(id).getVille()) ;
		    if(d <= distance) { System.out.println("yesss");
		    NewListDemande.add(item) ;
		    }
		}
		return NewListDemande;
		
	}
	//@RequestMapping(value="/DemandesSorted",method=RequestMethod.GET, headers="Accept=application/json")
//	public List DemandeSorted(){
	//	return DemandeMetier.getAllDemandeSorted();
	//}
	
	
}
