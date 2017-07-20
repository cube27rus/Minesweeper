package core.models;

/**
 * Created by Cube27 on 19.07.2017.
 */
public class ObjectInCase {
    //класс устанавливаем содержимое ячейки(возможно лучше делать enum)
    private static String modelMine = "X";//дефолт того, что устаналвиваем в ячейку
    private String thatInCase = modelMine;

    public ObjectInCase() {

    }

    public ObjectInCase(String objectToSet) {
        this.thatInCase = objectToSet;
    }

    public static String getModel() {
        return ObjectInCase.modelMine;
    }

    public String toString() {
        return thatInCase;
    }
}
