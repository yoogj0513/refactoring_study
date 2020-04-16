package refactoring_study;

public class HtmlStatement extends Statement{
	String eachRentalString(Rental aEach) {
		return String.format("%s : %s<br>%n", aEach.getMovie().getTitle(), aEach.getCharge());
	}
	
	String footerString(Customer aCustomer) {
		return String.format("<p>누적 대여료 : <em>%s</em></p>%n<p>적립 포인트 : <em>%s</em></p>", aCustomer.getTotalChange(), aCustomer.getTotalFrequentRenterPoints());
	}
	
	String headerString(String coustomerName) {
		return String.format("<h1><em>%s 고객님의 대여 기록</em></h1><p>%n", coustomerName);
	}
}
