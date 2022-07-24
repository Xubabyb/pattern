package my.home.something.collection;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("A", "B", "D", "C", "E", "Y", "O");
        List<String> list = stream.sorted().toList();
        //  List<String> list = stream.sorted().collect(Collectors.toList());
        System.out.println(list);
    }
}
