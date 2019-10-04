package com.spring.demo.repository.jdbc;

import com.spring.demo.model.TeacherModel;
import com.spring.demo.repository.TeacherRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Access Teacher using JDBC
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
@Repository()
@ConditionalOnProperty(name = "demo.repository", havingValue = "jdbc")
public class JdbcTeacherRepository implements TeacherRepository {

    private static final String FIND_ALL_QUERY = "SELECT * FROM teacher;";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM teacher WHERE id = ?;";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TeacherModel> findAll() {
        return jdbcTemplate.query(FIND_ALL_QUERY, new TeacherRowMapper());
    }

    @Override
    public TeacherModel findById(int id) {
        try {
            return jdbcTemplate.queryForObject(FIND_BY_ID_QUERY, new TeacherRowMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void save(TeacherModel teacher) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
