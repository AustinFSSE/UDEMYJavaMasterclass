package dev.lpa;

import java.util.List;

public class Main {

    public static void main(String[] args) {

//        StringBuilder bobsNotes = new StringBuilder();
//        StringBuilder billsNotes = new StringBuilder("Bill struggles with generics");
//
//        Student bob = new Student("Bob", bobsNotes);
//        Student bill = new Student("Bill", billsNotes);
//
//        List<Student> students = new ArrayList<>(List.of(bob, bill));
//        List<Student> studentsFirstCopy = new ArrayList<>(students); // shallow copy
//        List<Student> studentsSecondCopy = List.copyOf(students);
//        List<Student> studentsThirdCopy = Collections.unmodifiableList(students); // returns a view of List of students
//
//        studentsFirstCopy.add(new Student("Bonnie", new StringBuilder()));
////        studentsThirdCopy.set(0, new Student("Bonnie", new StringBuilder()));
//        studentsFirstCopy.sort(Comparator.comparing(Student::getName));
//        students.add(new Student("Bonnie", new StringBuilder()));
//        bobsNotes.append("Bob was one of my first students.");
//
//        StringBuilder bonniesNotes = studentsFirstCopy.get(2).getStudentNotes();
//        bonniesNotes.append("Bonnie is taking 3 of my courses");
//
//        students.forEach(System.out::println);
//        System.out.println("-----------------------");
//        studentsFirstCopy.forEach(System.out::println);
//        System.out.println("-----------------------");
//        studentsSecondCopy.forEach(System.out::println);
//        System.out.println("-----------------------");
//        studentsThirdCopy.forEach(System.out::println);
//        System.out.println("-----------------------");

        Bank bank = new Bank(3214567);
        bank.addCustomer("Joe", 500, 100000);

        BankCustomer joes = bank.getCustomer("101");
        System.out.println(joes);
        if (bank.doTransaction(joes.getCustomerId(), BankAccount.AccountType.CHECKING,+3500)) {
            System.out.println("Transaction successful ---> " + joes);
        }
        BankAccount checking = joes.getAccountType(BankAccount.AccountType.CHECKING);
        var transactions = checking.getTransactions();
        transactions.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}