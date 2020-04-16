
package refactoring_study;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();
	
	public Customer(String name) {
		this.name = name;
	}
	
	public void addRental(Rental aRental) {
		this.rentals.add(aRental);
	}

	public String getName() {
		return this.name;
	}
	
	public List<Rental> getRentals(){
		return this.rentals;
	}
		
	public String statement() {
		return new TextStatement().value(this);
	}// end of method statement
	
	public String htmlStatement() {
		return new HtmlStatement().value(this);
	}

	// 적립포인트 (적립 포인트를 1포인트 증가 / 최신물을 이틀 이상 대여하면 보너스 포인트 지급)
	public int getTotalFrequentRenterPoints() {
		int result = 0;
		for(Rental rental : rentals) {
			result += rental.getFrequentRenterPoints();
		}
		return result;
	}

	// 누적된 총 대여료
	public double getTotalChange() {
		double result = 0;
		for(Rental rental : rentals) {
			result += rental.getCharge();
		}
		return result;
	}

}
