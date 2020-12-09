import java.io.*;
public class FootballManager2k21{

  private static void creaGiocator1(String Giocatori[]){
    String[]Nomi={"Saro","Gregorio","Mariello","Salvatore","Pino","Sandro","Rey","Ezio","Alex","Frode"};
    String[]Cognomi={"Scavoli","Bomba","Settebello","Laureantont","Battilamiera","Amicodisfera","Rollins","Greggio","Mazza","Informatica"};
    int max=Nomi.length-1;
    int min=0;
    int range=max-min+1;
    int randNomi;
    int randCognomi;

    for (int i=0 ;i<Giocatori.length ;i++ ) {

      boolean salcazzi=false;
      randNomi=(int)(Math.random() * range) + min;
      randCognomi=(int)(Math.random() * range) + min;
      String ciocatori= Nomi[randNomi]+" "+Cognomi[randCognomi];

      for (int j=0 ;j<i ;j++ ) {
        String gae = Giocatori[j];

        if ( (ciocatori.equals(gae) ) == true  ) {
          salcazzi=true ;
        }
      }

      if (salcazzi == false  ){
        Giocatori[i]=ciocatori;
      }else if (i>0)
          i--;
      }


    for (int picone=0;picone<Giocatori.length;picone++){
      System.out.println(Giocatori[picone]);
    }
  }
  public static void main(String[] args) {
    InputStreamReader isr;
    BufferedReader br;
    isr = new InputStreamReader(System.in);
    br = new BufferedReader(isr);

    String[] Giocatori=new String[100];
    creaGiocator1(Giocatori);
  }

}
