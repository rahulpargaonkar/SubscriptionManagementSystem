package entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Subscription {
	private Product product;
	private frequency frequency;
	private LocalDate startDate;
	private double amount;

	public void setSubscriptionAmount() {
		if (this.getFrequency().toString().equalsIgnoreCase(entity.frequency.Monthly.toString())) {
			Map<String, Double> priceMap = new HashMap<String, Double>();
			LocalDate endDate = startDate.plusMonths(1);
			System.out.println(endDate.toString());
			product.getPrices().stream().forEach(price -> {
				priceMap.put(price.getWeekdays().toString(), price.getPrice());
			});
			System.out.println(priceMap);
			Stream.iterate(startDate, date ->  date.plusDays(1)).limit(ChronoUnit.DAYS.between(startDate, endDate))
					.forEach(date -> {
						System.out.println(date+ " == "+date.getDayOfWeek().name().toLowerCase()+" == " +priceMap.get(date.getDayOfWeek().name().toLowerCase()));
						amount = amount + priceMap.get(date.getDayOfWeek().name().toLowerCase());
					});

			System.out.println(amount);
		}

	}

	public double getSubscriptionAmount() {
		return amount;
	}

}
