package com.bdg.db_repository;

import com.bdg.model.from_db.Company;

import java.util.Optional;
import java.util.Set;

public interface CompanyRepository {

    Optional<Company> getById(int id);

    Optional<Set<Company>> getAll();
}