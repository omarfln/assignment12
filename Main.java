import java.util.InputMismatchException;
import java.util.Scanner;

///////////////////////////////////////
//THIS IS THE SOLUTION OF PROBLEM #!///
///////////////////////////////////////

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Please input a number between 0 and 100: ");

        Scanner s = new Scanner(System.in);
        try {
            int num= s.nextInt();
            if (num >100 || num <0){
                throw new UnsupportedOperationException ("Number should be between 0 and 100");
            }
        }
        catch(InputMismatchException e){
            System.out.println("Please provide a valid integer number !!");
            System.exit(1);
        }
        catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
    }
}