package dev.alm.StreamingStudents;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainChallenge {
    public static void main(String[] args) {
        Course pymc= new Course("PYMC", "Python Masterclass", 50);
        Course jmc= new Course("JMC", "Java Masterclass", 100);
        Course games = new Course("GAMES", "Creating Games in Java");

        List <Student> students =
                Stream.generate(() -> Student.getRandomStudent(jmc, pymc)).limit(5000).toList();

        double totalPercent =
                students.stream()
                        .map(s -> s.getPercentComplete("JMC")).reduce(0.0, (Double::sum));

        double avgPercent = totalPercent / students.size();
        System.out.println("Java Sum Completion (avg): " + avgPercent);

        Set<Student> aboveAvg =
                students.stream()
                        .filter(s -> s.getPercentComplete("JMC") > 74)
                        .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                        .limit(10)
                        .collect(Collectors.toSet());
        System.out.println("Java Avg Completion (aboveAvg): " + aboveAvg);
    }
}
