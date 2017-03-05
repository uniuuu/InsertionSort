import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class sort {

	private static ArrayList<Object> myList;
	private static String d = "-d";
	private static String in;
	private static String out;
	//	static private String a;
	//	private static String b;
	//private static String[] k = new String[2];


	public static void Run(String args[]) throws Exception {

		myList = new ArrayList<Object>();
		in = args[0];
		out = args[1];
		//k[0] = args[2];
		//k[1] = args[3];
		int numberOfArgs = args.length;
		for (int i=0; i<numberOfArgs; i++){
			System.out.println("I’ve got " + args[i]);
		}
		readFile(myList);
		insertionSort(myList, args );
		writeFile(myList); 
	}

	public static void writeFile(ArrayList<Object> x) throws Exception
	{
		/*	for(int ctr = 0; ctr < 12; ctr++)
			System.out.println(x[ctr]); */

		try
		{
			System.out.println("write \n");
			FileOutputStream fout = 
					new FileOutputStream(out);
			PrintStream myOutput =
					new PrintStream(fout);

			for(int i = 0; i < x.size(); i++)
			{
				myOutput.println(x.get(i).toString());
			}
			myOutput.close();
		}
		catch (IOException e)
		{
			System.out.println(e);
			System.exit(1);
		}
		/*	System.out.println("---");
		for(int i = 0; i < x.size(); i++) {
			System.out.println((x.get(i)).toString());
			}*/

	}	

	public static void readFile(ArrayList<Object> x) throws IOException
	{
		//int i = 0;
		//	try
		//	{
		System.out.println("read \n");
		FileInputStream fstream = 
				new FileInputStream(in);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(in));
		String strLine;
		while ( (strLine = br.readLine()) != null)
		{
			//x.add(Integer.parseInt(strLine));
			x.add(strLine);
			//x[i] = Integer.parseInt(strLine);
			//i++;
			//	System.out.println(strLine);
		}
		//a = x.length;
		in.close();
		//	}
		//	catch (Exception e)
		//	{
		//		System.err.println( "Error1: " + e.getMessage());
		//	}
		/*		for(int i = 0; i < x.size(); i++) {
			System.out.println((x.get(i)).toString());
		}*/
	}


	public static ArrayList<Object> insertionSort (ArrayList<Object> x, String args[]) throws Exception
	{
		System.out.println(Arrays.toString(args)+ " start for");

		if (args[2].equals("-i") && args[3].equals("-a")){
			System.out.println(Arrays.toString(args) + " equals 1st for \n");
			if (((String) x.get(0)).matches(".*\\d+.*") == true){
			int i, j, key, temp;
			for(i = 1; i< x.size(); i++){
				System.out.println("for");
				key = Integer.valueOf((String) x.get(i));
				j = i-1;
				while (j>=0 && key < (Integer.valueOf(String.valueOf(x.get(j))))){
					System.out.println("while");
					temp = Integer.valueOf(String.valueOf(x.get(j)));
					//list[j] = x.get(j+1);
					x.set(j,x.get(j+1));
					//	list[j+1] = temp;
					x.set(j+1,temp);
					j--;
				} 
			}
		}
			else {
				System.err.println("sort source type exception \n");
				throw new NotASpecificParameterException("This is not a numeric file, please use -s key instead");	
			}
		
		
		}
		else if (args[2].equals("-s") && args[3].equals("-a")){
			if (((String) x.get(0)).matches(".*\\d+.*") == false){
			System.out.println(Arrays.toString(args) + "equals 2nd");
			int i, j;
			String key, temp;
			for(i = 1; i< x.size(); i++){
				key = (String) x.get(i);
				j = i-1;
				while (j>=0 && key.compareTo((String) x.get(j)) < 0){
					temp = (String) x.get(j);
					//list[j] = x.get(j+1);
					x.set(j,x.get(j+1));
					//	list[j+1] = temp;
					x.set(j+1,temp);
					j--;
				}
			}
		}
			else {
				System.err.println("sort source type exception \n");
				throw new NotASpecificParameterException("This is not a words contained file, please use -i key instead");
			}
		}
		else if (args[2].equals("-i") && args[3].equals("-d")){
			if (((String) x.get(0)).matches(".*\\d+.*") == true){
			System.out.println(Arrays.toString(args) + "equals 3rd");
			int i, j, key, temp;
			for(i = 1; i< x.size(); i++){
				key = Integer.valueOf(String.valueOf(x.get(i)));
				j = i-1;
				while (j>=0 && key > Integer.valueOf(String.valueOf(x.get(j)))){
					temp = Integer.valueOf(String.valueOf(x.get(j)));
					x.set(j,x.get(j+1));
					x.set(j+1,temp);
					j--;
				}
			}
		}
			else {
				System.err.println("sort source type exception \n");
				throw new NotASpecificParameterException("This is not a numeric file, please use -s key instead");	
			}
		
		}
		else if (args[2].equals("-s") && args[3].equals("-d")){
			if (((String) x.get(0)).matches(".*\\d+.*") == false){
			System.out.println(Arrays.toString(args) + "equals 4th");
			int i, j;
			String key, temp;
			for(i = 1; i< x.size(); i++){
				key = (String) x.get(i);
				j = i-1;
				while (j>=0 && key.compareTo((String) x.get(j)) > 0){
					temp = (String) x.get(j);
					//list[j] = x.get(j+1);
					x.set(j,x.get(j+1));
					//	list[j+1] = temp;
					x.set(j+1,temp);
					j--;
				}
			}
		}
			else {
				System.err.println("sort source type exception \n");
				throw new NotASpecificParameterException("This is not a words contained file, please use -i key instead");
			}
		}
		else{ 
			System.err.println("sort exception \n");
			throw new NotASpecificParameterException();
		}
		return x;
	}
}
