import java.io.*;
import java.util.concurrent.*;

public class FootballManager2k21{

  public static String nomeAllenatore;
  public static int budget= 250;
  public static String nomeSquadra;

  public static void main(String[] args) {
    InputStreamReader isr;
    BufferedReader br;
    isr = new InputStreamReader(System.in);
    br = new BufferedReader(isr);


    String[] Giocatori=new String[100];
    int[] Overall=new int[Giocatori.length];
    int[] Caratteristiche1=new int[Giocatori.length]; //velocita,tuffo
    int[] Caratteristiche2=new int[Giocatori.length]; //potenza,contrasto,posizione
    int[] Caratteristiche3=new int[Giocatori.length]; //dinamicità,visione di gioco, riflessi, scivolata
    String[] Ruoli=new String[Giocatori.length];
    int[] Prezzo=new int[Giocatori.length];

    final int nPortieri=10;
    final int nDifensori=30;
    final int nCentrocampisti=35;
    final int nAttaccanti=25;

    int[] nRuoli={nPortieri,nDifensori,nCentrocampisti,nAttaccanti};


    titoliDiTesta();

    creaGiocator1(Giocatori);
    creaStatistiche(Caratteristiche1, Caratteristiche2, Caratteristiche3);
    prezzi(Prezzo, Caratteristiche1, Caratteristiche2, Caratteristiche3, Overall);

    System.out.println("Benvenuto in Football Manager 2k21, la miglior simulazione calcistica della storia, non come quei nabbi di EA Sports ");
    System.out.println("");
    dormi(1);
    System.out.println("Inserisci il tuo nome da allenatore:");
    System.out.print("Dr.  ");
    nomeAllenatore=insString();
    System.out.println("");
    System.out.println("");
    System.out.println("Ahhh, il famoso Allenatore "+nomeAllenatore+", bene! Adesso scegli il nome della squadra che dovrai formare");
    nomeSquadra=insString();
    clearScreen();

    contratto();
    System.out.println("                              __________________");
    System.out.println("Premi invio per firmare");
    try{
      System.in.read();
    }catch(Exception e){System.out.println(e);}

    clearScreen();
    contratto();
    System.out.println("                               "+nomeAllenatore);
    dormi(2);

    refreshScreen(nomeAllenatore, nomeSquadra, budget);

    stampaTabella(Giocatori,  Ruoli,  Prezzo, Caratteristiche1 , Caratteristiche2,  Caratteristiche3,  nRuoli, Overall);



  }

  public static void dormi (int i){

    try{

      TimeUnit time = TimeUnit.SECONDS;
      time.sleep(i);

    }catch(Exception e){System.out.println(e);}

  }

  public static void randPrezzi(int min, int max, int prezzobase, int modifier,int[] Overall, int[]Prezzo, int a){
    if(Overall[a]>min && Overall[a]<max){
      Prezzo[a]=(prezzobase+randomizzaInt(modifier,1));
    }
  }

  public static void clearScreen() {

    // attenazione, funziona solo col cmd
    try{

      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

    }catch(Exception e){System.out.println(e);}

  }

  public static void refreshScreen(String nomeAllenatore, String nomeSquadra, int budget ){

    clearScreen();

    System.out.println(nomeAllenatore+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+" Ufficio "+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"Budget: "+budget+" Mln");
    System.out.println("Squadra: "+nomeSquadra);

  }

