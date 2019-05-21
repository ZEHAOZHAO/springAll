package com.zhzh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Author: jason.zhao
 * @date:2019/4/15 15:01
 * @Description:
 */
@Repository
public class UserDaoImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void saveLog(UserModel userModel){
        StringBuffer sql = new StringBuffer("insert into t_user ");
        sql.append("(user_name,user_pwd) ");
        sql.append(":user_name,:user_pwd");
        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        npjt.update(sql.toString(), new BeanPropertySqlParameterSource(userModel));
    }
}
