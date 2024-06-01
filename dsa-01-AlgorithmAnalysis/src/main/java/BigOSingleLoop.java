public class BigOSingleLoop {

    public static void main(String[] args) {

        long numberOfOperations = 0;
        int n = 1000;// number of data
        int m= 500;
        long startTime;
        long endTime;

        System.out.println("input size n is :" + n);

        //single loop
        //num of operation will be O(n)
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            numberOfOperations += 1;
        }
        endTime = System.currentTimeMillis();
        System.out.println(numberOfOperations + "   number of operations in single loop " + (endTime - startTime) + "   milliseconds");


        //nested loop
        //num of operations will be O(n)2
        numberOfOperations = 0;
        startTime = System.currentTimeMillis();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                numberOfOperations += 1;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println(numberOfOperations + "   number of operations in nested loop  " + (endTime - startTime) + "  milliseconds");



        //logarithmic complexity
        //num of operations will be less than O(n)
        numberOfOperations = 0;
        startTime = System.currentTimeMillis();
            for (int i = 1 ; i < n; i*=2) {
                numberOfOperations += 1;
            }

        endTime = System.currentTimeMillis();
        System.out.println(numberOfOperations + "   number of operations in in logarithmic  " + (endTime - startTime) + "  milliseconds");


        //triple nested loop
        //num of operations will be O(n)3
        numberOfOperations = 0;
        startTime = System.currentTimeMillis();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n ; k++) {
                    numberOfOperations += 1;
                }
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println(numberOfOperations + "   number of operations in triple nested loop  " + (endTime - startTime) + "  milliseconds");




        // N and M nested loop
        //num of operations will be O(n*m)
        numberOfOperations = 0;
        startTime = System.currentTimeMillis();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                numberOfOperations += 1;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println(numberOfOperations + "   number of operations in (n * m) nested loop  " + (endTime - startTime) + "  milliseconds");



        //N and M consecutive loops
        //num of operation will be O(n+m)
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            numberOfOperations += 1;
        }
        for (int i = 0; i < m; i++) {
            numberOfOperations += 1;
        }
        endTime = System.currentTimeMillis();
        System.out.println(numberOfOperations + "   number of operations in (n+m) loop " + (endTime - startTime) + "   milliseconds");

    }


        public boolean bigO( int length){   // constant+ (constant+constant) * n = O(n)
            if (length== 0) {//constant(assigning/ initializing a variable)
                return false; // constant(returning sth)
            } else {
                for (int n = 0; n < length;n++){
                //    if (list[n].equals(otherList[n]))  ->constant (comparing)
                }
                return false; // constant
            }
        }


}
