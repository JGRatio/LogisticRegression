package Tools;
import java.awt.Color;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ScatterPlot extends JFrame {
    private static final long serialVersionUID = 6294689542092367723L;
    DataSet data;

    public ScatterPlot(String title, DataSet data) throws FileNotFoundException {
        super(title);
        this.data = data;

        XYDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createScatterPlot(
                "Scatter plot",
                "", "", dataset);


        XYPlot plot = (XYPlot)chart.getPlot();
        plot.setBackgroundPaint(new Color(255,228,196));


        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYDataset createDataset() throws FileNotFoundException {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("0");
        XYSeries series2 = new XYSeries("1");

            for (int i = data.getPlotData().length/ 2 ; i < data.getPlotData().length ; i++){
               series2.add(data.getPlotData()[i][0],data.getPlotData()[i][1]);
            }
        for (int i = 0 ; i < data.getPlotData().length / 2 ; i++){
            series1.add(data.getPlotData()[i][0],data.getPlotData()[i][1]);
        }

        dataset.addSeries(series1);
        dataset.addSeries(series2);

        return dataset;
    }
}
