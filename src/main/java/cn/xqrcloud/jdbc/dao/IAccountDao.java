package cn.xqrcloud.jdbc.dao;

import cn.xqrcloud.jdbc.entity.Account;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: jdbctemplate
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-02 22:42
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public interface IAccountDao {
    //根据ID查找账户
    Account findAccountById(Integer accountId);
    //根据名称查询账户
    Account findAccountById(String accountName);
    //跟新账户
    void updateAccount(Account account);
}
