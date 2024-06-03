public class SinglyLinkedListApp {
    public static void main(String[] args) {
        MySinglyLinkedList myList= new MySinglyLinkedList();
        System.out.println(myList.isEmpty());

        for (int i = 0; i < 10 ; i++) {
            myList.add(i); //add to tail
        }

        myList.printNodes();
        System.out.println("kth item from the last: " + myList.getKthItemFromLast(8));

        myList.removeKthItemFromLast(8);
        myList.printNodes();


        myList.printNodes();
        myList.deleteById(6);//deleting middle
        myList.printNodes();
        myList.deleteById(9);//deleting tail
        myList.printNodes();

        System.out.println(myList.indexOf(4));

        //add first method
        myList.addFirst(1);
        myList.printNodes();




    }
}
