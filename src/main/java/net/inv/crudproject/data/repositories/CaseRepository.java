package net.inv.crudproject.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.inv.crudproject.data.entities.Case;

public interface CaseRepository extends JpaRepository<Case, Long>
{

}
