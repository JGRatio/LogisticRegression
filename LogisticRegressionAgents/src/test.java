/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Tools.DataSet;
import Tools.ScatterPlot;

import javax.swing.*;
import java.io.FileNotFoundException;

/**
 *
 * @author Julio J. Castillo
 */

public class test {

    public static void main(String[] args) throws FileNotFoundException {

        DataSet m = new DataSet( "Stephen Curry Stats.csv");  //GeeksExample.csv Stephen Curry Stats.csv
        MultipleGradientLogisticRegression g = new MultipleGradientLogisticRegression(m.getX(), m.getY());
        if(m.isPlotFile()){
            ScatterPlot plot = new ScatterPlot("",m);
            plot.setSize(800, 400);
            plot.setLocationRelativeTo(null);
            plot.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            plot.setVisible(true);
        }






    }
    
}
