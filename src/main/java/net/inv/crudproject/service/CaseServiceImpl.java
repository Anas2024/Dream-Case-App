package net.inv.crudproject.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.inv.crudproject.data.entities.Case;
import net.inv.crudproject.data.repositories.CaseRepository;
import net.inv.crudproject.exceptions.CaseNotFoundException;

@Service
@Slf4j
public class CaseServiceImpl implements CaseService 
{
	CaseRepository caseRepository;
	
	
	public CaseServiceImpl(CaseRepository caseRepository) {
		this.caseRepository = caseRepository;
	}

	@Override
	public Case getCaseById(long id) throws CaseNotFoundException 
	{
		return caseRepository.findById(id).orElseThrow(()->new CaseNotFoundException("Case with "+id+"not found"));
		
	}

	@Override
	public List<Case> getAllCases() {
		
		return caseRepository.findAll();
	}

	@Override
	public Case saveCase(Case newCase) {
		log.info("new Case added");
	    return caseRepository.save(newCase);
	}

	@Override
	public Case updateCase(long id, String title, String description) throws CaseNotFoundException {
		//on vérifie d'abord si l'id existe dans la base de données sinon on lève une exception de type CaseNotFoundException
		Case newCase = caseRepository.findById(id).orElseThrow(()->new CaseNotFoundException("Case with "+id+"not found"));
		if (title !=null)
		{
			newCase.setTitle(title);
		}
		if (description !=null)
		{
			newCase.setDescription(description);
		}
		newCase.setLastUpdateDate(new Date());
		log.info("new Case updated");
		return caseRepository.save(newCase);
	}

	@Override
	public void deleteCase(long id) throws CaseNotFoundException {
		//on vérifie d'abord si l'id existe dans la base de données sinon on lève une exception de type CaseNotFoundException
		caseRepository.findById(id).orElseThrow(()->new CaseNotFoundException("Case with id= "+id+" not found"));
		caseRepository.deleteById(id);
		log.info("Case deleted");
		
	}

}
