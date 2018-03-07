package com.mylesoft.crm.dao;

import java.util.List;

import com.mylesoft.crm.pojo.CustomerDO;

public interface CustomerDao {
	public int insert(CustomerDO customer);
	public int[] insertBatch(List<CustomerDO> list);
	public List<CustomerDO> list();
	public CustomerDO get(int id);
	public int update(CustomerDO customer);
}
