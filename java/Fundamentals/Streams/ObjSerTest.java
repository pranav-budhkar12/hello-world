import hr.*;
import java.io.*;

class ObjSerTest{

	public static void main(String[] args) throws Exception{
		if(args.length > 0){
			Department dpmt = new Department();
			dpmt.setTitle(args[0]);
			dpmt.addEmployee(3, 35000);
			dpmt.addEmployee(5, 55000);
			dpmt.addEmployee(7, 75000);
			dpmt.addEmployee(6, 65000);
			dpmt.addEmployee(4, 45000);
			ObjectOutputStream oout = new ObjectOutputStream(
				new FileOutputStream("mydept.dat"));
			oout.writeObject(dpmt);
			oout.close();
		}else{
			ObjectInputStream oin = new ObjectInputStream(
				new FileInputStream("mydept.dat"));
			Department dpmt = (Department) oin.readObject();
			oin.close();
			System.out.printf("Employees of %s department%n",
				dpmt.getTitle());
			for(Employee emp : dpmt.getEmployees())
				System.out.println(emp);
		}
	}

}












