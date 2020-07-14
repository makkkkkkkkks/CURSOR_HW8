package main.java.com.makkkkkkkks.executor;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Executor {
    public static void execute() {
        List<User> users = Arrays.asList(
                new User("Вася", 16, "Днепр"),
                new User("Петя", 23, "Днепр"),
                new User("Елена", 42, "Луцк"),
                new User("Елена", 92, "Чернигов"),
                new User("Сергей", 5, "Киев"),
                new User("Марина", 32, "Киев"),
                new User("Иван Иванович", 69, "Львов"));
        System.out.println("Users over 40:");
        users.stream()
                .filter(user -> user.getAge() > 40)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("Users under 50:");
        users.stream()
                .filter(user -> user.getAge() < 50 & user.getCity().equals("Днепр"))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("The average age of people from Lvov => " + (users.stream()
                .filter(user -> user.getCity().equals("Львов"))
                .mapToInt(User::getAge).sum()) / users.stream()
                .filter(user -> user.getCity().equals("Львов")).count() + "\n");
        System.out.println("The people are not from Kiev => " + users.stream()
                .filter(user -> !user.getCity().equals("Киев"))
                .count());
        System.out.println("Sorting out the first three ");
        users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .limit(3)
                .forEach(System.out::println);

        Random random = new Random();
        List<Integer> integers = random.ints(15).boxed().collect(Collectors.toList());
        System.out.println(integers);

        System.out.println("Max of random ints=> " +
                integers.stream()
                        .max(Comparator.comparing(integer -> integer)));

        System.out.println("Min of random ints=> " +
                integers.stream()
                        .min(Comparator.comparing(integer -> integer)));

        System.out.println("Numbers divisible by 2");
        integers.stream()
                .filter(integer -> integer % 2 == 0)
                .forEach(System.out::println);
        System.out.println("increase each number by 10");
        integers.stream()
                .map(integer -> integer + 10)
                .forEach(integer -> System.out.println(integer));
    }
}
