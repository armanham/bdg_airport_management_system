package com.bdg.db_service;

import com.bdg.db_repository.CompanyRepository;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class CompanyService implements CompanyRepository {

    private Connection connection;


    public com.bdg.model.from_db.Company getById(int id) {
        checkId(id);

        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = connection.prepareStatement("select * from company where id = ?");
            pst.setInt(1, id);

            rs = pst.executeQuery();

            com.bdg.model.from_db.Company result = null;
            while (rs.next()) {
                result = new com.bdg.model.from_db.Company();
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
                result.setFoundDate(rs.getDate("found_date"));
            }

            return result;
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


    public Set<com.bdg.model.from_db.Company> getAll() {
        Statement st = null;
        ResultSet rs = null;

        try {
            st = connection.createStatement();
            rs = st.executeQuery("select * from company");

            Set<com.bdg.model.from_db.Company> result = new LinkedHashSet<>();

            while (rs.next()) {
                com.bdg.model.from_db.Company tempComp = new com.bdg.model.from_db.Company();
                tempComp.setId(rs.getInt("id"));
                tempComp.setName(rs.getString("name"));
                tempComp.setFoundDate(rs.getDate("found_date"));

                result.add(tempComp);
            }

            return result.isEmpty() ? null : result;
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


    @Override
    public com.bdg.model.to_db.Company save(com.bdg.model.to_db.Company company) {
        if (company == null) {
            throw new NullPointerException("Passed null value: ");
        }

        PreparedStatement pst = null;

        try {
            pst = connection.prepareStatement("insert into company(name, found_date) values(?, ?)");
            pst.setString(1, company.getName());
            pst.setDate(2, company.getFoundDate());

            pst.executeUpdate();

            return company;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert pst != null;
                pst.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public boolean deleteBy(int id) {
        checkId(id);

        PreparedStatement pst = null;

        if (getById(id) == null) {
            System.out.println("Company with " + id + " id does not exists:");
            return false;
        }

        try {
            pst = connection.prepareStatement("select count(*) from trip where company_id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            int count = rs.getInt("count");

            if (count > 0) {
                System.out.println("First remove the row from the 'trip' table where 'company_id' is " + id + ": ");
                return false;
            }

            pst = connection.prepareStatement("delete from company where id = ?");
            pst.setInt(1, id);
            pst.executeUpdate();

            System.out.println("Company with " + id + " id deleted successfully:");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert pst != null;
                pst.close();
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