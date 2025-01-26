

public class Main {



    public static void main(String[] args) {

        EnumChallenge weekendDay  = EnumChallenge.WEDNESDAY;

        System.out.println(weekendDay.name() + " <- name : index value -> " + weekendDay.ordinal());
        System.out.println("-".repeat(40));
        System.out.println(getRandomDay());
        System.out.println("-".repeat(40));
        for (Topping topping : Topping.values()) {
            System.out.println(topping.name() + " : " + topping.getaPrice());
        }
    }
    public static EnumChallenge getRandomDay() {

        int randomDay = (int)(Math.random()*7);
        var allDays = EnumChallenge.values();
        return allDays[randomDay];
    }
}