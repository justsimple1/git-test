package ru.job4j.array;
/**
 *
 * Class where check by diagonal is mono .
 *
 * @author NikPanin .
 * @since 06.06.2018 .
 * @version 1 .
 */
public class MatrixCheck {
    /**
     * Method for check diagonal.
     * @param - values of dimensional-array.
     * @return - result true or false, what elements in diagonal is mono.
     */
    public boolean mono(boolean[][] data){
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            for(int j = 0; j < data.length; j++) {
                if((i+j)%2==0 && data[data.length-1][data.length-1] != data[i][j]){
                    result = false;
                    break;
                }
            }
        }return result;
    }
}
