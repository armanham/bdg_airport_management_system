package com.bdg.db_service;

import com.bdg.db_repository.CompanyRepository;
import com.bdg.model.from_db.Company;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class CompanyService implements CompanyRepository {

    private Connection connection;


    public Optional<Company> getById(int id) {
        checkId(id);

        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = connection.prepareStatement("select * from company where id = ?");
            pst.setInt(1, id);

            rs = pst.executeQuery();

            Company result = new Company();
            while (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
                result.setFoundDate(rs.getDate("found_date"));
            }

            return Optional.of(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert rs != null;
                rs.close();
                pst.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public Optional<Set<Company>> getAll() {
        Statement st = null;
        ResultSet rs = null;

        try {
            st = connection.createStatement();
            rs = st.executeQuery("select * from company");

            Set<Company> result = new LinkedHashSet<>();

            while (rs.next()) {
                Company tempComp = new Company();
                tempComp.setId(rs.getInt("id"));
                tempComp.setName(rs.getString("name"));
                tempComp.setFoundDate(rs.getDate("found_date"));

                result.add(tempComp);
            }

            return Optional.of(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert rs != null;
                rs.close();
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setConnection(Connection connection) {
        checkNullConnection(connection);
        this.connection = connection;
    }

    private void checkNullConnection(Connection con) {
        if (con == null) {
            throw new NullPointerException("Passed null value as 'con': ");
        }
    }

    private void checkId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("'Id' must be positive number: ");
        }
    }
}