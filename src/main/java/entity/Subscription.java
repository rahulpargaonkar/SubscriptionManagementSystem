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
	private Frequency frequency;
	private LocalDate startDate;
	private double amount;

	public void setSubscriptionAmount() {
		if (this.getFrequency().toString().equalsIgnoreCase(entity.Frequency.Monthly.toString())) {
			LocalDate endDate = startDate.plusMonths(1);
			calculateSubscriptionAmount(endDate);
		}
		else if(this.getFrequency().toString().equalsIgnoreCase(entity.Frequency.Biweekly.toString())) {
			LocalDate endDate = startDate.plusWeeks(2);
			calculateSubscriptionAmount(endDate);
		}
		else if(this.getFrequency().toString().equalsIgnoreCase(entity.Frequency.Weekly.toString())) {
			LocalDate endDate = startDate.plusWeeks(1);
			calculateSubscriptionAmount(endDate);
		}

	}
	
	private void calculateSubscriptionAmount(LocalDate endDate) {
		Map<String, Double> priceMap = new HashMap<String, Double>();
		product.getPrices().stream().forEach(price -> {
			priceMap.put(price.getWeekdays().toString(), price.getPrice());
		});
		System.out.println(priceMap);
		Stream.iterate(startDate, date ->  date.plusDays(1)).limit(ChronoUnit.DAYS.between(startDate, endDate))
				.forEach(date -> {
					System.out.println(date+ " == "+date.getDayOfWeek().name().toLowerCase()+" == " +priceMap.get(date.getDayOfWeek().name().toLowerCase()));
					amount = amount + priceMap.get(date.getDayOfWeek().name().toLowerCase());
				});

	}

	public double getSubscriptionAmount() {
		return amount;
	}

}
