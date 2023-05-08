import java.awt.Color; 
import java.awt.BasicStroke; 

import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class GraficaXY extends ApplicationFrame {

   public GraficaXY( String applicationTitle, String chartTitle ) {
      super(applicationTitle);
      JFreeChart xylineChart = ChartFactory.createXYLineChart(
         chartTitle ,
         "Category" ,
         "Score" ,
         createDataset() ,
         PlotOrientation.VERTICAL ,
         true , true , false);
         
      ChartPanel chartPanel = new ChartPanel( xylineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      final XYPlot plot = xylineChart.getXYPlot( );
      
      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
      renderer.setSeriesPaint( 0 , Color.RED );
      renderer.setSeriesPaint( 1 , Color.GREEN );
      renderer.setSeriesPaint( 2 , Color.YELLOW );
      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
      renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
      renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
      plot.setRenderer( renderer ); 
      setContentPane( chartPanel ); 
   }
   
   private XYDataset createDataset( ) {
      final XYSeries opera = new XYSeries( "OperaGX" );          
      opera.add( 2007 , 25 );   
      opera.add( 2008 , 29.1 ); 
      opera.add( 2009 , 32.1 ); 
      opera.add( 2010 , 32.9 ); 
      opera.add( 2011 , 31.9 ); 
      opera.add( 2012 , 25.5 ); 
      opera.add( 2013 , 20.1 ); 
      opera.add( 2014 , 18.4 ); 
      opera.add( 2015 , 15.3 ); 
      opera.add( 2016 , 11.4 ); 
      opera.add( 2017 , 9.5 ); 
               
      
      final XYSeries google = new XYSeries( "Google" );  
      google.add( 2007 , 67.7 );   
      google.add( 2008 , 63.1 ); 
      google.add( 2009 , 60.2 ); 
      google.add( 2010 , 50.6 ); 
      google.add( 2011 , 41.1 ); 
      google.add( 2012 , 31.8 ); 
      google.add( 2013 , 27.6 ); 
      google.add( 2014 , 20.4 ); 
      google.add( 2015 , 17.3 ); 
      google.add( 2016 , 12.3 ); 
      google.add( 2017 , 8.1 ); 
          
      
      final XYSeries edge = new XYSeries( "MicrosoftEdge" );          
      edge.add( 2007 , 0.2 );   
      edge.add( 2008 , 6.4 ); 
      edge.add( 2009 , 14.6 ); 
      edge.add( 2010 , 25.3 ); 
      edge.add( 2011 , 30.1 ); 
      edge.add( 2012 , 34.3 ); 
      edge.add( 2013 , 43.2 ); 
      edge.add( 2014 , 47.3 ); 
      edge.add( 2015 , 58.4 ); 
      edge.add( 2016 , 56.2 ); 
      edge.add( 2017 , 51.3 );         
      
      final XYSeriesCollection dataset = new XYSeriesCollection( );          
      dataset.addSeries( opera );          
      dataset.addSeries( google );          
      dataset.addSeries( edge );
      return dataset;
   }

   public static void main( String[ ] args ) {
      GraficaXY chart = new GraficaXY("Buscadores mas usados",
         "Buscadores");
      chart.pack( );          
      RefineryUtilities.centerFrameOnScreen( chart );          
      chart.setVisible( true ); 
   }
}
