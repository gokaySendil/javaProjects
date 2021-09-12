package gokaySendil;
import com.google.gson.*;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;

public class CurrencyConventer {

    private String API_KEY="YOUR API KEY";
    private String from;
    private String to;
    private String amount;
    String urls ="https://v6.exchangerate-api.com/v6/YOUR_API_KEY/latest/";

    public CurrencyConventer(String from,String to,String amount){
        this.from=from;
        this.to=to;
        this.amount=amount;
        System.out.println("From =>"+from);
        System.out.println("To =>"+to);
        System.out.println("Amount=>"+amount);
    }
    // this method makes the connection with api server and returns the value of conversion
    public String connect() throws IOException {
        String result="";
        double r;
        urls=urls+from;
        URL url = new URL(urls);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        System.out.println("Response Code =>"+request.getResponseCode());
        request.connect();
        if (request.getResponseCode()==HttpURLConnection.HTTP_OK){
            String rate = make_request(read(request),to);
             r= Double.parseDouble(rate)* Double.parseDouble(amount);
            return String.valueOf(r);
        }
        return result.toString();
    }
    //this method reads the value of that comes from api with request
    public String read(HttpURLConnection request) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(request.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();

    }
    // this method returns the conversion rate
    public String make_request(String req,String key){
        JSONObject myResponse = new JSONObject(req);
        JSONObject array = myResponse.getJSONObject("conversion_rates");
        return (array.get(key)).toString();
    }

}














// OLD WITHOUT GUI VERSION

/*
    public String connect(String key) throws IOException {
        URL _url = new URL(url);
        HttpURLConnection request = (HttpURLConnection) _url.openConnection();
        if (request.getResponseCode()==HttpURLConnection.HTTP_OK){
            request.connect();
           return get_specific_rate(read(request),key);
        }
        return "a";
    }
    public String read(HttpURLConnection request) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(request.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();

    }
    public void currency_read(String response) throws IOException {
        JSONObject myResponse = new JSONObject(response);
        System.out.println(myResponse.getJSONObject("conversion_rates").toString());

    }
    public String get_specific_rate(String response,String key){
        JSONObject myResponse = new JSONObject(response);
        JSONObject array = myResponse.getJSONObject("conversion_rates");
        return ( array.get(key)).toString();
    }

    public void showMenu() throws IOException {
        String menu = "1=> USD \n2=> CAD\n3=> EUR \n4=> HKD \n5=> INR \n0=> Exit";
        int input = -1;
        double amount=0;
        double result=0;
        double rate=0;
        Scanner sc = new Scanner(System.in);
        while (input!=0){
            System.out.println(menu);
            System.out.print("Enter the number of that u want to convert to  => ");
            input=sc.nextInt();
            if (input!=0){
                System.out.println();
                System.out.print("Enter the amount => ");
                amount=sc.nextFloat();
                System.out.println();
                rate=get_rate(input);
                System.out.println("Rate => "+rate);
                amount=amount*rate;
                System.out.println("Result =>"+amount);
            }

        }

    }
    public double get_rate(int num) throws IOException {
        double rate=0;
        switch (num){
            case 1:
                rate=Double.parseDouble(connect("USD"));
                break;
            case 2:
                rate=Double.parseDouble(connect("CAD"));
                break;
            case 3:
                rate=Double.parseDouble(connect("EUR"));
            case 4:
                rate=Double.parseDouble(connect("HKD"));
                break;
            case 5:
                rate=Double.parseDouble(connect("INR"));
        }
        return rate;
    }
     */