
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose Rodriguez
 */
public class AccountUtility
{
    static String filename = "accounts.txt";

	public static ArrayList <Account> getAccounts() throws ParseException
    {
        ArrayList <Account> accounts = new ArrayList<>();
        String columns[] = null;
        BufferedReader in = null;

        try{
            in = new BufferedReader(new FileReader(filename));
            String line;
            while((line = in.readLine()) != null) {//Assuming each account is seperated by tab.
                Account account = new Account();
                columns = line.split("<>");

                DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                account.setAccountNumber(columns[0]);
                account.setOpenDate(format.parse(columns[1]));
                account.setCustomerName(columns[2]);
                account.setBalance(Double.parseDouble(columns[3]));

                //Add account to the list of accounts
                accounts.add(account);
            }
            in.close();

        }
        catch(IOException ioe)
        {
            System.out.println(ioe);
        }
       //Return account list.
       return accounts;
    }


	public static void saveAccounts(List <Account> accounts) throws ParseException, FileNotFoundException
    {
        PrintWriter pw = new PrintWriter("try1.txt");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String convertedDate;

        for(Account account : accounts)
        {
        	pw.print(account.getAccountNumber()+"<>");

        	convertedDate =(sdf).format(account.getOpenDate());
        	String year = convertedDate.substring(0,convertedDate.indexOf("/"));
        	String month = convertedDate.substring(convertedDate.indexOf("/")+1,convertedDate.lastIndexOf("/"));
        	if(month.charAt(0) == '0')
        		month = month.substring(1);
        	String day = convertedDate.substring(convertedDate.lastIndexOf("/")+1);
        	if(day.charAt(0) == '0')
        		day = day.substring(1);

        	pw.print(year+"/"+month+"/"+day+"<>");
        	pw.print(account.getCustomerName()+"<>");
        	pw.print(account.getBalance()+"\n");

        }

        pw.close();

        File file = new File(filename);
        File file2 = new File("try1.txt");
        if(file.exists())
        {
        	file.delete();
        	file2.renameTo(new File(filename));
        }



    }
}
