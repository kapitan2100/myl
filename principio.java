/**
 * @(#)principio.java
 *
 *
 * @author 
 * @version 1.00 2008/7/10
 */

public class principio extends Carta{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Carta d; 
 	Carta a=new Carta();
    System.out.println("TIPO="+a.getipo()+" NOMBRE="+a.nombre+" valor="+a.getcoste()+" fuerza="+a.getfuerza()+" numero"+a.getnum());
    Carta b=new Carta(17);
     System.out.println("TIPO="+b.getipo()+" NOMBRE="+b.nombre+" valor="+b.getcoste()+" fuerza="+b.getfuerza()+" numero"+b.getnum());
    Carta c[]=new Carta[3];
    c[0]=new Carta(18);
    c[1]=new Carta(19);
    c[2]=new Carta(20);
    for(int i=0;i<3;i++){
    	 System.out.println("TIPO="+c[i].getipo()+" NOMBRE="+c[i].nombre+" valor="+c[i].getcoste()+" fuerza="+c[i].getfuerza()+" numero"+c[i].getnum());
           System.out.println("turno="+c[i].getturno());
    }
    a=b;
    System.out.println("TIPO="+a.getipo()+" NOMBRE="+a.nombre+" valor="+a.getcoste()+" fuerza="+a.getfuerza()+" numero"+a.getnum());
     System.out.println("TIPO="+b.getipo()+" NOMBRE="+b.nombre+" valor="+b.getcoste()+" fuerza="+b.getfuerza()+" numero"+b.getnum());
    d=a;
     System.out.println("TIPO="+d.getipo()+" NOMBRE="+d.nombre+" valor="+d.getcoste()+" fuerza="+d.getfuerza()+" numero"+d.getnum());
    }
}
