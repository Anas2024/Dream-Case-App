package net.inv.crudproject.controller;


import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.inv.crudproject.common.Paths;
import net.inv.crudproject.data.entities.Case;
import net.inv.crudproject.dtos.CaseDTO;
import net.inv.crudproject.exceptions.CaseNotFoundException;
import net.inv.crudproject.mappers.CaseMapper;
import net.inv.crudproject.service.CaseService;


@RestController
@RequestMapping(Paths.path)
public class CaseController 
{
	private CaseService caseService;
	private CaseMapper caseMapper;
	
	
	
	public CaseController(CaseService caseService, CaseMapper caseMapper) {
		this.caseService = caseService;
		this.caseMapper = caseMapper;
	}
	@GetMapping("{id}")
	Case getCaseById(@PathVariable long id) throws CaseNotFoundException
	{
		return caseService.getCaseById(id);
	}
	@GetMapping
	List<Case> getAllCases()
	{
		return caseService.getAllCases();
	}
	@PostMapping
	Case saveCase(@RequestBody CaseDTO caseDTO)
	{
		Case newCase = caseMapper.fromCaseDTO(caseDTO);
		//lors de la création du Case la date de création est équivaut à la date de dernière modification
		newCase.setCreationDate(new Date());
		newCase.setLastUpdateDate(new Date());
		return caseService.saveCase(newCase);
	}
	@PutMapping("{id}")
	Case updateCase(@PathVariable long id, @RequestBody CaseDTO caseUpdateData ) throws CaseNotFoundException
	{
		return caseService.updateCase(id, caseUpdateData.getTitle(), caseUpdateData.getDescription());
	}
	@DeleteMapping("{id}")
	void deleteCase(@PathVariable long id)  throws CaseNotFoundException
	{
		caseService.deleteCase(id);
	}

}

