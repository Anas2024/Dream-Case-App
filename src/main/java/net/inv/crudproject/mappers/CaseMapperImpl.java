package net.inv.crudproject.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import net.inv.crudproject.data.entities.Case;
import net.inv.crudproject.dtos.CaseDTO;

@Service
public class CaseMapperImpl implements CaseMapper
{
	public Case fromCaseDTO(CaseDTO caseDTO)
	 {
	        Case caseUpdate = new Case();
	        BeanUtils.copyProperties(caseDTO, caseUpdate);
	        return caseUpdate;
	 }

}
 