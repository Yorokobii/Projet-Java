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

        System.out.println("mandelbrot dessin: "+ fractale.getiNumber());

        //la couleur
        g.setColor(Color.blue);

        //les bornes de la fractale
        double x1=-2.1;
        double x2=0.6;
        double y1=-1.2;
        double y2=1.2;

        //zoom, taille de la zone ou on va dessiner la fractale
        int zoom=2;
        double largeur=(x2-x1)*zoom;
        double hauteur=(y2-y1)*zoom;

        fractale.setW( (fractale.getxTwo() - fractale.getxOne() ) * fractale.gZoom());
        fractale.setH( (fractale.getyTwo() - fractale.getyOne() ) * fractale.gZoom());

        System.out.print(fractale.getW());
        System.out.println(" : "+fractale.getH());



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

                    System.out.println(z_r*z_r );

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

        for(int x=0; x< fractale.getW(); ++x){
            for(int y=0; y< fractale.getH(); ++y){
                fractale.scr( ((double)x)/fractale.gZoom() + fractale.getxOne() );
                fractale.sci( ((double)y)/fractale.gZoom() + fractale.getyOne() );

                int i=0;
                do{
                    double tmp = fractale.gzr();
                    System.out.println((fractale.gzr() * fractale.gzr()));

                    //System.out.println( (fractale.gzr() * fractale.gzr()) - (fractale.gzi()*fractale.gzi()) + fractale.gcr()  );
                    fractale.szr( (fractale.gzr() * fractale.gzr()) - (fractale.gzi()*fractale.gzi()) + fractale.gcr() );

                    //fractale.szr( Math.pow( fractale.gzr(), 2) - Math.pow( fractale.gzi(), 2) + fractale.gcr() );
                    //System.out.println( fractale.gzr() );
                    //fractale.szi( 2*fractale.gzi()*tmp + fractale.gci() ); */

                    ++i;

                }while( Math.pow( fractale.gzr(), 2) + Math.pow( fractale.gzi(), 2) <4 && i < fractale.getiNumber() );

                if(i== fractale.getiNumber())
                    g.drawLine(x,y,x,y);

            }

        }
    }



}
