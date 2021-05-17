package entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductPrice {
	private weekDays weekdays;
	private double price;

}
