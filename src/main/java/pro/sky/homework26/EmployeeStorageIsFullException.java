package pro.sky.homework26;

public class EmployeeStorageIsFullException extends Exception{

    public EmployeeStorageIsFullException(String message){
        super(message);
    }
}
