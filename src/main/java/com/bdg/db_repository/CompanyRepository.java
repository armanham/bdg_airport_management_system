package com.bdg.db_repository;

import com.bdg.model.Company;

import java.util.Set;

public interface CompanyRepository {

    Company getById(int id);

    Set<Company> getAll();

    Company save(Company company);

    boolean deleteBy(int id);

    int updateBy(int id, Company company);

    Set<Company> get(int offset, int perPage, String sort);
}