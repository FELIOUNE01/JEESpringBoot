package com.gsnotes.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gsnotes.bo.Etudiant;
import com.gsnotes.bo.Module;

public interface IModuleService {
	
	
	public void addModule(Module Module);
	

	public void updateModule(Module Module);

	public List<Module> getAllModule();

	public void deleteModule(Long id);

	public Module getModuleById(Long id);
	

}
