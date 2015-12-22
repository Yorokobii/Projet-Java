/***
La classe Mandelbrot

SUJET :
On souhaite écrire un programme en Java permettant de calculer et d'afficher une fractale portant pour nom l'ensemble de Mandelbrot.

Pour savoir si un point complexe c du plan appartient à l'ensemble de Mandelbrot, on lui fait subir la transformation suivante selon un nombre d'itération fixé :
zn = z2n+1+c

zn, zn+1 et c sont des nombres complexes. On débute avec z0 = 0, c étant le point étudié. Si au terme de ces itérations le module de zn est inférieur ou égal à 2, alors il est probable qu'il appartienne à l'ensemble de Mandelbrot (la certitude augmente avec le nombre d'itérations). Si le module dépasse 2 avant la dernière itération, alors il y a certitude que ce point n'appartient pas à l'ensemble.

On devra pouvoir choisir le nombre d'itérations, zoomer ou dézoomer à la souris sur une partie de la fractale. La fractale devra occuper toute la surface de la fenêtre, même si on l'aggrandit ou la réduit.

http://sdz.tdct.org/sdz/dessiner-la-fractale-de-mandelbrot.html

*/
import java.awt.Color;

public class Mandelbrot {
    // Bornes de dessin de la fractale
    private final double xOne = -2.1;
    private final double xTwo = 0.6;
    private final double yOne = -1.2;
    private final double yTwo = 1.2;

    public final double getxo() { return xOne; }
    public final double getxt() { return xTwo; }
    public final double getyo() { return yOne; }
    public final double getyt() { return yTwo; }

    //Point à zoomer
    private static double xPaint;
    private static double yPaint;

    public final double getXPaint() { return xPaint; }
    public final double getYPaint() { return yPaint; }
    public void setXPaint(final double _xPaint) { xPaint = _xPaint; }
    public void setYPaint(final double _yPaint) { yPaint = _yPaint; }

	//Couleur
	private Color color;

	public Color getColor() { return color; }
	public void setColor(Color _color) { color = _color; }

    // Zoom
    private static long zoom;
    public long getZoom() { return zoom; }
    public void setZoom(long z) { zoom = z; }

    // Nombre d'itérations
    private static int iterMax;
    public int getiNumber() { return iterMax; }
    public void setiNumber(int i) { iterMax = i; }

    // Hauteur & Largeur
    public double getWidth() { return (xTwo - xOne)* zoom; }
    public double getHeight() { return (yTwo - yOne)* zoom; }

    // z & c Real & Imaginary
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
    }

    // Constructeur sans paramètres
    public Mandelbrot() { }
}
