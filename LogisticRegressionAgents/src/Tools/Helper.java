package Tools;

public class Helper {

    public static double sigmoid(double x) {



        return 1 / (1 + Math.exp(-x));
    }

    public static double sigmoid(int position,double [] weights,double [][] x) {
        double result = 0;
        for (int i = 0; i < x[0].length; i++) {

            result += weights[i] * x[position][i];

        }

        return 1 / ( 1 + Math.exp(-result));
    }

    public static void print(double[] data){
        System.out.print("Regression model weights: ");
        for(int i=0;i< data.length;i++){
            System.out.print("W"+ i + "=" + data[i]);
            System.out.print(" ");
        }
    }

    public static double predict(double[] data, double [] Ws){
        double sum = Ws[0];
        for(int i = 0 ; i < Ws.length-1 ; i++){
          sum+= Ws[i+1] * data[i];
        }
        return sigmoid(sum);
    }

}
