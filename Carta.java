/**
 * @(#)carta.java
 *
 *
 * @author Meister_Kapitan
 * @version 1.00 2008/7/10
 */
import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.io.*;

/*LAS CARTAS HASTA MERLIN 107*/
public class Carta {
	String nombre;
    private int valor;
    private int fuerza;
    private int bono;
    private int numero;
    private String tipo;
    private String raza;
    boolean habilidad;
    private String ability; 
    private int turno;
    private int posicion; /*si defiende o ataca(0,1,2)*/
    private boolean unica;
    private boolean bloquea; /*si esta bloqueando a una carta*/
    private boolean ataca; /*si esta atacando*/
    /*Constructores*/
    public Carta(){
    	valor=fuerza=numero=bono=-1;
    	habilidad=false;
    	nombre="NULA";
    	tipo="ORO";
    	raza="";
    	ability="";
    	turno=0;
    	posicion=0;
    	unica=false;
    	bloquea=false;
    	ataca=false;
    }
    public Carta(int n){
    	valor=coste(n);
    	numero=n;
    	fuerza=force(n);
    	bono=0;
    	habilidad=habil(n);
    	nombre=getname(n);
    	tipo=gettipo(n);
    	raza=veraza(n);
    	ability=getability(n);
    	turno=0;
    	posicion=getposic(n);
    	unica=unicidad(n);
    	bloquea=false;
    	ataca=false;
    }
    
