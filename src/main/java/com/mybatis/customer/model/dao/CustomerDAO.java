package com.mybatis.customer.model.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.mybatis.customer.model.vo.Customer;
import com.mybatis.customer.model.vo.SearchVO;


public class CustomerDAO {
	 private static Connection conn;
	 
	public int addCustomer(SqlSession session, Customer customer) {
		int result = session.insert("CustomerMapper.insertCustomer", customer);
		return result;
	}

	public Customer selectOneById(SqlSession session, String userId) {
		Customer customer = session.selectOne("CustomerMapper.selectOneById", userId);
		return customer;
	}

	public int updateCustomer(SqlSession session, Customer customer) {
		int result = session.update("CustomerMapper.updateCustomer", customer);
		return result;
	}

	public int deleteCustomer(SqlSession session, String userId) {
		int result = session.delete("CustomerMapper.deleteCustomer", userId);
		return result;
	}

	public int getTotalCount(SqlSession session) {
		 Integer totalCount = session.selectOne("CustomerMapper.getTotalCount");
		return totalCount != null ? totalCount : 0;
	}

	public List<Customer> selectSearchList(SqlSession session, SearchVO search) {
		List<Customer> searchList = session.selectList("CustomerMapper.selectSearchList", search);
		return searchList;
	}
	
	public List<Customer> selectList(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);

		List<Customer> cList = session.selectList("CustomerMapper.selectList", currentPage, rowBounds);
		return cList;
	}

	

	
	  
}