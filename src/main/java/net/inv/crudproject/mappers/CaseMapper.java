package net.inv.crudproject.mappers;

import net.inv.crudproject.data.entities.Case;
import net.inv.crudproject.dtos.CaseDTO;

public interface CaseMapper 
{
	Case fromCaseDTO(CaseDTO caseDTO);
}
