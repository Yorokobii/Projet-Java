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
import java.awt.event.*;

public class Window extends JFrame implements ActionListener {
    public PaintArea area;

    public Window(String s){
        super(s);   //Appel du constructeur JFrame en y mettant le nom de la fenêtre
        setSize(560, 640);  // Taille de la fenêtre à son lancement
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture de la fenêtre
        setResizable(true); // Fenêtre dont on peut faire varier la taille
        setLocationRelativeTo(null);  // Fenêtre initialement posée au centre de l'écran
        setAlwaysOnTop(false);  // La fenêtre n'as pas toujours le focus
		
	//______ MENU BAR _________________
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
	//_________________________________
	
		
	//______ MENU TAB _________________
		JMenu option = new JMenu("Options");
		menuBar.add(option);
	//_________________________________
	
		
	//______ MENU ITEM ________________
	
		// Création des différents items composant l'onglet Options
		JMenuItem item_iteration = new JMenuItem("Iteration number");
		JMenuItem item_color = new JMenuItem("Color");
		JMenuItem item_zoom = new JMenuItem("Zoom");
		JMenuItem item_exit = new JMenuItem("Exit");
		
		// Ajout des items à l'onglet 
		option.add(item_iteration);
		option.add(item_color);
		option.add(item_zoom);
		option.add(new JSeparator());
		option.add(item_exit);
		
		// Action effectuée sur item_iteration
		item_iteration.setActionCommand("iteration");
        item_iteration.addActionListener(this);
		
		// Action effectuée sur item_color
        item_color.setActionCommand("color");
        item_color.addActionListener(this);

        // Action effectuée sur item_zoom
        item_zoom.setActionCommand("zoom");
        item_zoom.addActionListener(this);
        
        // Action effectuée sur item exit
        item_exit.setActionCommand("exit");
        item_exit.addActionListener(this);
	//_________________________________
		
        area = new PaintArea(); // Création d'une instance de PaintArea
        setContentPane(area); // On ajoute le JPanel à la JFrame
        
        setVisible(true); // Affiche la fenêtre
    }
    
    public void actionPerformed(ActionEvent evenement){
		
	//______ EXIT _________________________________
		if(evenement.getActionCommand().equals("exit")){
            if( JOptionPane.showConfirmDialog(  null, //< icon
                                                "Voulez vous vraiment quitter ?", //< Texte
                                                "Quitter",  //< Titre
                                                JOptionPane.YES_NO_OPTION,  //< Option sur les boutons
                                                JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION ) //< Condition

				System.exit(0); //< Si elle est vérifiée alors on sort du programme
        }
    
    
    //______ ITERATION ___________________________
		if(evenement.getActionCommand().equals("iteration")){
            JOptionPane jop_iteration = new JOptionPane();
			String name = jop_iteration.showInputDialog(null, "Set the iteration number you want : ", "Iteration Number", JOptionPane.QUESTION_MESSAGE);
			
            Mandelbrot mandel = new Mandelbrot();
            double value = Double.parseDouble(name);
            mandel.setiNumber(value);
            System.out.println("value "+value);
            
            this.repaint();
        } 
		
		
	}




}
