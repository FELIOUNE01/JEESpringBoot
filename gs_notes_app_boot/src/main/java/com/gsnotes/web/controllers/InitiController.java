package com.gsnotes.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsnotes.bo.Etudiant;
import com.gsnotes.bo.Utilisateur;
import com.gsnotes.dao.IUtilisateurDao;
import com.gsnotes.services.IPersonService;
import com.gsnotes.utils.export.UserExcelImporter;
import com.gsnotes.web.models.PersonModel;
import com.gsnotes.web.models.StudentExcel;


//Ce controleur affiche la page index 
@Controller
public class InitiController {
	
	IUtilisateurDao Etd;
	
	
	@RequestMapping("/")
	public String index(Model model) {

		return "index";
	}
	
	
	

	
	
}
