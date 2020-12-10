import java.io.*;
public class FootballManager2k21{

  public static void main(String[] args) {
    InputStreamReader isr;
    BufferedReader br;
    isr = new InputStreamReader(System.in);
    br = new BufferedReader(isr);
    String nomeAllenatore;
    String[] Giocatori=new String[100];
    Int[] Caratteristiche1=new Int[Giocatori.length]; //velocita,tuffo
    Int[] Caratteristiche2=new Int[Giocatori.length]; //potenza,contrasto,posizione
    Int[] Caratteristiche3=new Int[Giocatori.length]; //dinamicità,visione di gioco, riflessi, scivolata
    String[] Ruoli=new String[Giocatori.length];
    Int[] Prezzo=new Int[Giocatori.length];

    creaGiocator1(Giocatori);
    creaStatistiche(Caratteristiche1, Caratteristiche2, Caratteristiche3);
    nomeAllenatore=creaAllenatore();

  }

  public static String creaAllenatore(){
    InputStreamReader isr;
    BufferedReader br;
    isr = new InputStreamReader(System.in);
    br = new BufferedReader(isr);
    String nome=br.readLine();

    return nome;
  }

  public static int randomizzaInt(Int max, int min){
    range=max-min+1;
    return (int)(Math.random() * range) + min;
  }

  public static void ruoli(String Ruoli[]){
    final int nPortieri=10;
    final int nDifensori=30;
    final int nCentrocampisti=35;
    final int nAttaccanti=25;

  }

  public static void creaStatistiche(Int Caratteristiche1[],Int Caratteristiche2[], Int Caratteristiche3[]){
    final int minStat=30;
    final int maxStat=99;
    for(int a=0;a<Caratteristiche1.length ;a++){
      Caratteristiche1[a]=randomizzaInt(maxStat, minStat);
      Caratteristiche2[a]=randomizzaInt(maxStat, minStat);
      Caratteristiche3[a]=randomizzaInt(maxStat, minStat);
    }
  }

  private static void creaGiocator1(String Giocatori[]){
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


    for (int picone=0;picone<Giocatori.length;picone++){
      System.out.println(Giocatori[picone]);
    }
  }
}
