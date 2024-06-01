import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SetReview {
    public static void main(String[] args) {

        Set<Student> set = new HashSet<>();
        //does maintain the insertion order, it is based on hashcode

        set.add(new Student(1, "Jack"));
        set.add(new Student(2, "Mary"));
        set.add(new Student(3, "Julia"));
        set.add(new Student(4, "Mike"));
        set.add(new Student(4, "Mike"));//do not accept duplicates
        //if I try to print the duplicate, it returns false
        //if the element does mot exist, return true
        System.out.println(set.add(new Student(1, "Jack")));//false
        System.out.println(set.add(new Student(5, "Ken")));//true

        System.out.println(set);


        Set<Student> linkedSet = new LinkedHashSet<>();
        //maintain the insertion order
        linkedSet.add(new Student(1, "Jack"));
        linkedSet.add(new Student(2, "Mary"));
        linkedSet.add(new Student(3, "Julia"));
        linkedSet.add(new Student(4, "Mike"));

        System.out.println(linkedSet);

        System.out.println("------testing the method below-------- ");
        System.out.println(firstDuplicate("Javacvv"));


    }

    //time complexity -> O(n)
    //space complexity -> O(n)
    //new data structure takes additional space,
    //in worse case it has same num of elements with our data size (when there is no duplicate)

    //method to find the first duplicated character using hashset
    public static Character firstDuplicate(String str){
        Set<Character>   set= new HashSet<>();

        for (char eachChar: str.toCharArray()) { //turn str into char array then added to hashset
            if (!(set.add(eachChar))) return eachChar;// when cannot add to the set, return that char
        }
        return null;
    }

}
