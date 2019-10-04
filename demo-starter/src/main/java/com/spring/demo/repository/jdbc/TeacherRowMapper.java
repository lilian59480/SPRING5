package com.spring.demo.repository.jdbc;

import com.spring.demo.model.TeacherModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * JDBC Row Mapper
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
public class TeacherRowMapper implements RowMapper<TeacherModel> {

    @Override
    public TeacherModel mapRow(ResultSet rs, int i) throws SQLException {
        TeacherModel tm = new TeacherModel();

        tm.setId(rs.getInt("id"));
        tm.setFirstName(rs.getString("first_name"));
        tm.setLastName(rs.getString("last_name"));
        tm.setSubject(rs.getString("subject"));

        return tm;
    }

}
