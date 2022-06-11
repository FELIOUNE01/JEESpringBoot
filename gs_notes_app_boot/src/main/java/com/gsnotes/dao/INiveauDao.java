package com.gsnotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsnotes.bo.Niveau;
import com.gsnotes.bo.Utilisateur;


//ce sont des repository permmettand de se communiquer avec la  
//base de doonee contenant les fonctions CRUD de lapplication

public interface INiveauDao extends JpaRepository<Niveau, Long>{

}
