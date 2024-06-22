import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CovidGraph extends ApplicationFrame {

    public CovidGraph(String title) {
        super(title);
        JFreeChart xylineChart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(xylineChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        final XYPlot plot = xylineChart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        plot.setRenderer(renderer);
        setContentPane(chartPanel);
    }

    private XYSeriesCollection createDataset() {
        XYSeries casesSeries = new XYSeries("Cases");
        XYSeries deathsSeries = new XYSeries("Deaths");

        String csvFile = "covid_data.csv";
        String line;
        String csvSplitBy = ",";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                Date date = dateFormat.parse(data[0]);
                double dateInMillis = date.getTime();
                int cases = Integer.parseInt(data[1]);
                int deaths = Integer.parseInt(data[2]);
                casesSeries.add(dateInMillis, cases);
                deathsSeries.add(dateInMillis, deaths);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(casesSeries);
        dataset.addSeries(deathsSeries);
        return dataset;
    }

    private JFreeChart createChart(XYSeriesCollection dataset) {
        return ChartFactory.createXYLineChart(
                "COVID-19 Cases and Deaths",
                "Date",
                "Number",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
    }

    public static void main(String[] args) {
        CovidGraph chart = new CovidGraph("COVID-19 Data");
        chart.pack();
        chart.setVisible(true);
    }
}