package com.gsnotes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsnotes.bo.Etudiant;
import com.gsnotes.dao.IEtudiantDao;
import com.gsnotes.services.IEtudiantService;


// ce sont des classes services permettant d'implemnter les differentes fonctions de 
//JPA repository

@Service
public class EtudiantServiceImpl implements IEtudiantService{

	
	@Autowired
	IEtudiantDao ETD;
	@Override
	public void addEtudiant(Etudiant etd) {
		ETD.save(etd);
	}

	@Override
	public void updateEtudiant(Etudiant etd) {
				ETD.save(etd);		
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		// TODO Auto-generated method stub
		return ETD.findAll();
	}

	@Override
	public void deleteEtudiant(Long id) {
		// TODO Auto-generated method stub
		ETD.deleteById(id);
	}

	@Override
	public Etudiant getEtudiantById(Long id) {
		// TODO Auto-generated method stub
		return ETD.getById(id);
	}

	@Override
	public Etudiant getEtudiantByCin(String cne) {
		// TODO Auto-generated method stub
		return ETD.getEtudiantByCne(cne	);
	}

	@Override
	public Etudiant getEtudiantByCne(String cne) {
		// TODO Auto-generated method stub
		return  ETD.getEtudiantByCne(cne	);
	}
}
	
