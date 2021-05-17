package entity;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer implements ICustomer {
	private String name;
	private List<Subscription> subscription;

	public double getSubScriptionPriceForCurrentMonth() {

		return subscription.stream()
				.filter(sub -> sub.getFrequency().toString().equalsIgnoreCase(frequency.Monthly.name()))
				.filter(sub -> sub.getStartDate().isBefore(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth())))
				.mapToDouble(o -> o.getAmount()).sum();

	}

}
