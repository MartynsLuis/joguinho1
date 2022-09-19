import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String description;
    private HashMap<String, Item> itensSala;
    private CaixaDeTesouro tesouro;
    private HashMap<String, Room> exits;        // stores exits of this room.

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description, String descricaoTesouro, String chave) 
    {
        this.description = description;
        tesouro = new CaixaDeTesouro(descricaoTesouro, chave);
        itensSala = new HashMap<>();
        exits = new HashMap<>();
    }

    public Room(String description) 
    {
        this.description = description;
        tesouro = null;
        itensSala = new HashMap<>();
        exits = new HashMap<>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "Você esta " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Saídas:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    public Item abrirTesouro(HashMap<String,Item> inventario){
        boolean bauAberto = tesouro.destrancarBau(inventario);
        if(bauAberto){
            Item itemTesouro = getTesouroBau();
            System.out.println("Você abriu " + tesouro.getDescricao());
            System.out.println("Dentro havia" + itemTesouro.getDescricao());
            return itemTesouro;
        }
        else{
            System.out.println("Parece que precisa de uma chave para abrir");
            return null;
        }
    }

    public String getChaveBau(){
        String chave = tesouro.getChave();
        return chave;
    }

    private Item getTesouroBau(){
        Item tesouroBau = tesouro.getTesouro();
        return tesouroBau;
    }
}

