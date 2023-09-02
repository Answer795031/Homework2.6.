package pro.sky.homework26;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @ExceptionHandler
    public String handleException(Exception e){
        return e.getMessage();
    }

    private final EmployeeService employeeService;

    // инжектим EmployeeService в EmployeeController
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String employees(){
        return employeeService.employees();
    }

    @GetMapping(path = "/add")   // /employee/add?firstName=Ivan&lastName=Ivanov
    public Employee addNewEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        return employeeService.addNewEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")    // /employee/remove?firstName=Ivan&lastName=Ivanov
    public Employee removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName)
            throws EmployeeNotFoundException {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")  // /employee/find?firstName=Ivan&lastName=Ivanov
    public int findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName)
            throws EmployeeNotFoundException {
        return employeeService.findEmployee(firstName, lastName);
    }

}
