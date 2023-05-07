
import java.io.*;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;

public class GráficoLinial {

    public static void main(String[] args) throws Exception {

        float voltage = Float.parseFloat(JOptionPane.showInputDialog("Ingrese valor del voltage:"));
        int op = 0;
        DefaultCategoryDataset line = new DefaultCategoryDataset();
        do {
            float resistencia = Float.parseFloat(JOptionPane.showInputDialog("Ingrese valor de la resistencia:"));
            float corriente = voltage / resistencia;
            op =Integer.parseInt( JOptionPane.showInputDialog("¿Desea ingresar un nuevo dato de voltage?(s=0,n=1)"));
            line.addValue(corriente, "Corriente",Float.toString(resistencia));   
            System.out.print(corriente);
        } while (op != 1);
        

        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Resistencia Vs Corriente con un voltage "+ voltage, "Resistencia",
                "Corriente",
                line, PlotOrientation.VERTICAL,
                true, true, false);

        int width = 640;
        /* Width of the image */
        int height = 480;
        /* Height of the image */
        File lineChart = new File("Resistencia Vs Corriente.jpeg");
        ChartUtilities.saveChartAsJPEG(lineChart, lineChartObject, width, height);
    }
}
