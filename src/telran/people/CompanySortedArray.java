package telran.people;

import java.util.Arrays;
import telran.people.*;

public class CompanySortedArray extends CompanyArray {

	@Override
	public int getEmployeeIndex(long id) {
		
		long[] arrOfID = new long[employees.length];
		for (int i = 0; i < employees.length; i++) {
			arrOfID[i] = employees[i].getId();
		}
		
		int res= Arrays.binarySearch(arrOfID, id);
		return res;
	}

	@Override
	public boolean addEmployee(Employee empl) {
		
		if (getEmployeeIndex(empl.getId()) >= 0) {  
			return false;
		}
		Employee[] tmpArr = new Employee[employees.length + 1];		
		int indexOfNewEmp = -(getEmployeeIndex(empl.getId())) - 1;
		System.arraycopy(employees, 0, tmpArr, 0, indexOfNewEmp);		
		tmpArr[indexOfNewEmp] = empl;		
		if (indexOfNewEmp != employees.length) {		System.arraycopy(employees, indexOfNewEmp, tmpArr, indexOfNewEmp + 1, tmpArr.length - (indexOfNewEmp+1));
		}		
		
		employees = Arrays.copyOf(tmpArr, tmpArr.length);
		
		return true;
	}

	@Override
	public Employee[] getAllEmployees() {
		return Arrays.copyOf(employees, employees.length);
	}
}
