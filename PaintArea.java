/**
Commentaires :
Cette classe est la zone de dessin dans laquel nous devons dessiner la fractale de Mandelbrot


*/

//* Liste imports
import java.awt.*;
import javax.swing.*;

public class PaintArea extends JPanel{
    public PaintArea(){ }

    public void paint(Graphics g){ mandelbrot(g); }

    public void mandelbrot(Graphics g){
        //la couleur
        g.setColor(Color.blue);
        Mandelbrot fra = new Mandelbrot();

        System.out.println("Zoom : "+fra.getZoom() );
        System.out.println("Largeur : "+fra.getWidth()+" - Hauteur : "+fra.getHeight());
        System.out.println("Nombre d'itérations : "+fra.getiNumber() );

        for(int x=0;x< fra.getWidth() ;x++)
            for(int y=0;y<  fra.getHeight() ;y++){

                fra.setzr(0);
                fra.setzi(0);

                fra.setcr( (double)x/ (fra.getZoom() + fra.getXPaint()) );
                fra.setci( (double)y/ (fra.getZoom() + fra.getYPaint()) );

                int i=0;

                do{
                    double tmp = fra.getzr();

                    fra.setzr( Math.pow( fra.getzr(), 2 ) - Math.pow( fra.getzi(), 2 ) + fra.getcr() );
                    fra.setzi( (2*fra.getzi()*tmp) + fra.getci() );

                    ++i;
                }while( Math.pow( fra.getzr(), 2 ) + Math.pow( fra.getzi(), 2 ) < 4 && i <  fra.getiNumber() );

                //allumer pixel
                if(i <= fra.getiNumber()-1)
					fra.setColor(new Color(0,(int)(i*(255/fra.getiNumber())),0));
				else
					fra.setColor(Color.black);
				g.setColor(fra.getColor());
				g.drawLine(x,y,x,y);
            }
    }
}
