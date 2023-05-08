import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class GraficaPastel2 extends ApplicationFrame {
   
   public GraficaPastel2( String title ) {
      super( title ); 
      setContentPane(createDemoPanel( ));
   }
   
   private static PieDataset createDataset( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "No consume" , new Double( 18 ) );  
      dataset.setValue( "Una o dos veces" , new Double( 60.7 ) );   
      dataset.setValue( "Tres a cinco veces" , new Double( 18.1 ) );    
      dataset.setValue( "Mas de cinco veces" , new Double( 3.2 ) );  
      return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Veces que su hijo consumio comida rapida en el ultimo mes",   
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
      GraficaPastel2 demo = new GraficaPastel2( "Nutricion en niños Colombianos" );  
      demo.setSize( 700 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
   }
}