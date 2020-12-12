import java.io.*;
import java.util.concurrent.*;
import java.awt.event.KeyEvent;

public class FootballManager2k21{

  public static String nomeAllenatore;
  public static int budget= 250;
  public static String nomeSquadra;


  public static void main(String[] args) {
    try{

      new ProcessBuilder("cmd", "/c", "mode con: cols=160 lines=78").inheritIO().start().waitFor();

    }catch(Exception e){System.out.println(e);}

    InputStreamReader isr;
    BufferedReader br;
    isr = new InputStreamReader(System.in);
    br = new BufferedReader(isr);


    String[] Giocatori=new String[100];
    int[] Overall=new int[Giocatori.length];
    int[] Caratteristiche1=new int[Giocatori.length]; //velocita,tuffo
    int[] Caratteristiche2=new int[Giocatori.length]; //potenza,contrasto,posizione
    int[] Caratteristiche3=new int[Giocatori.length]; //dinamicità,visione di gioco, riflessi, scivolata
    Boolean[] disponibilita=new Boolean[Giocatori.length];//true Disponibile, false non disponibile
    String[] Ruoli=new String[Giocatori.length];
    int[] Prezzo=new int[Giocatori.length];

    final int nPortieri=10;
    final int nDifensori=30;
    final int nCentrocampisti=35;
    final int nAttaccanti=25;

    int[] nRuoli={0, nPortieri,nDifensori+nPortieri,nCentrocampisti+nDifensori+nPortieri,nAttaccanti+nCentrocampisti+nDifensori+nPortieri};
    //contiene gli step del vettore in cui cambiano i ruoli dei giocatori

    titoliDiTesta();

    creaGiocator1(Giocatori);
    creaStatistiche(Caratteristiche1, Caratteristiche2, Caratteristiche3);
    prezzi(Prezzo, Caratteristiche1, Caratteristiche2, Caratteristiche3, Overall);

    for (int i=0; i<Giocatori.length;i++)
      disponibilita[i]=true;


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
      System.in.read(new byte[2]);
    }catch(Exception e){System.out.println(e);}


    clearScreen();
    contratto();
    System.out.println("                               "+nomeAllenatore);
    dormi(2);

    refreshScreen();

    System.out.println("");

