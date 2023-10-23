package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
        //task4();
        //task5();
        //task6();
        //task7();
        //task8();
        //task9();
        //task10();
        //task11();
        //task12();
        //task13();
        task14();
        task15();
        //task16();
        //task17();
        task18();
        task19();
        task20();
        task21();
        task22();
    }

    public static void task1() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparingInt(Animal::getAge))
                .toList()
                .subList(14, 21)
                .forEach(System.out::println);
    }

    public static void task2() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getOrigin().equals("Japanese"))
                .peek(animal -> {
                    if (animal.getGender().equals("Female")) {
                        animal.setBread(animal.getBread().toUpperCase());
                    }
                })
                .map(Animal::getBread)
                .forEach(System.out::println);

    }

    public static void task3() {
        List<Animal> animals = Util.getAnimals();
        animals.stream().
                filter(animal -> animal.getAge() > 30 && animal.getOrigin().startsWith("A"))
                .map(Animal::getOrigin)
                .distinct()
                .forEach(System.out::println);
    }

    public static void task4() {
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count()
        );
    }

    public static void task5() {
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .anyMatch(animal -> animal.getOrigin().equals("Hungarian"))
        );
    }

    public static void task6() {
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .allMatch(animal -> animal.getGender().equals("Male") || animal.getGender().equals("Female"))
        );
    }

    public static void task7() {
        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania"))
        );
    }

    public static void task8() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .max(Comparator.comparing(Animal::getAge))
                .ifPresent(animal -> System.out.println(animal.getAge()));

    }

    public static void task9() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .min(Comparator.comparing(chars -> chars.length))
                .ifPresent(chars -> System.out.println(chars.length));
    }

    public static void task10() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .mapToInt(Animal::getAge)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }

    public static void task11() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .mapToInt(Animal::getAge)
                .average().ifPresent(System.out::println);
    }

    public static void task12() {
        List<Person> persons = Util.getPersons();
        persons.stream()
                .filter(person -> person.getGender().equals("Male")
                        && person.getDateOfBirth().isAfter(LocalDate.now().minusYears(28))
                        && person.getDateOfBirth().isBefore(LocalDate.now().minusYears(18))
                )
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(200)
                .forEach(System.out::println);

    }

    public static void task13() {
        List<House> houses = Util.getHouses();
        houses.stream()
                .flatMap(house -> house.getPersonList().stream()
                        .map(person -> {
                            int priority = 3;
                            if (house.getBuildingType().equals("Hospital")) {
                                priority = 1;
                            } else if (person.getDateOfBirth().isAfter(LocalDate.now().minusYears(18))
                                    || (person.getDateOfBirth().isBefore(LocalDate.now().minusYears(63))
                                        && person.getGender().equals("Male"))
                                    || (person.getDateOfBirth().isBefore(LocalDate.now().minusYears(58))
                                        && person.getGender().equals("Female"))) {
                                priority = 2;
                            }
                            return Map.entry(priority, person);
                        }))
                .sorted(Map.Entry.comparingByKey())
                .limit(500)
                .map(Map.Entry::getValue)
                .forEach(System.out::println);
    }

    public static void task14() {
        List<Car> cars = Util.getCars();
//        cars.stream()
//                .map(car -> {
//
//                })

    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
//        flowers.stream() Продолжить ...
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
        System.out.println(students.stream()
                .filter(student -> student.getAge() < 18)
                .sorted(Comparator.comparing(Student::getSurname))
                .map(student -> student.getSurname() + " " + student.getAge())
                .collect(Collectors.toList())
        );
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
        System.out.println(students.stream()
                .map(Student::getGroup)
                .distinct()
                .collect(Collectors.toList())
        );
    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
//        students.stream() Продолжить ...
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }
}
