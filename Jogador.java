import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private int vida;
    private ArrayList<String> inventario;

    public Jogador(){
        vida = 100;
        inventario = null;
    }

    public void receberDano(int dano){
        vida -= dano;
    }

    public boolean encontrarItem(String item){
        return true;
    }
}
