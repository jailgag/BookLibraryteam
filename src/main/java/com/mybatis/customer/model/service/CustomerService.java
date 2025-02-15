package com.mybatis.customer.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.common.SqlSessionTemplate;
import com.mybatis.customer.model.dao.CustomerDAO;
import com.mybatis.customer.model.vo.Customer;
import com.mybatis.customer.model.vo.SearchVO;

public class CustomerService {
	private CustomerDAO cDao;
	private SqlSession session;
	
	public CustomerService() {
		cDao = new CustomerDAO();
		session = SqlSessionTemplate.getSqlSession();
	}

	public int addCustomer(Customer Customer) {
		int result = cDao.addCustomer(session, Customer);
		return result;
	}

	public Customer selectOneById(String userId) {
		Customer Customer = cDao.selectOneById(session, userId);
		return Customer;
	}

	public int updateCustomer(Customer Customer) {
		int result = cDao.updateCustomer(session, Customer);
		return result;
	}

	public int deleteCustomer(String userId) {
		int result = cDao.deleteCustomer(session, userId);
		return result;
	}

	public int getTotalCount() {
		int totalCount = cDao.getTotalCount(session);
		return totalCount;
	}

	public List<Customer> selectSearchList(SearchVO search) {
		List<Customer> searchList = cDao.selectSearchList(session, search);
		return searchList;
	}

	
	public List<Customer> selectList(int currentPage) {
		List<Customer> selectList = cDao.selectList(session, currentPage);
		return selectList;
		
	}
	
	

}
