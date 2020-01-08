import java.awt.*;

public class Triple<A, B, C > {
    public A first;
    public B second;
    public C third;

    public Triple (A first,B second,C third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
    public void setFirst(A first){

        this.first = first;
    }
    public  void setSecond(B second){

        this.second = second;
    }
    public  void setThird(C third){

        this.third = third;
    }
    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public C getThird() {
        return third;
    }

}
