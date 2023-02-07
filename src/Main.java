import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(9);


        Stream<Integer> stream = list.stream();
        Comparator<Integer> comparator = (o1, o2) -> o1.compareTo(o2);
        BiConsumer<Integer,Integer> biConsumer = (integer, integer2) -> {
            if (integer > integer2){
                System.out.println("Первое число больше");
            }else if (integer < integer2) {
                System.out.println("Второе число больше");
            }else {
                System.out.println("Числа равны");
            }
        };
        findMinMax(stream,comparator,biConsumer) ;
        evevAnd(list);





    }
    public  static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer
    )
    {
        List<T> listStream;
        listStream = stream
                .sorted()
                .collect(Collectors.toList());
        T minNum = null;
        T maxNum = null;
        if (listStream.size() != 0){
            minNum = listStream.get(0);
            maxNum = listStream.get(listStream.size()-1);

        }
        minMaxConsumer.accept(minNum,maxNum);
        System.out.println(listStream);



    }
    public static void evevAnd(List<Integer> list){
        System.out.println(list.stream()
                .filter(i -> i % 2 == 0)
                .count());
    }

}