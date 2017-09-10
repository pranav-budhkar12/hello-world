package finance;

public class PersonalLoan implements LoanPolicy{

	@MaxDuration(value=4)
	public float interestRate(double p, int n){
		return (p <= 50000) ? 10.5f : 11.5f;
	}
	
	@MaxDuration
	public float interestRateForEmployees(double p, int n){
		return (p <= 100000) ? 5.5f : 6.5f;
	}
}












