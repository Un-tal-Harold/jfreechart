import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GraficaSerieTiempo extends ApplicationFrame {
    
    public GraficaSerieTiempo(String title) {
        super(title);
    }
    
    private XYDataset createDataset() {
        final TimeSeries series = new TimeSeries("Datos aleatorios");
        Second current = new Second();
        double value = 100.0;
        
        for (int i = 0; i < 4000; i++) {
            try {
                value = value + Math.random() - 0.5;
                series.add(current, new Double(value));
                current = (Second) current.next();
            } catch (SeriesException e) {
                System.err.println("Error al agregar a la serie");
            }
        }
        
        return new TimeSeriesCollection(series);
    }
    
    private JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Mi serie de tiempo",
                "Segundos",
                "Valor",
                dataset,
                false,
                false,
                false);
        return chart;
    }
    
    public static void main(String[] args) {
        GraficaSerieTiempo demo = new GraficaSerieTiempo("Mi serie de tiempo");
        XYDataset dataset = demo.createDataset();
        JFreeChart chart = demo.createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        demo.setContentPane(chartPanel);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
