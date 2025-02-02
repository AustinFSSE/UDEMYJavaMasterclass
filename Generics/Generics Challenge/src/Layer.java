import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable>{


    private ArrayList <T> layers;

    public Layer(T[] layers) {
        this.layers = new ArrayList<T>(List.of(layers));
    }

    public void addElements(T... elements) {
        layers.addAll(List.of(elements));
    }

    public void renderLayer() {
        for (T layer : layers) {
            layer.render();
        }
    }
}
