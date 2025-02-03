public class Main {
    public static void main(String[] args) {


        var nationalUSParks = new Parks[] {
                new Parks("Yellowstone", "44.4882, -110.5916"),
                new Parks("Grand Canyon", "36.1085, -112.0965"),
                new Parks("Yosemite", "37.8855, -119.5360")
        };
        Layer<Parks> parkLayer = new Layer<Parks>(nationalUSParks);
        parkLayer.renderLayer();

        var majorUSRivers = new Rivers[] {
                new Rivers("Mississippi", "47, -95", "29, -89"),
                new Rivers("Missouri", "45, -111", "38, -90")
        };
        Layer<Rivers> riversLayer = new Layer<Rivers>(majorUSRivers);
        riversLayer.addElements(
                new Rivers("Colorado", "40, -105", "31, -114"),
                new Rivers("Delaware", "42, -75", "39, -75"));

        riversLayer.renderLayer();
    }
}