       /*Metodos básicos obtener*/
    public String getnombre(){
    	return(nombre);
    }
    public int getnum(){
    	return(numero);
    }
    public int getcoste(){
    	return(valor);
    }
    public int getfuerza(){
    	return(fuerza);
    }
    public String getipo(){
    	return(tipo);
    }
    public boolean getabil(){
    	return(habilidad);
    }
    public String gethabil(){
    	return(ability);
    }
    public int getturno(){
    	return(turno);
    }
    public int getpos(){ return(posicion);
    }
    public boolean unicidad(int n){
    	if((n==36)||(n==48)){
    	return(true);}
    	else{return(false);
    	}
    }
    public int getbono(){return(bono);
    }
    public String getraza(){return(raza);
    }
      /*Metodos basicos cambiar*/
    public void cambturno(){
    	turno++;
    }
    public void incfuerza(int n){
    	fuerza=fuerza+n;
    }
    public void incbono(int n){bono=bono+n;
    }
    public void cambpos(int n){
    	posicion=n;
    }
    public void cambunica(){
    	if(unica==true){unica=false;
    	}
    	else{unica=true;
    	}
    }
    public void sinhabil(){
    	if(habilidad==true){
    		habilidad=false;
    	}
    }
    public void cambcoste(int n){valor=n;
    }
    public void cambbloqueo(){
    	if(bloquea==true){
    		bloquea=false;
    	}
    	else{bloquea=true;
    	}
    }
    public void cambatacar(){
    	if(ataca==true){
    		ataca=false;
    	}else{ataca=true;
    	}
    }
     /*Metodos avanzados*/
    public int coste(int n){   /*Busca el coste de la carta segun numero de la carta*/
    	int a;
    	switch(n){
    		case 16: 
    			a=1;
    		break;
    		case 17: 
    			a=3;
    		break;
    		case 18: 
    			a=1;
    		break;
    		case 19: 
    			a=3;
    		break;
    		case 20: 
    			a=3;
    		break;
    		case 21: 
    			a=4;
    		break;
    		case 22: 
    			a=1;
    		break;
    		case 23: 
    			a=2;
    		break;
    		case 24: 
    			a=4;
    		break;
    		case 25: 
    		      a=3;
    		break;
    		case 26: 
    			a=3;
    		break;
    		case 27: 
    			a=2;
    		break;
    		case 28: 
    			a=1;
    		break;
    		case 29: 
    			a=3;
    			break;
    		case 30: 
    			a=1;
    			break;
    		case 31: 
    			a=2;
    			break;
    		case 32: 
    			a=3;
    			break;
    		case 33: 
    			a=5;
    			break;
    		case 34: 
    			a=6;
    			break;
    		case 35: 
    			a=3;
    			break;
    		case 36: 
    			a=0;
    			break;
    		case 37: 
    			a=3;
    			break;
    		case 38: 
    			a=2;
    			break;
    		case 39: 
    			a=6;
    			break;
    		case 40: 
    			a=3;
    			break;
    		case 41: 
    			a=1;
    			break;
    		case 42: 
    			a=2;
    			break;
    		case 43: 
    			a=2;
    			break;
    		case 44: 
    			a=2;
    			break;
    		case 45: 
    			a=2;
    			break;
    		case 46: a=2;
    			break;
    		case 47: a=2;
    			break;
    		case 48: a=2;
    			break;
    		case 49: a=2;
    			break;
    		case 50: a=1;
    			break;
    		case 51: a=2;
    			break;
    		case 52: a=4;
    			break;
    		case 53: a=3;
    			break;
    		case 54: a=2;
    			break;
    		case 55: a=0;
    			break;
    		case 56: a=2;
    			break;
    		case 57: a=2;
    			break;
    		case 58: a=5;
    			break;
    		case 59: a=2;
    			break;
    		case 60: a=3;
    			break;
    		case 61: a=2;
    			break;
    		case 62: a=3;
    			break;
    		case 63: a=2;
    			break;
    		case 64: a=1;
    			break;
    		case 65: a=2;
    			break;
    		case 66: a=1;
    			break;
    		case 67: a=2;
    			break;
    		case 68: a=3;
    			break;
    		case 69: a=5;
    			break;
    		case 70: a=3;
    			break;
    		case 71: a=3;
    			break;
    		case 72: a=2;
    			break;
    		case 73: a=3;
    			break;
    		case 74: a=3;
    			break;
    		case 75: a=2;
    			break;
    		case 76: a=3;
    			break;
    		case 77: a=1;
    			break;
    		case 78: a=3;
    			break;
    		case 79: a=0;
    			break;
    		case 80: a=2;
    			break;
    		case 81: a=2;
    			break;
    		case 82: a=1;
    			break;
    		case 83: a=3;
    			break;
    		case 84: a=3;
    			break;
    		case 85: a=3;
    			break;
    		case 86: a=2;
    			break;
    		case 87: a=3;
    			break;
    		case 88: a=2;
    			break;
    		case 89: a=4;
    			break;
    		case 90: a=1;
    			break;
    		case 91: a=3;
    			break;
    		case 92: a=2;
    			break;
    		case 93: a=4;
    			break;
    		case 94: a=3;
    			break;
    		case 95: a=5;
    			break;
    		case 96: a=2;
    			break;
    		case 97: a=4;
    			break;
    		case 98: a=1;
    			break;
    		case 99: a=3;
    			break;
    		case 100: a=2;
    			break;
    		case 101: a=1;
    			break;
    		case 102: a=4;
    			break;
    		case 103: a=2;
    			break;
    		case 104: a=6;
    			break;
    		case 105: a=4;
    			break;
    		case 106: a=4;
    			break;
    		case 107: a=4;
    			break;
    		default: a=0;
    			}
    	return(a);		
    		}
    public int force(int n){
    		int a;
    	switch(n){
    		case 16: 
    			a=1;
    		break;
    		case 17: 
    			a=2;
    		break;
    		case 19: 
    			a=1;
    		break;
    		case 21: 
    			a=4;
    		break;
    		case 22: 
    			a=1;
    		break;
    		case 23: 
    			a=2;
    		break;
    		case 29: 
    			a=1;
    			break;
    		case 30: 
    			a=1;
    			break;
    		case 33: 
    			a=0;
    			break;
    		case 35: 
    			a=2;
    			break;
    		case 36: 
    			a=6;
    			break;
    		case 37: 
    			a=1;
    			break;
    		case 38: 
    			a=3;
    			break;
    		case 39: 
    			a=6;
    			break;
    		case 40: 
    			a=1;
    			break;
    		case 41: 
    			a=1;
    			break;
    		case 42: 
    			a=2;
    			break;
    		case 43: 
    			a=4;
    			break;
    		case 44: 
    			a=1;
    			break;
    		case 47: a=4;
    			break;
    		case 48: a=0;
    			break;
    		case 51: a=1;
    			break;
    		case 52: a=3;
    			break;
    		case 53: a=2;
    			break;
    		case 54: a=1;
    			break;
    		case 55: a=2;
    			break;
    		case 56: a=1;
    			break;
    		case 58: a=2;
    			break;
    		case 59: a=1;
    			break;
    		case 60: a=1;
    			break;
    		case 63: a=1;
    			break;
    		case 64: a=1;
    			break;
    		case 70: a=2;
    			break;
    		case 71: a=1;
    			break;
    		case 72: a=1;
    			break;
    		case 73: a=1;
    			break;
    		case 75: a=1;
    			break;
    		case 76: a=2;
    			break;
    		case 78: a=2;
    			break;
    		case 82: a=1;
    			break;
    		case 83: a=3;
    			break;
    		case 86: a=1;
    			break;
    		case 87: a=1;
    			break;
    		case 88: a=2;
    			break;
    		case 89: a=2;
    			break;
    		case 91: a=2;
    			break;
    		case 92: a=3;
    			break;
    		case 93: a=4;
    			break;
    		case 94: a=1;
    			break;
    		case 95: a=4;
    			break;
    		case 97: a=2;
    			break;
    		case 100: a=4;
    			break;
    		case 101: a=1;
    			break;
    		case 102: a=3;
    			break;
    		case 104: a=4;
    			break;
    		case 105: a=1;
    			break;
    		case 106: a=2;
    			break;
    		default: a=0;
    			}
    	return(a);		
    }
    public String getname(int n){
    		String a;
    	switch(n){
    		case 0: 
    			a="ARMADURA DORADA";
    		break;
    		case 1: 
    			a="CALIZ SAGRADO";
    		break;
    		case 2: 
    			a="DIAMANTE TURQUEZA";
    		break;
    		case 3: 
    			a="ESCUDO REAL";
    		break;
    		case 4: 
    			a="ESPADA REAL";
    		break;
    		case 5: 
    			a="FINAL DEL ARCOIRIS";
    		break;
    		case 6: 
    			a="ESTATUA DE ORO";
    		break;
    		case 7: 
    			a="FRUTO SAGRADO";
    		break;
    		case 8: 
    			a="JOYAS DE LA CORONA";
    		break;
    		case 9: 
    			a="LAMPARA MAGICA";
    		break;
    		case 10: 
    			a="MINAS DEL REY SALOMON";
    		break;
    		case 11: 
    			a="MONEDAS DE ORO";
    		break;
    		case 12: 
    			a="PORTAL CELESTIAL";
    		break;
    		case 13: 
    			a="ROSA DE LOS VIENTOS";
    		break;
    		case 14: 
    			a="TESORO DEL REY";
    		break;
    		case 15: 
    			a="CUERNO DE LA ABUNDANCIA";
    		break;
    		case 16: 
    			a="BEOWULF";
    		break;
    		case 17: 
    			a="BERSERKER";
    		break;
    		case 18: 
    			a="BRUJA CARABUSSE";
    		break;
    		case 19: 
    			a="BRUJO CHILOTE";
    		break;
    		case 20: 
    			a="BUFALO BLANCO";
    		break;
    		case 21: 
    			a="BUNYIP";
    		break;
    		case 22: 
    			a="CABALLERO BLANCO";
    		break;
    		case 23: 
    			a="CABALLERO NEGRO";
    		break;
    		case 24: 
    			a="CABALLO DE TROYA";
    		break;
    		case 25: 
    		      a="CAJA DE PANDORA";
    		break;
    		case 26: 
    			a="CALEUCHE";
    		break;
    		case 27: 
    			a="AFRODITA";
    		break;
    		case 28: 
    			a="CANCERBERO";
    		break;
    		case 29: 
    			a="CENTAURO";
    			break;
    		case 30: 
    			a="CERNUNNO";
    			break;
    		case 31: 
    			a="CHON CHON";
    			break;
    		case 32: 
    			a="CICLOPE";
    			break;
    		case 33: 
    			a="CIZIN";
    			break;
    		case 34: 
    			a="CONEJO ESCRIBA";
    			break;
    		case 35: 
    			a="EL BASAJAUN";
    			break;
    		case 36: 
    			a="DEMONIO";
    			break;
    		case 37: 
    			a="EL ALICANTO";
    			break;
    		case 38: 
    			a="DAGON";
    			break;
    		case 39: 
    			a="DRAGON ORIENTAL";
    			break;
    		case 40: 
    			a="DUENDE";
    			break;
    		case 41: 
    			a="EK CHUAH";
    			break;
    		case 42: 
    			a="AMAZONAS";
    			break;
    		case 43: 
    			a="ESFINGE";
    			break;
    		case 44: 
    			a="ESHU";
    			break;
    		case 45: 
    			a="ANCHIMALLEN";
    			break;
    		case 46: a="APOLO";
    			break;
    		case 47: a="FENRIR";
    			break;
    		case 48: a="ANUBIS";
    			break;
    		case 49: a="AQUILES";
    			break;
    		case 50: a="FUHI";
    			break;
    		case 51: a="GARGOLA";
    			break;
    		case 52: a="GIGANTE ANDINO";
    			break;
    		case 53: a="GILGAMESH";
    			break;
    		case 54: a="GNOMO";
    			break;
    		case 55: a="GNOMOS BURLONES";
    			break;
    		case 56: a="GOBLINS";
    			break;
    		case 57: a="GORGONAS";
    			break;
    		case 58: a="GRIFO";
    			break;
    		case 59: a="GROOTSLANG";
    			break;
    		case 60: a="GUERRERO JAGUAR";
    			break;
    		case 61: a="GUILLERMO TELL";
    			break;
    		case 62: a="HADA VIVIANA";
    			break;
    		case 63: a="HADAS";
    			break;
    		case 64: a="HADAS GUERRERAS";
    			break;
    		case 65: a="HADES";
    			break;
    		case 66: a="HALLT";
    			break;
    		case 67: a="HAIWATHA";
    			break;
    		case 68: a="HEFESTO";
    			break;
    		case 69: a="HERCULES";
    			break;
    		case 70: a="HERMES";
    			break;
    		case 71: a="HOMBRE DE PIEDRA";
    			break;
    		case 72: a="HOMBRE LOBO";
    			break;
    		case 73: a="HOMBRE PAJARO";
    			break;
    		case 74: a="HORUS";
    			break;
    		case 75: a="HUNAHPU Y XBALANQUI";
    			break;
    		case 76: a="HUMBABA";
    			break;
    		case 77: a="HUTZILOPOCHTLI";
    			break;
    		case 78: a="HYDRA";
    			break;
    		case 79: a="ICARO";
    			break;
    		case 80: a="INDRA";
    			break;
    		case 81: a="INVUNCHE";
    			break;
    		case 82: a="ISIS";
    			break;
    		case 83: a="ISTHAR";
    			break;
    		case 84: a="IZANAMI E IZANAGI";
    			break;
    		case 85: a="JINAS";
    			break;
    		case 86: a="ARGONAUTAS";
    			break;
    		case 87: a="KALI";
    			break;
    		case 88: a="KASEWATS";
    			break;
    		case 89: a="KEL-ESSUF";
    			break;
    		case 90: a="KELPIE";
    			break;
    		case 91: a="KHNUM";
    			break;
    		case 92: a="KRISHNA";
    			break;
    		case 93: a="KORDRAG";
    			break;
    		case 94: a="KORNOS";
    			break;
    		case 95: a="KRAKEN";
    			break;
    		case 96: a="ARPIA";
    			break;
    		case 97: a="LILITH";
    			break;
    		case 98: a="LOKI";
    			break;
    		case 99: a="LOTHAR";
    			break;
    		case 100: a="MANUK";
    			break;
    		case 101: a="MARA";
    			break;
    		case 102: a="MARDUK";
    			break;
    		case 103: a="MATADOR DE DRAGONES";
    			break;
    		case 104: a="MAUI";
    			break;
    		case 105: a="MEDUSA";
    			break;
    		case 106: a="MELUSINA";
    			break;
    		case 107: a="MERLIN";
    			break;
    		default: a="NO_HAY";
    			}
    	return(a);	
    }
    public String gettipo(int n){
     String a;
     if(n<16){
     	a="ORO";
     }
     else{
     	if((n==18)||(n==20)||(n==24)||(n==25)||(n==26)||(n==27)||(n==28)||(n==31)||(n==32)||(n==34)||(n==45)||(n==46)||(n==49)||(n==50)||(n==57)||(n==61)||(n==62)||(n==65)||(n==66)||(n==67)||(n==68)||(n==69)||(n==74)||(n==77)||(n==79)||(n==80)||(n==81)||(n==84)||(n==85)||(n==90)||(n==96)||(n==98)||(n==99)||(n==103)||(n==107)){
     	 a="TALISMAN";
     	 }
     	else{
     		a="ALIADO";
     	} 
     }	
     	return(a);
    }
    public String getability(int n){
      String a;
    	switch(n){
          	case 17: 
    			a="BERSERKER no puede ser bloqueado";
    		break;
    		case 18: 
    			a="Una carta oponente no puede bloquear en este turno";
    		break;
    		case 20: 
    			a="Todos tus aliados ganan +1 a la fuerza hasta el final del turno";
    		break;
    		case 21: 
    			a="Cuando entra en juego destruye uno de tus aliados";
    		break;
    		case 23: 
    			a="Al entrar en juego todos los demas caballeros ganan +1 de fuerza permanentemente";
    		break;
    		case 24: 
    			a="Nombra una carta de tu oponente; este no puede jugar mas copias de esa carta ";
    		break;
    		case 25: 
    		      a="Cada jugador muestra la carta superior de su castillo.\nSi es un aliado es puesto en juego, sino descartala";
    		break;
    		case 26: 
    			a="Las cartas del oponente no pueden bloquear en este turno";
    		break;
    		case 27: 
    			a="Mira las 3 cartas superiores del castillo oponente y ordenalas como quieras";
    		break;
    		case 28: 
    			a="Destruye un aliado en juego y puedes buscar 2 cartas de oro en tu castillo";
    		break;
    		case 31: 
    			a="El oponente bota 2 cartas de su castillo";
    			break;
    		case 32: 
    			a="Bota al azar 2 cartas del oponente";
    			break;
    		case 33: 
    			a="Tiene fuerza igual al numero de oros que tengas en juego";
    			break;
    		case 34: 
    			a="Por el resto del juego, tu oponente juega con la mano descubierta";
    			break;
    		case 35: 
    			a="Si ataca debe ser bloqueado";
    			break;
    		case 36: 
    			a="Para ponerlo en juego, debes botar 4 cartas de tu castillo";
    			break;
    		case 38: 
    			a="Cuando entra en juego, debes mostrar tu mano a tu oponente";
    			break;
    		case 39: 
    			a="Puede bloquear cartas imbloqueables";
    			break;
    		case 41: 
    			a="Cuando ataca, tambien deben hacerlo todos los aliados habilitados para atacar";
    			break;
    		case 42: 
    			a="Si hay cartas de AMAZONAS en juego su valor se reduce a '0'";
    			break;
    		case 43: 
    			a="La ESFINGE no puede atacar, sólo defender";
    			break;
    		case 45: 
    			a="Envia al cementerio una carta al azar de la mano de tu oponente";
    			break;
    		case 46: a="Una carta en juego pierde todas sus habilidades por este turno";
    			break;
    		case 47: a="Si ataca debe ser acompañado por 2 aliados";
    			break;
    		case 48: a="Destruye a Anubis y regresa una carta de tu cementerio a linea de defensa";
    			break;
    		case 49: a="Un aliado defensor gana +3 a la fuerza hasta el final del turno";
    			break;
    		case 50: a="Una carta atacante no hace daño en este turno";
    			break;
    		
    		case 55: a="Destruye una carta de aliado en juego";
    			break;
    		case 56: a="Si un aliado oponente lo bloquea, este pierde un punto de fuerza";
    			break;
    		case 57: a="Una carta de tu oponente que tu elijas tendra fuerza '0' hasta el final del turno";
    			break;
    		case 59: a="Puedes destruirlo, buscar un oro en tu castillo y ponerlo en juego";
    			break;
    		case 60: a="Cuando ataca, gana +1 a la fuerza hasta el final del turno";
    			break;
    		case 61: a="Nombra una carta. Tu oponente muestra la mano, si la tiene descartala ";
    			break;
    		case 62: a="Tu oponente no roba en el proximo turno";
    			break;
    		case 65: a="Elige una carta de aliado en juego y cambiala por una de tu oponente";
    			break;
    		case 66: a="Otorga 2 oros por el turno";
    			break;
    		case 67: a="Devuelve una carta del cementerio a tu mano";
    			break;
    		case 68: a="Un aliado en batalla gana +1 de fuerza permanentemente";
    			break;
    		case 69: a="Un aliado gana +3 de fuerza permanentemente";
    			break;
    		case 70: a="Si tu oponente bloquea, tu eliges quien bloquea a Hermes";
    			break;
    		case 73: a="Cuando entra en juego, cada jugador muestra su mano y descarta un talisman si tiene alguno";
    			break;
    		case 74: a="Elige un aliado en juego de tu oponente y este lo debe barajar en su castillo";
    			break;
    		case 76: a="Si es destruido devuelve una carta de oro de tu oponente a su mano";
    			break;
    		case 77: a="Un aliado gana +3 a la fuerza hasta el final del turno";
    			break;
    		case 79: a="Puedes robar una carta de tu castillo";
    			break;
    		case 80: a="Mira la mano de tu oponente,puedes descartarle una carta de oro";
    			break;
    		case 81: a="Las cartas oponentes pierden un punto de fuerza en este turnoE";
    			break;
    		case 83: a="Despues de atacar, si no es destruido es devuelto a la mano";
    			break;
    		case 84: a="Puedes buscar una carta de Dragon en tu castillo en ponerla en tu mano";
    			break;
    		case 85: a="Mira las 6 cartas superiores de tu castillo y ordenalas como quieras";
    			break;
    		case 88: a="Debe atacar todos los turnos";
    			break;
    		case 90: a="Un vampiro gana +3 por este turno";
    			break;
    		case 92: a="Al entrar en juego, descarta la carta superior de tu castillo";
    			break;
    		case 93: a="Todos tus aliados se consideran caballeros cuando Kordrag esta en juego";
    			break;
    		case 94: a="Solo puede ser bloqueado por caballeros";
    			break;
    		case 95: a="Si ataca, gana +1 de fuerza por el turno";
    			break;
    		case 96: a="Dos cartas oponentes pierden un punto de fuerza por este turno";
    			break;
    		case 98: a="Puedes ver al azar una carta del oponenteI";
    			break;
    		case 99: a="Los aliados destruidos en este turno vuelven al juego (a la linea de defensa)";
    			break;
    		case 100: a="Cada turno pierde un punto de fuerza";
    			break;
    		case 101: a="Si es destruido, devuelvelo a tu mano";
    			break;
    		case 102: a="Si hay un Dragon en juego, gana +3 a la fuerza";
    			break;
    		case 103: a="Puedes buscar un dragon en el castillo oponente y descartarlo al cementerio";
    			break;
    		case 105: a="Paga 3 de oro, y una carta oponente no puede atacar en este turno";
    			break;
    		case 107: a="Busca una carta de Caballero en tu castillo y ponla en juego";
    			break;
    		default: a="";
    				}
    	return(a);			
    }
    public boolean habil(int n){
    	boolean a;
    	switch(n){
          	case 17: 
    			a=true;
    		break;
    		case 18: 
    			a=true;
    		break;
    		case 20: 
    			a=true;
    		break;
    		case 21: 
    			a=true;
    		break;
    		case 23: 
    			a=true;
    		break;
    		case 24: 
    			a=true;
    		break;
    		case 25: 
    		      a=true;
    		break;
    		case 26: 
    			a=true;
    		break;
    		case 27: 
    			a=true;
    		break;
    		case 28: 
    			a=true;
    		break;
    		case 31: 
    			a=true;
    			break;
    		case 32: 
    			a=true;
    			break;
    		case 33: 
    			a=true;
    			break;
    		case 34: 
    			a=true;
    			break;
    		case 35: 
    			a=true;
    			break;
    		case 36: 
    			a=true;
    			break;
    		case 38: 
    			a=true;
    			break;
    		case 39: 
    			a=true;
    			break;
    		case 41: 
    			a=true;
    			break;
    		case 42: 
    			a=true;
    			break;
    		case 43: 
    			a=true;
    			break;
    		case 45: 
    			a=true;
    			break;
    		case 46: a=true;
    			break;
    		case 47: a=true;
    			break;
    		case 48: a=true;
    			break;
    		case 49: a=true;
    			break;
    		case 50: a=true;
    			break;
    		
    		case 55: a=true;
    			break;
    		case 56: a=true;
    			break;
    		case 57: a=true;
    			break;
    		case 59: a=true;
    			break;
    		case 60: a=true;
    			break;
    		case 61: a=true;
    			break;
    		case 62: a=true;
    			break;
    		case 65: a=true;
    			break;
    		case 66: a=true;
    			break;
    		case 67: a=true;
    			break;
    		case 68: a=true;
    			break;
    		case 69: a=true;
    			break;
    		case 70: a=true;
    			break;
    		case 73: a=true;
    			break;
    		case 74: a=true;
    			break;
    		case 76: a=true;
    			break;
    		case 77: a=true;
    			break;
    		case 79: a=true;
    			break;
    		case 80: a=true;
    			break;
    		case 81: a=true;
    			break;
    		case 83: a=true;
    			break;
    		case 84: a=true;
    			break;
    		case 85: a=true;
    			break;
    		case 88: a=true;
    			break;
    		case 90: a=true;
    			break;
    		case 92: a=true;
    			break;
    		case 93: a=true;
    			break;
    		case 94: a=true;
    			break;
    		case 95: a=true;
    			break;
    		case 96: a=true;
    			break;
    		case 98: a=true;
    			break;
    		case 99: a=true;
    			break;
    		case 100: a=true;
    			break;
    		case 101: a=true;
    			break;
    		case 102: a=true;
    			break;
    		case 103: a=true;
    			break;
    		case 105: a=true;
    			break;
    		case 107: a=true;
    			break;
    		default: a=false;
    				}
    	return(a);			
    }
    public int getposic(int n){/*0=solo bloq,1=bloq imbloq,2=ataca y def,3=ataca,4=imbloq*/
    	if(n==43){return(0);
    	}
    	else{if(n==17){return(4);}
    	     else{if(n==39){return(1);
    	         }
    	         else{return(2);
    	         }
    	     }
    	}
    }
    public String veraza(int n){
    	if((n==22)||(n==23)){return("CABALLERO");}
    	else{return("");
    	}
    }
   /*Metodos del juego*/
  
}