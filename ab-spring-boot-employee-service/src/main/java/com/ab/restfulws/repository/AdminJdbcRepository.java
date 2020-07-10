package com.ab.restfulws.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ab.restfulws.model.Admin;

@Repository
public class AdminJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Admin> findAllAdmin() {
		/* if bean variables match with columns */
		return jdbcTemplate.query("select * from admin", new BeanPropertyRowMapper<Admin>(Admin.class));

	}

	public Admin findAdminById(int id) {

		return jdbcTemplate.queryForObject("select * from admin where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Admin>(Admin.class));

	}

	public int deleteAdminById(int id) {

		return jdbcTemplate.update("delete  from admin where id=?", new Object[] { id });

	}

	public int saveAdmin(Admin admin) {
		return jdbcTemplate.update("insert into admin (id, name) " + "values(?,  ?)",
				new Object[] { admin.getId(), admin.getName() });
	}

	public int updateAdmin(Admin admin) {
		return jdbcTemplate.update("update admin " + " set name = ?" + " where id = ?",
				new Object[] { admin.getName(), admin.getId() });
	}

}
