package com.aca.IdealHealthNow.model;


public enum ProductType {
	FOOD, SUPPLEMENT;
	
	public static ProductType convertStringToProductType (String value) {
		ProductType myProductType = null;
		for (ProductType productType : ProductType.values()) {
			if (productType.toString().equalsIgnoreCase(value)) {
				myProductType = productType;
				break;
			}
		}
		return myProductType;
	}
	
	
	
}
