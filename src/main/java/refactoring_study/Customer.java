
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
	
	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		
		StringBuilder result = new StringBuilder(getName() + " 고객님의 대여 기록\n");
		
		//비디오 종류별 대여료 계산
		for(Rental each : rentals) {
			// 적립 포인트를 1포인트 증가 / 최신물을 이틀 이상 대여하면 보너스 포인트 지급
			frequentRenterPoints += each.getFrequentRenterPoints();
			
			//이번에 대여한 비디오 정보와 대여료를 출력
			result.append("\t" + each.getMovie().getTitle());
			result.append("\t" + String.valueOf(each.getCharge()) + "\n");
			
			//현재까지 누적된 총 대여료
			totalAmount += each.getCharge();
		}// end of for-loop
		
		//푸터행 추가
		result.append("누적 대여료 : " + String.valueOf(totalAmount) + "\n");
		result.append("적립 포인트 : " + String.valueOf(frequentRenterPoints));
		
		return result.toString();
	}// end of method statement

}
