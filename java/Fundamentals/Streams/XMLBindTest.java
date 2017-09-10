import hr.*;
import java.io.*;
import javax.xml.bind.*;

class XMLBindTest{

	public static void main(String[] args) throws Exception{
		JAXBContext jc = JAXBContext.newInstance(Department.class);
		if(args.length > 0){
			Department dpmt = new Department();
			dpmt.setTitle(args[0]);
			dpmt.addEmployee(3, 35000);
			dpmt.addEmployee(5, 55000);
			dpmt.addEmployee(7, 75000);
			dpmt.addEmployee(6, 65000);
			dpmt.addEmployee(4, 45000);
			Marshaller m = jc.createMarshaller();
			m.setProperty("jaxb.formatted.output", true);
			FileWriter fw = new FileWriter("mydept.xml");
			m.marshal(dpmt, fw);
			fw.close();
		}else{
			Unmarshaller u = jc.createUnmarshaller();
			FileReader fr = new FileReader("mydept.xml");
			Department dpmt = (Department) u.unmarshal(fr);
			fr.close();
			System.out.printf("Employees of %s department%n",
				dpmt.getTitle());
			for(Employee emp : dpmt.getEmployees())
				System.out.println(emp);
		}
	}

}












