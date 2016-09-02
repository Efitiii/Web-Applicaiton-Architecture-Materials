package app04a.repositoryimpl;

import app04a.repository.ProductRepository;

 public class ProductRepositoryFactory   {
	  // Factory Allows for multiple choices at config dev .vs. prod ....
 	public static final ProductRepository getProductRepository() {
 		// if dev then
		return ProductRepositoryImpl.INSTANCE;
		// could have else for Prod..prod2, etc.
	}
}
 
