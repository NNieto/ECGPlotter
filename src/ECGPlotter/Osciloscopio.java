/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ECGPlotter;

/**
 *
 * @author Norman
 */
// fichero Osciloscopio.java
import java.applet.*;
import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Osciloscopio {
 
	private static Color COLOR_SERIE_1 = new Color(255, 128, 64);
 
	private static Color COLOR_SERIE_2 = new Color(28, 84, 140);
 
	private static Color COLOR_RECUADROS_GRAFICA = new Color(255, 255, 255);
 
	private static Color COLOR_FONDO_GRAFICA = Color.white;
 
	public JFreeChart crearGrafica(XYSeriesCollection dataset) {
 
		final JFreeChart chart = ChartFactory.createXYLineChart("ECG", "Tiempo", "Voltios", 
				dataset,
				PlotOrientation.VERTICAL, 
				true, // uso de leyenda
				false, // uso de tooltips  
				false // uso de urls
 				);
		// color de fondo de la gráfica
		chart.setBackgroundPaint(COLOR_FONDO_GRAFICA);
 
		final XYPlot plot = (XYPlot) chart.getPlot();
		configurarPlot(plot);
 
		final NumberAxis domainAxis = (NumberAxis)plot.getDomainAxis();
		configurarDomainAxis(domainAxis);
		
		final NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
		configurarRangeAxis(rangeAxis);
 
		final XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer)plot.getRenderer();
		configurarRendered(renderer);
 
		return chart;
	}
	
	// configuramos el contenido del gráfico (damos un color a las líneas que sirven de guía)
	private void configurarPlot (XYPlot plot) {
		plot.setDomainGridlinePaint(COLOR_RECUADROS_GRAFICA);
		plot.setRangeGridlinePaint(COLOR_RECUADROS_GRAFICA);
	}
	
	// configuramos el eje X de la gráfica (se muestran números enteros y de uno en uno)
	private void configurarDomainAxis (NumberAxis domainAxis) {
		domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		domainAxis.setTickUnit(new NumberTickUnit(10));
	}
	
	// configuramos el eje y de la gráfica (números enteros de dos en dos y rango entre 120 y 135)
	private void configurarRangeAxis (NumberAxis rangeAxis) {
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setTickUnit(new NumberTickUnit(10));
		rangeAxis.setRange(-50, 50);
	}
	
	// configuramos las líneas de las series (añadimos un círculo en los puntos y asignamos el color de cada serie)
	private void configurarRendered (XYLineAndShapeRenderer renderer) {
		renderer.setSeriesShapesVisible(0, false);
		//renderer.setSeriesShapesVisible(1, true);
		renderer.setSeriesPaint(0, COLOR_SERIE_1);
		//renderer.setSeriesPaint(1, COLOR_SERIE_2);
	}
}