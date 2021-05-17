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
import entity.Frequency;
import entity.WeekDays;

public class TestSubscription {
	@Test
	public void verifySubscriptionAmount() {

		ProductPrice toiSundayPrice = ProductPrice.builder().weekdays(WeekDays.sunday).price(1).build();
		ProductPrice toiMondayPrice = ProductPrice.builder().weekdays(WeekDays.monday).price(2).build();
		ProductPrice toiTuesdayPrice = ProductPrice.builder().weekdays(WeekDays.tuesday).price(3).build();
		ProductPrice toiWednesdayPrice = ProductPrice.builder().weekdays(WeekDays.wednesday).price(4).build();
		ProductPrice toiThursdayPrice = ProductPrice.builder().weekdays(WeekDays.thursday).price(5).build();
		ProductPrice toiFridayPrice = ProductPrice.builder().weekdays(WeekDays.friday).price(6).build();
		ProductPrice toiSaturdayPrice = ProductPrice.builder().weekdays(WeekDays.saturday).price(7).build();

		List<ProductPrice> toiPriceList = Arrays.asList(toiSundayPrice, toiMondayPrice, toiTuesdayPrice,
				toiWednesdayPrice, toiThursdayPrice, toiFridayPrice, toiSaturdayPrice);
		Product TOI = Product.builder().name("TOI").category("Books & Periodical").subcategory("NewsPaper")
				.prices(toiPriceList).build();

		Subscription toiSubscription = Subscription.builder().product(TOI).frequency(Frequency.Monthly)
				.startDate(LocalDate.now()).build();

		toiSubscription.setSubscriptionAmount();

		List<Subscription> subscriptionList = new ArrayList<Subscription>();
		subscriptionList.add(toiSubscription);

		ICustomer rahul = Customer.builder().subscription(subscriptionList).name("Rahul").build();

		double amount = rahul.getSubScriptionPriceForCurrentMonth();

		Assert.assertEquals(amount, 121.00);

	}

	@Test
	public void verifySubscriptionAmountForDifferentCategory() {

		ProductPrice toiSundayPrice = ProductPrice.builder().weekdays(WeekDays.sunday).price(1).build();
		ProductPrice toiMondayPrice = ProductPrice.builder().weekdays(WeekDays.monday).price(2).build();
		ProductPrice toiTuesdayPrice = ProductPrice.builder().weekdays(WeekDays.tuesday).price(3).build();
		ProductPrice toiWednesdayPrice = ProductPrice.builder().weekdays(WeekDays.wednesday).price(4).build();
		ProductPrice toiThursdayPrice = ProductPrice.builder().weekdays(WeekDays.thursday).price(5).build();
		ProductPrice toiFridayPrice = ProductPrice.builder().weekdays(WeekDays.friday).price(6).build();
		ProductPrice toiSaturdayPrice = ProductPrice.builder().weekdays(WeekDays.saturday).price(7).build();

		List<ProductPrice> toiPriceList = Arrays.asList(toiSundayPrice, toiMondayPrice, toiTuesdayPrice,
				toiWednesdayPrice, toiThursdayPrice, toiFridayPrice, toiSaturdayPrice);
		Product toi = Product.builder().name("TOI").category("Books & Periodical").subcategory("NewsPaper")
				.prices(toiPriceList).build();

		Subscription toiSubscription = Subscription.builder().product(toi).frequency(Frequency.Monthly)
				.startDate(LocalDate.now()).build();

		toiSubscription.setSubscriptionAmount();

		ProductPrice amulMilkSundayPrice = ProductPrice.builder().weekdays(WeekDays.sunday).price(30).build();
		ProductPrice amulMilkMondayPrice = ProductPrice.builder().weekdays(WeekDays.monday).price(30).build();
		ProductPrice amulMilkTuesdayPrice = ProductPrice.builder().weekdays(WeekDays.tuesday).price(30).build();
		ProductPrice amulMilkWednesdayPrice = ProductPrice.builder().weekdays(WeekDays.wednesday).price(30).build();
		ProductPrice amulMilkThursdayPrice = ProductPrice.builder().weekdays(WeekDays.thursday).price(30).build();
		ProductPrice amulMilkFridayPrice = ProductPrice.builder().weekdays(WeekDays.friday).price(30).build();
		ProductPrice amulMilkSaturdayPrice = ProductPrice.builder().weekdays(WeekDays.saturday).price(30).build();

		List<ProductPrice> amulMilkPriceList = Arrays.asList(amulMilkSundayPrice, amulMilkMondayPrice,
				amulMilkTuesdayPrice, amulMilkWednesdayPrice, amulMilkThursdayPrice, amulMilkFridayPrice,
				amulMilkSaturdayPrice);
		Product amulMilk = Product.builder().name("Amul Milk").category("Dairy").subcategory("Milk")
				.prices(amulMilkPriceList).build();

		Subscription amulMilkSubscription = Subscription.builder().product(amulMilk).frequency(Frequency.Biweekly)
				.startDate(LocalDate.now()).build();

		amulMilkSubscription.setSubscriptionAmount();

		List<Subscription> subscriptionList = new ArrayList<Subscription>();
		subscriptionList.add(amulMilkSubscription);
		subscriptionList.add(toiSubscription);

		ICustomer rahul = Customer.builder().subscription(subscriptionList).name("Rahul").build();

		double amount = rahul.getSubScriptionPriceForCurrentMonth();

		Assert.assertEquals(amount, 541.0);

	}

