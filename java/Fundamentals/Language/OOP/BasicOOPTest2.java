import payroll.Employee;
import payroll.SalesPerson;

class BasicOOPTest2{

	private static double incomeTax(Employee emp){
		double i = emp.getNetIncome();
		return i > 10000 ? 0.15 * (i - 10000) : 0;
	}

	public static void main(String[] args){
		Employee jack = new Employee();
		jack.setHours(186);
		jack.setRate(52);
		System.out.printf("Jack's ID is %d, Income is %.2f, Tax is %.2f%n", 
			jack.getId(), jack.getNetIncome(), incomeTax(jack));
		SalesPerson jill = new SalesPerson(186, 52, 80000);
		System.out.printf("Jill's ID is %d, Income is %.2f, Tax is %.2f%n", 
			jill.getId(), jill.getNetIncome(), incomeTax(jill));
		System.out.printf("Number of Employees: %d%n",
			Employee.countEmployees());
	}
}

