package com.gsnotes.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gsnotes.bo.Module;
import com.gsnotes.bo.Niveau;

public interface ImoduleDao extends JpaRepository<Module, Long> {
	
    //@Query("From module where idNiveau=:n")
	//public List<Module> findModuleByNiveau(@Param("n")long idniveau);
	

	public List<Module> findAllByNiveau(Niveau niveau);

}
