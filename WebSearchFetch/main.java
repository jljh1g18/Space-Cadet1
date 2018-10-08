package WebSearchFetch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class main {
	
	//BufferedReader object that gets input from the 'System.in' - i.e. takes input.
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedReader website;
	static String name = "property=\"name\">";
	
	public static void main(String[] args) {
	
		try {
			String ID = input.readLine(); //Creates String, that is equal to the readLine() function.
			
			URL url = new URL("https://www.ecs.soton.ac.uk/people/" + ID); //Creates object of URL
			website = new BufferedReader(new InputStreamReader(url.openStream())); //Website reader that takes the URL url as an input
			
			String line; //String to hold every line from the website html, line by line.
			
			while ((line = website.readLine()) != null) { 
			//While line has a value, then run the loop. Otherwise end loop.
			//indexOf() checks whether any text in the current line is equal to 'property="name"'. As I know the persons name will be after this tag.		
				if (line.indexOf(name) != -1) {
					break;
				}
			}
			
			
			int nameStart = line.indexOf(name) + name.length(); //Index value of the first letter of the persons name.
			int nameEnd = line.indexOf("<", nameStart); //Index value of the next '<' after the persons name, as this closing tag will be the end of the persons name. 
			System.out.println(line.substring(nameStart, nameEnd)); //Prints a substring of 'list', that is between the nameStart and nameEnd index'
			
			website.close(); //Closes the BufferedReader
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
