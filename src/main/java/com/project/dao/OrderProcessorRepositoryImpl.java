package com.project.dao;

import java.util.List;
import java.util.Map;

import com.project.model.Customers;
import com.project.model.Products;

public class OrderProcessorRepositoryImpl implements OrderProcessorRepository{

	@Override
	public boolean createProduct(Products product) {
		
		return false;
	}

	@Override
	public boolean createCustomer(Customers customer) {
		
		return false;
	}

	@Override
	public boolean deleteProduct(int productId) {
		
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerId) {

		return false;
	}

	@Override
	public boolean addToCart(Customers customer, Products product, int quantity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeFromCart(Customers customer, Products product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Products> getAllFromCart(Customers customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean placeOrder(Customers customer) {
		// TODO Auto-generated method stub
		return false;
	}
  
	@Override
	public List<Map<Products, Integer>> getOrdersByCustomer(int customerid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
