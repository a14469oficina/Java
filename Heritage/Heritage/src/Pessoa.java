import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
    private String nomeProprio;
    private String sobreNome;
    private LocalDate dataNascimento;
    private LocalDate dataFalecimento;
    private boolean falecido;
    private Pessoa pai;
    private Pessoa mae;

    public String getNomeProprio() {
        return nomeProprio;
    }
    public void setNomeProprio(String nomeProprio) {
        this.nomeProprio = nomeProprio;
    }
    public String getSobreNome() {
        return sobreNome;
    }
    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public Pessoa getPai() {
        return pai;
    }
    public void setPai(Pessoa pai) {
        this.pai = pai;
    }
    public Pessoa getMae() {
        return mae;
    }
    public void setMae(Pessoa mae) {
        this.mae = mae;
    }
    public boolean isFalecido() {
        return falecido;
    }
    public void setFalecido(boolean falecido) {
        this.falecido = falecido;
    }
    public LocalDate getDataFalecimento() {
        return dataFalecimento;
    }
    public void setDataFalecimento(LocalDate dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    public Pessoa() {
        this.nomeProprio = "";
        this.sobreNome = "";
        this.dataNascimento = null;
        this.dataFalecimento = null;
        this.falecido = false;
        this.mae = null;
        this.pai = null;
    }
    
    
    public Pessoa(String nomeProprio, String sobreNome, LocalDate dataNascimento,LocalDate dataFalecimento ,boolean falecido, Pessoa pai, Pessoa mae) {
        this.nomeProprio = nomeProprio;
        this.sobreNome = sobreNome;
        this.dataNascimento = dataNascimento;
        this.dataFalecimento = dataFalecimento;
        this.falecido = falecido;
        this.pai = pai;
        this.mae = mae;
    }
    
    
    /*@Override
    public String toString() {
        /*return "Pessoa [nomeProprio=" + nomeProprio + ", sobreNome=" + sobreNome + ", dataNascimento=" + dataNascimento
                + ", pai=" + pai + ", mae=" + mae + "]";
        String aux = "";
        aux += "Pessoa [nomeProprio=" + nomeProprio + ", ";
        aux += "sobreNome=" + sobreNome + ", ";
        aux += "dataNascimento=" + dataNascimento + ", ";

        aux += "\n\t pais de (" + nomeProprio + " " + sobreNome + ")";
        aux += "\n\t pai=" + pai + "\t mae=" + mae + "\n"; 

        return aux;

    }*/

    public int getIdade(){
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        return periodo.getYears();
    }

    public int getIdadeFalecido(){
        Period periodo = Period.between(dataNascimento, dataFalecimento);
        return periodo.getYears();
    }

    
    public String mostraDescendencia(int nivel){
        String aux = "\n";

        for (int i=0; i<nivel;i++)aux += "\t ";
        aux += nomeProprio + " (";
        if(this.falecido){
            aux += "faleceu com " + this.getIdadeFalecido();
        }else {
            aux += this.getIdade();
        }
        aux += "anos)";
        if(pai != null){
            aux += pai.mostraDescendencia(nivel +1);
        }
        if(mae != null){
            aux += mae.mostraDescendencia(nivel +1);
        }
        return aux;
    }
    
    

    
    
}
