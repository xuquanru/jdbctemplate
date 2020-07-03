package cn.xqrcloud.jdbc.template;

import cn.xqrcloud.jdbc.entity.Account;
import cn.xqrcloud.jdbc.entity.rowmapper.AccountRowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: jdbctemplate
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-02 22:27
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class MyJdbcTemplate {
    public static void main(String[] args) {
        //准备数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/jdbctemplate");
        ds.setUsername("root");
        ds.setPassword("123456");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(ds);

        //jdbcTemplate.execute("insert  into account (id, name, money) values (3,'ccc',3000)");
       // jdbcTemplate.update("insert  into account (id, name, money) values (2,'bbb',2000),(4,'ddd',4000)");
       // jdbcTemplate.update("delete  from account where  id=1");
      //  List<Account> list = jdbcTemplate.query(" select * from account where money > ?", new AccountRowMapper(),0);
       //spring 自己的封装
        //List<Account> list2 = jdbcTemplate.query(" select * from account where money > ?",new BeanPropertyRowMapper<Account>(Account.class),0);
        System.err.println();

        //查询一行
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account  ", Long.class);

    }

}
