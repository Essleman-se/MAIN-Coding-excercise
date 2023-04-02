package streamCodeInterviews;

import usedClasses.Employee;
import usedClasses.Person;

import javax.swing.text.html.parser.Entity;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8StreamCodeInterviews {

    public static void main(String[] args){
        List<Integer> ints = Arrays.asList(10, 20, 80, 12, 10, 80, 100);
        //prime number
        //ints.stream().filter(x -> x )

        ///remove duplicate
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        ints.stream().filter(x-> !set.add(x)).forEach(x->System.out.println(x));
        //ints.stream().filter(x-> !set.add(x)).collect(Collectors.toSet()).forEach(x->System.out.println("no dublication : " + x));
        //System.out.println("no duplication  " + set2);
        //limit examples
        //ints.stream().limit(4).forEach(x->System.out.println(x));

        //Skip
        //ints.stream().skip(1).forEach(x->System.out.println(x));

        //Count words in string
        String str = "Welcome to code decor and code decod Welcome you";
        List<String> strs = Arrays.asList(str.split(" "));
        Map<String, Long> map = strs.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Counted words   "+map);
        List<Integer> nums = Arrays.asList(1, 4, 6,7,6,4);
        Map<Integer, Long> mapNum = nums.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Counted nums  " + mapNum);
        Function<String, String> fn = Function.identity();
        System.out.println("Salas Identity  : "  + fn.apply("salas"));
        //////////////////////////////////////
        Map<Integer, Person> pMap = new HashMap<>();
        pMap.put(10, new Person("001", "Semir", 39));
        pMap.put(20, new Person("002", "Endesh", 46));
        pMap.put(30, new Person("003", "Sol", 39));
        pMap.put(40, new Person("004", "Esain", 38));

        System.out.println(("from map with entrySet  "));
        pMap.entrySet().forEach(v -> System.out.println(v.getKey() + "   " +
                v.getValue().getName() + "  "  + v.getValue().getAge()));
        System.out.println(("from map with no entrySet  "));
        pMap.forEach((k, v) -> System.out.println(v.getName() + "  " + v.getAge()));

        Integer inntes[] = {1, 0, 6, 8, 0, 0, 9};
        int j=0;
        System.out.println("befor move  ");
        System.out.println(Arrays.asList(inntes));
        for (int i=0; i < inntes.length; i++){
            if (inntes[i] != 0) {
                int temp = inntes[j];
                inntes[j++] = inntes[i];
                inntes[i] = temp;
            }
            System.out.println("after move in loop  ");
            System.out.println(Arrays.asList(inntes));
        }
        System.out.println("after move in loop  ");
        System.out.println(Arrays.asList(inntes));

        realTimeJava8Queries();

    }

    public static void realTimeJava8Queries(){
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));


        //Query 3.1 : How many male and female employees are there in the organization?
        Map<String, Long> noOfMaleAndFemaleEploy = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println("Number of male and female employees");
        System.out.println(noOfMaleAndFemaleEploy);


        System.out.println("Employees grouped by department");
        Map<String, List<Employee>> employeeByDep = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        employeeByDep.forEach((key, emplist) -> {System.out.println(key + " -> " + emplist);} );

        //System.out.println(employeeByDep);

        //Query 3.2 : Print the name of all departments in the organization?
        System.out.println("Name All Departments");
        employeeList.stream().map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);

        //Query 3.3 : What is the average age of male and female employees?
        System.out.println("Average female and male age");
        Map<String, Double> averageMaleAndFemaleAge = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,
                Collectors.averagingInt(Employee::getAge)));
        System.out.println(averageMaleAndFemaleAge);

        //Query 3.4 : Get the details of highest paid employee in the organization?
        Optional<Employee> highestPaidEmployeeWrapper = employeeList.stream()
                .collect((Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

        Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();


        System.out.println("Details Of Highest Paid Employee : ");

        System.out.println("==================================");

        System.out.println("ID : "+highestPaidEmployee.getId());

        System.out.println("Name : "+highestPaidEmployee.getName());

        System.out.println("Age : "+highestPaidEmployee.getAge());

        System.out.println("Gender : "+highestPaidEmployee.getGender());

        System.out.println("Department : "+highestPaidEmployee.getDepartment());

        System.out.println("Year Of Joining : "+highestPaidEmployee.getYearOfJoining());

        System.out.println("Salary : "+highestPaidEmployee.getSalary());


        //Query 3.5 : Get the names of all employees who have joined after 2015?
        System.out.println("Employee names who joined after 2015");
        employeeList.stream().filter(e -> e.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .forEach(System.out::println);


        //Query 3.6 : Count the number of employees in each department?
        System.out.println("Number of Employee in each department");
        Map<String, Long> employeeCountByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        Set<Map.Entry<String, Long>> entrySet = employeeCountByDepartment.entrySet();
        entrySet.forEach(e ->{
            System.out.println(e.getKey() + " : " + e.getValue());
        });

        //Query 3.7 : What is the average salary of each department?
        Map<String, Double> averageSalaryByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("Average salary of Department");
        Set<Map.Entry<String, Double>> averageSallarInDep = averageSalaryByDepartment.entrySet();
        averageSallarInDep.forEach(s -> {
            System.out.println(s.getKey() + " : " + s.getValue());
        });

        //Query 3.8 : Get the details of youngest male employee in the product development department?
        Optional<Employee> youngestEmpInProducDevelopmentDepWrraper = employeeList.stream()
                .filter(e -> e.getDepartment().equals("Product Development") &&
                        e.getGender().equals("Female"))
                .min(Comparator.comparingInt(Employee::getAge));

        Employee youngestMaleEmployeeInProductDevelopment = youngestEmpInProducDevelopmentDepWrraper.get();

        System.out.println("Youngest Male Employee in Product Development");
        System.out.println("Details Of Youngest Male Employee In Product Development");

        System.out.println("----------------------------------------------");

        System.out.println("ID : "+youngestMaleEmployeeInProductDevelopment.getId());

        System.out.println("Name : "+youngestMaleEmployeeInProductDevelopment.getName());

        System.out.println("Age : "+youngestMaleEmployeeInProductDevelopment.getAge());

        System.out.println("Year Of Joinging : "+youngestMaleEmployeeInProductDevelopment.getYearOfJoining());

        System.out.println("Salary : "+youngestMaleEmployeeInProductDevelopment.getSalary());

        //Query 3.9 : Who has the most working experience in the organization?
        System.out.println("The most exprienced persson in the company");
        Optional<Employee> empWrapper = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
        Employee seniorMostEmployee = empWrapper.get();

        System.out.println("Senior Most Employee Details :");

        System.out.println("----------------------------");

        System.out.println("ID : "+seniorMostEmployee.getId());

        System.out.println("Name : "+seniorMostEmployee.getName());

        System.out.println("Age : "+seniorMostEmployee.getAge());

        System.out.println("Gender : "+seniorMostEmployee.getGender());

        System.out.println("Age : "+seniorMostEmployee.getDepartment());

        System.out.println("Year Of Joinging : "+seniorMostEmployee.getYearOfJoining());

        System.out.println("Salary : "+seniorMostEmployee.getSalary());

        //Query 3.10 : manyHow  male and female employees are there in the sales and marketing team?
        System.out.println("manyHow  male and female employees Sales and marketing team");
        Map<String, Long> noOfmaleAndFemaleInSalesAndMarketing = employeeList.stream().filter(e -> e.getDepartment().equals("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(noOfmaleAndFemaleInSalesAndMarketing);

        //Query 3.11 : What is the average salary of male and female employees?
        System.out.println("average salary of male and female employees?");
        Map<String, Double> averageMandFsalary = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(averageMandFsalary);

        //Query 3.12 : List down the names of all employees in each department?
        System.out.println("List of names of all employees in each department");
        Map<String, List<Employee>> empListInEachDep = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        Set<Map.Entry<String, List<Employee>>> entrySet2 = empListInEachDep.entrySet();

        entrySet2.forEach(entry -> {
            System.out.println("--------------------------------------");

            System.out.println("Employees In "+entry.getKey() + " : ");

            System.out.println("--------------------------------------");

            List<Employee> list = entry.getValue();

            list.forEach(l -> {
                ;
                {
                    System.out.println(l.getName());
                }
            });

        });

        //Query 3.13 : What is the average salary and total salary of the whole organization?
        System.out.println("Average salary and total salary of the whole organization");
        DoubleSummaryStatistics employeeSalaryStatistics = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println("Average Salary = "+employeeSalaryStatistics.getAverage());

        System.out.println("Total Salary = "+employeeSalaryStatistics.getSum());

        //Query 3.14 : Separate the employees who are younger or
        // equal to 25 years from those employees who are older than 25 years.
        System.out.println("Separate the employees who are younger or equal to 25 " +
                "years from those employees who are older than 25 years");
        Map<Boolean, List<Employee>> partitioningByEmpByAge = employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 25));

        Set<Map.Entry<Boolean, List<Employee>>> entrySet3 = partitioningByEmpByAge.entrySet();

        for (Map.Entry<Boolean, List<Employee>> entry : entrySet3)
        {
            System.out.println("----------------------------");

            if (entry.getKey())
            {
                System.out.println("Employees older than 25 years :");
            }
            else
            {
                System.out.println("Employees younger than or equal to 25 years :");
            }

            System.out.println("----------------------------");

            List<Employee> list = entry.getValue();

            for (Employee e : list)
            {
                System.out.println(e.getName());
            }
        }

        //Query 3.15 : Who is the oldest employee in the organization?
        // What is his age and which department he belongs to?
        System.out.println("Find Oldest employee in the company");
        //Optional<Employee> emplWrapper
        //Employee employee = employeeList.stream()
                //.sorted(Comparator.comparingInt(Employee::getAge))
                //.skip(employeeList.size()-1).findFirst().get();
        Employee employee = employeeList.stream()
                        .max(Comparator.comparingInt(Employee::getAge)).get();

                System.out.println("Name : " + employee.getName() + " Age : " + employee.getAge() +
                        " Department : " + employee.getDepartment());

    }
}
