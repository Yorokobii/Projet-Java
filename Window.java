/**
Commentaires :
Cette classe génère la fenêtre dans lequel l'affichage sera implenté.
Les propriétés que la fenêtre doit respecter sont dans les commentaires de la classe Mandelbrot

IHM codée aussi ici :
- Choisir le nombre d'idérations
- Zoomer & Dézoomer avec la souris (Gestion de la molette)
- Si l'on joue avec la taille de la fenêtre la fractale dessinée devra garder proportionnellement la même surface
*/

//* Liste imports :
import javax.swing.*;

public class Window extends JFrame /* implements ActionListener*/ {
    public PaintArea area;

    public Window(String s){
        super(s);   //Appel du constructeur JFrame en y mettant le nom de la fenêtre
        setSize(560, 640);  // Taille de la fenêtre à son lancement
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture de la fenêtre
        setResizable(true); // Fenêtre dont on peut faire varier la taille
        setLocationRelativeTo(null);  // Fenêtre initialement posée au centre de l'écran
        setAlwaysOnTop(false);  // La fenêtre n'as pas toujours le focus

        area = new PaintArea(); // Création d'une instance de PaintArea
        setContentPane(area); // On ajoute le JPanel à la JFrame

        setVisible(true); // Affiche la fenêtre
    }




}
