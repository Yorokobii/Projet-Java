/**
La classe Window génère la fenêtre dans laquelle l'affichage sera implanté.
*/

//* Liste imports :
import javax.swing.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener {
    public PaintArea area;  // Instance de PaintArea
    private Mandelbrot mandel;  // Instance de Mandelbrot

    public Window(String s){
        super(s);                                           // Appel du constructeur JFrame en y mettant le nom de la fenêtre
        setSize(810, 720);                                  // Taille de la fenêtre à son lancement
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // Fermeture de la fenêtre
        setResizable(true);                                 // Fenêtre dont on peut faire varier la taille
        setLocationRelativeTo(null);                        // Fenêtre initialement posée au centre de l'écran
        setAlwaysOnTop(false);                              // La fenêtre n'as pas toujours le focus

        // Création d'une barre des tâches
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

        // Ajout d'un onglet "Options" à la barre des tâches
	    JMenu option = new JMenu("Options");
		menuBar.add(option);

		// Création des différents items composant l'onglet Options
        JMenuItem item_iteration = new JMenuItem("Nombre d'itérations");
        JMenuItem item_point = new JMenuItem("Point");
		JMenuItem item_color = new JMenuItem("Couleur");
		JMenuItem item_zoom = new JMenuItem("Zoom");
        JMenuItem item_default = new JMenuItem("Réinitialiser");
		JMenuItem item_exit = new JMenuItem("Quitter");

		// Ajout des items à l'onglet
        option.add(item_iteration);
        option.add(item_point);
		option.add(item_color);
		option.add(item_zoom);
		option.add(new JSeparator()); // Ajout d'un séparateur entre les différents items
        option.add(item_default);
		option.add(item_exit);

        // Affectation d'un nom de signal à chaque composant qui est "écouté".
        // Si un bouton est selecionné alors le signal est déclanché.
        item_point.setActionCommand("point");
        item_point.addActionListener(this);
		item_iteration.setActionCommand("iteration");
        item_iteration.addActionListener(this);
        item_color.setActionCommand("color");
        item_color.addActionListener(this);
        item_zoom.setActionCommand("zoom");
        item_zoom.addActionListener(this);
        item_default.setActionCommand("default");
        item_default.addActionListener(this);
        item_exit.setActionCommand("exit");
        item_exit.addActionListener(this);
	//_________________________________

        area = new PaintArea(); // Création d'une instance de PaintArea
        setContentPane(area); // On ajoute le JPanel à la JFrame

        setVisible(true); // Affiche la fenêtre
    }

    // Implémentation dans le code obligatoire (implements de l'interface ActionListener)
    public void actionPerformed(ActionEvent evenement){

        // Action effectué sur l'activation du signal "exit"
		if(evenement.getActionCommand().equals("exit")){
            if( JOptionPane.showConfirmDialog(  null, //< icon
                                                "Voulez vous vraiment quitter ?", //< Texte
                                                "Quitter",  //< Titre
                                                JOptionPane.YES_NO_OPTION,  //< Option sur les boutons
                                                JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION ) //< Condition

				System.exit(0); //< Si elle est vérifiée alors on sort du programme
        }


        // Action effectuée sur "iteration"
		if(evenement.getActionCommand().equals("iteration")){
            // Création d'une fenêtre de dialogue
            JOptionPane jop_iteration = new JOptionPane();
			String iter = jop_iteration.showInputDialog(null, "Entrez le nombre d'itérations que vous voulez : ", "Iteration Number", JOptionPane.QUESTION_MESSAGE);
            if(iter !=null){
                if(iter.matches("-?\\d+(\\.\\d+)?")){ // Test si le texte est un nombre
                    mandel = new Mandelbrot();      // Appel du constructeur sans paramètres de la classe Mandelbrot pour pouvoir modifier ses membres statics
                    int value = Integer.parseInt(iter);
                    mandel.setiNumber(value);   // Modifications du nombre d'itérations dans le programme tout entier, et non uniquement dans cette fonction.
                    System.out.println("Nouveau nombre iterations : "+mandel.getiNumber());

                    this.repaint(); // Nécessaire pour redessiner notre fractale.
                }
            }

        }

        // Action concernant "point"
        if(evenement.getActionCommand().equals("point")){
            JOptionPane jop_point = new JOptionPane();
            String px = jop_point.showInputDialog(null, "Entrez la coordonnée x de votre point : ", "Point", JOptionPane.QUESTION_MESSAGE);
            String py = jop_point.showInputDialog(null, "Entrez la coordonnée y de votre point : ", "Point", JOptionPane.QUESTION_MESSAGE);

            if(px != null && py != null && px.matches("-?\\d+(\\.\\d+)?") && py.matches("-?\\d+(\\.\\d+)?")){
                double pointx = Double.parseDouble(px);
                double pointy = Double.parseDouble(py);

                mandel = new Mandelbrot();
                mandel.setXPaint(pointx);
                mandel.setYPaint(pointy);
                System.out.println("Nouveau point : " + mandel.getXPaint() + "," + mandel.getYPaint());

                this.repaint();
            }

        }

        // Action sur "default"
        if(evenement.getActionCommand().equals("default")){
            mandel = new Mandelbrot(250,300);
            setSize(810,720);
            setLocationRelativeTo(null);
            this.repaint();
        }

        // Action sur "zoom"
        if(evenement.getActionCommand().equals("zoom")){
            mandel = new Mandelbrot();
            JOptionPane jop_point = new JOptionPane();
            long z = 0;
            boolean isok = false;
            while(!isok){
                String sz = jop_point.showInputDialog(null, "A combien voulez-vous zoomer ? ", "Zoom", JOptionPane.QUESTION_MESSAGE);
                if(sz != null && sz.matches("-?\\d+(\\.\\d+)?")){
                    z = Integer.parseInt(sz);
                    if(z>=mandel.getRatio())
                        isok = true;
                    else{
                        JOptionPane jop = new JOptionPane();
                        jop.showMessageDialog(null, "Entrez un zoom supérieur ou égal à "+mandel.getRatio(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    z = mandel.getZoom();
                    isok = true;
                }
            }

            mandel.setZoom(z);

            this.repaint();
        }

        if(evenement.getActionCommand().equals("color")){
            RGBDialog dialog = new RGBDialog(this, "Color", true);
            this.repaint();
        }
	}

}
