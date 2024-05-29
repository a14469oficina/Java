import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class App {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String datamaemae = "03/07/1950";
        String datapaimae = "03/07/1950";
        String datamaepai = "03/07/1950";
        String datapaipai = "03/07/1950";
        String datapai = "03/07/1970";
        String datamae = "03/07/1980";
        String datafilho = "03/07/2008";

        /*try{
            LocalDate data = LocalDate.parse(dataStr,formato);
            System.out.println("Data convertida: " + data);
        }catch(DateTimeParseException e){
            e.printStackTrace();
        }*/
        Pessoa maemae = new Pessoa("Ludmila","a", LocalDate.parse(datamaemae, formato),null,false ,null,null);
        Pessoa paimae = new Pessoa("Vladimir","a", LocalDate.parse(datapaimae, formato),null,false ,null,null);
        Pessoa maepai = new Pessoa("Valentina","a", LocalDate.parse(datamaepai, formato),null,false ,null,null);
        Pessoa paipai = new Pessoa("nao sei","a", LocalDate.parse(datapaipai, formato),null,false ,null,null);
        Pessoa pai = new Pessoa("Alexandre","a", LocalDate.parse(datapai,formato),null,false ,paipai,maepai);
        Pessoa mae = new Pessoa("Yulia","a", LocalDate.parse(datamae, formato),null,false , paimae,maemae);
        Pessoa filho = new Pessoa("Filipe","Soblirov", LocalDate.parse(datafilho, formato),null,false ,pai,mae);

        System.out.println(filho.mostraDescendencia(0));


    }
}
