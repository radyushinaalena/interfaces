import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Напишите реализации функционального интерфейса Predicate, которые проверяют,
        // является ли число положительным.
        System.out.println("Задача 1");
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                if (i > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        System.out.println(predicate.test(-7));

        Predicate<Integer> predicate1 = i -> {
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        };
        System.out.println(predicate1.test(7));
        //Создайте функциональный интерфейс Consumer,
        //который принимает на вход имя человека и выводит в консоль приветствие в его адрес.
        System.out.println("Задача 2");
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println("Hi! " + name);
            }
        };
        consumer.accept("Маша");

        Consumer<String> consumer1 = name -> System.out.println("Hi!!! " + name);
        consumer1.accept("Петя");
        //Реализуйте функциональный интерфейс Function
        //, который принимает на вход вещественное число типа Double
        //, а возвращает его округленный вариант типа Long.
        System.out.println("Задача 3");
        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double number) {
                return number.longValue();
            }
        };
        System.out.println(function.apply(7.84545));

        Function<Double, Long> function1 = number -> number.longValue();
        System.out.println(function1.apply(8.56544));

        //Напишите Supplier, который возвращает случайное число из диапазона от 0 до 100.
        System.out.println("Задача 4");
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random random = new Random();
                int i = random.nextInt(100);
                return i;
            }
        };
        System.out.println(supplier.get());

        Supplier<Integer> supplier1 = () -> {
            Random random = new Random();
            int i = random.nextInt(100);
            return i;
        };
        System.out.println(supplier1.get());

        //Напишите метод ternaryOperator, который из предиката и двух функций построит новую функцию
        //, возвращающую значение функции ifTrue, если предикат выполнен, а в остальных случаях — ifFalse.
        System.out.println("Задача 5");
        Book book1 = new Book("Война и мир", 1863);
        Book book2 = new Book("Отцы и дети", 1860);
        Book book3 = new Book("Алые паруса", 1922);
        Book book4 = new Book("Гарри Поттер и Дары Смерти", 2007);
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);


        Predicate<Book> condition = (Book book) -> book.getYear() < 2000;
        Function<Book, String> ifTrue = (Book book) -> book.getName() + " - старая книга";
        Function<Book, String> ifFalse = (Book book) -> book.getName() + " - современная книга";
        Function<Book, String> function2 = ternaryOperator(condition, ifTrue, ifFalse);
        for (Book b : books) {
            System.out.println(function2.apply(b));
        }
    }

    ;

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }
}
