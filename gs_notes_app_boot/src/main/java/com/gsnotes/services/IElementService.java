package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.Element;

public interface IElementService {
	
	
	public void addElement(Element etd);

	public void updateElement(Element etd);

	public List<Element> getAllElements();

	public void deleteElement(Long id);

	public Element getElementById(Long id);
	

	

}
