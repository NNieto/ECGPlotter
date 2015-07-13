// fichero Osciloscopio.java
import java.applet.*;
import java.awt.*;

public class Osciloscopio extends Applet {
	// variables miembro
    int n=5;
    double X=100;
    double T=n*2*Math.PI;
    double omega=2*Math.PI*n/T;
    double fi=0;
    int nInt=100;
    double delta=T/nInt;
    Dimension d;
    
    public void start() {
        d = this.getSize();
    }
    
    public void paint(Graphics g) {
        double x, y, xn, yn;
        int w = d.width, h = d.height/2;
        double fact=w/T;
        x=0; y=f(0);
        for (int i=0; i<nInt; i++) {
            xn=x+delta; yn=f(xn);
            g.drawLine((int)(x*fact), h-(int)y, (int)(xn*fact), h-(int)yn);
            x=xn; y=yn;
        }
    }
    
    public double f(double x) {
        return X*Math.sin(omega*x+fi);
    }

}// fin clase Oscilosopio
