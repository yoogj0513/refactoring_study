package refactoring_study;

public class Movie {
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	public static final int CHILDRENS = 2;

	private String title;
	private int priceCode;
	private Price price;
	
	public Movie(String title, int priceCode) {
		this.title = title;
		setPriceCode(priceCode);
	}
	
	public int getPriceCode() {
		return price.getPriceCode();
	}
	
	public void setPriceCode(int aPriceCode) {
		switch(aPriceCode) {
		case REGULAR: price = new RegularPrice(); break;
		case CHILDRENS: price = new ChildrenPrice(); break;
		case NEW_RELEASE: price = new NewReleasePrice(); break;
		default : throw new IllegalArgumentException("가격 코드가 잘못 됐습니다.");
		}
	}

	public String getTitle() {
		return title;
	}
	
	public double getCharge(int aDaysRented) {
		double result = 0;
	
		switch (getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if(aDaysRented > 2) {
				result += (aDaysRented -2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			result += aDaysRented * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if(aDaysRented > 3) {
				result += (aDaysRented -3) * 1.5;
			}
			break;
		}
		return result;
	}
	
	public int getFrequentRenterPoints(int daysRented) {
		if((priceCode == Movie.NEW_RELEASE) && daysRented > 1) {
			return 2;
		} else {			
			return 1;
		}
	}

}
