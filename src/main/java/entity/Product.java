package entity;

import java.util.List;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class Product {
	private String name;
	private String category;
	private String subcategory;
	private List<ProductPrice> prices;

}
