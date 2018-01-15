package com.jm.employees.dao;

import org.apache.ibatis.annotations.Mapper;

import com.jm.employees.entity.Employees;

/**
 * 
 * 
 * @author James.Mai
 * @email mjl_workhard@163.com
 * @date 2018-01-15 12:12:29
 */
@Mapper
public interface EmployeesDao extends BaseDao<Employees> {
	
}
