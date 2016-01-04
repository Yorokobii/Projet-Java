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

    JPanel panNom = new JPanel();
    panNom.setBackground(Color.white);
    panNom.setPreferredSize(new Dimension(290, 80));
    r = new JTextField();
    r.setPreferredSize(new Dimension(50, 20));
    g = new JTextField();
    g.setPreferredSize(new Dimension(50, 20));
    b = new JTextField();
    b.setPreferredSize(new Dimension(50, 20));
    panNom.setBorder(BorderFactory.createTitledBorder("Your RGB color : "));
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

    this.getContentPane().add(content, BorderLayout.CENTER);
  }
}
