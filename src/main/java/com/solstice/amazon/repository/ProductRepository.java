package com.solstice.amazon.repository;

import com.solstice.amazon.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository  extends CrudRepository<Product, Long> {

}
