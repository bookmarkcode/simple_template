package com.mylesoft.crm.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mylesoft.crm.dao.CustomerDao;
import com.mylesoft.crm.mapper.CustomerMapper;
import com.mylesoft.crm.pojo.CustomerDO;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public int insert(CustomerDO customer) {
		return customerMapper.insert(customer);
	}

	@Override
	public int[] insertBatch(List<CustomerDO> list) {
		return customerMapper.insertBatch(list);
	}

	@Override
	public List<CustomerDO> list() {
		return customerMapper.list();
	}

	@Override
	public CustomerDO get(int id) {
		return customerMapper.get(id);
	}

	@Override
	public int update(CustomerDO customer) {
		return customerMapper.update(customer);
	}

	
}
