package refactoring_study;

public class TextStatement extends Statement{
	String eachRentalString(Rental aEach) {
		return String.format("\t%s \t%s%n", aEach.getMovie().getTitle(), aEach.getCharge());
	}
	
	String footerString(Customer aCustomer) {
		return String.format("누적 대여료 : %s%n적립 포인트 : %s", aCustomer.getTotalChange(), aCustomer.getTotalFrequentRenterPoints());
	}
	
	String headerString(String customerName) {
		return String.format("%s 고객님의 대여 기록%n", customerName);
	}
}
