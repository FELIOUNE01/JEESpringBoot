package com.gsnotes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsnotes.bo.Etudiant;
import com.gsnotes.bo.InscriptionAnnuelle;
import com.gsnotes.bo.Module;
import com.gsnotes.bo.Niveau;
import com.gsnotes.bo.Role;

public interface IInscriptionDao extends JpaRepository<InscriptionAnnuelle, Long>{

	
	public List<InscriptionAnnuelle> findAllByEtudiant(Etudiant Etudiant);
	

}
