import java.util.*;

/**
 * Created by Mellon on 9/30/17.
 */
public class EmployeeImportance {
    public static int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        Queue<Employee> queue = new LinkedList<>();

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).id == id) queue.add(employees.get(i));
            map.put(employees.get(i).id, employees.get(i));

        }

        int sum = 0;
        while (!queue.isEmpty()) {
            Employee parent = queue.poll();
            sum += parent.importance;
            for (int child : parent.subordinates) {
                queue.add(map.get(child));
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.id = 1;
        employee1.importance = 2;
        employee1.subordinates = Arrays.asList(2);

        Employee employee2 = new Employee();
        employee2.id = 2;
        employee2.importance = 3;
        employee2.subordinates = new ArrayList<>();

        List<Employee> list = Arrays.asList(employee1, employee2);
        int res = getImportance(list, 2);
        System.out.println(res);
    }
}


class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};