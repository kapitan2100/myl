/**
 * @(#)mito.java
 *
 *
 * @author Meister_Kapitan
 * @version 1.00 2008/7/6
 */
import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.io.*;
import javax.swing.JOptionPane;

public class mito extends JFrame implements ActionListener{
    	//matriz de botones
	JButton boton [][] = new JButton[6][10];   /*botones para las cartas*/
	JButton comandos[] = new JButton[4];       /*botones de opciones*/
	JLabel nombre = new JLabel(" El Juego Nº1 del Reino ",JLabel.CENTER); 
	ImageIcon vacia,mono,info,logo,cemen,atta;
	ImageIcon card[]=new ImageIcon[50]; 	    /*molde de las imagenes*/
    JPanel central=new JPanel(new GridLayout(6,10));
    JPanel abajo=new JPanel(new GridLayout(1,10));           /*campo de los botones */
    JLabel mensaje;
    
    int contar=0,numoros_res=1;
    int baja_oro=0,orutil=0;
    int fase=0,robar=0,skill=0;
    int usado=0,count=8;
    int g_res=1,g_util=0;
     /*Cartas utlilizadas por jugador*/
     Carta mazo[]=new Carta[50];
     Carta cementerio[]=new Carta[50];
     Carta mano[]=new Carta[15];
     Carta def[]=new Carta[9];
     Carta ataq[]=new Carta[9];
     Carta oro_util[]=new Carta[16];
     Carta oro_res[]=new Carta[16];
     Carta nula=new Carta();
     Carta informa=new Carta();
    /*Cartas utilizadas por el COM*/
     Carta castle[]=new Carta[50];
     Carta rip[]=new Carta[50];
     Carta hand[]=new Carta[15];
     Carta defen[]=new Carta[9];
     Carta atak[]=new Carta[9];
     Carta gold_util[]=new Carta[16];
     Carta gold_res[]=new Carta[16];
     
