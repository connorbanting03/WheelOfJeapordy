package wheelofjeapordyproblem;

/**
 *
 * @author Connor_Banting
 */
public class WOJobjectmaker {

    private String Category;
    private String Question;
    private String RightAnswer;
    private String WrongAnswer1;
    private String WrongAnswer2;
    private String WrongAnswer3;
    private String rightanswerID;

    /*
**Construtor for question Object, question Object has string qualities that make up question
     */

    public WOJobjectmaker(String C, String Q, String RA, String WA1, String WA2, String WA3, String RAID) {
        Category = C;
        Question = Q;
        RightAnswer = RA;
        WrongAnswer1 = WA1;
        WrongAnswer2 = WA2;
        WrongAnswer3 = WA3;
        rightanswerID = RAID;
    }

    /*
** will return Category (Accesor Method)
     */

    public String Category() {

        return Category;
    }

    /*
** will return Question (Accesor Method)
     */
    public String Question() {

        return Question;
    }

    /*
** will return RightAns (Accesor Method)
     */

    public String RightAns() {
        return RightAnswer;
    }

    /*
** will return WrongAns1 (Accesor Method)
     */
    public String WrongAns1() {
        return WrongAnswer1;
    }

    /*
** will return WrongAns2 (Accesor Method)
     */
    public String WrongAns2() {
        return WrongAnswer2;
    }

    /*
** will return WrongAns3 (Accesor Method)
     */

    public String WrongAns3() {
        return WrongAnswer3;
    }

    /*
    **using get methods all at once to put stuff onto the screen
     */

    public void askQuestion(int x) {
        //ask question function will take random in d, as int x, set it equal to test
        System.out.println("------------------");
        System.out.println(Category());
        System.out.println(Question());
        System.out.println("------------------");

        if (x == 0) {
            System.out.println("A " + RightAns());
            System.out.println("B " + WrongAns1());
            System.out.println("C " + WrongAns2());
            System.out.println("D " + WrongAns3());
            System.out.println("------------------");
            rightanswerID = "A";

        } else if (x == 1) {
            System.out.println("A " + WrongAns1());
            System.out.println("B " + RightAns());
            System.out.println("C " + WrongAns2());
            System.out.println("D " + WrongAns3());
            System.out.println("------------------");
            rightanswerID = "B";

        } else if (x == 2) {
            System.out.println("A " + WrongAns3());
            System.out.println("B " + WrongAns2());
            System.out.println("C " + RightAns());
            System.out.println("D " + WrongAns1());
            System.out.println("------------------");
            rightanswerID = "C";
        } else if (x == 3) {
            System.out.println("A " + WrongAns3());
            System.out.println("B " + WrongAns1());
            System.out.println("C " + WrongAns2());
            System.out.println("D " + RightAns());
            System.out.println("------------------");
            rightanswerID = "D";

        }
    }

    public String getanswerID() {

        return rightanswerID;
    }

}
