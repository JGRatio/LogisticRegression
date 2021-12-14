package Tools;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class DataSet {
    private double[][] x;
    private double[][] y;
    private double[][] plotData;
    private boolean plotFile;
    public String csvFileName;
    int skipLines = 1;

    public DataSet(String filename) throws FileNotFoundException {
        csvFileName = filename;

           readMultipleData();
           plotSimpleData();
    }

    public double[][] getPlotData() {
        return plotData;
    }

    public boolean isPlotFile() {
        return plotFile;
    }

    public void readMultipleData() {
        try {
            FileReader filereader = new FileReader("C:\\Users\\elcam\\IdeaProjects\\LogisticRegressionAgents\\src\\DataCSV\\"+csvFileName);
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(skipLines).build();
            List<String[]> allData = csvReader.readAll();
            double dataReader [][] = new double[allData.size()][allData.get(0).length];
            for (int i = 0 ; i < allData.size(); i++){
                String[] row = allData.get(i);
                for (int j = 0 ; j < allData.get(0).length ; j++) {
                    dataReader[i][j] = Double.parseDouble(row[j]);
                }
            }
            x = new double[dataReader.length][dataReader[0].length - 1];
            for (int i = 0; i < dataReader.length; i++) {
                for (int j = 0; j < dataReader[0].length - 1 ; j++) {
                    x[i][j] = dataReader[i][j];
                }
            }
            y = new double[dataReader.length][1];

            for(int i = 0 ; i < y.length ; i++){
                y[i][0] = dataReader[i][dataReader[0].length - 1];
            }


            System.out.println(x.length + " Records    " + (x[1].length-1) + " Features");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void plotSimpleData() {
        try {
            FileReader filereader = new FileReader("C:\\Users\\elcam\\IdeaProjects\\LogisticRegressionAgents\\src\\PlotCSV\\"+csvFileName);
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(skipLines).build();
            List<String[]> allData = csvReader.readAll();
            double dataReaderX [][] = new double[allData.size()][2];
            for (int i = 0 ; i < allData.size(); i++){
                String[] row = allData.get(i);
                dataReaderX[i][0] = Double.parseDouble(row[0]);
                dataReaderX[i][1] = Double.parseDouble(row[1]);
            }
            plotData = dataReaderX;
            plotFile = true;

        }
        catch (FileNotFoundException e) {
            System.out.println("No plot data file");
            plotFile = false;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public double[][] getX() {
        return x;
    }

    public double[][] getY() {
        return y;
    }

}
