package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.Etudiant;
import com.gsnotes.bo.Utilisateur;
import com.gsnotes.utils.export.ExcelExporter;

public interface IEtudiantService {
	
	public void addEtudiant(Etudiant etd);

	public void updateEtudiant(Etudiant etd);

	public List<Etudiant> getAllEtudiants();

	public void deleteEtudiant(Long id);

	public Etudiant getEtudiantById(Long id);
	
	public Etudiant getEtudiantByCin(String cin);

	Etudiant getEtudiantByCne(String cne);
	
	

}
