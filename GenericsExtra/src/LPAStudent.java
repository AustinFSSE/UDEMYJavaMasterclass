import java.util.Comparator;

public class LPAStudent extends Student implements QueryItem, Comparator<LPAStudent> {

    private double percentComplete;

    public LPAStudent() {
        percentComplete = random.nextDouble(0, 100.001);

    }
    public double getPercentComplete() {
        return percentComplete;
    }
    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        if (fieldName.equals("PercentComplete")) {
            return percentComplete <= Double.parseDouble(value);
        }
        return super.matchFieldValue(fieldName, value);
    }

    @Override
    public int compare(LPAStudent o1, LPAStudent o2) {
        if (o1.getPercentComplete() > o2.getPercentComplete()) {
            return 1;
        }
        if (o1.getPercentComplete() < o2.getPercentComplete()) {
            return -1;
        }
        return 0;
    }
}
