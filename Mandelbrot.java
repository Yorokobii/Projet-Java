/**
    Projet JAVA - IUT Arles 2015/2016
    BOEHM Guillaume & HECKEL Thibault

    Classe Mandelbrot : contient tous les éléments nécessaires à la contruction de notre fractale (ensemble de mandelbrot).
*/

// Liste import :
import java.awt.Color;

public class Mandelbrot {
    // Point à zoomer
    private static double xPaint;   // Coordonnée x (Partie réelle du nombre complexe à dessiner)
    private static double yPaint;   // Coordonnée y (Partie imaginaire du nombre complexe à dessiner)
    // Accesseurs & Mutateurs des
    public double getXPaint() { return xPaint; }
    public double getYPaint() { return yPaint; }
    public void setXPaint(double _xPaint) { xPaint = _xPaint; }
    public void setYPaint(double _yPaint) { yPaint = _yPaint; }

	// Couleur
    public static Color basecolor;
    public Color colorTab []; // Tableau de couleur nécessaire pour le dégradé de couleur (pour la colorisation de la fractale)
    private Color color;
	public Color getColor() { return color; }
	public void setColor(Color _color) { color = _color; }

    // Zoom
    private static long zoom;
    public long getZoom() { return zoom; }
    public void setZoom(long z) { zoom = z; }
    private int ratiozoom = 30;
    public int getRatio() { return ratiozoom; }
    public void setRatio(int ratio) { ratiozoom = ratio; }

    // Nombre d'itérations
    private static int iterMax;
    public int getiNumber() { return iterMax; }
    public void setiNumber(int i) { iterMax = i; }

    // z & c : Real / Imaginary
    private double zReal;
    private double zImag;
    private double cReal;
    private double cImag;

    public double getzr() { return zReal; }
    public double getzi() { return zImag; }
    public double getcr() { return cReal; }
    public double getci() { return cImag; }

    public void setzr(double zr) { zReal = zr; }
    public void setzi(double zi) { zImag = zi; }
    public void setcr(double cr) { cReal = cr; }
    public void setci(double ci) { cImag = ci; }

    // Constructeur avec paramètres
    public Mandelbrot(int _iterMax, long _zoom){
        iterMax = _iterMax;
        zoom = _zoom;
        xPaint = -0.743643887037151;
        yPaint = 0.13182590420533;
        basecolor = new Color(0,255,0);
    }

    // Constructeur sans paramètres
    public Mandelbrot() { }
}
