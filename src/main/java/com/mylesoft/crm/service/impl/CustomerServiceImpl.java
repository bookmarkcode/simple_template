package com.mylesoft.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mylesoft.crm.dao.CustomerDao;
import com.mylesoft.crm.pojo.CustomerDO;
import com.mylesoft.crm.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<CustomerDO> list() {
		return customerDao.list();
	}

}
