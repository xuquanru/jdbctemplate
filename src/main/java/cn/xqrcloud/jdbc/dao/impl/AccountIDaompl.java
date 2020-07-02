package cn.xqrcloud.jdbc.dao.impl;

import cn.xqrcloud.jdbc.dao.IAccountDao;
import cn.xqrcloud.jdbc.entity.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BeanPropertyBindingResult;

import java.sql.JDBCType;
import java.util.List;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: jdbctemplate
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-02 22:44
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class AccountIDaompl implements IAccountDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> query = jdbcTemplate.query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return query.isEmpty() ? null : query.get(0);
    }

    @Override
    public Account findAccountById(String accountName) {
        List<Account> query = jdbcTemplate.query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if (accountName.isEmpty()) {
            return null;
        }
        if (query.size() > 0) {
            throw new RuntimeException("结果集不唯一");
        }
        return query.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update  account set name=?,money=? where id=?",
                account.getName(), account.getMoney(), account.getId());
    }
}
