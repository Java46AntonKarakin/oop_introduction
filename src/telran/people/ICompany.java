package telran.people;

public interface ICompany {
boolean addEmployee(Employee empl);
Employee removeEmployee(long id);
Employee getEmployee(long id);
int getEmployeeIndex(long id);
long computeSalaryBudget();
Employee[] getAllEmployees();
}
