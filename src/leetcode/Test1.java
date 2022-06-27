package leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class Test1 {

    public static class Permutations {

        private Permutations() {
        }

        public static long factorial(int n) {
            if (n > 20 || n < 0) throw new IllegalArgumentException(n + " is out of range");
            return LongStream.rangeClosed(2, n).reduce(1, (a, b) -> a * b);
        }

        public static <T> List<T> permutation(long no, List<T> items) {
            return permutationHelper(no,
                    new LinkedList<>(Objects.requireNonNull(items)),
                    new ArrayList<>());
        }

        private static <T> List<T> permutationHelper(long no, LinkedList<T> in, List<T> out) {
            if (in.isEmpty()) return out;
            long subFactorial = factorial(in.size() - 1);
            out.add(in.remove((int) (no / subFactorial)));
            return permutationHelper((int) (no % subFactorial), in, out);
        }

        @SafeVarargs
        @SuppressWarnings("varargs") // Creating a List from an array is safe
        public static <T> Stream<Stream<T>> of(T... items) {
            List<T> itemList = Arrays.asList(items);
            return LongStream.range(0, factorial(items.length))
                    .mapToObj(no -> permutation(no, itemList).stream());
        }
    }
        static class Employee {
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        Integer id;
        String name;
    }

    static Comparator<Employee> employeeComparator = Comparator.comparingInt(Employee::getId);

    static Comparator<Employee> employeeComparatorString = Comparator.comparing(Employee::getName);


    public static void main(String[] args) {
        Map<String, Optional<String>> collect = Stream.<String>of("ABCDE", "ABC", "ABCD", "B", "c", "CDE")
                .collect(groupingBy(s -> String.valueOf(s.charAt(0)), collectingAndThen(

                        maxBy(Comparator.comparingInt(String::length)),
                        Function.identity())));

        System.out.println(collect);
//        Permutations.<Integer>of(1,2,3).map(s -> s.collect(toList()))
//                .forEachOrdered(System.out::println);
//
//        List<int[]> collect = IntStream.rangeClosed(1, 100).boxed().flatMap(hyp ->
//                        IntStream.range(1, hyp).boxed().flatMap(side1 ->
//                                IntStream.rangeClosed(1, side1).mapToObj(side2 -> new int[]{side2, side1, hyp})
//                        )
//                )
//                .filter(ints -> (ints[0] * ints[0]) + (ints[1] * ints[1]) == (ints[2] * ints[2]))
//                .collect(toList());
//        Stream.iterate(new int[]{0, 1},
//                        t -> new int[]{t[1], t[0]+t[1]})
//                .limit(20)
//                .forEach(t -> System.out.println("(" + t[0] + ")"));
//
//        collect.stream()
//                .forEach(t ->
//                        System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
//        int[][] input = new int[][]{{6,3,1}, {9,7,8},{4,5,2}};
//
//        int m = input.length;
//        int n = input[0].length;
//        // find mins in rows
//        int[] minElementsIndex = findMins(input, m);
//
//        int iter = 0;
//
//        while (iter < n) {
//            int index = minElementsIndex[iter];
//            int value = input[iter][index];
//            boolean flag = false;
//            for (int i = 0; i < m; i++) {
//                if (value == input[i][index]) {
//                    continue;
//                }
//                if (value < input[i][index]) {
//                    flag = true;
//                    break;
//                }
//            }
//            if (flag) {
//                iter++;
//            }
//            else {
//                System.out.println(value);
//                break;
//            }
//        }

    }

    public static int[] findMins(int[][] inputs, int m) {
        int i = 0;
        int[] minsElementsIndex = new int[m];
        while (i < m) {
            int minIndex = 0;
            Integer min = Integer.MAX_VALUE;
            for (int j = 0; j < inputs[i].length; j++) {
                if (inputs[i][j] < min) {
                    min = inputs[i][j];
                    minIndex = j;
                }
            }

            minsElementsIndex[i++] = minIndex;
        }
        return minsElementsIndex;
    }
}
