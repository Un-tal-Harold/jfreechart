import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class GraficaBar extends ApplicationFrame {
   
   public GraficaBar( String applicationTitle , String chartTitle ) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Categoria",            
         "Score",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   
   private CategoryDataset createDataset( ) {
      final String r = "Riesgo de subnutricion";        
      final String n = "Normopeso";        
      final String s = "Sobrepeso"; 
      final String o = "Obesidad";  
      final String nh = "No dedica ni una hora";        
      final String nd = "Hasta 2 horas";        
      final String md = "Mas de 2 horas";             
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      dataset.addValue( 15.9 , r , nh );        
      dataset.addValue( 31.7 , r , nd );        
      dataset.addValue( 52.4 , r , md );           

      dataset.addValue( 12.8 , n , nh );        
      dataset.addValue( 31.8 , n , nd );       
      dataset.addValue( 55.4 , n , md );        

      dataset.addValue( 16.1 , s , nh );        
      dataset.addValue( 31.4 , s , nd );        
      dataset.addValue( 52.5 , s , md );         
      
      dataset.addValue( 12.8 , o , nh );        
      dataset.addValue( 35.8 , o , nd );        
      dataset.addValue( 51.4 , o , md );           

      return dataset; 
   }
   
   public static void main( String[ ] args ) {
      GraficaBar chart = new GraficaBar("Actividad Fisica", 
         "¿Cuantas horas dedica su hijo a una actividad fisica?");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }
}
