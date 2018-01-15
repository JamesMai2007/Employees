package com.jm.employees.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jm.employees.entity.Employees;
import com.jm.employees.service.EmployeesService;
import com.jm.utils.PageUtils;
import com.jm.utils.Query;
import com.jm.utils.R;


/**
 * 
 * 
 * @author James.Mai
 * @email mjl_workhard@163.com
 * @date 2018-01-15 12:12:29
 */
@RestController
@RequestMapping("employees")
public class EmployeesController {
	@Autowired
	private EmployeesService employeesService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Employees> employeesList = employeesService.queryList(query);
		int total = employeesService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(employeesList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{empNo}")
	public R info(@PathVariable("empNo") Integer empNo){
		Employees employees = employeesService.queryObjectById(empNo);
		
		return R.ok().put("employees", employees);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody Employees employees){
		employeesService.save(employees);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody Employees employees){
		employeesService.update(employees);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] empNos){
		employeesService.deleteBatch(empNos);
		
		return R.ok();
	}
	
}
