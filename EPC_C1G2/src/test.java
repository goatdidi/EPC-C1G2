import java.util.Random;

/***
 * @author goatdidi
 **/
public class test {
    public static void main(String[] args) {
        Random rand = new Random();
        int i = 10;
        while (i > 0){
            System.out.println(rand.nextInt(3));
            i = i-1;
        }


    }
}
