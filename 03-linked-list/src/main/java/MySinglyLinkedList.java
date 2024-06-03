public class MySinglyLinkedList {
    Node head;
    Node tail;
    int size;

                    /**  my custom linked list methods  */

    //-----------------------------is empty--------------------------------------
    boolean isEmpty(){
        return head == null;
    }



    //---------------------------- add to tail --------------------------------------
    //time Com O(1)
    void add(int data){
        Node  node= new Node(data);
        if (isEmpty()){
            head=tail=node;
            size++;
        }else {
            tail.next= node;
            tail= node;
            size++;
        }
    }


    //-----------------------------add to head--------------------------------------
    void addFirst(int data){
        Node node= new Node(data);
        if(isEmpty()){
            node= head= tail;
            size++;
        }else {
            node.next = head;
            head = node;
            size++;
        }
    }




    //-----------------------------print nodes--------------------------------------
    void printNodes() {
        Node current = head;
        while (current != null) {
            if (current.next == null) {
                System.out.println(current.id + "=> null");
            } else {
                System.out.print(current.id + "=> ");
            }
            current = current.next;
        }
    }



    //-----------------------------delete by id--------------------------------------
    void deleteById(int id) {
        // check if the list is empty
        if (isEmpty()) {
            System.out.println("the list is empty");
        }
        //initialize the 'current' and 'previous' local variables with 'head'
        Node current = head;
        Node previous = head;
        while (current != null) {
            if (current.id == id) {  //find the match
                // case 1: head O(1)
                if (current == head) {
                    head = current.next;
                    current.next = null; //if there is no connection between nodes, it will be eligible for garbage collection;
                } else if (current == tail) { //case 2 : tail O(n)
                    tail = previous;
                    previous.next = null; //ex-tail eligible for garbage collection
                } else { //case 3 : middle O(n)
                    previous.next = current.next; //now, both current & previous is linked with current.next
                    current.next = null; //we are unlink the current and current.next
                    // so, curren is eligible for garbage collection

                    // after deletion
                    size--;
                }
            }
                //move to other elements and check for match
                previous = current;
                current = current.next;
            }
        }

    /**
     * Note for deletion:
     * current. next = null; //curren is eligible for garbage collection
     * if the both previous and next elements of a node is null,
     * then there is no link between them, thus this node become eligible for garbage collection
     * (it is not accessible through this list anymore)
     * but the tail. next is also null, but there is link between tail and previous element. So it is still in the list
     */




    //----------------------------index of node--------------------------------------
    int indexOf(int id){
        if(isEmpty()){
            return -1;
        }
       Node  current = head;
        int pos=0;
        while (current != null){
            if(current.id == id){
                return pos;
            }
            pos++;
            current = current.next;
        }
        return -1;
    }



    //-----------------------------getKthItemFromLast--------------------------------------
    public int getKthItemFromLast(int k){

        //create 2 pointers
        Node pointer1 = head;
        Node pointer2 = head;

        //move pointer2 k-1 times
        for (int i= 0; i < k-1; i++) {
        pointer2 = pointer2.next;
        }

        // move both elements until pointer2 hits the last element
        while (pointer2.next != null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        //pointer1 is on the Kth element from the last
        return pointer1.id;
    }

    //-----------------------------removeKthItemFromLast--------------------------------------
    public void removeKthItemFromLast(int  k){
        //create 3 pointers
        Node pointer1 = head;
        Node pointer2 = head;
        Node previous = head;

        //move pointer2 k-1 times
        for (int i = 0; i < k-1; i++) {// when pointer 2 moves k-1 times, there will be (total-k) elements until the end
            pointer2 = pointer2.next;
        }

        while(pointer2.next != null){// so, when we move both pointer1&pointer2 (total-k) times, pointer1 hits the kth item
            previous = pointer1;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        //pointer 1 is on the Kth element from the last

        //delete kth element
        if (pointer1 == head){
            head = pointer1.next;
            pointer1.next= null;// break the link between pointer1 and pointer1.next
            size--;
        }else if(pointer1 == tail){
            tail = previous;
            previous.next= null;// remove the link between the old tail and the new tail
            size--;
        }else{
            previous.next = pointer1.next;
            pointer1.next=null;
            size--;
        }

    }

    //second approach
    public void removeKthFromLast2(int k){
        Node ptr1=head;
        Node ptr2=head;
        for(int i=0;i<k-1;i++) {

            ptr2=ptr2.next;

            if (ptr2==null)  System.out.println("Less than k elements");

            else if(ptr2.next==null){
                head=ptr1.next;
                ptr1.next=null;
                return;
            }
        }
        while(ptr2.next.next!=null) {

            ptr1=ptr1.next;
            ptr2=ptr2.next;

        }

        ptr1.next=ptr1.next.next;
        ptr1=ptr1.next;
        ptr1=null;
    }


}
