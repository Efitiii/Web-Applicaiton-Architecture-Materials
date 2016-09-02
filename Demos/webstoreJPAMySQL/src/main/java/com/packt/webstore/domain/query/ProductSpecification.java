package com.packt.webstore.domain.query;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.h2.util.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.packt.webstore.domain.Product;

public class ProductSpecification implements Specification<Product> {

	  private final Product product;

	  public ProductSpecification(Product product) {
	    this.product = product;
	  }

	
	 @Override
	  public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
	    List<Predicate> predicates = new ArrayList<>();

	    if (!StringUtils.isNullOrEmpty(product.getCategory())) {
	        predicates.add(cb.equal(root.get("category"), product.getCategory()));
	      }
	    else if (!StringUtils.isNullOrEmpty(product.getProductId())) {
	    	// StartsWith
	        predicates.add(cb.like(root.get("productId"), (product.getProductId() + "%")));
	    	// Contains
//	        predicates.add(cb.like(root.get("productId"), ("%" + product.getProductId() + "%")));
	    	// EndsWith
//	        predicates.add(cb.like(root.get("productId"), ("%" + product.getProductId())));
	      }
	    
	    return cb.and(predicates.toArray(new Predicate[0]));

	 }
	 
   
}
