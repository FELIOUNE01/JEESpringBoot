package com.gsnotes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsnotes.bo.Module;
import com.gsnotes.bo.Niveau;
import com.gsnotes.dao.ImoduleDao;
import com.gsnotes.services.IModuleService;
@Service

public class IModuleImpl implements IModuleService{
	
	@Autowired
	ImoduleDao I ;
	

	@Override
	public void addModule(Module Module) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateModule(Module Module) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Module> getAllModule() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteModule(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Module getModuleById(Long id) {
		// TODO Auto-generated method stub
		return null;
	} 

	

}
