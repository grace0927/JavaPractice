package com.javapractice.basic;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPDemo {
    private final String USER_AGENT = "Mozilla/5.0";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
    	HTTPDemo http = new HTTPDemo();
        
        System.out.println("\nTesting 2 - Send Http POST request");
        http.sendPost();
    }
    
    // HTTP POST request
    private void sendPost() throws Exception {
        String url = "http://troubleticket.xrainbow.com/xrainbow/ttx.php";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
        con.setRequestProperty("Connection","close");
        
        String urlParameters = "cmd=newticket&do=1&xSite=XRainbow&CustomerCode=SEAWOLF&name=System&email=monitor@seawolftech.com&subject=System Alert";
 
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
 
        //print result
        System.out.println(response.toString());
    }
}
