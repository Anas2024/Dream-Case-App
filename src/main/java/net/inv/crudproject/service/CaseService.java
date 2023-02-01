package net.inv.crudproject.service;


import java.util.List;

import net.inv.crudproject.data.entities.Case;
import net.inv.crudproject.exceptions.CaseNotFoundException;

public interface CaseService 
{
	Case getCaseById(long id) throws CaseNotFoundException;
	List<Case> getAllCases();
	Case saveCase(Case newCase);
	Case updateCase(long id, String title, String description) throws CaseNotFoundException;
	void deleteCase(long id) throws CaseNotFoundException;
	

}
