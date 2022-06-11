package com.gsnotes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsnotes.bo.Niveau;
import com.gsnotes.dao.INiveauDao;
import com.gsnotes.services.INiveauService;
@Service
public  class INiveauImpl implements INiveauService  {

	@Autowired
	INiveauDao N;
	@Override
	public void addNiveau(Niveau Niveau) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNiveau(Niveau Niveau) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Niveau> getAllNiveau() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteNiveau(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Niveau getNIveauById(int id) {
		// TODO Auto-generated method stub
		return N.getById((long) id);
	}

}
