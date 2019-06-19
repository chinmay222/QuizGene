import java.io.Serializable;

public class Mcq implements Serializable
{
    String question;
    String opt1;
    String opt2;
    String opt3;
    String opt4;
    String answer;

    Mcq(String question, String opt1, String opt2, String opt3, String opt4, String answer)
    {
        this.question = question;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return question +" " + opt1 +" " + opt2 + " " +opt3 + " " +opt4;
    }
}
