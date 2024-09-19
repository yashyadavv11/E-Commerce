package com.project.dao;

import java.util.List;
import java.util.Map;

import com.project.model.Customers;
import com.project.model.Products;

interface OrderProcessorRepository {
	public boolean createProduct(Products product);
	public boolean createCustomer(Customers customer);
	public boolean deleteProduct(int productId);
	public boolean deleteCustomer(int customerId);
	public boolean addToCart(Customers customer, Products product, int quantity);
	public boolean removeFromCart(Customers customer, Products product);
	public List<Products> getAllFromCart(Customers customer); //return list of product
	public boolean placeOrder(Customers customer, List<Map<Products,int>>, String shippingAddress);
	public List<Map<Products, Integer>> getOrdersByCustomer(int customerid);
}
	