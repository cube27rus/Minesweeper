package core.view;

import core.models.ObjectInCase;
import core.controller.*;
/**
 * Created by Cube27 on 19.07.2017.
 * Выводить поле в консоль
 */
public class ConsoleView {
    public static void watchField(Field field){
        //в новый обьект стрингБилдера собираем значения каждого кейса поля
        // и выводим это на экран
        StringBuilder sb = new StringBuilder();
        int fieldSize = field.getSize();
         ObjectInCase[][] fieldInner = field.getField();
        for(int i=0;i<fieldSize;i++){
            for(int k=0;k<fieldSize;k++){
                if(fieldInner[i][k]!=null) {
                    sb.append(fieldInner[i][k]);
                }else{
                    sb.append(" ");
                }
                sb.append(" | ");
                if(k==fieldSize-1){
                    sb.append("\r\n");
                }
            }
            for(int v=0;v<fieldSize*4;v++){
                sb.append("-");
                if(v==fieldSize*4-1){
                    sb.append("\r\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
