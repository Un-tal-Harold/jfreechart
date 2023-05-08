import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.BubbleRenderer;
import org.jfree.data.xy.DefaultXYZDataset;

public class BubbleChartExample extends JFrame {

    public BubbleChartExample() {
        super("Bubble Chart Example");

        // Crear el conjunto de datos
        DefaultXYZDataset dataset = new DefaultXYZDataset();
        double[][] data = new double[3][3];
        data[0] = new double[] { 1, 2, 3 };
        data[1] = new double[] { 1, 2, 3 };
        data[2] = new double[] { 10, 20, 30 };
        dataset.addSeries("Series1", data);

        // Crear el objeto BubbleRenderer
        BubbleRenderer renderer = new BubbleRenderer();

        // Definir la escala del tamaño de la burbuja
        renderer.setBaseSize(5);

        // Crear el objeto XYPlot y agregar el conjunto de datos y el objeto BubbleRenderer
        JFreeChart chart = ChartFactory.createBubbleChart(
            "Bubble Chart", // título del gráfico
            "X Axis", // etiqueta del eje x
            "Y Axis", // etiqueta del eje y
            dataset, // conjunto de datos
            PlotOrientation.VERTICAL, // orientación del gráfico
            true, // leyenda
            true, // tooltips
            false // URLs
        );
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setRenderer(renderer);

        // Mostrar el gráfico en un componente ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BubbleChartExample();
    }
}

