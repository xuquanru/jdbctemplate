package cn.xqrcloud.jdbc.utils;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: jdbctemplate
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-03 15:18
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class JdbcDaoSupport {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public void setDataSource(DataSource dataSource) {

        if (jdbcTemplate == null) {
            jdbcTemplate=createJdbctemplate(dataSource);
        }
    }

    private JdbcTemplate createJdbctemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
