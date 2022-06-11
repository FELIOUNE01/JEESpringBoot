package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.InscriptionMatiere;
import com.gsnotes.bo.Niveau;

public interface InscriptionMatiereService {
	
	
	public void addMatiere(InscriptionMatiere Niveau);

	public void updateInscMat(InscriptionMatiere Niveau);

	public List<InscriptionMatiere> getAllInscMat();

	public void deleteInscMat(Long id);

	public InscriptionMatiere getInscMatById(Long id);
	
	

}
