package com.ucsr;

import com.yourapp.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.EmptyResultDataAccessException;

public class StudentDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Student validateLogin(String email, String password) {
        String sql = "SELECT * FROM students WHERE email = ? AND password = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{email, password}, (rs, rowNum) -> {
                Student s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setPassword(rs.getString("password"));
                return s;
            });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
