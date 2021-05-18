/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelofjeapordyproblem;

/**
 *
 * @author bantingc
 */
public class PlayerMaker {

    private String name;
    private int money;
    public static int PlayerCount = 1;
/*
    **Construtor to create Players, uses instance Variables money, name and static int PlayerCount, to keep track of totalPlayers created
    */
    
    public PlayerMaker(String nm) {
        name = nm;
        money = 0;
        PlayerCount++;
    }
/*
** Mutator method to change money based on the result of the question, sM will be negative if the user answers incorrectly
*/
    
    public void setMoney(int sM) {
        if (sM == 0) {
            money = 0;
        } else {
            money += sM;
        }

    }
/*
** getMoney will Return any PlayerMaker objects money, used to check if gameover point has been reached
*/
     public int getMoney() {

        return money;
    }
/*
** getName will return the String name of any PlayerMaker object
*/
    
    public String getName() {
        return name;
    }

}
