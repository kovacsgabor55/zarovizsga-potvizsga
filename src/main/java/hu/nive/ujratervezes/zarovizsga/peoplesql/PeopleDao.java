package hu.nive.ujratervezes.zarovizsga.peoplesql;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;

public class PeopleDao {
    private final MariaDbDataSource dataSource;

    public PeopleDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT `ip_address` FROM `people` WHERE `first_name` =? AND `last_name` =?;")) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            return execute(stmt);
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by select", sqle);
        }
    }

    private String execute(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getString("ip_address");
            }
            throw new IllegalArgumentException("No result");
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by select", sqle);
        }
    }
}
