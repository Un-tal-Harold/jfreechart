import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class GraficaArchivo {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("datos.txt"));


        DefaultPieDataset dataset = new DefaultPieDataset();


        String line;
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            String label = tokenizer.nextToken();
            double value = Double.parseDouble(tokenizer.nextToken());
            dataset.setValue(label, value);
        }


        JFreeChart chart = ChartFactory.createPieChart("Percepción y medidas de los padres entorno a la nutrición de sus hijos", dataset, true, true, false);

    
        ChartUtilities.saveChartAsJPEG(new java.io.File("GraficaArchivo.jpg"), chart, 800, 600);
    }
}

