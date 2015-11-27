/**
La classe Mandelbrot sert de classe Principal
C'est dans cette dernière que l'on appelera les fonctions de dessins et tracés
déclarée dans d'autres classes.

SUJET :
On souhaite écrire un programme en Java permettant de calculer et d'afficher une fractale portant pour nom l'ensemble de Mandelbrot.

Pour savoir si un point complexe c du plan appartient à l'ensemble de Mandelbrot, on lui fait subir la transformation suivante selon un nombre d'itération fixé :
zn = z2n+1+c

zn, zn+1 et c sont des nombres complexes. On débute avec z0 = 0, c étant le point étudié. Si au terme de ces itérations le module de zn est inférieur ou égal à 2, alors il est probable qu'il appartienne à l'ensemble de Mandelbrot (la certitude augmente avec le nombre d'itérations). Si le module dépasse 2 avant la dernière itération, alors il y a certitude que ce point n'appartient pas à l'ensemble.

On devra pouvoir choisir le nombre d'itérations, zoomer ou dézoomer à la souris sur une partie de la fractale. La fractale devra occuper toute la surface de la fenêtre, même si on l'aggrandit ou la réduit.

*/

public class Mandelbrot {
    public static void main(String [] args){


    }

    public Mandelbrot() { }


}
