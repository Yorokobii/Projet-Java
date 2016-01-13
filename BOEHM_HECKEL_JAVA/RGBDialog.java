import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RGBDialog extends JDialog {
  private JLabel rLabel, gLabel, bLabel;
  private JTextField r, g, b;
  private JCheckBox multi_color;

  public RGBDialog(JFrame parent, String title, boolean modal){
    super(parent, title, modal);
    this.setSize(300, 170);                 // Taille de la boîte de dialogue
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.initComponent();
    this.setVisible(true);
  }

  private void initComponent(){
    final Mandelbrot mandel = new Mandelbrot();
    JPanel panNom = new JPanel();   // Une première zone de dessin
    panNom.setBackground(Color.white);  // De couleur blanche

    r = new JTextField(Integer.toString( mandel.basecolor.getRed() ));  // Récupération ici de la "couleur de base", ou couleur courante. Elle est disposée dans le texte par défaut du champ de texte
    r.setPreferredSize(new Dimension(50, 20));
    g = new JTextField(Integer.toString( mandel.basecolor.getGreen() ));
    g.setPreferredSize(new Dimension(50, 20));
    b = new JTextField(Integer.toString( mandel.basecolor.getBlue() ));
    b.setPreferredSize(new Dimension(50, 20));

    panNom.setBorder(BorderFactory.createTitledBorder("Votre couleur RGB : ")); // Création d'une bordure ayant plus au mois de style
    rLabel = new JLabel("R");   // Les labels R, G et B en rapport avec notre boîte de dialogue sur la couleur à définir
    gLabel = new JLabel("G");
    bLabel = new JLabel("B");
    panNom.add(rLabel); // Disposition des labels et des champs de textes
    panNom.add(r);
    panNom.add(gLabel);
    panNom.add(g);
    panNom.add(bLabel);
    panNom.add(b);

    JPanel multi_color_pan = new JPanel();  // Une deuxième zone de dessin
    multi_color_pan.setBackground(Color.white);
    multi_color = new JCheckBox("Multicolor", mandel.multiple_color);   // Checkbox pour avoir le choix entre deux colorisations : soit monochrome ou multicolor
    multi_color_pan.add(multi_color);

    JPanel content = new JPanel();  // Une troisième zone de dessin englobant les deux premières
    content.setBackground(Color.white);
    content.add(panNom);
    content.add(multi_color_pan);

    JPanel control = new JPanel();  // Une quatrième zone de dessin
    control.setBackground(Color.white);

    JButton okBouton = new JButton("OK");   // Création d'un bouton OK et des actions à effectuer dessus
    okBouton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evenement) {
            if(r.getText().matches("-?\\d+(\\.\\d+)?") && b.getText().matches("-?\\d+(\\.\\d+)?") && g.getText().matches("-?\\d+(\\.\\d+)?")){ //test si r, g et b sont des nombres
                int red = Integer.parseInt(r.getText());
                int green = Integer.parseInt(g.getText());
                int blue = Integer.parseInt(b.getText());

                if(red<=255 && red>=0 && blue<=255 && blue>=0 && green<=255 && green>=0){
                    mandel.basecolor = new Color(red, green, blue);
                    mandel.multiple_color = multi_color.isSelected();
                    setVisible(false);
                }
            }
        }
    });

    JButton cancelBouton = new JButton("Annuler"); // Création d'un bouton Annuler ayant lui aussi une action
    cancelBouton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent evenement) { setVisible(false); } });

    control.add(okBouton); // Ajout des boutons à la zone de dessin
    control.add(cancelBouton);

    this.getContentPane().add(content, BorderLayout.CENTER);    // Disposition de la troisième zone de dessin
    this.getContentPane().add(control, BorderLayout.SOUTH);     // Disposition de la quatrième zone de dessin
  }
}