  public static void contratto(){

    System.out.println(nomeAllenatore+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+" Ufficio ");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("\t"+"\t"+"\t"+"Contratto     ");
    System.out.println("");
    System.out.println("");
    System.out.println("                     ");
    System.out.println("Nome:"+nomeAllenatore );
    System.out.println("                     ");
    System.out.println("Eta': 37");
    System.out.println("                     ");
    System.out.println("Sesso: Maschio       ");
    System.out.println("Segni particolari: Crocifisso tatuato sulla nuca");
    System.out.println("");
    System.out.println("Squadra:"+nomeSquadra);
    System.out.println("");
    System.out.println("Stipendio: Una pacca sul bacino e una guancia sulla spalla");
    System.out.println("");
    System.out.println("Durata Contratto : Quinquennale");
    System.out.println("");

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

        System.out.println("\t"+"\t"+"\t"+nome + " E' corretto ? Y/N " );

        conferma = br.readLine();

        if (conferma.equals("Y") || conferma.equals("y") )
        correggiuto = true;
        else if (conferma.equals("N") || conferma.equals("n") )
        System.out.println("Per favore, re-inserisci il nome ");
        else {

          if (nomeAllenatore ==null ){
            System.out.println("Come? Hai detto che ti chiami Mr. Pagliaccio? Y/N");
            conferma = br.readLine();
            System.out.println("Perfetto Mr. Pagliaccio");
            nome="Mr. Pagliaccio";
            correggiuto = true;
          }else
            System.out.println("Per favore, re-inserisci il nome ");

        }

      }catch(Exception e){System.out.println(e);}

    }while(correggiuto == false);

    return nome;
  }

  public static int randomizzaInt(int max, int min){
    int range=max-min+1;
    return (int)(Math.random() * range) + min;
  }

  public static void ruoli(String Ruoli[], int[] nRuoli){

    int k =0;

    for (int i=0; i<=nRuoli.length; i++){

      for(int j=k; j<nRuoli[i]; j++){

        if (j<= nRuoli[1] )
          Ruoli[j]="Portiere";

        if(j>nRuoli[1] && j<=nRuoli[2])
          Ruoli[j]="Difensore";

        if(j>nRuoli[2] && j<=nRuoli[3])
          Ruoli[j]="Centrocampista";

        if(j>nRuoli[3] && j<=nRuoli[4])
          Ruoli[j]="Attacante";
      }

      k += nRuoli[i];
    }

  }
  public static void prezzi(int[] Prezzo,int[] Caratteristiche1,int[] Caratteristiche2,int[] Caratteristiche3,int[] Overall){
    int media=0;
    for (int a=0;a<Prezzo.length;a++ ) {
      media=(Caratteristiche1[a]+Caratteristiche2[a]+Caratteristiche3[a])/3;
      Overall[a]=media;
      //Prezzo
      randPrezzi(50, 55,1,3,Overall,Prezzo,a);
      randPrezzi(55, 60,5,7,Overall,Prezzo,a);
      randPrezzi(65, 70,7,10,Overall,Prezzo,a);
      randPrezzi(75, 80,12,20,Overall,Prezzo,a);
      randPrezzi(80, 85,20,35,Overall,Prezzo,a);
      randPrezzi(85, 90,50,80,Overall,Prezzo,a);
      randPrezzi(90, 99,85,165,Overall,Prezzo,a);
    }

    }
  public static void stampaTabella(String[] Giocatori, String[] Ruoli, int[] Prezzo,int Caratteristiche1[],int Caratteristiche2[], int Caratteristiche3[], int[] nRuoli, int[] Overall){

    int tabella = 0;
    String[] Pagine={"Portieri", "Difensori", "Centrocampisti", "Attacanti"};

    System.out.println("");
    System.out.println("Pagina "+tabella+1+" di "+Pagine.length);
    System.out.println("");
    System.out.println(Pagine[0]);
    System.out.println("");

    for(int i=0; i<=nRuoli[tabella]; i++){
      int spazi = 27-Giocatori[i].length();
      System.out.print(Giocatori[i]);
      for (int j=0; j< spazi; j++ )
        System.out.print(" ");

      System.out.print(Caratteristiche1[i]+"     "+Caratteristiche2[i]+"     "+Caratteristiche3[i]+"     "+Overall[i]+"     "+Prezzo[i]+"\n");
    }
    System.out.println("");
  }

  public static void creaStatistiche(int Caratteristiche1[],int Caratteristiche2[], int Caratteristiche3[]){
    final int minStat=50;
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
      String nomiCognomi= Nomi[randNomi]+" "+Cognomi[randCognomi];

      for (int j=0 ;j<i ;j++ ) {
        String Ccneg = Giocatori[j];

        if ( (nomiCognomi.equals(Ccneg) )  ) {  //Ccneg = Controlla Che Non Esista Giá
          controlloNomi=true ;
        }
      }

      if (controlloNomi == false  ){
        Giocatori[i]=nomiCognomi;
      }else if (i>0)
      i--;
    }

  }
}
