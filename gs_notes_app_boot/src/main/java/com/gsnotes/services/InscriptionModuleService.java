package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.InscriptionMatiere;
import com.gsnotes.bo.InscriptionModule;
import com.gsnotes.bo.Niveau;

public interface InscriptionModuleService {
	
	

	public void addInscModule(InscriptionModule mod);

	public void updateInscMat(InscriptionModule Niveau);

	public List<InscriptionModule> getAllInscMat();

	public void deleteInscMat(Long id);

	public InscriptionModule getInscMatById(Long id);
	
	

}
