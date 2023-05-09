import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class GraficaPastel extends ApplicationFrame {
   
   public GraficaPastel( String title ) {
      super( title ); 
      setContentPane(createDemoPanel( ));
   }
   
   private static PieDataset createDataset( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "Sobrepeso" , new Double( 8.1 ) );  
      dataset.setValue( "Obesidad" , new Double( 9.6 ) );   
      dataset.setValue( "Riesgo de subnutricion" , new Double( 16.4 ) );    
      dataset.setValue( "Normopeso" , new Double( 65.9 ) );  
      return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Percepción y medidas de los padres entorno a la nutrición de sus hijos",   
         dataset,             
         true,               
         true, 
         false);

      return chart;
   }
   
   public static JPanel createDemoPanel( ) {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }

   public static void main( String[ ] args ) {
      GraficaPastel demo = new GraficaPastel( "Nutricion en niños españoles" );  
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
   }
}
