package com.bdg.db_repository;

import java.util.Optional;
import java.util.Set;

public interface CompanyRepository {

    Optional<com.bdg.model.from_db.Company> getById(int id);

    Optional<Set<com.bdg.model.from_db.Company>> getAll();

    com.bdg.model.to_db.Company save(com.bdg.model.to_db.Company company);
}