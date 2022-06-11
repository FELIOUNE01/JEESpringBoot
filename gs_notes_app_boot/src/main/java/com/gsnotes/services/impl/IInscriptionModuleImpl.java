package com.gsnotes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsnotes.bo.InscriptionMatiere;
import com.gsnotes.bo.InscriptionModule;
import com.gsnotes.dao.ImoduleDao;
import com.gsnotes.dao.InscriptionMatièreDao;
import com.gsnotes.dao.InscriptionModuleDAo;
import com.gsnotes.services.InscriptionMatiereService;
import com.gsnotes.services.InscriptionModuleService;
@Service
public class IInscriptionModuleImpl implements InscriptionModuleService {
	
	@Autowired
	InscriptionModuleDAo M;

	@Override
	public void addInscModule(InscriptionModule mod) {
             		M.save(mod);
	}

	@Override
	public void updateInscMat(InscriptionModule Niveau) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<InscriptionModule> getAllInscMat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInscMat(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InscriptionModule getInscMatById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