	@Test
	public void verifySubscriptionAmountForMultipleNewsPapers() {

		ProductPrice toiSundayPrice = ProductPrice.builder().weekdays(WeekDays.sunday).price(1).build();
		ProductPrice toiMondayPrice = ProductPrice.builder().weekdays(WeekDays.monday).price(2).build();
		ProductPrice toiTuesdayPrice = ProductPrice.builder().weekdays(WeekDays.tuesday).price(3).build();
		ProductPrice toiWednesdayPrice = ProductPrice.builder().weekdays(WeekDays.wednesday).price(4).build();
		ProductPrice toiThursdayPrice = ProductPrice.builder().weekdays(WeekDays.thursday).price(5).build();
		ProductPrice toiFridayPrice = ProductPrice.builder().weekdays(WeekDays.friday).price(6).build();
		ProductPrice toiSaturdayPrice = ProductPrice.builder().weekdays(WeekDays.saturday).price(7).build();

		List<ProductPrice> toiPriceList = Arrays.asList(toiSundayPrice, toiMondayPrice, toiTuesdayPrice,
				toiWednesdayPrice, toiThursdayPrice, toiFridayPrice, toiSaturdayPrice);
		Product toi = Product.builder().name("TOI").category("Books & Periodical").subcategory("NewsPaper")
				.prices(toiPriceList).build();

		Subscription toiSubscription = Subscription.builder().product(toi).frequency(Frequency.Monthly)
				.startDate(LocalDate.now()).build();

		toiSubscription.setSubscriptionAmount();

		ProductPrice etSundayPrice = ProductPrice.builder().weekdays(WeekDays.sunday).price(1.3).build();
		ProductPrice etMondayPrice = ProductPrice.builder().weekdays(WeekDays.monday).price(2.5).build();
		ProductPrice etTuesdayPrice = ProductPrice.builder().weekdays(WeekDays.tuesday).price(3.6).build();
		ProductPrice etWednesdayPrice = ProductPrice.builder().weekdays(WeekDays.wednesday).price(4.4).build();
		ProductPrice etThursdayPrice = ProductPrice.builder().weekdays(WeekDays.thursday).price(5.6).build();
		ProductPrice etFridayPrice = ProductPrice.builder().weekdays(WeekDays.friday).price(6.4).build();
		ProductPrice etSaturdayPrice = ProductPrice.builder().weekdays(WeekDays.saturday).price(7.3).build();

		List<ProductPrice> ETPriceList = Arrays.asList(etSundayPrice, etMondayPrice, etTuesdayPrice, etWednesdayPrice,
				etThursdayPrice, etFridayPrice, etSaturdayPrice);
		Product et = Product.builder().name("ET").category("Books & Periodical").subcategory("NewsPaper")
				.prices(ETPriceList).build();

		Subscription etSubscription = Subscription.builder().product(et).frequency(Frequency.Monthly)
				.startDate(LocalDate.now()).build();
		etSubscription.setSubscriptionAmount();

		List<Subscription> subscriptionList = Arrays.asList(toiSubscription, etSubscription);

		ICustomer rahul = Customer.builder().subscription(subscriptionList).name("Rahul").build();

		double amount = rahul.getSubScriptionPriceForCurrentMonth();

		Assert.assertEquals(amount, 255.89999999999998);

	}

}
