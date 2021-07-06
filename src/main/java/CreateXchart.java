import org.apache.spark.sql.Row;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.List;

public class CreateXchart {
    public void createBarChart(List<Row> datalist, String title, String xlabel, String ylabel, String seriesName){
    CategoryChart chart = new CategoryChartBuilder().width(1024).height(768).title(title).xAxisTitle(xlabel).yAxisTitle(ylabel).build();

    chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideE);
    chart.getStyler().setHasAnnotations(true);

    List<String> names = new ArrayList<>();
    List<Long> counts= new ArrayList<>();
    for (int i=0;i<20;i++){
        names.add(datalist.get(i).getString(0));
        counts.add(datalist.get(i).getLong(1));
    }


    chart.addSeries(seriesName,names,counts);

    new SwingWrapper(chart).displayChart();
    }

}
