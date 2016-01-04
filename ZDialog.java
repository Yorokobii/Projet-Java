import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ZDialog extends JDialog {
  private boolean sendData;
  private JLabel rLabel, gLabel, bLabel;
  private JTextField r, g, b;

  public ZDialog(JFrame parent, String title, boolean modal){
    super(parent, title, modal);
    this.setSize(300, 120);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.initComponent();
    this.setVisible(true);
  }

  private void initComponent(){
    final Mandelbrot mandel = new Mandelbrot();
    JPanel panNom = new JPanel();
    panNom.setBackground(Color.white);

    r = new JTextField(Integer.toString( mandel.basecolor.getRed() ));
    r.setPreferredSize(new Dimension(50, 20));
    g = new JTextField(Integer.toString( mandel.basecolor.getGreen() ));
    g.setPreferredSize(new Dimension(50, 20));
    b = new JTextField(Integer.toString( mandel.basecolor.getBlue() ));
    b.setPreferredSize(new Dimension(50, 20));

    panNom.setBorder(BorderFactory.createTitledBorder("Votre couleur RGB : "));
    rLabel = new JLabel("R");
    gLabel = new JLabel("G");
    bLabel = new JLabel("B");
    panNom.add(rLabel);
    panNom.add(r);
    panNom.add(gLabel);
    panNom.add(g);
    panNom.add(bLabel);
    panNom.add(b);

    JPanel content = new JPanel();
    content.setBackground(Color.white);
    content.add(panNom);

    JPanel control = new JPanel();
    control.setBackground(Color.white);

    JButton okBouton = new JButton("OK");
    okBouton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evenement) {
            int red = Integer.parseInt(r.getText());
            int green = Integer.parseInt(g.getText());
            int blue = Integer.parseInt(b.getText());

            if(red<=255 && red>=0 && blue<=255 && blue>=0 && green<=255 && green>=0){
                mandel.basecolor = new Color(red, green, blue);
                setVisible(false);
            }
        }
    });

    JButton cancelBouton = new JButton("Annuler");
    cancelBouton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent evenement) { setVisible(false); } });

    control.add(okBouton);
    control.add(cancelBouton);

    this.getContentPane().add(content, BorderLayout.CENTER);
    this.getContentPane().add(control, BorderLayout.SOUTH);
  }
}
