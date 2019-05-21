package com.zhzh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;

/**
 * @Author: jason.zhao
 * @date:2019/4/12 15:43
 * @Description:
 */
@Repository("customerDao")
public class CustomerDaoImpl {


        @Autowired
        private JdbcTemplate jdbcTemplate;

        public int add(Customer student) {
            // String sql = "insert into student(sno,sname,ssex) values(?,?,?)";
            // Object[] args = { student.getSno(), student.getName(), student.getSex() };
            // int[] argTypes = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
            // return this.jdbcTemplate.update(sql, args, argTypes);
            String sql = "insert into customer(name,lon,lat) values(:name,:lon,:lat)";
            NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
            return npjt.update(sql, new BeanPropertySqlParameterSource(student));
        }

    public int update(Customer customer) {
        String sql = "update customer set name = ?,lon = ? where id = ?";
        Object[] args = { customer.getName(), customer.getLon(), customer.getId() };
        int[] argTypes = { Types.VARCHAR, Types.VARCHAR, Types.INTEGER };
        return this.jdbcTemplate.update(sql, args, argTypes);
    }

    }

