/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nora Aguirre
 * Códgio 213400059
 */
import java.util.Scanner;

public class SLR {   
    
    private static double a;
    private static double b;
    //Variables para determinar las constantes
    private static double xAvg;
    private static double yAvg;

    //Constructor
    public SLR(){
        a = 0;
        b = 0;
        xAvg = 0;
        yAvg = 0;
    }

    public static void train(double[][] data){
        xAvg = 0;
        yAvg = 0;
        for (double[] reg : data){
            xAvg += reg[0];
            yAvg += reg[1];
        }
        xAvg = xAvg / data.length;
        yAvg = yAvg / data.length;
        
        double aux1 = 0;
        double aux2 = 0;
        
        for (double[] reg : data){
            aux1 += ((reg[0] - xAvg) * (reg[1] - yAvg));
            aux2 += (reg[0] - xAvg)*(reg[0] - xAvg);
        }
        a = aux1 / aux2;
        System.out.println("Valor de a: "+ a);

        b = yAvg - a * xAvg;
        System.out.println("Valor de b: "+ b);

        System.out.println(String.format("y_est = %.2f + %.2fx", b, a));
    }

    //Method for predict given x
    public static double predict(double x){
        return b + a * x;
    }

    //Method for predict an array X
    public static double[] predict(double[] X){
        double[] y = new double[X.length];
        int i = 0;
        for(double x : X){
            y[i] = predict(x);
            i++;
        }
        return y;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        double[][] dataSet = {
        {23, 651},
        {26, 762},
        {30, 856},
        {34, 1063},
        {43, 1190},
        {48, 1298},
        {52, 1421},
        {57, 1440},
        {58, 1518}
        };
        
        SLR slr = new SLR();
        slr.train(dataSet);
        
        System.out.println("Inserta el valor de X para predecir Y:");
        double xVal = scn.nextDouble();
        double yHat = slr.predict(xVal);
        System.out.println("Usando el valor de X " + xVal + " el valor de Y es: " + yHat);
    }
}
