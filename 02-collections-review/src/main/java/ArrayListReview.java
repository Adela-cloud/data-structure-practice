import java.util.*;


public class ArrayListReview {
    public static void main(String[] args) {


        List<Student> students= new ArrayList<>();
        students.add(new Student(1, "Jack"));
        students.add(new Student(2, "Mary"));
        students.add(new Student(3, "Julia"));
        students.add(new Student(4, "Mike"));


        System.out.println("-----------------printing------------------------");

        //for loop
        System.out.println();
        System.out.println("printing the list with for loop : ");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }

        //for each
        System.out.println();
        System.out.println("printing the list with for each loop :");
        for (Student  s:students) {
            System.out.println(s);
        }

        //iterator
        System.out.println();
        System.out.println("printing the list with for iterator :");
        Iterator iterator= students.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        //iterator (backward)
        System.out.println();
        System.out.println("printing the list backward with for iterator :");
        while (((ListIterator<?>) iterator).hasPrevious()){
            System.out.println(((ListIterator<?>) iterator).previous());
        }


        //lambda
        System.out.println();
        System.out.println("printing with lambda : ");
        students.forEach(student-> System.out.println(student));


        System.out.println("----------------sorting-------------------------");

        //sorting elements with Comparator interface
        System.out.println();
        System.out.println("sorting elements by id in descending order using custom comparator :");
        Collections.sort(students, new SortByIdDesc());
        students.forEach(student -> System.out.println(student));


        System.out.println();
        System.out.println("sorting elements by name in descending order using custom comparator :");
        Collections.sort(students, new SortByNameDesc());
        students.forEach(student -> System.out.println(student));
    }


    //creating a comparator
    static class SortByIdDesc implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o2.id- o1.id;
        }
    }

    static class SortByNameDesc implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o2.name.compareToIgnoreCase(o1.name);
        }
    }
}
