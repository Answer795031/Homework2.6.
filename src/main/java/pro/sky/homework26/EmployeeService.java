package pro.sky.homework26;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    public List<Employee> employees = new ArrayList<>();
    private static final int MAX_SIZE = 10; // максимум сотрудников

    public String employees(){
        return "Список сотрудников:\n" + employees;
    }

    // метод для добавления сотрудника
    public Employee addNewEmployee(String firstName, String lastName)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {

        Employee employee = new Employee(firstName, lastName);

        // проверка на наличие сотрудника перед добавлением
        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException("Ошибка! Сотрудник уже добавлен в список!");
        }

        // проверка на заполненность списка
        if (employees.size() == MAX_SIZE){
            throw new EmployeeStorageIsFullException("Ошибка! Список заполнен!");
        }

        // добавляем сотрудника, увеличиваем счетчик сотрудников
        employees.add(employee);

        return employee;
    }

    // метод для удаления сотрудника
    public Employee removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException {

        Employee employee = new Employee(firstName, lastName);

        // проверка на наличие сотрудника перед удалением
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException("Ошибка! Сотрудник не найден!");
        }

        // удаляем сотрудника, уменьшаем счетчик
        employees.remove(employee);

        return employee;
    }

    // метод для поиска сотрудника
    public int findEmployee(String firstName, String lastName)
            throws EmployeeNotFoundException {

        Employee employee = new Employee(firstName, lastName);

        // проверка на наличие сотрудника перед поиском
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException("Ошибка! Сотрудник не найден!");
        }

        return employees.indexOf(employee);
    }
}
