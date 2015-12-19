/**
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
        fra = new Mandelbrot();
		addMouseListener(this); 
		addMouseWheelListener(this); 
	}

    public void paint(Graphics g){ mandelbrot(g); }

    public void mandelbrot(Graphics g){
        //la couleur
        g.setColor(Color.blue);

        System.out.println("Zoom : "+fra.getZoom() );
        System.out.println("Largeur : "+fra.getWidth()+" - Hauteur : "+fra.getHeight());
        System.out.println("Nombre d'itérations : "+fra.getiNumber() );

        for(int x=-this.getSize().width/2;x< this.getSize().width/2 ;x++)
            for(int y=-this.getSize().height/2;y<  this.getSize().height/2 ;y++){

                fra.setzr(0);
                fra.setzi(0);

                fra.setcr( (double)x/ fra.getZoom() + fra.getXPaint() );
                fra.setci( (double)y/ fra.getZoom() + fra.getYPaint() );

                int i=0;

                do{
                    double tmp = fra.getzr();

                    fra.setzr( Math.pow( fra.getzr(), 2 ) - Math.pow( fra.getzi(), 2 ) + fra.getcr() );
                    fra.setzi( (2*fra.getzi()*tmp) + fra.getci() );

                    ++i;
                }while( Math.pow( fra.getzr(), 2 ) + Math.pow( fra.getzi(), 2 ) < 4 && i <  fra.getiNumber() );

                //allumer pixel
                if(i <= fra.getiNumber()-1)
					fra.setColor(new Color(100,(int)(i*(255/fra.getiNumber())),0));
				else
					fra.setColor(Color.black);
				g.setColor(fra.getColor());
				g.drawLine(x+this.getSize().width/2,y+this.getSize().height/2,x+this.getSize().width/2,y+this.getSize().height/2);
            }
    }
    
    public void mouseClicked(MouseEvent e){
		 if (e.getButton()==MouseEvent.BUTTON1)
            System.out.println(e.getX()+" "+e.getY());
    }
    
    public void mouseWheelMoved(MouseWheelEvent e){
		System.out.println(e.getWheelRotation());
		fra.setZoom(fra.getZoom()-e.getWheelRotation()*(fra.getZoom()/30));
		 
		this.repaint();	
	}
	
    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

}
