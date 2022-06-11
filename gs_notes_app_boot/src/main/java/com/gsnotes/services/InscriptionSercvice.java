package com.gsnotes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gsnotes.bo.InscriptionAnnuelle;
@Service
public interface InscriptionSercvice {
	
	
	public List<InscriptionAnnuelle> GetAllInscription(int id);
	public InscriptionAnnuelle getInscription(int id);
	public void addInscription(InscriptionAnnuelle L);
	
	
	

}
