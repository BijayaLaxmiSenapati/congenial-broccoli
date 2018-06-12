/**
 * 
 */
package com.bridgelabz.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.impl.DefaultPrettyPrinter;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;


/**
 * @author adminstrato
 *
 */
public class Utility 
{
	static Scanner scr = new Scanner(System.in);

	
	
	/**
	 * @return number a user given number
	 */
	//function to return a Integer value which is given by user.
	public static int retInt() {         
		return scr.nextInt();
	}

	
	/**
	 * @return String a user given word
	 */
	 //function to return a word of String value which is given by user.
	public static String retNext() {      
		return scr.next();
	}

	
	/**
	 * @return String a user given sentence/multiple words
	 */
	 //function to return a String line which is given by user.
	public static String retNextLine() {      
		return scr.nextLine();
	}



	/**
	 * @return boolean a user given boolen value
	 */
	public static boolean retBoolean() {
		return scr.nextBoolean();
	}


	/**
	 * @return number a number which is of double type and is given by the user
	 */
	public static double retDouble() {
		return scr.nextDouble();
	}
	

	/**
	 * @return
	 */
	public static long retLong() {
		
		return scr.nextLong();
	}
	
	
	/**
     * @param object
     * @param filePath
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static <T> void convertJavaToJson(T object,String filePath)
    {
    	ObjectMapper mapper=new ObjectMapper();
    	ObjectWriter writer=mapper.writer(new DefaultPrettyPrinter());
    	try 
    	{
			writer.writeValue(new File(filePath),object);
		}
    	catch (JsonGenerationException e)
    	{
			
			e.printStackTrace();
		} 
    	catch (JsonMappingException e) 
    	{
			
			e.printStackTrace();
		} 
    	catch (IOException e) 
    	{
			
			e.printStackTrace();
		}
    	System.out.println("JSON written to the file");
    }
    
    //only to convert the files
    /**
     * @param filePath
     * @return
     */
    public static <T> ArrayList<T> convertJsonToListUsingJackson(String filePath, Class<T> clazz)
    {
    	//ArrayList<T> files = new ArrayList<>();
    	ObjectMapper mapper=new ObjectMapper();
		try 
		{
			//list=mapper.readValue(new File(filePath), new TypeReference<ArrayList<T>>() {});
			JavaType type = mapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
			return mapper.readValue(new File(filePath), type);
		} 
		catch (IOException e) 
		{
			System.err.println("json file is empty... first add some persons data");
			//e.printStackTrace();
		}
		return null;
    }
    
    
    
    
    /**
     * @param filePath
     * @return
     */
    public static ArrayList<String> convertJsonToList(String filePath)
    {
    	JSONParser parser=new JSONParser();
    	ArrayList<String> addressBookList=new ArrayList<>();
    	try
    	{
    		Object obj=parser.parse(new FileReader(filePath));
    		JSONArray addressbookJsonList=(JSONArray)obj;
    		for(Object object : addressbookJsonList)
    		{
    			String addressBookName=object.toString();
    			addressBookList.add(addressBookName);
    		}
    	}catch(Exception e){
    		System.out.println("Error in loading Address Books");
    	}
    	return addressBookList;
    }
    
    /**
	 * @param fileName the location of the file from where the contents will be readed
	 * @return contents of the file
	 */
	public String readAllFromFile(String fileName)
	{
		String line=null;
		String readedFile="";
		try 
		{
			FileReader filereader=new FileReader(fileName);
			BufferedReader bufferedReader=new BufferedReader(filereader);
			while((line=bufferedReader.readLine())!= null)
			{
				readedFile+=line;
			}
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.out.println("your file is not found in the location '"+fileName+"'");
		}
		catch(IOException ioException)
		{
			System.out.println("Error in reading your file '"+fileName+"'");
		}
		return readedFile;
	}
	
	
	/**
	 * @param fileName
	 * @param content
	 */
	public void writeAllToFile(String fileName, String content)
	{
		try
		{
			FileWriter filewriter=new FileWriter(fileName);
			BufferedWriter bufferedwriter=new BufferedWriter(filewriter);
			bufferedwriter.write(content);
			bufferedwriter.close();
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.out.println("your file is not found in the location '"+fileName+"'");
		}
		catch(IOException ioException)
		{
			System.out.println("Error in reading your file '"+fileName+"'");
		}
	}
	
    public static int randomNumberInRange(int min, int max) 
    {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
