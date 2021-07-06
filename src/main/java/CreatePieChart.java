import java.text.DecimalFormat;
import java.util.List;

import javax.swing.*;

import org.apache.spark.sql.Row;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class CreatePieChart extends JFrame {
    private static final long serialVersionUID = 6294689542092367723L;

    public CreatePieChart(String title,List <Row> datalist) {
        super(title);

        // Create dataset
        PieDataset dataset = createDataset(datalist);

        // Create chart
        JFreeChart chart = ChartFactory.createPieChart(
                title,
                dataset,
                true,
                true,
                false);

        //Format Label
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }
    private PieDataset createDataset(List<Row> datalist) {

        DefaultPieDataset dataset=new DefaultPieDataset();
        for(int i=0;i<20;i++) {
            dataset.setValue(datalist.get(i).getString(0), datalist.get(i).getLong(1));
        }
        return dataset;
    }


}