    Tabbella(Giocatori, Prezzo, Caratteristiche1 , Caratteristiche2,  Caratteristiche3,  nRuoli, Overall, disponibilita);


  }

  public static void dormi (int i){

    try{

      TimeUnit time = TimeUnit.SECONDS;
      time.sleep(i);

    }catch(Exception e){System.out.println(e);}

  }

  public static void randPrezzi(int min, int max, int prezzobase, int modifier,int[] Overall, int[]Prezzo, int a){
    if(Overall[a]>=min && Overall[a]<=max){
      Prezzo[a]=(prezzobase+randomizzaInt(modifier,1));
    }
  }

  public static void clearScreen() {

    // attenazione, funziona solo col cmd
    try{

      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

    }catch(Exception e){System.out.println(e);}


  }

  public static void refreshScreen(){

    clearScreen();

    System.out.println(nomeAllenatore+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+" Ufficio "+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"Budget: "+budget+" Mln");
    System.out.println("Squadra: "+nomeSquadra);

  }

  public static void contratto(){

    System.out.println(nomeAllenatore+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+" Ufficio ");
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
    System.out.println("Squadra: "+nomeSquadra);
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


  public static void prezzi(int[] Prezzo,int[] Caratteristiche1,int[] Caratteristiche2,int[] Caratteristiche3,int[] Overall){
    int media=0;
    for (int a=0;a<Prezzo.length;a++ ) {
      media=(Caratteristiche1[a]+Caratteristiche2[a]+Caratteristiche3[a])/3;
      Overall[a]=media;
      //Prezzo
      randPrezzi(50, 55,1,3,Overall,Prezzo,a);
      randPrezzi(55, 60,5,6,Overall,Prezzo,a);
      randPrezzi(60, 65,6,7,Overall,Prezzo,a);
      randPrezzi(65, 70,7,10,Overall,Prezzo,a);
      randPrezzi(70, 75,7,10,Overall,Prezzo,a);
      randPrezzi(75, 80,12,20,Overall,Prezzo,a);
      randPrezzi(80, 85,20,35,Overall,Prezzo,a);
      randPrezzi(85, 90,50,80,Overall,Prezzo,a);
      randPrezzi(90, 99,85,100,Overall,Prezzo,a);
    }

    }

  public static void Tabbella(String[] Giocatori, int[] Prezzo,int Caratteristiche1[],int Caratteristiche2[], int Caratteristiche3[], int[] nRuoli, int[] Overall, Boolean[] disponibilita){

    InputStreamReader isr;
    BufferedReader br;
    isr=new InputStreamReader(System.in);
    br=new BufferedReader(isr);

    int pagina = 1;
    boolean c= true;
    int s = 0;

    do{

      String[] nomePagine={"Portieri", "Difensori", "Centrocampisti", "Attacanti"};

      System.out.println("");
      System.out.println("");
      System.out.println("");
      System.out.println("Pagina "+(pagina)+" di "+nomePagine.length);
      System.out.println("");
      System.out.println("");
      System.out.println("                                 "+nomePagine[pagina-1]);
      System.out.println("");

      switch(pagina){

        case 1:
          System.out.println("                              TUF    POS    RIF    OVL   $$$");
        break;

        case 2:
          System.out.println("                              VEl    CNT    SCI    OVL   $$$");
        break;

        case 3:
          System.out.println("                              VEl    POT    DIN    OVL   $$$");
        break;

        case 4:
          System.out.println("                              VEl    POT    DIN    OVL   $$$");
        break;
      }

      System.out.println("");

      for(int i=nRuoli[pagina-1]; i<nRuoli[pagina]; i++){
        int spazi = 27-Giocatori[i].length();

        if (i>=9)
          spazi -=1;

        System.out.print((i+1)+"  "+ Giocatori[i]);

        for (int j=0; j< spazi; j++ )
          System.out.print(" ");

        System.out.print(Caratteristiche1[i]+"     "+Caratteristiche2[i]+"     "+Caratteristiche3[i]+"     "+Overall[i]+"     "+Prezzo[i]+"\t");

        if(disponibilita[i] == true )
          System.out.println("Disponibile ");
        else
          System.out.println("Non Disponibile");

        //pagina+=frecce();
      }
      System.out.println("");
      System.out.println("");

      do{

        System.out.println("Che cosa vuoi fare?");
        System.out.println("1) Cambiare pagina ");
        System.out.println("2) Comprare un giocatore");

        try{

  				String xStringa=br.readLine();
  				s= Integer.parseInt(xStringa);

        }catch(Exception e){System.out.println(e);}

        if (s< 1 || s> 2)
          System.out.println("Per favore, inserire SOLO il numero della scelta");

      }while(s< 1 || s> 2);

      if (s == 1){

        int t=0;
        System.out.println("Inserire il numero della pagina a cui si vuole andare");

        do{

          try{

      			String xStringa=br.readLine();
      			t= Integer.parseInt(xStringa);

            if (t>0 && t<5 ){
              pagina = t;
              refreshScreen();
            }
            else
              System.out.println("Attenzione! Le pagine vanno da 1 a 4. Inserire un valore valido.");

          }catch(Exception e){System.out.println(e);}

        }while(t< 1 || t>4 );

      }else if(s==2){

        int a= -1;
        do{
          System.out.println("Inserire il numero del giocatore che si desidera comprare");

          try{

      			String xStringa=br.readLine();
      			a = Integer.parseInt(xStringa);

          }catch(Exception e){System.out.println(e);}

          if(a<nRuoli[pagina-1] || a>nRuoli[pagina])
            System.out.println("Il giocatore richiesto non é presente in questa pagina. Inserire un numero di questa pagina");

        }while(a<nRuoli[pagina-1] || a>nRuoli[pagina]);
        System.out.println("Ottimo affare, hai acquistato "+Giocatori[a-1]+" Alla modica cifra di "+Prezzo[a-1]);
        budget=budget-Prezzo[a-1];
        disponibilita[a-1]= false;
        dormi(2);
        refreshScreen();
      }


    }while(c == true);
  }

  /*public static int frecce(){

    double tastoP= 0;
    tastoP= KeyEvent.getKeyCode();

    if(  tastoP ==KeyEvent.VK_RIGHT)
      return 1;
    if(  tastoP ==KeyEvent.VK_LEFT)
      return -1;
  }*/ //gue gue gue gue

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
