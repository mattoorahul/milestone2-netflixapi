package com.myproject.springboot.employeecrudrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.springboot.employeecrudrestapi.dao.NetflixDAO;
import com.myproject.springboot.employeecrudrestapi.entity.Data;

@Service
public class NetFlixServiceImpl implements NetflixService {

	private NetflixDAO employeeDAO;

	@Autowired
	public NetFlixServiceImpl(NetflixDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}

	@Override
	@Transactional
	public List<Data> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public List<Data> find(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Data> findBymovieType(String movieType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Data> findBycountry(String country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Data> findByDate(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
