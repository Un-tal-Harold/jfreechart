
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class GráficoCircular {

    public static void main(String[] args) {
        try {
            // Establecer la conexión con la base de datos
            String URL = "jdbc:mysql://aws.connect.psdb.cloud/ia-project?sslMode=VERIFY_IDENTITY";//si algo es el host
            String USER = "hfmw0r3dhv10taliwf04";
            String CLAVE = "pscale_pw_Ss4WJsoTlm7ihE2Knv50dIbkrg9krlYEIpAzNBF60me";
            Connection conn = DriverManager.getConnection(URL, USER, CLAVE);

            // Crear una sentencia SQL para seleccionar todos los datos de la tabla
            String sql = "SELECT * FROM vehiculos";

            // Ejecutar la sentencia SQL y obtener los resultados
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            DefaultPieDataset dataset = new DefaultPieDataset();

            // Recorrer los resultados e imprimirlos en la consola
            while (rs.next()) {
                String nombre = rs.getString("CLASE");
                int id = rs.getInt("Cantidad");
                dataset.setValue(nombre, id);
                // ... Obtener los valores de las demás columna
                System.out.println(id + ", " + nombre + ", ...");
            } 
            JFreeChart chart = ChartFactory.createPieChart(
                    "Venta de vehiculos del 2023 ", // chart title           
                    dataset, // data           
                    true, // include legend          
                    true,
                    false);

            int width = 570;
            /* Width of the image */
            int height = 380;
            /* Height of the image */
            File pieChart = new File("Grafica-sql.jpeg");
            try {
                ChartUtilities.saveChartAsJPEG(pieChart, chart, width, height);
            } catch (IOException ex) {
                    System.out.print(ex);
            }
            // Cerrar la conexión y liberar los recursos
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
