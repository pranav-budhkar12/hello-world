import payroll.*;

class BasicOOPTest3{

	private static double averageIncome(Employee[] group){
		double total = 0;
		for(Employee emp : group){
			total += emp.getNetIncome();
		}
		return total / group.length;
	}

	private static double totalSales(Employee[] group){
		double total = 0;
		for(Employee emp : group){
			if(emp instanceof SalesPerson){
				SalesPerson sp = (SalesPerson) emp;
				total += sp.getSales();
			}
		}
		return total;
	}

	public static void main(String[] args){
		Employee[] dept = {
			new Employee(186, 52),
			new Employee(204, 236),
			new SalesPerson(172, 51, 60000),
			new Employee(168, 104),
			new SalesPerson(194, 63, 40000)
		};
		System.out.printf("Average income: %.2f%n", averageIncome(dept));
		System.out.printf("Total sales   : %.2f%n", totalSales(dept));
	}
}

