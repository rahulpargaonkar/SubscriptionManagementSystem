import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import entity.Customer;
import entity.ICustomer;
import entity.Product;
import entity.ProductPrice;
import entity.Subscription;
import entity.frequency;
import entity.weekDays;

public class TestSubscription {
	@Test
	public void verifySubscriptionAmount() {

		ProductPrice TOISundayPrice = ProductPrice.builder().weekdays(weekDays.sunday).price(1).build();
		ProductPrice TOIMondayPrice = ProductPrice.builder().weekdays(weekDays.monday).price(2).build();
		ProductPrice TOITuesdayPrice = ProductPrice.builder().weekdays(weekDays.tuesday).price(3).build();
		ProductPrice TOIWednesdayPrice = ProductPrice.builder().weekdays(weekDays.wednesday).price(4).build();
		ProductPrice TOIThursdayPrice = ProductPrice.builder().weekdays(weekDays.thursday).price(5).build();
		ProductPrice TOIFridayPrice = ProductPrice.builder().weekdays(weekDays.friday).price(6).build();
		ProductPrice TOISaturdayPrice = ProductPrice.builder().weekdays(weekDays.saturday).price(7).build();

		List<ProductPrice> toiPriceList = Arrays.asList(TOISundayPrice, TOIMondayPrice, TOITuesdayPrice,
				TOIWednesdayPrice, TOIThursdayPrice, TOIFridayPrice, TOISaturdayPrice);
		Product TOI = Product.builder().name("TOI").category("Books & Periodical").subcategory("NewsPaper")
				.prices(toiPriceList).build();

		Subscription toiSubscription = Subscription.builder().product(TOI).frequency(frequency.Monthly)
				.startDate(LocalDate.now()).build();

		toiSubscription.setSubscriptionAmount();

		List<Subscription> subscriptionList = new ArrayList<Subscription>();
		subscriptionList.add(toiSubscription);

		ICustomer rahul = Customer.builder().subscription(subscriptionList).name("Rahul").build();

		double amount = rahul.getSubScriptionPriceForCurrentMonth();
		
		Assert.assertEquals(amount, 121.00);

	}
	
	
	@Test
	public void verifySubscriptionAmountForMultipleNewsPapers() {

		ProductPrice TOISundayPrice = ProductPrice.builder().weekdays(weekDays.sunday).price(1).build();
		ProductPrice TOIMondayPrice = ProductPrice.builder().weekdays(weekDays.monday).price(2).build();
		ProductPrice TOITuesdayPrice = ProductPrice.builder().weekdays(weekDays.tuesday).price(3).build();
		ProductPrice TOIWednesdayPrice = ProductPrice.builder().weekdays(weekDays.wednesday).price(4).build();
		ProductPrice TOIThursdayPrice = ProductPrice.builder().weekdays(weekDays.thursday).price(5).build();
		ProductPrice TOIFridayPrice = ProductPrice.builder().weekdays(weekDays.friday).price(6).build();
		ProductPrice TOISaturdayPrice = ProductPrice.builder().weekdays(weekDays.saturday).price(7).build();
		
	
		
		
		List<ProductPrice> toiPriceList = Arrays.asList(TOISundayPrice, TOIMondayPrice, TOITuesdayPrice,
				TOIWednesdayPrice, TOIThursdayPrice, TOIFridayPrice, TOISaturdayPrice);
		Product TOI = Product.builder().name("TOI").category("Books & Periodical").subcategory("NewsPaper")
				.prices(toiPriceList).build();
		

		Subscription toiSubscription = Subscription.builder().product(TOI).frequency(frequency.Monthly)
				.startDate(LocalDate.now()).build();
		
		toiSubscription.setSubscriptionAmount();
		
		ProductPrice ETSundayPrice = ProductPrice.builder().weekdays(weekDays.sunday).price(1.3).build();
		ProductPrice ETMondayPrice = ProductPrice.builder().weekdays(weekDays.monday).price(2.5).build();
		ProductPrice ETTuesdayPrice = ProductPrice.builder().weekdays(weekDays.tuesday).price(3.6).build();
		ProductPrice ETWednesdayPrice = ProductPrice.builder().weekdays(weekDays.wednesday).price(4.4).build();
		ProductPrice ETThursdayPrice = ProductPrice.builder().weekdays(weekDays.thursday).price(5.6).build();
		ProductPrice ETFridayPrice = ProductPrice.builder().weekdays(weekDays.friday).price(6.4).build();
		ProductPrice ETSaturdayPrice = ProductPrice.builder().weekdays(weekDays.saturday).price(7.3).build();
		
		List<ProductPrice> ETPriceList = Arrays.asList(ETSundayPrice, ETMondayPrice, ETTuesdayPrice,
				ETWednesdayPrice, ETThursdayPrice, ETFridayPrice, ETSaturdayPrice);
		Product ET = Product.builder().name("ET").category("Books & Periodical").subcategory("NewsPaper")
				.prices(ETPriceList).build();
		

		Subscription ETSubscription = Subscription.builder().product(ET).frequency(frequency.Monthly)
				.startDate(LocalDate.now()).build();
		ETSubscription.setSubscriptionAmount();
	

		List<Subscription> subscriptionList = Arrays.asList(toiSubscription,ETSubscription);

		ICustomer rahul = Customer.builder().subscription(subscriptionList).name("Rahul").build();

		double amount = rahul.getSubScriptionPriceForCurrentMonth();
		
		Assert.assertEquals(amount, 121.00);

	}
}
