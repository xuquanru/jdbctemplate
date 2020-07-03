package cn.xqrcloud.jdbc.day01;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌道阻且长，行则将至🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 * 🍁 Program: jdbctemplate
 * 🍁 Description
 * 🍁 Author: Stephen
 * 🍁 Create: 2020-07-03 20:22
 * 🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌行而不辍，未来可期🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌🐌
 **/
public class TestJdbc {
    @Test
    public  void test1(){
        InputStream resourceAsStream = TestJdbc.class.getClassLoader().
                getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            //加载配置
            properties.load(resourceAsStream);
            //获取连接池
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            //获取连接
            Connection connection = dataSource.getConnection();
            String sql="select * from account where id>?";

            //获取执行SQL对象
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Object id = resultSet.getObject(1);
                Object name = resultSet.getObject(2);
                Object money = resultSet.getObject(3);
                System.err.println(id+","+name+","+money);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
