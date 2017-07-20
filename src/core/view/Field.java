package core.view;

import core.models.ObjectInCase;

/**
 * Created by Cube27 on 19.07.2017.
 * Класс для хранения и использования игрового поля
 */
public class Field {
    private int fieldSize;
    private ObjectInCase[][] field;

    public Field() {
        this(5);

    }

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        field = new ObjectInCase[fieldSize][fieldSize];
        //инициализируем (чем угодно)
        for (int i = 0; i < fieldSize; i++) {
            for (int k = 0; k < fieldSize; k++) {
                field[i][k] = null;
            }
        }

    }
    //получить размер поля
    public int getSize() {
        return fieldSize;
    }
    //получить поле
    public ObjectInCase[][] getField() {
        return (ObjectInCase[][]) field;
    }
    //получить содержимое
    public ObjectInCase getMineOnPoint(int y, int x) {
        return (ObjectInCase) field[y][x];
    }
    //установить мину
    public boolean setObjectInCase(int y, int x, ObjectInCase objectInCase) {
        if (this.field[y][x] == null) {
            this.field[y][x] = objectInCase;
            return true;
        }
        return false;
    }
    //вывести поле на экран(Лучше исполььзовать ConsoleView)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < fieldSize; i++) {
            for (int k = 0; k < fieldSize; k++) {
                if (field[i][k] != null) {
                    sb.append(field[i][k]);
                } else {
                    sb.append(" ");
                }
                sb.append(" | ");
                if (k == fieldSize - 1) {
                    sb.append("\r\n");
                }
            }
            for (int v = 0; v < fieldSize * 4; v++) {
                sb.append("-");
                if (v == fieldSize * 4 - 1) {
                    sb.append("\r\n");
                }
            }
        }
        return sb.toString();
    }

}
