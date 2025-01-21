public class OverloadedMethodChallenge {

    public static double convertToCentimeters(double value) {
        return value * 2.54;
    }
    public static double convertToInches(int feet, int inches) {
        double value = (feet * 12) + inches;
        return convertToCentimeters(value);
    }

    public static void main(String[] args) {
        System.out.println(convertToCentimeters(68));
        System.out.println(convertToInches(5,8));
    }
}
