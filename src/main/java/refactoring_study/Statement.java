package refactoring_study;

import java.util.List;

public abstract class Statement {
	public String value(Customer aCustomer) {
		List<Rental> rentals = aCustomer.getRentals();
		
		StringBuilder result = new StringBuilder();
		
		//헤더출력
		result.append(headerString(aCustomer.getName()));
		
		//비디오 종류별 대여료 계산
		for(Rental each : rentals) {
			result.append(eachRentalString(each));
		}//end of for-loop
		
		//푸터행 추가
		result.append(footerString(aCustomer));
		
		return result.toString();
	}


	abstract Object headerString(String name);
	abstract Object eachRentalString(Rental each);
	abstract Object footerString(Customer aCustomer);
	
}
