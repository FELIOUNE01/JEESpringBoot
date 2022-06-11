package com.gsnotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsnotes.bo.InscriptionModule;
import com.gsnotes.bo.Utilisateur;

public interface InscriptionModuleDAo extends JpaRepository<InscriptionModule, Long>{

}
