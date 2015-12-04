/**
La classe Mandelbrot

SUJET :
On souhaite écrire un programme en Java permettant de calculer et d'afficher une fractale portant pour nom l'ensemble de Mandelbrot.

Pour savoir si un point complexe c du plan appartient à l'ensemble de Mandelbrot, on lui fait subir la transformation suivante selon un nombre d'itération fixé :
zn = z2n+1+c

zn, zn+1 et c sont des nombres complexes. On débute avec z0 = 0, c étant le point étudié. Si au terme de ces itérations le module de zn est inférieur ou égal à 2, alors il est probable qu'il appartienne à l'ensemble de Mandelbrot (la certitude augmente avec le nombre d'itérations). Si le module dépasse 2 avant la dernière itération, alors il y a certitude que ce point n'appartient pas à l'ensemble.

On devra pouvoir choisir le nombre d'itérations, zoomer ou dézoomer à la souris sur une partie de la fractale. La fractale devra occuper toute la surface de la fenêtre, même si on l'aggrandit ou la réduit.

http://sdz.tdct.org/sdz/dessiner-la-fractale-de-mandelbrot.html

*/

public class Mandelbrot {

    //Bornes de la fractale
    // L'ensemble de Mandelbrot est toujours compris entre -2.1 et 0.6 sur l'axe des abscisse et entre -1.2 et 1.2 sur l'axe des ordonnées
    private final double xOne = -2.1;
    private final double xTwo = 0.6;
    private final double yOne = -1.2;
    private final double yTwo = 1.2;

    private double width = 0; // largeur de dessin
    private double height = 0; // hauteur de dessin


    /** Il s'agit ici d'écrire en Java cZn+1 = Zn² + cZ0 = 0
        soit z = z² + c
        On sépare la partie imaginaire de z et c, nous avons donc deux variables pour z et c
    */

    private double zReal = 0; // zr = zr² - zi² + cr
    private double zImg = 0; // zi = 2*zr*zi + ci

    private double cReal = 0;
    private double cImg = 0;
// ________________________

    private double zoom; // à définir selon la molette
    private static double iterationNumber; // Nombre d'itération

    /* Variable pour récupérer la position de la souris à l'écran */
    /* Récupérer la taille de la fenêtre */

    public Mandelbrot() { zoom = 2; width = xTwo - xOne; height = yTwo - xTwo; }



    // Getter des bornes de la fractale
    public double getxOne() { return xOne; }
    public double getyOne() { return yOne; }
    public double getxTwo() { return xTwo; }
    public double getyTwo() { return yTwo; }

    public double gzr() { return zReal; }
    public double gzi() { return zImg; }
    public double gcr() { return cReal; }
    public double gci() { return cImg; }

    public void szr(double zr) { zReal = zr; }
    public void szi(double zi) { zImg = zi; }
    public void sci(double ci) { cImg = ci; }
    public void scr(double cr) { cReal = cr; }

    public double gZoom() { return zoom; }
    public void sZoom(double z) { zoom = z; }

    /* ->>> En construction
        public double getZoom()
    */

    public double getiNumber() { return iterationNumber; }
    public void setiNumber(double i) { iterationNumber = i; }

    // Accesseurs et Mutateurs hauteur et largeur de dessin
    public double getW() { return width; }
    public double getH() { return height; }

    public void setW(double w) { width = w; }
    public void setH(double h) { height = h; }


}
