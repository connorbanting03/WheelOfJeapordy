/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelofjeapordyproblem;

import java.util.ArrayList;

public class Wheel {

    private int moneyValue;
   
    private int[] wheel;

/*
** Construtor wheel is created with random numbers between 1-12 inclsuvie, only takes on perameter
*/
    
    public Wheel(int x) {
        ArrayList<Integer> wheelFiller = new ArrayList<Integer>();
        while(wheelFiller.size()<x){
        int flag = 0;
            moneyValue = ((((int) (Math.random() * 12) + 1) * 100));
        for(int z = 0; z<wheelFiller.size(); z++){
        
        if(wheelFiller.get(z)==moneyValue){
        flag++;
        }
        
        }
        if(flag==0){
        
        wheelFiller.add(moneyValue);
        }
        
        
        }
        
        
        wheel = new int[x];
        for (int y = 0; y < x; y++) {
            
            wheel[y] = wheelFiller.get(y);

        }

        
        

    }
    /*
    ** function will pick a random number in wheel to simulate "Spin"
    */
    

    public int wheelSpin() {
        //Spin function
        int pickerW = (int) (Math.random() * 12);

        return wheel[pickerW];
    }

 
}