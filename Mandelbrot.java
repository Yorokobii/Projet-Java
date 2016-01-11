/**
    Projet JAVA - IUT Arles 2015/2016
    BOEHM Guillaume & HECKEL Thibault

    Classe Mandelbrot : contient tous les éléments nécessaires à la contruction de notre fractale (ensemble de mandelbrot).
*/

// Liste import :
import java.awt.Color;

public class Mandelbrot {
    /** Point à zoomer, Point cliqué dans notre JPanel */
    private static double xPaint;   // Coordonnée x (Partie réelle du nombre complexe à dessiner) - Ce membre est static, sa modification touche donc l'ensemble du programme.
    private static double yPaint;   // Coordonnée y (Partie imaginaire du nombre complexe à dessiner)

    /** Accesseurs & Mutateurs des coordoonées */
    public double getXPaint() { return xPaint; }
    public double getYPaint() { return yPaint; }
    public void setXPaint(double _xPaint) { xPaint = _xPaint; }
    public void setYPaint(double _yPaint) { yPaint = _yPaint; }

	/** Couleur */
    public static Color basecolor;                             // Représente la couleur de base demandée pour notre fractale
    public Color colorTab [];                                  // Tableau de Color nécessaire pour le dégradé de couleur (colorisation de la fractale)
    public static boolean multiple_color;                      // Booléen en relation avec la classe RGBDialog et PaintArea - Permet un choix de colorisation
    private Color color;                                       // Couleur variable selon l'intensité du pixel
	public Color getColor() { return color; }                  // Accesseur
	public void setColor(Color _color) { color = _color; }     // Mutateur

    /** Zoom */
    private static long zoom;                                   // Zoom exprimé en "long", lui aussi static
    public long getZoom() { return zoom; }                      // Accesseur
    public void setZoom(long z) { zoom = z; }                   // Mutateur
    private int ratiozoom = 30;                                 // Ratio donnant le "pas" de notre zoom. Plus il est grand, plus nous avançons petit à petit
    public int getRatio() { return ratiozoom; }                 // Accesseur
    public void setRatio(int ratio) { ratiozoom = ratio; }      // Mutateur

    /** Nombre d'itérations */
    private static int iterMax;                                 // Le nombre d'itérations demandé, ou encore la précision de notre fractale
    public int getiNumber() { return iterMax; }                 // Accesseur
    public void setiNumber(int i) { iterMax = i; }              // Mutateur

    /** Nombre complexe */
    private double zReal;   // Partie réelle du nombre complexe z
    private double zImag;   // Partie imaginaire du nombre complexe z
    private double cReal;   // Partie réelle du nombre complexe c
    private double cImag;   // Partie imaginaire du bombre complexe c

    public double getzr() { return zReal; }
    public double getzi() { return zImag; }
    public double getcr() { return cReal; }
    public double getci() { return cImag; }

    public void setzr(double zr) { zReal = zr; }
    public void setzi(double zi) { zImag = zi; }
    public void setcr(double cr) { cReal = cr; }
    public void setci(double ci) { cImag = ci; }

    /** Constructeur avec paramètres */
    public Mandelbrot(int _iterMax, long _zoom){
        iterMax = _iterMax;
        zoom = _zoom;
        xPaint = -0.743643887037151;
        yPaint = 0.13182590420533;
        basecolor = new Color(0,255,0);
        multiple_color = true;
    }

    /** Constructeur sans paramètres */
    public Mandelbrot() { }
}
