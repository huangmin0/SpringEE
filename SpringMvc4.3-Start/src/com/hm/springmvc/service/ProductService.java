package com.hm.springmvc.service;

import com.hm.springmvc.domain.Product;

public interface ProductService
{
Product add(Product product);
Product get(long id);
}
