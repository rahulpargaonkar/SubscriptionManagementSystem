package entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductPrice {
	private WeekDays weekdays;
	private double price;

}
