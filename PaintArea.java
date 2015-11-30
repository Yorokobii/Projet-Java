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
        Mandelbrot fractale = new Mandelbrot();
        fractale.getxOne();
        
        System.out.println("mandelbrot dessin: "+ fractale.getiNumber());

        //la couleur
        g.setColor(Color.blue);

        //les bornes de la fractale
        double x1=-2.1;
        double x2=0.6;
        double y1=-1.2;
        double y2=1.2;

        //zoom, taille de la zone ou on va dessiner la fractale
        int zoom=200;
        double largeur=(x2-x1)*zoom;
        double hauteur=(y2-y1)*zoom;

        //le nombre d'itération
        int iter_max=150;


        double z_r,z_i,c_r,c_i;
        //calcul
        for(int x=0;x<largeur;x++){

            for(int y=0;y<hauteur;y++){

                z_r=0;
                z_i=0;

                c_r=(double)x/zoom +x1;
                c_i=(double)y/zoom + y1;

                int i=0;

                do{
                    double tmp = z_r;

                    z_r = z_r*z_r - z_i*z_i +c_r;
                    z_i = 2*z_i*tmp +c_i;

                    ++i;
                }while(z_r*z_r + z_i*z_i < 4 && i < iter_max);

                //allumer pixel
                if(i==iter_max){

                    g.drawLine(x,y,x,y);
                }
            }
        }
    }



}
