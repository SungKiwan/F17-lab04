package edu.ucsb.cs56.drawings.kiwansung.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Line2D;

/**
   A FreeWeights
      
   @author Ki Wan Sung, modified from Phil Conrad
   @version for CS56, F17, UCSB
   
*/
public class Dumbbell extends FreeWeights implements Shape
{
    public Dumbbell(double x, double y, double width, double length)
    {
	super(x,y,width,length);

	GeneralPath gp = this.get();
	/*We will add one more plate to each side of weights
	  to make look more like heavy dumbbells*/

	double BarLength = .75 * length;
	double BarWidth = .1 * width;
	double xL = x + BarLength;
	double yL = y+BarWidth;
	double yR = y-BarWidth;
	double PlateWidth = 3.0 * BarWidth;
	double PlateHeight = 0.5 * BarLength;

	double newPlateHeight = PlateHeight - (0.2 * PlateHeight);
	double newPlateWidth = PlateWidth + (0.2 * PlateWidth);

	Line2D.Double LPlateLine1 = new Line2D.Double(xL + newPlateWidth, yL + newPlateHeight, xL + newPlateWidth, yR-newPlateHeight);
	/*
	  Line2D.Double LPlateLine2 = new Line2D.Double(xL + PlateWidth, yL + newPlateHeight, xL + PlateWidth, yR-newPlateHeight);*/
	Line2D.Double LPlateLine3 = new Line2D.Double(xL + newPlateWidth, yL + newPlateHeight, xL + PlateWidth, yL+newPlateHeight);
	Line2D.Double LPlateLine4 = new Line2D.Double(xL + newPlateWidth, yR - newPlateHeight, xL + PlateWidth, yR-newPlateHeight);

	Line2D.Double RPlateLine1 = new Line2D.Double(x - newPlateWidth, yL + newPlateHeight, x - newPlateWidth, yR-newPlateHeight);/*
																      Line2D.Double RPlateLine2 = new Line2D.Double(x + PlateWidth, yL + newPlateHeight, x + PlateWidth, yR-newPlateHeight);*/
	Line2D.Double RPlateLine3 = new Line2D.Double(x - newPlateWidth, yL + newPlateHeight, x - PlateWidth, yL+newPlateHeight);
	Line2D.Double RPlateLine4 = new Line2D.Double(x - newPlateWidth, yR - newPlateHeight, x - PlateWidth, yR-newPlateHeight);
	
	GeneralPath wholeFreeWeights = this.get();
        wholeFreeWeights.append(LPlateLine1, false);
	//wholeFreeWeights.append(LPlateLine2, false);
	wholeFreeWeights.append(LPlateLine3, false);
	wholeFreeWeights.append(LPlateLine4, false);
	wholeFreeWeights.append(RPlateLine1, false);
	//wholeFreeWeights.append(RPlateLine2, false);
	wholeFreeWeights.append(RPlateLine3, false);
	wholeFreeWeights.append(RPlateLine4, false);
    }
}
