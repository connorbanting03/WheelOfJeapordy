
package wheelofjeapordyproblem;

/***
 *
 * @author Connor_Banting
 */
public class hostCreatorClass {

    private String name;
    private static int qCount;
/**
    ** This will construct my host (Tony Stark)
    */

    public hostCreatorClass(String n, int qC) {

        name = n;
        qCount = qC;
    }
/**
    ** This will call on a random introduction
    */
    
    public String rIntroduction() {
        int x = (int) (Math.random() * 3);
        String intro = "";

        if (x == 0) {
            intro = "Hello I am " + getName() + ". Welcome to Wheel of Jeapordy";
            return intro;
        } else if (x == 1) {
            intro = "Mornin folks i'm " + getName() + ", Welcome to Wheel of Jeapordy";
            return intro;
        } else {
            intro = "Sup dudes my name is " + getName() + ". Welcome to Wheel of Jeapordy";
            return intro;
        }

    }
/**
 * 
 * 
    ** This will call on the static variable that gets the questions and then adds to it
    */
    public int getQuestionv() {
        int v = qCount;
        qCount++;
        return v;

    }
    /**
    ** will randomly pick a responce, based on if the user got it right and use rResponce to pick randomly which responce will be printed
    */
    
    public String hostoResponce(boolean f) {
        int rResponce = (int) Math.random() * 2;
        if (f) {
            if (rResponce == 0) {
                return "Tony: Well done there kiddo, thats correct";

            } else {
                return "Tony: Just dandy man, you got that one correct";
            }
        } else {
            if (rResponce == 0) {
                return "Tony: Aw dude you got it wrong";
            } else {

                return "Tony:Silly guy that's wrong";
            }
        }

    }
    /**
    ** Will call on bankrupt comment
    */
    
    public String hostBankruptComment(){
    int rResponce = (int) Math.random() * 2;
        
    if(rResponce==0)    
    return "Sorry sir you landed on bankrupt";
    
    else{
    return "Unlucky dude you landed on bankrupt";
    }
    }
/**
    ** Will call on timesTwoComment comment
    */
    
    public String timesTwoComment(){
    int rResponce = (int) Math.random() * 2;
    if(rResponce==0)
    return "Tony: Yipee congrats you landed on times two, i will spin the wheel agian for you, and multiply it by two";
    
    else{
    return "Tony: Holy smokes you landed on times two, i will spin the wheel agian for you and multiply your next answer by two";
    }
    }
    
    /**
    ** Will use host to "introduce the question"
    */
    public String rQuestion() {

        String excitment = "Tony: For question number " + getQuestionv() + ",";
        return excitment;
    }
/**
    ** fetches name of Host
    */
    public String getName() {

        return name;
    }
    /***
    * for the purpose of bankruptsy
    */
    
    public String ifbelowzero(){
    return "Tony: Since your below zero nothing will change";
    }
    
}