package com.gsnotes.web.controllers;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsnotes.bo.Compte;
import com.gsnotes.bo.Element;
import com.gsnotes.bo.Etudiant;
import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.InscriptionMatiere;
import com.gsnotes.bo.InscriptionModule;
import com.gsnotes.bo.Module;
import com.gsnotes.bo.Niveau;
import com.gsnotes.bo.Utilisateur;
import com.gsnotes.dao.IElementDao;
import com.gsnotes.dao.IInscriptionDao;
import com.gsnotes.dao.ImoduleDao;
import com.gsnotes.dao.InscriptionMatièreDao;
import com.gsnotes.services.ICompteService;
import com.gsnotes.services.IEtudiantService;
import com.gsnotes.services.IModuleService;
import com.gsnotes.services.INiveauService;
import com.gsnotes.services.IPersonService;
import com.gsnotes.services.InscriptionMatiereService;
import com.gsnotes.services.InscriptionModuleService;
import com.gsnotes.services.InscriptionSercvice;
import com.gsnotes.services.impl.EtudiantServiceImpl;
import com.gsnotes.utils.export.ExcelExporter;
import com.gsnotes.utils.export.UserExcelImporter;
import com.gsnotes.web.models.AccountModel;
import com.gsnotes.web.models.StudentExcel;

//controlleur là ou on excécute les differetnes requtes
// de l'application et recoit les differentes requètes à exexcuter
//@WIssal FELIOUNE
//@H130034422

//
//

@Controller
 					
public class ImportExcelController {

	//les exceptions au niveau de l'importation s 
	//sont faites d'une manière implicite dans la class userExcelImport
	
	
	
	//on fait appel a toute torte d'objet service 
	//ou dao qui va noupermettre d'appeler
	//les differentes méthode 
	@Autowired
	private ICompteService userService; // On obtient par injection automatique le service

	@Autowired
	private IPersonService personService; // On obtient par injection automatique le service
	
	@Autowired 
	private InscriptionSercvice IN;
	@Autowired 
	private IEtudiantService Et;
	@Autowired
	InscriptionMatiereService IM;
	@Autowired
	ImoduleDao Imo;
	@Autowired
	INiveauService N;
	@Autowired
	IInscriptionDao Ins;
	@Autowired
	InscriptionModuleService in;
	@Autowired
	InscriptionMatièreDao im;
	@Autowired
	IElementDao ele;
	
	
	
	//requete ou on affichrea seulement l'import
	
	@RequestMapping("/admin/import")
	public String showimport() {
		
		
		return "/admin/import";
	}
	
	
	
	
	//cette methode ou on execute les differentes condion à executer sur letudiant
	
	@PostMapping("/admin/importExcel")
	@ResponseBody
	public String importFromExcel(Model model) {
		
		
		
		UserExcelImporter excelImporter=new UserExcelImporter();
		//La liste importé a partir d' excel
		//onimporte le contenu d'excel
		List<StudentExcel> L= excelImporter.excelImport();
		
		
		//defincition de differentes objet à utiliser
		
		Module M = new Module();
		List<Etudiant> Etd = new ArrayList<Etudiant>();
		List<Module> Mod = new ArrayList<Module>();
		InscriptionAnnuelle I = new InscriptionAnnuelle();
		List<Element> el = new ArrayList<Element>();
		List<InscriptionAnnuelle> I2= new ArrayList<InscriptionAnnuelle>();

		
		Niveau Ni = new Niveau();
		
		
		
		
		int Nu=0;
		String type=null;
		String nom="";
		String prenom="";
		
		
		//recuperer les etudiants de la  base de donne 
		Etd=Et.getAllEtudiants();
		
		//parcourir la liste des etudiants importé de la base de données
		for(StudentExcel S : L) {
			//instanciation de elements
			Nu=Math.toIntExact(S.getSniveau());
			Ni =N.getNIveauById(Nu);
			long id=S.getSid();
			type=S.getStype();
			nom=S.getSnom();
			prenom=S.getSprenom();
			String cne = S.getScne();
			Etudiant E = new Etudiant ();
			
			// on fait le test si l'id d'un etudiant existe dans la base de données 
			// si oui alors il est deja dans la base de données 
			//sinon il n'est jamais stocké dans la base donnée
			if(!(Etd.contains(S.getSid()))) {
				
				
				
				//on va faire un enregistrement au niveau de l'inscription
				InscriptionAnnuelle I3= new InscriptionAnnuelle();
				
				I3.setType(type);
				E.setCne(cne);
				Et.addEtudiant(E);
				E=Et.getEtudiantByCne(cne);
				I3.setNiveau(Ni);
				I3.setEtudiant(E);
				
				//appel de la methode crud pour ajouter inscription annuelle dans la base de données 
				//selon le niveau et l'id des etudiants
				IN.addInscription(I3);
				
				//recuperation de l'id inscription pour pouvoir la reutiliser dans le stockage au niveau de module et de matiere
				I2=Ins.findAllByEtudiant(E);
				I3=I2.get(I2.size()-1);
				
				
				
				//Inscription Module
				//on récupère les module de niveau spécifique
				
				Mod = Imo.findAllByNiveau(Ni);
				// on parcours la liste des module 
				// on l'ajoute dans inscrption module
				for(Module ml : Mod) {
					
					InscriptionModule ms = new InscriptionModule();
					
					ms.setInscriptionAnnuelle(I3);
					ms.setModule(ml);
					//ajout dansla base de données en effectuant id module et id inscription annuelle
					in.addInscModule(ms);
					
					
					
				}
				
				
				//Inscription matiere 
				// on parcours la liste des module 
				for(Module ml : Mod) {
					//on recupère les elements qui correspondent au module et le niveau concerne
					el=ele.findElementsByModule(ml);
					for(Element  o : el) {
						InscriptionMatiere m = new InscriptionMatiere();
						m.setInscriptionAnnuelle(I3);
						m.setMatiere(o);
					//inscription de la matiere
						IM.addMatiere(m);
					}
				}
	
				//maintenant on trait ou il y'a des etudiant deja dans la base de données
				//on fait le meme processuss
				// sauf on aoute le nouvel niveau 
				// et en se basant sur l'ensemble des inscripiton annuelle et s'il a validé l'nanées dernière
			}else  {
				
				
				E.setCne(cne);
				E.getIdUtilisateur();
				I2=Ins.findAllByEtudiant(E);
				I=I2.get((I2.size())-1);
				if(I.getValidation()=="V") {
				Mod =Imo.findAllByNiveau(Ni); 
				for(Module Ml : Mod ) {
					
					
				InscriptionModule Ms = new InscriptionModule();
					
					Ms.setModule(Ml);
					Ms.setInscriptionAnnuelle(I);
					
					in.addInscModule(Ms);
					
				}
				
				
				// on effectue maintenant une inscription au niveau des de matière
				for(Module ml : Mod) {
					el=ele.findElementsByModule(ml);
					
						
						for(Element o : el) {
							
							InscriptionMatiere m = new InscriptionMatiere();
							
							m.setInscriptionAnnuelle(I);
							m.setMatiere(o);
							
							IM.addMatiere(m);
						
						
					}
	
				
			}
			
	
			
		}
			}

			
}
		return null;	
}

									
}							
								
								
							
							
							

							
						
					
					
					
					

			

			
			
			
			
		
		
		
		
		
		
		
		
	


