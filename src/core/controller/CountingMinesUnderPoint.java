package core.controller;

import core.models.ObjectInCase;
import core.view.Field;

/**
 * Created by Cube27 on 19.07.2017.
 */
public class CountingMinesUnderPoint {
    //функция нужна для подсчета мин вокруг выбранной точки
    public static int count(int pointY, int pointX, Field field) {
        Field innerField = field;
        int count = 0;
        //следим чтобы итерация не вышла за пределы размеров минного поля
        int startYPoint = pointY - 1 < 0 ? 0 : pointY - 1;
        int startXPoint = pointX - 1 < 0 ? 0 : pointX - 1;

        int finishYPoint = pointY + 1 > field.getSize() - 1 ? field.getSize() - 1 : pointY + 1;
        int finishXPoint = pointX + 1 > field.getSize() - 1 ? field.getSize() - 1 : pointX + 1;

        // если указали точку с миной
        if (innerField.getMineOnPoint(pointY, pointX) != null) {
            return -1;
        }

        for (int i = startYPoint; i <= finishYPoint; i++) {
            for (int k = startXPoint; k <= finishXPoint; k++) {
                //Считаем количество мин вокруг точки
                if (i != pointY || k != pointX) {
                    if (innerField.getMineOnPoint(i, k) != null && innerField.getMineOnPoint(i, k).toString().equals(ObjectInCase.getModel())) {
                        count++;
                    }
                }
            }
        }


        return count;
    }
}
