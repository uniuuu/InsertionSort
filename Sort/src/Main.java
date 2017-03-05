import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	//	static int a;
	//vdsv

	public static void main(String[] args) {
		boolean done1 = false;
		do {
			try {
				System.out.println(Arrays.toString(args));
				sort.Run (args);
				done1 = true;
			}

			catch (ArrayIndexOutOfBoundsException e){
				System.err.println( " " + e.getMessage() + " \n");
				System.err.println( " " + e.toString() + " \n");
				e.printStackTrace();
				System.out.println("Your 1st argument = " + ((args.length > 0) ? args[0] : "<null>"));
				System.out.println("Your 2nd argument = " + ((args.length > 1) ? args[1] : "<null>"));
				System.out.println("Your 3rd argument = " + ((args.length > 2) ? args[2] : "<null>"));
				System.out.println("Your 4th argument = " + ((args.length > 3) ? args[3] : "<null>"));
				System.out.println("please specify four parameters");
				break;
			}

			catch (FileNotFoundException e){
				System.err.println("try different name of the output/input file. don't use inapropriate stuff ");
				break;
			}
			
			catch (IOException e){
				System.err.println( "Error: " + e.getMessage());
				System.out.println(e);
				System.exit(1);
				break;
			}
			catch (NotASpecificParameterException e){
				System.err.println("Please make parameters correct. You should type keys");
				boolean done = false;
				String st;
				String st2;
				System.out.println(Arrays.toString(args) + "array in try/catch inc pr" + "\n");
				do {
					try {
						Scanner input = new Scanner(System.in);
						System.out.print("Enter a key (-s or -i)\n");
						st = input.next();
						System.out.print("You've entered " + st + " \n");
						System.out.print("Enter a key (-a or -d)\n");
						st2 = input.next();
						System.out.print("You've entered " + st2 + " \n" );
						if ( (st.equals("-i") || st.equals("-s")) && (st2.equals("-a") || st2.equals("-d") ) ) 
						{args[2] = st;
						args[3] = st2;
						done = true;}
						else throw new NotASpecificParameterException();
					} catch (NotASpecificParameterException ex){
						System.err.println("Try again");
					}
				} while (!done);
			}
			
		catch (IllegalArgumentException e)
			{
			System.err.println("Please specify only four arguments");
	
			break;
			}
			
			catch (Exception e){
				System.err.println( e.getMessage());
				break;
			}

		} while (!done1);
	}




}
