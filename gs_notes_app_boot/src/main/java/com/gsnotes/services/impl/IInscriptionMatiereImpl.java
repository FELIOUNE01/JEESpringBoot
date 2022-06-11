package com.gsnotes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsnotes.bo.InscriptionMatiere;
import com.gsnotes.dao.InscriptionMatièreDao;
import com.gsnotes.services.InscriptionMatiereService;

@Service
public class IInscriptionMatiereImpl implements InscriptionMatiereService {

	
	
	@Autowired
	private InscriptionMatièreDao In;
	@Override
	public void addMatiere(InscriptionMatiere Niveau) {
		In.save(Niveau);
	}

	@Override
	public void updateInscMat(InscriptionMatiere Niveau) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<InscriptionMatiere> getAllInscMat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInscMat(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InscriptionMatiere getInscMatById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
