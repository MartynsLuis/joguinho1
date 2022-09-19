public class CaixaDeTesouro {
    private String descricao;
    private String chave;
    private Item tesouro;

    public CaixaDeTesouro(String descricao, String chave){
        this.descricao = descricao;
        this.chave = chave;
        this.tesouro = new Item("Comida");
    }

    public void getDescircao(){
        System.out.println(descricao);
    }

    public Item getTesouro(){
        return tesouro;
    }

    public String getChava(){
        return chave;
    }
}
