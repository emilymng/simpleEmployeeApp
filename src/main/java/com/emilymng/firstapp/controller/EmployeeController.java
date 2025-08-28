package com.emilymng.firstapp.controller;

import com.emilymng.firstapp.model.Employee;
import com.emilymng.firstapp.repo.EmployeeRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/getEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        try {
            List<Employee> employeeList = new ArrayList<>();
            employeeRepo.findAll().forEach(employeeList::add);

            if (employeeList.isEmpty()){
                return new ResponseEntity<>(employeeList, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        } catch (Exception e)  {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Optional<Employee> employeeData = employeeRepo.findById(id);
        return employeeData.map(employee -> new ResponseEntity<>(employee, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    @GetMapping
//    public void getEmployeeByName(String name){
//
//    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
        Employee employeeObj = employeeRepo.save(employee);
        return new ResponseEntity<>(employeeObj, HttpStatus.OK);
    }

    @PostMapping("/updateEmployeeById/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee newEmployeeData){
        Optional<Employee> oldEmployeeData = employeeRepo.findById(id);
        if(oldEmployeeData.isPresent()){
            Employee updatedEmployeeData = oldEmployeeData.get();
            updatedEmployeeData.setFirstName(newEmployeeData.getFirstName());
            updatedEmployeeData.setLastName(newEmployeeData.getLastName());
            updatedEmployeeData.setEmail(newEmployeeData.getEmail());
            Employee employeeData = employeeRepo.save(updatedEmployeeData);
            return new ResponseEntity<>(employeeData, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Long id) {
        employeeRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
