package com.gsnotes.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.dao.IInscriptionDao;
import com.gsnotes.services.InscriptionSercvice;
@Service

public class InscriptionServiceImpl implements InscriptionSercvice{

	
	@Autowired
	IInscriptionDao In;
	@Override
	public List<InscriptionAnnuelle> GetAllInscription(int id) {
				
		return In.findAll();
		
				
	
	}

	public List<InscriptionAnnuelle> addInscription(List<InscriptionAnnuelle> L) {
          
		return In.saveAll(L);
	}

	@Override
	public void addInscription(InscriptionAnnuelle L) {
		In.save(L);
		
	}

	@Override
	public InscriptionAnnuelle getInscription(int id) {
		// TODO Auto-generated method stub
		return In.getById((long)id);
	}
	
	
	
	
	
	

}
