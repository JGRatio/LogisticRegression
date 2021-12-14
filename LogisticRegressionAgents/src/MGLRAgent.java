import Tools.DataSet;
import Tools.Helper;
import Tools.ScatterPlot;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

import javax.swing.*;
import java.io.FileNotFoundException;

public class MGLRAgent extends Agent {
    DataSet data;
    MultipleGradientLogisticRegression g;
    public MGLRAgent() throws FileNotFoundException {

    }

    protected void setup() {
        // Create and show the GUI
        InputDialogBox myGui = new InputDialogBox(this);
        myGui.showGui();
        System.out.println("Hello world! I'm a OneShot Logistic Regression agent!");
        System.out.println("My local name is " + getAID().getLocalName());
        try {
            data = new DataSet("NBADataExample.csv"); //GeeksExample.csv Stephen Curry Stats.csv
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        g = new MultipleGradientLogisticRegression(data.getX(), data.getY());

        if(data.isPlotFile()){
            ScatterPlot plot = null;
            try {
                plot = new ScatterPlot("",data);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            plot.setSize(800, 400);
            plot.setLocationRelativeTo(null);
            plot.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            plot.setVisible(true);
        }


    }

    public void getX(final String x1) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                String [] inputS = x1.split(",");
                double [] input = new double[inputS.length];
                for (int i = 0 ; i < inputS.length ; i++) input[i] = Double.parseDouble(inputS[i]);
                Helper helper = new Helper();
                System.out.println("\nTest result: "+Math.round(helper.predict(input,g.getWs())));
            }
        });

    }
}
