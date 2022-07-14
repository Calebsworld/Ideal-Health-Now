package com.aca.IdealHealthNow.Controller;


import java.util.List;

import com.aca.IdealHealthNow.model.Product;
import com.aca.IdealHealthNow.service.IdealHealthNowService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@Path("/home")
@Produces(MediaType.APPLICATION_JSON)
public class IdealHealthNowController {

	private IdealHealthNowService service = new IdealHealthNowService();
	
		
	    @Path("/products")
	    @GET
	    public List<Product> getAllProducts() {
	    	return service.getAllProducts();
	    }
		
	    @Path("/products/id/{productIdValue}")
	    @GET
	    @Consumes(MediaType.APPLICATION_JSON)
	    public List<Product> getProductById(@PathParam ("productIdValue") Integer id) {
			return service.getProductById(id);
		}
	    
	    @Path("/products/productName")
	    @GET
	    @Consumes(MediaType.APPLICATION_JSON)
		public List<Product> getProductByName(@QueryParam ("productNameValue") String name) {
			return service.getProductByName(name);
		}

	    @Path ("/products/productType/{productTypeValue}")
	    @GET
	    @Consumes(MediaType.APPLICATION_JSON)
	    public List<Product> getProductsByProductType(@PathParam("productTypeValue") String productType) {
	    	return service.getProductsByProductType(productType);
	    }
	    
	    
		@Path("/products")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Product addProduct(Product product) {
			return service.addProduct(product);
		}
		
		@Path("/products")
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public Product updateProduct(Product product) {
			return service.updateProduct(product);
		}
		
		
		
		@Path("/products/id/{productIdValue}")
		@DELETE
		@Consumes(MediaType.APPLICATION_JSON)
		public Product removeProductById(@PathParam ("productIdValue") Integer id) {
			return service.removeProductById(id);
		}
	
	
	    
	    
	    
	    
	    
	    
	    
}
