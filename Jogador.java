import java.util.HashMap;
import java.util.HashSet;

public class Jogador {
    private int vida;
    private HashMap<String,Item> inventario;

    public Jogador(){
        vida = 100;
        inventario = null;
    }

    public void receberDano(int dano){
        vida -= dano;
    }

    public HashMap<String,Item> getInventario(){
        return inventario;
    }

    public void removerDoInventario(String keyItem){
        for(String key : new HashSet<>(inventario.keySet())){
            if(key == keyItem){
                inventario.remove(keyItem);
                break;
            }
        }
    }

    public void removerDoInventario2(String keyItem){
        inventario.remove(keyItem);
    }
}
