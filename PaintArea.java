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
        fra = new Mandelbrot(250,300);          // Appel du constructeur avec paramètres de la casse Mandelbrot. Celui donne 250 d'itérations et 300 de zoom de base à la Fractale.
		addMouseListener(this);               // Permet la gestion de la souris dans l'ensemble de la classe
		addMouseWheelListener(this);          // Permet la gestion de la molette dans l'ensemble de la classe
        fra.colorTab = new Color[3*256];

        /*******permet la coloration dégradée******/
        for(int i=0; i<(3*256); ++i){
            int red=0;
            int green=0;
            int blue=0;

            if(i >= 512){
                red = i - 512;
                green = 255 - red;
            }
            else if(i >= 256){
                green = i-256;
                blue = 255 - green;
            }
            else blue = i;

            fra.colorTab[i] = new Color(red, green, blue);
        }
        /*****************************************/
	}

    public void paint(Graphics g){
        System.out.println("Zoom : "+fra.getZoom() );
        System.out.println("Iterations : "+fra.getiNumber() );
        System.out.println("Points = "+fra.getXPaint()+" + "+fra.getYPaint()+"i");

        for(int x=-this.getSize().width/2;x< this.getSize().width/2 ;x++)
            for(int y=-this.getSize().height/2;y<  this.getSize().height/2 ;y++){
                fra.setzr(0);
                fra.setzi(0);

                fra.setcr( (double)x/ fra.getZoom() + fra.getXPaint() );                    // points c du plan complexe, coordonnée x (réelle)
                fra.setci( (double)y/ fra.getZoom() + fra.getYPaint() );                    // coordonnée y (imaginaire) de c

                int i=0;
                do{
                    double tmp = fra.getzr();

                    fra.setzr( Math.pow( fra.getzr(), 2 ) - Math.pow( fra.getzi(), 2 ) + fra.getcr() );
                    fra.setzi( (2*fra.getzi()*tmp) + fra.getci() );

                    ++i;
                }while( Math.pow( fra.getzr(), 2 ) + Math.pow( fra.getzi(), 2 ) < 4 && i <  fra.getiNumber() );/*répeter l'operation jusqu'à ce que
                                                                                                                 le module du nombre complexe dépasse
                                                                                                                 2 ou que le nombre d'iterations max
                                                                                                                 soit atteint*/


                double module = Math.sqrt( Math.pow(fra.getzr(),2) + Math.pow(fra.getzi(),2) ); //utilisé pour la coloration dégradée
                /*definir la couleur du pixel a dessiner*/
                if(i < fra.getiNumber() ){
                    if(fra.multiple_color){ // si le booleen multiple_color est a true on dessine la fractale selon ce schema de coloration dégradée
                        double mu = i - Math.log(Math.log( module ))/ Math.log(2);
                        int colorIndex = (int) ( (mu/fra.getiNumber()) * 768);
                        if(colorIndex >= 768) colorIndex=0;
                        if(colorIndex <0) colorIndex = 0;
                        fra.setColor(fra.colorTab[colorIndex]);
                    }
                    else{//sinon on la dessine selon ce schema
                        double red = i*fra.basecolor.getRed()/fra.getiNumber();
                        double green = i*fra.basecolor.getGreen()/fra.getiNumber();
                        double blue = i*fra.basecolor.getBlue()/fra.getiNumber();
                        fra.setColor(new Color((int)red,(int)green,(int)blue));
                    }
                }
                else
                    fra.setColor(Color.black);
                /*dessine le pixel*/
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
