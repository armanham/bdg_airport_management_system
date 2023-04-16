package com.bdg.db_repository;

import java.util.Set;

public interface CompanyRepository {

    com.bdg.model.from_db.Company getById(int id);

    Set<com.bdg.model.from_db.Company> getAll();

    com.bdg.model.to_db.Company save(com.bdg.model.to_db.Company company);

    boolean deleteBy(int id);

    int updateBy(int id, com.bdg.model.to_db.Company company);

    Set<com.bdg.model.from_db.Company> get(int offset, int perPage, String sort);
}