package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.Etudiant;
import com.gsnotes.bo.Niveau;
import com.gsnotes.bo.Utilisateur;
import com.gsnotes.utils.export.ExcelExporter;

public interface INiveauService {
	
	public void addNiveau(Niveau Niveau);

	public void updateNiveau(Niveau Niveau);

	public List<Niveau> getAllNiveau();

	public void deleteNiveau(int id);

	public Niveau getNIveauById(int nu);
}
