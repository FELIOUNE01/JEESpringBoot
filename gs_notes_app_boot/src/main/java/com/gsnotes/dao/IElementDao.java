package com.gsnotes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gsnotes.bo.Compte;
import com.gsnotes.bo.Element;
import com.gsnotes.bo.Module;

public interface IElementDao extends JpaRepository<Element, Long> {

	
	public List<Element> findElementsByModule(Module Module);
	
	
}
