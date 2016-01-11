/***
Commentaires :
Cette classe est la zone de dessin dans laquel nous devons dessiner la fractale de Mandelbrot


*/

//* Liste imports
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PaintArea extends JPanel implements MouseListener, MouseWheelListener {
    private static Mandelbrot fra;

    public PaintArea(){
        fra = new Mandelbrot(250,300);  // Appel du constructeur avec paramètres de la casse Mandelbrot. Celui donne 250 d'itérations et 300 de zoom de base à la Fractale.
		addMouseListener(this); // Permet la gestion de la souris dans l'ensemble de la classe
		addMouseWheelListener(this); // Permet la gestion de la molette dans l'ensemble de la classe
	}

    public void paint(Graphics g){
        System.out.println("Zoom : "+fra.getZoom() );
        System.out.println("Iterations : "+fra.getiNumber() );
        System.out.println("Points = "+fra.getXPaint()+" + "+fra.getYPaint()+"i");

        for(int x=-this.getSize().width/2;x< this.getSize().width/2 ;x++)                   // > Guillaume a expliquer
            for(int y=-this.getSize().height/2;y<  this.getSize().height/2 ;y++){           // > same pélo
                fra.setzr(0);
                fra.setzi(0);

                fra.setcr( (double)x/ fra.getZoom() + fra.getXPaint() );                    // points c du plan complexe, coordonnée x
                fra.setci( (double)y/ fra.getZoom() + fra.getYPaint() );                    // coordonnée y de c

                int i=0;
                do{
                    double tmp = fra.getzr();

                    fra.setzr( Math.pow( fra.getzr(), 2 ) - Math.pow( fra.getzi(), 2 ) + fra.getcr() );
                    fra.setzi( (2*fra.getzi()*tmp) + fra.getci() );

                    ++i;
                }while( Math.pow( fra.getzr(), 2 ) + Math.pow( fra.getzi(), 2 ) < 4 && i <  fra.getiNumber() );

                /*//allumer pixel
                if(i < fra.getiNumber()){
                    double red = i*fra.basecolor.getRed()/fra.getiNumber();
                    double green = i*fra.basecolor.getGreen()/fra.getiNumber();
                    double blue = i*fra.basecolor.getBlue()/fra.getiNumber();
                    fra.setColor(new Color((int)red,(int)green,(int)blue));
                }
                */
                if(i < ( fra.getiNumber() / 100 * 20)){
                    int tmp  = i*255/fra.getiNumber();
                    //if(tmp<40) tmp=40;
                    fra.setColor(new Color(tmp, 255, 255));
                }

                else if(i < ( fra.getiNumber() / 100 * 40)){
                    int tmp  = i*255/fra.getiNumber();
                    //if(tmp<20) tmp=20;
                    fra.setColor(new Color(255, tmp, 0));
                }

                else if(i < ( fra.getiNumber() / 100 * 60)){
                    int tmp  = i*255/fra.getiNumber();
                    //if(tmp<20) tmp=20;
                    fra.setColor(new Color(0, 255, tmp));
                }

                else if(i < ( fra.getiNumber() / 100 * 80)){
                    int tmp  = i*255/fra.getiNumber();
                    //if(tmp<20) tmp=20;
                    fra.setColor(new Color(255, 255, tmp));
                }

                else if(i < ( fra.getiNumber() / 100 * 99)){
                    int tmp  = i*255/fra.getiNumber();
                    //if(tmp<20) tmp=20;
                    fra.setColor(new Color(0, 0, tmp));
                }

				else
					fra.setColor(Color.black);
				g.setColor(fra.getColor());
				g.drawLine(x+this.getSize().width/2,-y+this.getSize().height/2,x+this.getSize().width/2,-y+this.getSize().height/2);
            }
    }

    public void mouseClicked(MouseEvent e){
		 if (e.getButton()==MouseEvent.BUTTON1){
            fra.setXPaint(fra.getXPaint()-((this.getSize().width/2-e.getX())/(double)fra.getZoom()));
            fra.setYPaint(fra.getYPaint()+((this.getSize().height/2-e.getY())/(double)fra.getZoom()));
            this.repaint();
         }
    }

    public void mouseWheelMoved(MouseWheelEvent e){
        if(fra.getZoom()>=fra.getRatio()){
            fra.setZoom(fra.getZoom()-e.getWheelRotation()*(fra.getZoom()/fra.getRatio()));
	        this.repaint();
        }
        else{
            fra.setZoom(fra.getRatio());
            JOptionPane jop2 = new JOptionPane();
            jop2.showMessageDialog(null, "Impossible d'aller plus loin", "Attention", JOptionPane.WARNING_MESSAGE);
            this.repaint();
        }
	}

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

}
