package com.spring.demo.repository;

import com.spring.demo.model.TeacherModel;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test the repository
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void shouldFindTeacherById() {
        TeacherModel result = teacherRepository.findById(1);

        assertNotNull(result);

        int expectedId = 1;
        int resultId = result.getId();
        assertEquals(expectedId, resultId);

        String expectedFirstName = "Alain";
        String resultFirstName = result.getFirstName();
        assertEquals(expectedFirstName, resultFirstName);

        String expectedLastName = "Husson";
        String resultLastName = result.getLastName();
        assertEquals(expectedLastName, resultLastName);

        String expectedSubject = "Anglais";
        String resultSubject = result.getSubject();
        assertEquals(expectedSubject, resultSubject);
    }

    @Test
    public void shouldNotFindUnexistingTeacherAndReturnsNull() {
        TeacherModel result = teacherRepository.findById(-1);

        assertNull(result);
    }

    @Test
    public void shouldFindAllTeachers() {
        List<TeacherModel> result = teacherRepository.findAll();

        assertNotNull(result);

        int expectedSize = 5;
        int resultSize = result.size();

        assertEquals(expectedSize, resultSize);
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:clear.sql")
    public void shouldReturnEmptyCollection() {
        List<TeacherModel> result = teacherRepository.findAll();

        assertNotNull(result);

        int expectedSize = 0;
        int resultSize = result.size();

        assertEquals(expectedSize, resultSize);
    }
}
