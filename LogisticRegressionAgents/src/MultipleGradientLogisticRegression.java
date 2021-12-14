/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Tools.Helper;

/**
 *
 * @author Julio J. Castillo
 */
class MultipleGradientLogisticRegression {
    Helper helper = new Helper();
    private double[][] x;
    private double[][] y;

    public MultipleGradientLogisticRegression(double [][] x , double [][] y) {
        this.x = x;
        this.y = y;
        Ws = new double[x[0].length];
        calculate();
    }

    double[] Ws;
    private double alpha = 0.1;

    public double[] getWs() {
        return Ws;
    }




    private boolean isConverged() {

        for (int i = 0; i < x.length; i++) {
            float x1 = Math.round(helper.sigmoid(Ws[0] * x[i][0] + Ws[1] * x[i][1] + Ws[2] * x[i][2]));
            if (x1 != y[i][0]) {
                return false;
            }
        }
        return true;
    }

    public void calculate() {
        int count = 0;
        //while (!isConverged()){
        while (count < 100) {
        double[] NeWs = new double[x[0].length];
        double summatory = 0;
            for (int j = 0; j < x[1].length; j++) {

                for (int i = 0; i < x.length; i++) {
                    summatory +=((helper.sigmoid(i,Ws,x))  - y[i][0] ) * x[i][j];
                }
                NeWs[j] = Ws[j] - alpha * summatory;
                summatory = 0;
            }
            for (int n = 0; n < x[1].length; n++) {
                Ws[n] = NeWs[n];
            }

         count++;
        }
        System.out.println("Number of iterations : " + count);
        helper.print(Ws);

    }
}




