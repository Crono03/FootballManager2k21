import java.io.*;
import java.util.concurrent.*;
import java.awt.*;

public class FootballManager2k21{

  public static void main(String[] args) {
    InputStreamReader isr;
    BufferedReader br;
    isr = new InputStreamReader(System.in);
    br = new BufferedReader(isr);
    String nomeAllenatore;
    String nomeSquadra;
    String[] Giocatori=new String[100];
    int[] Caratteristiche1=new int[Giocatori.length]; //velocita,tuffo
    int[] Caratteristiche2=new int[Giocatori.length]; //potenza,contrasto,posizione
    int[] Caratteristiche3=new int[Giocatori.length]; //dinamicità,visione di gioco, riflessi, scivolata
    String[] Ruoli=new String[Giocatori.length];
    int[] Prezzo=new int[Giocatori.length];

    titoliDiTesta();

    creaGiocator1(Giocatori);
    creaStatistiche(Caratteristiche1, Caratteristiche2, Caratteristiche3);

    System.out.println("Benvenuto in Football Manager 2k21, la miglior simulazione calcistica della storia, non come quei nabbi di EA Sports ");
    System.out.println("");
    System.out.println("Inserisci il tuo nome da allenatore:");
    System.out.print("Dr.  ");
    nomeAllenatore=insString();
    System.out.println("Ahhh, il famoso Allenatore "+nomeAllenatore+", bene! Adesso scegli il nome della squadra che dovrai formare");
    nomeSquadra=insString();
    System.out.println(" ");
    System.out.println("|");
    System.out.println("|");
    System.out.println("|");
    System.out.println("|");
    System.out.println("|");
    clearScreen();

  }

  public static void dormi (int i){

    try{

      TimeUnit time = TimeUnit.SECONDS;
      time.sleep(i);

    }catch(Exception e){System.out.println(e);}

  }

    public static void clearScreen() {

      System.out.print("\033[H\033[2J");
      System.out.flush();

    }

  public static void titoliDiTesta() {


    clearScreen();

    for (int i=0; i<8; i++ )
        System.out.println("");

    dormi(1);
    System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"FootballManager2k21");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    dormi(2);
    System.out.println("Created By C4zz1 Studios Ltd.");
    dormi(2);
    clearScreen();


    for (int i=0; i<8; i++ )
      System.out.println("");
  }


  public static String insString(){

      String nome=null;
      String conferma=null;
      boolean correggiuto = false ;

    do{

      try{

        InputStreamReader isr;
        BufferedReader br;
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);

        nome = br.readLine();

        System.out.println("\t"+"\t"+"\t"+nome + " E' corretto ? Y/N (se non metti niente o sbagli so affari tuoi) " );

        conferma = br.readLine();

        if (conferma.equals("Y") || conferma.equals("y") )
          correggiuto = true;

      }catch(Exception e){System.out.println(e);}

    }while(correggiuto == false);

    return nome;
    }

  public static int randomizzaInt(int max, int min){
    int range=max-min+1;
    return (int)(Math.random() * range) + min;
  }

  public static void ruoli(String Ruoli[]){
    final int nPortieri=10;
    final int nDifensori=30;
    final int nCentrocampisti=35;
    final int nAttaccanti=25;

  }

  public static void creaStatistiche(int Caratteristiche1[],int Caratteristiche2[], int Caratteristiche3[]){
    final int minStat=30;
    final int maxStat=99;
    for(int a=0;a<Caratteristiche1.length ;a++){
      Caratteristiche1[a]=randomizzaInt(maxStat, minStat);
      Caratteristiche2[a]=randomizzaInt(maxStat, minStat);
      Caratteristiche3[a]=randomizzaInt(maxStat, minStat);
    }
  }

  public static void creaGiocator1(String Giocatori[]){
    String[]Nomi={"Lukabboloy","Sean","TonyFantino","Guesus","AlexObesoNano","Deiso","Carolo","Marvin","EvilKann","Carl","Bernardo","Joele","Gabe","William","Marco","'Ntuoni","Juanni","Sarpeni","Saro","Gregorio","Mariello","Salvatore","Sandro","Frode","Gianni","Moe","Dark","Michele","Pakalu","Pinzkeberg"};
    String[]Cognomi={"Picone","Figliodijuanni","Canadesi","Girelli","Piconetu","Chamberlain","Kane","Cosimo","Russell","Jordano","De Magistris","Cosmo","Froicio","Berlinguer","Boschetti","Dula","Scavoli","Bomba","Settebello","Laureantont","Battilamiera","Rollins","Egregio","Mazza","Pinorat","Hamilton","Gang","Gianni","Misseri","Andreotti","Papito","Osas","Maggi","Fonino"};
    int randNomi;
    int randCognomi;

    for (int i=0 ;i<Giocatori.length ;i++ ) {

      boolean controlloNomi=false;
      randNomi=randomizzaInt(Nomi.length-1,0);
      randCognomi=randomizzaInt(Cognomi.length-1,0);
      String ciocatori= Nomi[randNomi]+" "+Cognomi[randCognomi];

      for (int j=0 ;j<i ;j++ ) {
        String gae = Giocatori[j];

        if ( (ciocatori.equals(gae) )  ) {  //gae=GenerazioneArrayEnonsapevochemetteredopo
          controlloNomi=true ;
        }
      }

      if (controlloNomi == false  ){
        Giocatori[i]=ciocatori;
      }else if (i>0)
          i--;
    }

  }
}
