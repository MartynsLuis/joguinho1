import java.util.HashMap;

public class CaixaDeTesouro {
    private String descricao;
    private String chave;
    private Item tesouro;

    public CaixaDeTesouro(String descricao, String chave){
        this.descricao = descricao;
        this.chave = chave;
        this.tesouro = new Item("Comida");
    }

    public String getDescricao(){
        return descricao;
    }

    public Item getTesouro(){
        return tesouro;
    }

    public String getChave(){
        return chave;
    }

    public boolean destrancarBau(HashMap<String,Item> inventarioJogador){
        for(String key : inventarioJogador.keySet()){
            if(key == chave){
                return true;
            }
        }
        return false;

    }
}