    public mito() {
    	/*ini_mano();*/
    	inicializar();
    	//Metodo para cerrar la ventana
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
			 	System.exit(0);
			 }
		});
		// Propiedades de la ventana
	    setTitle("MITOS Y LEYENDAS");	
	    setResizable(true);
	    setSize(1000,730);
		setVisible(true);
		}
    public void inicializar(){
    	vacia=new ImageIcon("vacio.jpg");
    	mono=new ImageIcon("volteada.jpg");
    	info=new ImageIcon("info.jpg");
    	logo=new ImageIcon("premio.jpg");
    	cemen=new ImageIcon("cementerio.jpg");
    	atta=new ImageIcon("vatta.jpg");
    	for(int i=0;i<50;i++){
    		card[i]=new ImageIcon("El_Reto/"+ Integer.toString(i)+".jpg");
    	}
    		//add(nombre,"North"); 
    		 //Anadir Botones al panel principal donde se colocaran las cartas
		   for(int i=0;i<6;i++){
		  for(int j=0;j<10;j++){ 
		  	   if(((i==2)||((i==3)))&&(j==0)){
		  	    boton[i][j]=new JButton();
		  	    boton[i][j].setBackground(Color.blue);
		  	    boton[i][j].setIcon(info);
		  	    boton[i][j].addActionListener(this);
		  	    central.add(boton[i][j]);
		  	    }
		  	   else{
		  	   boton[i][j]=new JButton();
		  	   if((i==0)&&(j==0)||(i==5)&&(j==0)){
		  	   	boton[i][j].setIcon(logo);}	
		  	   else{
		  	   	  if(((i==1)||((i==4)))&&(j==0)){
		  	   	  	boton[i][j].setIcon(cemen);
		  	   	  }
		  	   	  else{
		  	   	  	if((i==2)||(i==3)){
		  	   	  	 boton[i][j].setIcon(atta);	
		  	   	  	}
		  	   	  	else{
		  	   	  		boton[i][j].setIcon(vacia);
		  	   	  	}}}
		  	   boton[i][j].addActionListener(this);
		  	   central.add(boton[i][j]);}
		  	   }}	
		  add(central,"Center");
		 
		 comandos[0] = new JButton(" NUEVO JUEGO ");  /* Botón que ejecuta la accion */
		  comandos[0].addActionListener(this);
		   abajo.add(comandos[0]);
		  comandos[1] = new JButton(" COLECCION ");  /* Botón que ejecuta la accion */
		  comandos[1].addActionListener(this);
		   abajo.add(comandos[1]);
		    comandos[2] = new JButton(" DEFENDER ");  /* Botón que ejecuta la accion */
		  comandos[2].addActionListener(this);
		   abajo.add(comandos[2]);
		    comandos[3] = new JButton(" FASES ");  /* Botón que ejecuta la accion */
		  comandos[3].addActionListener(this);
		   abajo.add(comandos[3]);
            mensaje = new JLabel("   Mensajes"); /* Texto Patente */
            //mensaje.setText("Mensajes");
            abajo.add(mensaje);
		    add(abajo,"North");		
    }
    public void ini_mano(){
        boton[1][1].setIcon(mono);
		boton[4][1].setIcon(mono);
		boton[5][1].setIcon(card[0]);
        oro_res[0]=new Carta(0);
        oro_res[1]=oro_util[0]=cementerio[0]=mano[0]=def[0]=nula;
        for(int i=0;i<8;i++){ataq[i]=nula;}
       	for(int i=0;i<49;i++){
       		mazo[i]=new Carta(i+1);
      //System.out.println("TIPO="+mazo[i].getipo()+" NOMBRE="+mazo[i].nombre+" valor="+mazo[i].getcoste()+" fuerza="+mazo[i].getfuerza()+" numero"+mazo[i].getnum());
       	}
       	mazo[49]=new Carta(); /*tope mazo*/
       	barajar(49);
       	barajar(49);
       	barajar(49);
       	inicio_oponente();
    	}
    public void barajar(int numero){
    	Random rnd=new Random();
		Carta aux;
		int x;
			for(int i=0;i<numero;i++){
			x=(int) (rnd.nextDouble()*numero);
			 //System.out.println("aleatorio="+x);
			 aux=mazo[i];
			 mazo[i]=mazo[x];
			 mazo[x]=aux;
			}
    }
    public void barajar_op(int numero){
    	Random rnd=new Random();
		Carta aux;
		int x;
			for(int i=0;i<numero;i++){
			x=(int) (rnd.nextDouble()*numero);
			 //System.out.println("aleatorio="+x);
			 aux=castle[i];
			 castle[i]=castle[x];
			 castle[x]=aux;
			}
    }
    public void nuevo_juego(){
    	reagrupar();
    	int i,k;
    	Carta aux;
    	for(i=0;mazo[i].getnum()!=-1;i++){
    	}
    	for(k=0;cementerio[k].getnum()!=-1;k++){
    		mazo[i]=cementerio[k];
    		cementerio[k]=nula;
    		i++;
    	}
    		boton[4][0].setIcon(vacia);
    		for(k=0;mano[k].getnum()!=-1;k++){
    		mazo[i]=mano[k];
    		mano[k]=nula;
    		boton[5][k+2].setIcon(vacia);
    		i++;
    	}
    	for(k=0;def[k].getnum()!=-1;k++){
    		mazo[i]=def[k];
    		def[k]=nula;
    		boton[4][k+2].setIcon(vacia);
    		i++;
    	}
    	for(k=1;oro_res[k].getnum()!=-1;k++){
    		mazo[i]=oro_res[k];
    		oro_res[k]=nula;
    		i++;
    	}
    	boton[5][1].setIcon(card[oro_res[0].getnum()]);
    	barajar(49);
    	barajar(49);
    	barajar(49);
    	contar=0;
    	numoros_res=1;
        baja_oro=0;
        orutil=0;
        fase=1;
        robar=0;
        skill=0;
        reagrupa_op();
    	for(i=0;castle[i].getnum()!=-1;i++){
    	}
    	for(k=0;rip[k].getnum()!=-1;k++){
    		castle[i]=rip[k];
    		rip[k]=nula;
    		i++;
    	}
    		boton[1][0].setIcon(vacia);
    		for(k=0;hand[k].getnum()!=-1;k++){
    		castle[i]=hand[k];
    		hand[k]=nula;
    		boton[0][k+2].setIcon(vacia);
    		i++;
    	}
    	for(k=0;defen[k].getnum()!=-1;k++){
    		castle[i]=defen[k];
    		defen[k]=nula;
    		boton[1][k+2].setIcon(vacia);
    		i++;
    	}
    	for(k=1;gold_res[k].getnum()!=-1;k++){
    		castle[i]=gold_res[k];
    		gold_res[k]=nula;
    		i++;
    	}
    	boton[0][1].setIcon(card[gold_res[0].getnum()]);
        gold_res[1]=gold_util[0]=rip[0]=hand[0]=defen[0]=atak[0]=nula;
        usado=g_util=0;
        count=8;
        g_res=1;
        barajar_op(49);
       	barajar_op(49);
       	barajar_op(49);	
       	for(i=0;i<8;i++){
       		hand[i]=castle[i];
       		boton[0][i+2].setIcon(card[hand[i].getnum()]); 
       	}
       	hand[8]=nula;
       	for(i=0;i<8;i++){ /*mover cartas mazo*/
       	for(int j=0;j<49;j++){
       		castle[j]=castle[j+1];
       	   }}
      fase=1;
      comandos[3].setText("FASES"); 	   
    }
    public void coleccion(){
    	int i,j;
    	for(i=0;i<5;i++){
    		for(j=0;j<10;j++){
    		 boton[i][j].setIcon(card[(10*i)+j]);	
    		}
    	}
    	
    }
    /*jugadas usuario*/
    public void robar_carta(){
    	if((contar<8)&&(robar==0)){
    		/*algoritmo de robar*/
    		 int i;
    		 if(mazo[0].getnum()!=-1){  /*si quedan cartas*/
   	             for(i=0;mano[i].getnum()!=-1;i++){
   	  	                                       }                            
   	  	        mano[i+1]=nula;                               
   	          	mano[i]=mazo[0];
   	          	informa=mano[i];
   	          	boton[5][i+2].setIcon(card[mano[i].getnum()]);
   	          	boton[3][0].setIcon(card[mano[i].getnum()]);
   	          	System.out.println("robando:");
   	    	    System.out.println("TIPO="+mano[i].getipo()+" NOMBRE="+mano[i].nombre+" valor="+mano[i].getcoste()+" fuerza="+mano[i].getfuerza()+" numero"+mano[i].getnum());
   	  	        System.out.println("Turno="+mano[i].getturno());
   	  	       for(i=0;i<49;i++){
   	  	       	mazo[i]=mazo[i+1]; /*se mueven todas las cartas del castillo*/
   	  	       }
    		    contar++;
    		    if(contar==8){robar=1;
    		    } 
   	            }	
   		
    		}
    		else{ mensaje.setText(" No puedes robar + cartas");
    		} 
    }
    public void reagrupar(){
      int i;
     	  for(i=0;oro_util[i].getnum()!=-1;i++){
     		//System.out.println(" "+oro_util[i].getnombre());
     		oro_res[numoros_res+i]=oro_util[i];
     		oro_util[i]=nula;
     	     }
     	   numoros_res=numoros_res+i; 
     	  boton[3][1].setIcon(vacia); 
     	  boton[5][1].setIcon(card[oro_res[numoros_res-1].getnum()]);
          orutil=0;
          baja_oro=0;
          usado=0;
          oro_res[numoros_res]=nula;
          //System.out.println("oro res="+numoros_res+" oro util="+orutil);	
          for(i=0;i<8;i++){
          	if(ataq[i].getnum()!=-1){
          		def[i]=ataq[i];
          		ataq[i]=nula;
          		boton[4][i+2].setIcon(card[def[i].getnum()]);
          		boton[3][i+2].setIcon(vacia); 
          	}}
          for(i=0;def[i].getnum()!=-1;i++){
          	def[i].cambturno();
          }
    }
    public void realiza_habilidad(int code){
      if(code==18){
      	JOptionPane.showMessageDialog(null,"Elige una carta oponente","EFECTO DE CARTA (MyL)",JOptionPane.INFORMATION_MESSAGE,card[code]);  
        skill=18;}
      if(code==20){int i;
        for(i=0;def[i].getnum()!=-1;i++){def[i].incfuerza(1);
        }
        skill=20;}
      if(code==21){JOptionPane.showMessageDialog(null,"Elige una carta de aliado para destruir","EFECTO DE CARTA (MyL)",JOptionPane.INFORMATION_MESSAGE,card[code]);  
      	skill=21;}
      if(code==23){int i;
         for(i=0;def[i].getnum()!=-1;i++){
         	if(def[i].getraza()=="CABALLERO"){def[i].incfuerza(1);
         	}
         }}	  
      if(code==24){JOptionPane.showMessageDialog(null,"Elige una carta oponente","EFECTO DE CARTA (MyL)",JOptionPane.INFORMATION_MESSAGE,card[code]);  
       skill=24;}
      if(code==25){informa=mazo[0];
        JOptionPane.showMessageDialog(null,""+informa.getnombre()+"\n"+informa.gethabil(),"Carta ROBADA (MyL)",JOptionPane.INFORMATION_MESSAGE,card[informa.getnum()]);  
        if(mazo[0].getipo()=="ALIADO"){
        	int i;
        	for(i=0;def[i].getnum()!=-1;i++){}
        	def[i]=mazo[0];
        	def[i+1]=nula;        
        	boton[4][i+2].setIcon(card[def[i].getnum()]);	
        	for(i=0;i<49;i++){
   	  	       	mazo[i]=mazo[i+1]; /*se mueven todas las cartas del castillo*/
   	  	       }	}
   	  	else{	int i;
        	for(i=0;cementerio[i].getnum()!=-1;i++){}
        	cementerio[i]=mazo[0];
        	cementerio[i+1]=nula;
        	boton[4][0].setIcon(card[mazo[0].getnum()]);	
        	for(i=0;i<49;i++){
   	  	       	mazo[i]=mazo[i+1]; /*se mueven todas las cartas del castillo*/
   	  	       }
   	  	}/*ver carta oponente*/
   	  	informa=castle[0];
   	  	JOptionPane.showMessageDialog(null,""+informa.getnombre()+"\n"+informa.gethabil(),"Carta ROBADA OPONENTE (MyL)",JOptionPane.INFORMATION_MESSAGE,card[informa.getnum()]);  
        if(castle[0].getipo()=="ALIADO"){
        	int i;
        	for(i=0;defen[i].getnum()!=-1;i++){}
        	defen[i]=castle[0];
        	defen[i+1]=nula;        
        	boton[1][i+2].setIcon(card[defen[i].getnum()]);	
        	for(i=0;i<49;i++){
   	  	       	castle[i]=castle[i+1]; /*se mueven todas las cartas del castillo*/
   	  	       }	}
   	  	else{	int i;
        	for(i=0;rip[i].getnum()!=-1;i++){}
        	rip[i]=mazo[0];
        	rip[i+1]=nula;
        	boton[1][0].setIcon(card[castle[0].getnum()]);	
        	for(i=0;i<49;i++){
   	  	       	castle[i]=castle[i+1]; /*se mueven todas las cartas del castillo*/
   	  	       }
   	  	}       
      }
      if(code==26){int i;
        for(i=0;defen[i].getnum()!=-1;i++){defen[i].cambpos(2); /*solo ataca*/
        }
      }
      if(code==27){JOptionPane.showMessageDialog(null,"(1) "+castle[0].getnombre()+"\n"+castle[0].gethabil(),"Las 3 Cartas Miradas son: (MyL)",JOptionPane.INFORMATION_MESSAGE,card[castle[0].getnum()]);  
        JOptionPane.showMessageDialog(null,"(2) "+castle[1].getnombre()+"\n"+castle[1].gethabil(),"Las 3 Cartas Miradas son: (MyL)",JOptionPane.INFORMATION_MESSAGE,card[castle[1].getnum()]);  
        JOptionPane.showMessageDialog(null,"(3) "+castle[2].getnombre()+"\n"+castle[2].gethabil(),"Las 3 Cartas Miradas son: (MyL)",JOptionPane.INFORMATION_MESSAGE,card[castle[2].getnum()]);  
        String alt;
        Carta aux;
        alt=JOptionPane.showInputDialog(null,"Elige orden:\n(1) "+castle[0].getnombre()+"\n(2) "+castle[1].getnombre()+"\n(3) "+castle[2].getnombre()+"\nAlternativa A: 1-2-3\nAlternativa B: 1-3-2\nAlternativa C: 2-1-3\nAlternativa D: 2-3-1\nAlternativa E: 3-1-2\nAlternativa F: 3-2-1","EFECTO DE CARTA (MyL)",JOptionPane.QUESTION_MESSAGE);
        	if(alt.equals("b")){aux=castle[1];
        	                   castle[1]=castle[2];
        	                   castle[2]=aux;
        	}
        	if(alt.equals("c")){aux=castle[0];
        	                   castle[0]=castle[1];
        	                   castle[1]=aux;
        	}
        	if(alt.equals("d")){aux=castle[0];
        	                   castle[0]=castle[1];
        	                   castle[1]=castle[2];
        	                   castle[2]=aux;
        	}
        	if(alt.equals("e")){aux=castle[0];
        	                   castle[0]=castle[2];
        	                   castle[2]=castle[1];
        	                   castle[1]=aux;
        	}
        	if(alt.equals("f")){aux=castle[0];
        	                   castle[0]=castle[2];
        	                   castle[2]=aux;
        	}
        	JOptionPane.showMessageDialog(null,"orden:\n(1) "+castle[0].getnombre()+"\n(2) "+castle[1].getnombre()+"\n(3) "+castle[2].getnombre(),"Las 3 Cartas Miradas quedan: (MyL)",JOptionPane.INFORMATION_MESSAGE,logo);
    }
    if(code==28){JOptionPane.showMessageDialog(null,"Elige un aliado para destruir.","EFECTO DE CARTA (MyL)",JOptionPane.INFORMATION_MESSAGE,card[code]);  
    	skill=28;
    }
    if(code==31){
    	int i;
    	for(i=0;rip[i].getnum()!=-1;i++){
    	}
    	JOptionPane.showMessageDialog(null,""+castle[0].getnombre()+"\n"+castle[0].gethabil(),"Carta enviada al cementerio (MyL)",JOptionPane.INFORMATION_MESSAGE,card[castle[0].getnum()]);  
        rip[i]=castle[0];
        boton[1][0].setIcon(card[castle[0].getnum()]);
        JOptionPane.showMessageDialog(null,""+castle[1].getnombre()+"\n"+castle[1].gethabil(),"Carta enviada al cementerio (MyL)",JOptionPane.INFORMATION_MESSAGE,card[castle[1].getnum()]);  
        rip[i+1]=castle[1];
        boton[1][0].setIcon(card[castle[1].getnum()]);
        rip[i+2]=nula;
        for(i=0;i<49;i++){
   	  	       	castle[i]=castle[i+1]; /*se mueven todas las cartas del castillo*/
   	  	       }
   	  	for(i=0;i<49;i++){
   	  	       	castle[i]=castle[i+1]; /*se mueven todas las cartas del castillo*/
   	  	       }       
    }
    if(code==32){skill=32;
              JOptionPane.showMessageDialog(null,"Elige 2 cartas de la mano oponente","EFECTO DE CARTA (MyL)",JOptionPane.INFORMATION_MESSAGE,card[code]);  }
    if(code==33){System.out.println("numero oros="+(numoros_res+orutil));
                 int i,suma=numoros_res+orutil;
                 for(i=0;mano[i].getnum()!=33;i++){}
                 mano[i].incfuerza(suma);}
    if(code==34){
    }
    if(code==36){int i;
    	    for(i=0;cementerio[i].getnum()!=-1;i++){}
    	    int j,k;
    	    for(j=0;j<4;j++){
    	      cementerio[i+j]=mazo[0];
    	      cementerio[i+j+1]=nula;
    	      boton[4][0].setIcon(card[cementerio[i+j].getnum()]); 
    	      for(k=0;k<49;k++){
   	  	       	mazo[k]=mazo[k+1]; /*se mueven todas las cartas del castillo*/
   	  	       }
    	      }
    	     
    		JOptionPane.showMessageDialog(null,"Botaste 4 cartas","EFECTO DE CARTA (MyL)",JOptionPane.INFORMATION_MESSAGE,card[code]);  
    	}
    if(code==45){JOptionPane.showMessageDialog(null,"Elige 1 carta de la mano oponente","EFECTO DE CARTA (MyL)",JOptionPane.INFORMATION_MESSAGE,card[code]);  
     skill=45;}
    if(code==46){JOptionPane.showMessageDialog(null,"Elige 1 carta en juego","EFECTO DE CARTA (MyL)",JOptionPane.INFORMATION_MESSAGE,card[code]);  
     skill=46;}
    if(code==49){JOptionPane.showMessageDialog(null,"Elige 1 aliado Defensor","EFECTO DE CARTA (MyL)",JOptionPane.INFORMATION_MESSAGE,card[code]);  
     skill=49;}  
    }
    public int hab_coste(int code){
    	int wa=0;
    	Carta aux=new Carta(code); 
    	if(code==42){int i;
    	  for(i=0;def[i].getnum()!=-1;i++){
    	  	if(def[i].getnum()==42){wa++;
    	  	}}
    	  for(i=0;defen[i].getnum()!=-1;i++){
    	  	if(defen[i].getnum()==42){wa++;
    	  	}
    	  }	}
      if(wa>0){return(0);}
      else{return(aux.getcoste());}	  
    }
    public void instantanea(int code){
    	
    }
   /*Jugadas del COMPUTER IA*/
    public void inicio_oponente(){
    	gold_res[0]=new Carta(0);
        gold_res[1]=gold_util[0]=rip[0]=hand[0]=defen[0]=atak[0]=nula;
       	for(int i=0;i<49;i++){
       		castle[i]=new Carta(i+1);
       		}
       	castle[49]=new Carta(); /*tope mazo*/
       	barajar_op(49);
       	barajar_op(49);
       	barajar_op(49);	
       	for(int i=0;i<8;i++){
       		hand[i]=castle[i];
       		boton[0][i+2].setIcon(card[hand[i].getnum()]); 
       	}
       	hand[8]=nula;
       	for(int i=0;i<8;i++){ /*mover cartas mazo*/
       	for(int j=0;j<49;j++){
       		castle[j]=castle[j+1];
       	   }}
       	 boton[0][1].setIcon(card[oro_res[0].getnum()]);  
       	}
    public void mover_oros(int valor){
    	int i;
    	for(i=0;i<valor;i++){
    		gold_util[g_util+i]=gold_res[g_res-i-1];
    		boton[2][1].setIcon(card[gold_util[g_util+i].getnum()]);
    		gold_res[g_res-i-1]=nula;
    		if((g_res-i-1)!=0){
    				boton[0][1].setIcon(card[gold_res[g_res-i-2].getnum()]);
    		}
    	    else{boton[0][1].setIcon(vacia);
    	    }
    	}
    	g_util=g_util + i;
    	gold_util[g_util]=nula;
    	g_res=g_res - i;
    }   	
    public void turno_oponente(){
      System.out.println("antes oro_res="+g_res+" oro_util="+g_util);
      jugar_oro();
      jugar_aliado();
      jugar_talisman();	
      System.out.println("oro_res="+g_res+" oro_util="+g_util);
    } 	
    public void jugar_oro(){
    	int num=-1;
           for(int i=0;hand[i].getnum()!=-1;i++){ /*buscar un oro en la mano*/
      	       if(hand[i].getipo()=="ORO"){
      		      num=i;
      	        }
           }   	
      if(num!=-1){  /*jugar oro*/
      	int i;
        gold_res[g_res]=hand[num];
        gold_res[g_res+1]=nula;
        g_res++;
        System.out.println("jugo oro:"+hand[num].getnombre());
        boton[0][1].setIcon(card[hand[num].getnum()]);  
        for(i=num;hand[i].getnum()!=-1;i++){	
      	 hand[i]=hand[i+1];
      	 if(hand[i+1].getnum()!=-1){boton[0][i+2].setIcon(card[hand[i+1].getnum()]);  
      	 }
      	 else{ boton[0][i+2].setIcon(vacia);
      	 }
      	}
        count--;
      }
     else{ System.out.println("no hay oros para jugar");
     } 	
    }
    public void jugar_aliado(){
    	int num=-1;
    	  for(int i=0;hand[i].getnum()!=-1;i++){  /*buscar un aliado en la mano*/
      	   if(hand[i].getipo()=="ALIADO"){
      		 if(hand[i].getcoste()<=g_res){
      		 	num=i;
      		 }
      	         }
                                              }	
        if(num!=-1){
           	int i;
           	mover_oros(hand[num].getcoste());
           	count--;
            for(i=0;defen[i].getnum()!=-1;i++){	}
            if(i<8){
            	defen[i]=hand[num];
                defen[i+1]=nula;
                boton[1][i+2].setIcon(card[hand[num].getnum()]);
                JOptionPane.showMessageDialog(null,""+defen[i].getnombre()+"\n"+defen[i].gethabil(),"JUGADA OPONENTE (MyL)",JOptionPane.INFORMATION_MESSAGE,card[defen[i].getnum()]);  
            }
            else{
            	System.out.println("no hay espacio para jugar");
            }
            	for(i=num;hand[i].getnum()!=-1;i++){	
      	        hand[i]=hand[i+1];
      	        if(hand[i+1].getnum()!=-1){boton[0][i+2].setIcon(card[hand[i+1].getnum()]);  
      	        }
      	        else{ boton[0][i+2].setIcon(vacia);
      	        }
      	    }
        }
        else{System.out.println("no se puede pagar el coste");
        }                                       	
    }
    public void jugar_talisman(){
    	int num=-1;
    	  for(int i=0;hand[i].getnum()!=-1;i++){  /*buscar un talisman en la mano*/
      	   if(hand[i].getipo()=="TALISMAN"){
      		 if(hand[i].getcoste()<=g_res){
      		 	num=i;
      		 }
      	         }
                                              }	
        if(num!=-1){
           	int i;
           	mover_oros(hand[num].getcoste());
           	count--;
            for(i=0;rip[i].getnum()!=-1;i++){	}
            rip[i]=hand[num];
            rip[i+1]=nula;
            JOptionPane.showMessageDialog(null,""+rip[i].getnombre()+"\n"+rip[i].gethabil(),"JUGADA OPONENTE (MyL)",JOptionPane.INFORMATION_MESSAGE,card[rip[i].getnum()]);  
            boton[1][0].setIcon(card[hand[num].getnum()]);  
            	for(i=num;hand[i].getnum()!=-1;i++){	
      	        hand[i]=hand[i+1];
      	        if(hand[i+1].getnum()!=-1){boton[0][i+2].setIcon(card[hand[i+1].getnum()]);  
      	        }
      	        else{ boton[0][i+2].setIcon(vacia);
      	        }
      	    }
        }
        else{System.out.println("no se puede pagar el coste");
        }                                     
    }
    public void reagrupa_op(){
    	 int i=0;
    	 System.out.println("reagrupar oro res="+g_res+" oro util="+g_util);	
     	  for(i=0;gold_util[i].getnum()!=-1;i++){
     		System.out.println(" "+gold_util[i].getnombre());
     		gold_res[g_res+i]=gold_util[i];
     		gold_util[i]=nula;
     	     }
     	   g_res=g_res+i; 
     	  boton[2][1].setIcon(vacia); 
     	  boton[0][1].setIcon(card[gold_res[g_res-1].getnum()]);
          g_util=0;
          gold_res[g_res]=nula;
          System.out.println("despues oros op oro res="+g_res+" oro util="+g_util);	
    }
    public void robar(){
    	int i;
    	if(castle[0].getnum()!=-1){  /*si quedan cartas*/
   	             for(i=0;hand[i].getnum()!=-1;i++){
   	  	                                       }                            
   	  	        hand[i+1]=nula;                               
   	          	hand[i]=castle[0];
   	          	boton[0][i+2].setIcon(card[hand[i].getnum()]);
   	          	System.out.println("robando oponente:");
   	    	    System.out.println("TIPO="+hand[i].getipo()+" NOMBRE="+hand[i].nombre+" valor="+hand[i].getcoste()+" fuerza="+hand[i].getfuerza()+" numero:"+hand[i].getnum());
   	  	       for(i=0;i<49;i++){
   	  	       	castle[i]=castle[i+1]; /*se mueven todas las cartas del castillo*/
   	  	       }
    		    count++; 
   	            }	
    	
    }
    public void atacar(int n){
    	/*Daño al castillo*/
    	int i,mayor,igual;
    	int daño=0;
    	mayor=igual=-1;
    	for(i=0;defen[i].getnum()!=-1;i++){
    		if(defen[i].getfuerza()>ataq[n].getfuerza()){
    		  mayor=i;}
    		if(defen[i].getfuerza()==ataq[n].getfuerza()){
    		  igual=i;}   
    	}
    	if(mayor!=-1){JOptionPane.showMessageDialog(null,"El oponente bloquea y destruye a "+ataq[n].getnombre(),"DEFENSA OPONENTE (MyL)",JOptionPane.INFORMATION_MESSAGE,card[defen[mayor].getnum()]);  	
    		  for(i=0;cementerio[i].getnum()!=-1;i++){}
    		  cementerio[i]=ataq[n];
    		  cementerio[i+1]=nula;
    		 for(i=n;ataq[i].getnum()!=-1;i++){	
      	        ataq[i]=ataq[i+1];
      	        if(ataq[i+1].getnum()!=-1){boton[3][i+2].setIcon(card[ataq[i+1].getnum()]);  
      	        }
      	        else{ boton[3][i+2].setIcon(vacia);
      	        }
      	    }
    	}
    	else{if(igual!=-1){JOptionPane.showMessageDialog(null,"Los 2 ALIADOS se destruyen ","DEFENSA OPONENTE (MyL)",JOptionPane.INFORMATION_MESSAGE,card[defen[igual].getnum()]);  	
              for(i=0;cementerio[i].getnum()!=-1;i++){}
    		   cementerio[i]=ataq[n];
    		   cementerio[i+1]=nula;
    		  for(i=n;ataq[i].getnum()!=-1;i++){	
      	        ataq[i]=ataq[i+1];
      	        if(ataq[i+1].getnum()!=-1){boton[3][i+2].setIcon(card[ataq[i+1].getnum()]);  
      	        }
      	        else{ boton[3][i+2].setIcon(vacia);
      	        }
      	     }	  
    	     /*envia aliado oponente al cementerio*/
    	     for(i=0;rip[i].getnum()!=-1;i++){}
    		   rip[i]=defen[igual];
    		   rip[i+1]=nula;
    		   boton[1][0].setIcon(card[rip[i].getnum()]);  
    		  for(i=igual;defen[i].getnum()!=-1;i++){	
      	        defen[i]=defen[i+1];
      	        if(defen[i+1].getnum()!=-1){boton[1][i+2].setIcon(card[defen[i+1].getnum()]);  
      	        }
      	        else{ boton[1][i+2].setIcon(vacia);
      	        }
      	     }	 
    	  }
    	  else{daño=ataq[n].getfuerza();
    	  }
    	}
        
        mensaje.setText("Daño="+daño);
        damage(daño,n);
      }
    public void damage(int daño,int n){
      int i;	
      for(i=0;rip[i].getnum()!=-1;i++){}
      if(daño>0){JOptionPane.showMessageDialog(null,"Castillo oponente recibe un Daño de "+daño+" puntos. ","CASTILLO OPONENTE (MyL)",JOptionPane.INFORMATION_MESSAGE,card[ataq[n].getnum()]);  
      }
    	int j;
    	for(j=i;daño!=0;j++){
    		if(castle[0].getnum()!=-1){
    		rip[j]=castle[0];
    		rip[j+1]=nula;
    		boton[1][0].setIcon(card[rip[j].getnum()]);
    		for(i=0;i<49;i++){
   	  	       	castle[i]=castle[i+1]; /*se mueven todas las cartas del castillo*/
   	  	       }
   	  	     if(castle[0].getnum()==-1){boton[1][1].setIcon(vacia);}  
    		daño--;}
    		else{JOptionPane.showMessageDialog(null,"Haz masacrado el Castillo oponente\nGANASTE!!!. ","CASTILLO OPONENTE (MyL)",JOptionPane.INFORMATION_MESSAGE,logo);  
    		daño=0;}
    	}
    }
    /*accion del mouse*/
    public void actionPerformed(ActionEvent ae) {
    	int x=0; /*para la mano*/
    	int w=0; /*defensa*/
    	int v=0; /*ataque*/
    	int y=0; /*defensa oponente*/
    	int z=0; /*ataque oponente*/
    	int u=0; /*mano oponente*/
    
    
    	if(ae.getSource()==boton[4][0]){  /*Boton del Cementerio*/
    		if(cementerio[0].getnum()!=-1){
    			int i=0;
    	  	do{
    	  	JOptionPane.showMessageDialog(null,""+cementerio[i].getnombre()+"\n"+cementerio[i].gethabil(),"CEMENTERIO (MyL)",JOptionPane.INFORMATION_MESSAGE,card[cementerio[i].getnum()]);
    	  	i++;}while(cementerio[i].getnum()!=-1);
    	}else{mensaje.setText(" No hay cartas..");
    	}}
    	if(ae.getSource()==boton[1][0]){  /*Boton del Cementerio oponente*/
    		if(rip[0].getnum()!=-1){
    			int i=0;
    	  	do{
    	  	JOptionPane.showMessageDialog(null,""+rip[i].getnombre()+"\n"+rip[i].gethabil(),"CEMENTERIO (MyL)",JOptionPane.INFORMATION_MESSAGE,card[rip[i].getnum()]);
    	  	i++;}while(rip[i].getnum()!=-1);
    	}else{mensaje.setText(" No hay cartas..");
    	}}	
    	if(ae.getSource()==boton[3][0]){ /*BOTON de Informacion*/
    	  if(informa.getnum()!=-1){
    	  	JOptionPane.showMessageDialog(null,""+informa.getnombre()+" "+informa.getfuerza()+"/"+informa.getcoste()+"\n"+informa.gethabil(),"INFORMACION (MyL)",JOptionPane.INFORMATION_MESSAGE,card[informa.getnum()]);
    	}}
    	if(ae.getSource()==boton[4][1]){           /*robar cartas*/
    		robar_carta();
    		}
    	if(ae.getSource()==boton[5][1]){   /* desde reserva de oros*/
    		 if(numoros_res>0){
    		 	//System.out.println("oros res="+numoros_res);
    		 boton[3][1].setIcon(card[oro_res[numoros_res-1].getnum()]);  /*muestra la carta*/
    		 numoros_res--;
    		 oro_util[orutil]=oro_res[numoros_res];
    		 oro_util[orutil+1]=nula;
    		 orutil++;
    		 usado++;
    		     if(numoros_res==0){
    		     	 oro_res[0]=nula;
    		     	 boton[5][1].setIcon(vacia);}
    		     else{boton[5][1].setIcon(card[oro_res[numoros_res-1].getnum()]);
    		         oro_res[numoros_res]=nula;
    		         }
    		}
    		else{ mensaje.setText(" No hay + oros en reserva.");
    		}	}
    	/* jugar desde la mano */
    	if(ae.getSource()==boton[5][2]){   
    	   x=2;}
    	if(ae.getSource()==boton[5][3]){                   /*carta 1*/
    		x=3;}
    	if(ae.getSource()==boton[5][4]){             /*carta 2*/
    		x=4;}
    	if(ae.getSource()==boton[5][5]){        /*carta 3*/
    		x=5;}
    	if(ae.getSource()==boton[5][6]){  /*carta 4*/
    		x=6;}
    	if(ae.getSource()==boton[5][7]){  /*carta 5*/
    		x=7;}
    	if(ae.getSource()==boton[5][8]){ /*mano 6*/
    		x=8;}
    	if(ae.getSource()==boton[5][9]){
    		x=9;}
    		/*Boton JuGar carta*/
         if((fase==4)&&(x!=0)){ /*Fase 4, descartar*/
    		if(contar>8){
    			int i;
    	    			for(i=0;cementerio[i].getnum()!=-1;i++){
    	    			}
    	    			System.out.println("i= "+i);
    	    			cementerio[i]=mano[x-2];
    	    			boton[4][0].setIcon(card[cementerio[i].getnum()]);
    	    			cementerio[i+1]=nula;
    	    			for(i=x-2;mano[i].getnum()!=-1;i++){ /*mover todas las cartas*/
    	               mano[i]=mano[i+1];
    	               if(i<7){
    	               	 boton[5][i+2].setIcon(boton[5][i+3].getIcon());
    	               }
    	               else{boton[5][i+2].setIcon(card[informa.getnum()]);
    	                    mano[7]=informa;
    	                    mano[8]=nula;
    	               }
    	               }        
    		contar--;}
    	}    		 
    	/*jugar carta desde la mano*/
    	 if(x!=0){
    	 	boton[3][0].setIcon(boton[5][x].getIcon());
    	 	informa=mano[x-2];
    	    if((mano[x-2].getnum()>-1)&&(mano[x-2].getnum()<16)){       /*bajar oro*/
    	      if((baja_oro==0)&&(fase==2)){
    	      int i;
    	      baja_oro++;
    	      oro_res[numoros_res]=mano[x-2];
    	      oro_res[numoros_res+1]=nula;
    	      numoros_res++;	
    	      boton[5][1].setIcon(boton[5][x].getIcon());
    	      for(i=x-2;mano[i].getnum()!=-1;i++){   /*mover todas las cartas*/
    	               mano[i]=mano[i+1];
    	               if(i<7){
    	               	 boton[5][i+2].setIcon(boton[5][i+3].getIcon());
    	               }
    	               else{boton[5][i+2].setIcon(vacia);
    	               }
    	               }
    	               
    	       contar--;        
    	      }
    	      else{
    	      	if(fase!=2){
    	      	mensaje.setText(" Solo en fase de vigilia.");}
    	      	else{mensaje.setText(" No puedes jugar + oros..");}
    	      	}
    	      }
    	    else{
    	    	if((mano[x-2].getnum()>-1)&&(usado>=mano[x-2].getcoste())){   /*juega carta*/
    	    		int i;
    	    		if((mano[x-2].getipo()=="TALISMAN")&&(fase!=4)){
    	    			usado=usado-mano[x-2].getcoste();
    	    			JOptionPane.showMessageDialog(null,mano[x-2].getnombre()+"\n"+mano[x-2].gethabil(),"MITOS Y LEYENDAS",JOptionPane.INFORMATION_MESSAGE,card[mano[x-2].getnum()]);
    	    			realiza_habilidad(mano[x-2].getnum());
    	    			boton[4][0].setIcon(boton[5][x].getIcon());
    	    			for(i=0;cementerio[i].getnum()!=-1;i++){
    	    			}
    	    			cementerio[i]=mano[x-2];
    	    			cementerio[i+1]=nula;
    	    			for(i=x-2;mano[i].getnum()!=-1;i++){ /*mover todas las cartas*/
    	               mano[i]=mano[i+1];
    	               if(i<7){
    	               	 boton[5][i+2].setIcon(boton[5][i+3].getIcon());
    	               }
    	               else{boton[5][i+2].setIcon(vacia);
    	               }
    	               }
    	    		contar--;
    	    		
    	    		}
    	    		else{
    	    			if(fase==2){
    	    			 mano[x-2].cambcoste(hab_coste(mano[x-2].getnum()));	
    	    			 usado=usado-mano[x-2].getcoste();
    	    		     for(i=0;def[i].getnum()!=-1;i++){}
    	    		     def[i+1]=nula;
    	    		     def[i]=mano[x-2];
    	    		     def[i].cambturno();
                         if(mano[x-2].getabil()==true){
                    	 JOptionPane.showMessageDialog(null,mano[x-2].getnombre()+"\n"+mano[x-2].gethabil(),"MITOS Y LEYENDAS",JOptionPane.INFORMATION_MESSAGE,card[mano[x-2].getnum()]);
                         realiza_habilidad(mano[x-2].getnum());
                         }
    	    		     boton[4][i+2].setIcon(boton[5][x].getIcon());
    	    	         for(i=x-2;mano[i].getnum()!=-1;i++){ /*mover todas las cartas*/
    	                  mano[i]=mano[i+1];
    	                  if(i<7){
    	               	   boton[5][i+2].setIcon(boton[5][i+3].getIcon());
    	                   }
    	                  else{boton[5][i+2].setIcon(vacia);}
    	                 } 
    	                 contar--;	}
    	               else{mensaje.setText(" Solo en fase de vigilia.");
    	               }
    	               }
    	           }
    	    	else{if(mano[x-2].getnum()==-1){mensaje.setText(" No hay carta...");
    	    	}
    	    		else{mensaje.setText(" Es MAYOR el coste...("+mano[x-2].getcoste()+")");}
    	    	}
    	    }  
    	    	} 	
    	/* apuntar aliado oponente */
    	if(ae.getSource()==boton[1][2]){   
    	   y=2;}
    	if(ae.getSource()==boton[1][3]){y=3;}                   
    	if(ae.getSource()==boton[1][4]){             
    		y=4;}
    	if(ae.getSource()==boton[1][5]){y=5;}        
    	if(ae.getSource()==boton[1][6]){  
    		y=6;}
    	if(ae.getSource()==boton[1][7]){  
    		y=7;}
    	if(ae.getSource()==boton[1][8]){ 
    		y=8;}
    	if(ae.getSource()==boton[1][9]){
    		y=9;} /*Usar habilidad de cartas efecto en cartas oponentes*/ 	    	 
        if(y!=0){if(defen[y-2].getnum()!=-1){
        	     informa=defen[y-2];
                 boton[3][0].setIcon(boton[1][y].getIcon());
                    if(skill==18){ defen[y-2].cambpos(3);}
                    if(skill==24){ defen[y-2].cambunica();}
                   if(skill==46){defen[y-2].sinhabil();
                                skill=0;}
                       
                    }
                 }
     	/* apuntar mano oponente */
    	if(ae.getSource()==boton[0][2]){   
    	   u=2;}
    	if(ae.getSource()==boton[0][3]){u=3;}                   
    	if(ae.getSource()==boton[0][4]){             
    		u=4;}
    	if(ae.getSource()==boton[0][5]){u=5;}        
    	if(ae.getSource()==boton[0][6]){  
    		u=6;}
    	if(ae.getSource()==boton[0][7]){  
    		u=7;}
    	if(ae.getSource()==boton[0][8]){ 
    		u=8;}
    	if(ae.getSource()==boton[0][9]){
    		u=9;} /*Usar habilidad de cartas efecto en mano oponente*/ 	    	 
        if(u!=0){
        	if(hand[u-2].getnum()!=-1){
        	     informa=hand[u-2];
                 boton[3][0].setIcon(boton[0][u].getIcon());
                   
                    if(skill==45){int i;
                    for(i=0;rip[i].getnum()!=-1;i++){ }
                    rip[i]=hand[u-2];
                    rip[i+1]=nula;
                    boton[1][0].setIcon(card[rip[i].getnum()]);
                    for(i=u-2;hand[i].getnum()!=-1;i++){ /*mover todas las cartas*/
    	               hand[i]=hand[i+1];
    	               if(i<7){
    	               	 boton[0][i+2].setIcon(boton[0][i+3].getIcon());
    	               }
    	               else{boton[0][i+2].setIcon(vacia);
    	               }
    	               }
                    }
                  if(skill==32){
                  	int i;
                    for(i=0;rip[i].getnum()!=-1;i++){ }
                    rip[i]=hand[u-2];
                    rip[i+1]=nula;
                    boton[1][0].setIcon(card[rip[i].getnum()]);
                    for(i=u-2;hand[i].getnum()!=-1;i++){ /*mover todas las cartas*/
    	               hand[i]=hand[i+1];
    	               if(i<7){
    	               	 boton[0][i+2].setIcon(boton[0][i+3].getIcon());
    	               }
    	               else{boton[0][i+2].setIcon(vacia);
    	               }
    	               }
                  	skill=45;
                  }  
                 } 
                 	}           
     /* apuntar aliado en defensa*/
    	if(ae.getSource()==boton[4][2]){   
    	   w=2;}
    	if(ae.getSource()==boton[4][3]){w=3;}                   
    	if(ae.getSource()==boton[4][4]){             
    		w=4;}
    	if(ae.getSource()==boton[4][5]){w=5;}        
    	if(ae.getSource()==boton[4][6]){  
    		w=6;}
    	if(ae.getSource()==boton[4][7]){  
    		w=7;}
    	if(ae.getSource()==boton[4][8]){ 
    		w=8;}
    	if(ae.getSource()==boton[4][9]){
    		w=9;} 	    	 
        if(w!=0){boton[3][0].setIcon(boton[4][w].getIcon());
    	 	     informa=def[w-2];
    	 	     if((fase==3)&&(def[w-2].getturno()>1)){ /*Atacar oponente*/
    	 	     	if(def[w-2].getpos()!=0){
    	 	     		int i;
    	 	     		ataq[w-2]=def[w-2];
    	 	     		boton[3][w].setIcon(boton[4][w].getIcon());
    	 	     		boton[4][w].setIcon(vacia);
    	 	     		def[w-2]=nula;
    	 	     		atacar(w-2);
    	 	     	}
    	 	     	else{mensaje.setText("No puede ATACAR.");
    	 	     	}
    	 	     }
    	 	     if(skill==21){int i;
                       for(i=0;cementerio[i].getnum()!=-1;i++){}
                       cementerio[i]=def[w-2];
                       cementerio[i+1]=nula;
                       boton[4][0].setIcon(card[cementerio[i].getnum()]);
                       for(i=w-2;def[i].getnum()!=-1;i++){ /*mover todas las cartas*/
    	               def[i]=def[i+1];
    	               if(i<7){
    	               	 boton[4][i+2].setIcon(boton[4][i+3].getIcon());
    	               }
    	               else{boton[4][i+2].setIcon(vacia);}}
    	 	     skill=0;}
    	 	     if(skill==49){def[w-2].incfuerza(3);
    	 	        skill=0;}
    	 	     if(skill==28){int i;
                       for(i=0;cementerio[i].getnum()!=-1;i++){}
                       cementerio[i]=def[w-2];
                       cementerio[i+1]=nula;
                       boton[4][0].setIcon(card[cementerio[i].getnum()]);
                       for(i=w-2;def[i].getnum()!=-1;i++){ /*mover todas las cartas*/
    	               def[i]=def[i+1];
    	               if(i<7){
    	               	 boton[4][i+2].setIcon(boton[4][i+3].getIcon());
    	               }
    	               else{boton[4][i+2].setIcon(vacia);}}
    	               int k=0;
    	               while(k!=2){
    	               for(i=0;mazo[i].getipo()!="ORO";i++){
    	               	  JOptionPane.showMessageDialog(null,""+mazo[i].getnombre()+"\n"+mazo[i].gethabil(),"CASTILLO (MyL)",JOptionPane.INFORMATION_MESSAGE,card[mazo[i].getnum()]);
                         }
                          JOptionPane.showMessageDialog(null,"Se encontró un ORO:\n"+mazo[i].getnombre()+"\n"+mazo[i].gethabil(),"CASTILLO (MyL)",JOptionPane.INFORMATION_MESSAGE,card[mazo[i].getnum()]);
                         int j;
                         for(j=0;mano[j].getnum()!=-1;j++){}
                         mano[j]=mazo[i];
                         mano[j+1]=nula;
                         if(j<8){boton[5][j+2].setIcon(card[mano[j].getnum()]);
                         }
                         for(j=i;j<49;j++){
                         	mazo[j]=mazo[j+1];
                         }
                         for(j=0;mazo[j].getnum()!=-1;j++){}
                         barajar(j);
                         contar++;
                         k++;}
                      skill=0;}
                if(def[w-2].getnum()==48){
                   String alt;	
                   Carta aux;
                   alt=JOptionPane.showInputDialog(null,"¿Destruir a Anubis?","MyL",JOptionPane.QUESTION_MESSAGE);
                   if(alt.equals("si")){int i;
                      for(i=0;(cementerio[i].getnum()!=-1)||(i!=-1);i++){
                         JOptionPane.showMessageDialog(null,""+cementerio[i].getnombre()+"\n"+cementerio[i].gethabil(),"CEMENTERIO (MyL)",JOptionPane.INFORMATION_MESSAGE,card[cementerio[i].getnum()]);
                         if(cementerio[i].getipo()=="ALIADO"){
                         String resp;
                         resp=JOptionPane.showInputDialog(null,"¿Exhumar este Aliado?","CEMENTERIO (MyL)",JOptionPane.QUESTION_MESSAGE);
                           if(resp.equals("si")){
                           	 aux=def[w-2];
                           	 def[w-2]=cementerio[i];
                           	 cementerio[i]=aux;
                           	 boton[4][w].setIcon(card[def[w-2].getnum()]);
                           	 i=-2;}}}
                           }
                  if(alt.equals("no")){mensaje.setText("No se exhuma.");} }
                 }
      /* apuntar aliado en ataque*/
    	if(ae.getSource()==boton[3][2]){ v=2;}
    	if(ae.getSource()==boton[3][3]){v=3;}                   
    	if(ae.getSource()==boton[3][4]){v=4;}
    	if(ae.getSource()==boton[3][5]){v=5;}        
    	if(ae.getSource()==boton[3][6]){v=6;}
    	if(ae.getSource()==boton[3][7]){v=7;}
    	if(ae.getSource()==boton[3][8]){v=8;}
    	if(ae.getSource()==boton[3][9]){v=9;} 	 
    	if(v!=0){boton[3][0].setIcon(boton[3][v].getIcon());
    	 	     informa=ataq[v-2];}
    /*Opciones para elegir desde los comandos*/	 	     
     if(fase==0){/*Elige cartas desde coleccion*/
      }	 	     		                                    
     if(ae.getSource()==comandos[0]){
     	JOptionPane.showMessageDialog(null,"Comenzando una nueva partida\nLas cartas se barajan en tu Castillo.","MITOS Y LEYENDAS",JOptionPane.INFORMATION_MESSAGE,logo);
		if(fase==0){ini_mano();
		fase++;
		}
		else{nuevo_juego();
		}
		JOptionPane.showMessageDialog(null,"Roba 8 Cartas de tu Castillo.","MITOS Y LEYENDAS",JOptionPane.INFORMATION_MESSAGE,logo); }
     if(ae.getSource()==comandos[1]){
     	JOptionPane.showMessageDialog(null,"Coleccion Total de Cartas\nElige 50 cartas para crear tu mazo-Castillo.","MITOS Y LEYENDAS",JOptionPane.INFORMATION_MESSAGE,logo);
		coleccion();	
     }
     
     if(ae.getSource()==comandos[3]){
    	 fase++;        	
    	 if(fase==2){
    	 comandos[3].setText("FASE de VIGILIA"); }
    	 if(fase==3){
    	 comandos[3].setText("FASE de BATALLA"); }
    	 if(fase==4){
    	 	System.out.println("contar="+contar);
     	    if(contar<8){        /*robar cartas*/
    		/*algoritmo de robar*/
    		 int i;
    		 if(mazo[0].getnum()!=-1){  /*si quedan cartas*/
   	             for(i=0;mano[i].getnum()!=-1;i++){
   	  	                                       }                            
   	  	        mano[i+1]=nula;                               
   	          	mano[i]=mazo[0];
   	          	informa=mano[i];
   	          	boton[3][0].setIcon(card[mano[i].getnum()]);
   	          	JOptionPane.showMessageDialog(null,""+mano[i].getnombre()+"\n"+mano[i].gethabil(),"ROBASTE (MyL)",JOptionPane.INFORMATION_MESSAGE,card[mano[i].getnum()]);
   	          	boton[5][i+2].setIcon(card[mano[i].getnum()]);
   	          	System.out.println("robando:");
   	    	    System.out.println("TIPO="+mano[i].getipo()+" NOMBRE="+mano[i].nombre+" valor="+mano[i].getcoste()+" fuerza="+mano[i].getfuerza()+" numero"+mano[i].getnum());
   	  	        System.out.println("Turno="+mano[i].getturno());
   	  	       for(i=0;i<49;i++){
   	  	       	mazo[i]=mazo[i+1]; /*se mueven todas las cartas del castillo*/
   	  	       }
   	            }	
    		contar++;
    		}
    	   else{ int num=contar-7;
    	         mensaje.setText("Descartate de "+num+" carta.");
    	         int i;
    		 if(mazo[0].getnum()!=-1){  /*si quedan cartas*/                                                       
   	          	informa=mazo[0];
   	          	boton[3][0].setIcon(card[informa.getnum()]);
   	          	JOptionPane.showMessageDialog(null,""+informa.getnombre()+"\n"+informa.gethabil(),"ROBASTE (MyL)",JOptionPane.INFORMATION_MESSAGE,card[informa.getnum()]);
   	          	System.out.println("robando:");
   	    	    System.out.println("TIPO="+informa.getipo()+" NOMBRE="+informa.nombre+" valor="+informa.getcoste()+" fuerza="+informa.getfuerza()+" numero"+informa.getnum());
   	  	        System.out.println("Turno="+informa.getturno());
   	  	       for(i=0;i<49;i++){
   	  	       	mazo[i]=mazo[i+1]; /*se mueven todas las cartas del castillo*/
   	  	       }
   	            }
   	            JOptionPane.showMessageDialog(null,"Elige "+num+" cartas de tu mano para descartar","MITOS Y LEYENDAS",JOptionPane.INFORMATION_MESSAGE);	
    	        contar++;	}
    	 comandos[3].setText("FIN TURNO"); }          	
    	 if(fase==5){
    	 	if(contar>8){fase=4;
    	 	JOptionPane.showMessageDialog(null,"NO PUEDES TERMINAR SIN DESCARTAR","MITOS Y LEYENDAS",JOptionPane.INFORMATION_MESSAGE);	
    	 	}
    	 	else{
    	 comandos[3].setText("Turno OPONENTE"); 	
     	/*empieza turno oponente*/
     	reagrupa_op();
     	turno_oponente();
     	robar();
     
     	/*los oros vuelven*/
     	reagrupar();
    	 fase=1;}
    	 }
       }  	                 
     }
    public static void main (String [] args){
		  //lanza la aplicacion
		  new mito();
		  
		}
}