package com.jm.employees.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.jm.employees.dao.EmployeesDao;
import com.jm.employees.entity.Employees;



@Service("employeesService")
public class EmployeesService {
	@Autowired
	private EmployeesDao employeesDao;
	
	public Employees queryObjectById(Integer empNo){
		return employeesDao.queryObjectById(empNo);
	}
	
	public List<Employees> queryList(Map<String, Object> map){
		return employeesDao.queryList(map);
	}
	
	public int queryTotal(Map<String, Object> map){
		return employeesDao.queryTotal(map);
	}
	
	public void save(Employees employees){
		employeesDao.save(employees);
	}
	
	public void update(Employees employees){
		employeesDao.update(employees);
	}
	
	public void delete(Integer empNo){
		employeesDao.delete(empNo);
	}
	
	public void deleteBatch(Integer[] empNos){
		employeesDao.deleteBatch(empNos);
	}
	
}
