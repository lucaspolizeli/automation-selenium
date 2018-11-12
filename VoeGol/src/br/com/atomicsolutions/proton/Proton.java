package br.com.atomicsolutions.proton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class Proton {
 
	public static String getProtonValue(String param){
		
		String returnValue = "";
		
		String host = getHost();
		
		String url = "http://"+ host +"/Gravity/rest/Proton/ProtonLib/GetInParamValue";
		
		try {
			URL objUpdate = new URL(url);
			
			HttpURLConnection con = (HttpURLConnection) objUpdate.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", ProtonConfig.getProperty("wspwd"));
			con.setRequestProperty("Dataset_Run", System.getProperty("Id_Dataset_Run"));
			con.setRequestProperty("Parameter", param);
			
			con.getResponseCode();
			
			String line = null;
			BufferedReader rd  = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder sb = new StringBuilder();

			while ((line = rd.readLine()) != null){
				sb.append(line);
			}
			
			returnValue = sb.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnValue;
  
	}
 
	public static void setProtonValue(String param, String value){
		
		String host = getHost();
		
		String url = "http://"+ host +"/Gravity/rest/Proton/ProtonLib/SetOutParamValue";
		
		try {
			URL objUpdate = new URL(url);
			
			HttpURLConnection con = (HttpURLConnection) objUpdate.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", ProtonConfig.getProperty("wspwd"));
			con.setRequestProperty("Dataset_Run", System.getProperty("Id_Dataset_Run"));
			con.setRequestProperty("Parameter", param);
			con.setRequestProperty("Value", value);
			
			con.getResponseCode();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
 
	
	public static void setProtonValue(String param, int value){
		
		String sValue = String.valueOf(value);
		
		String host = getHost();
		
		String url = "http://"+ host +"/Gravity/rest/Proton/ProtonLib/SetOutParamValue";
		
		try {
			URL objUpdate = new URL(url);
			
			HttpURLConnection con = (HttpURLConnection) objUpdate.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", ProtonConfig.getProperty("wspwd"));
			con.setRequestProperty("Dataset_Run", System.getProperty("Id_Dataset_Run"));
			con.setRequestProperty("Parameter", param);
			con.setRequestProperty("Value", sValue);
			
			con.getResponseCode();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void startComponent(){
		
		String host = getHost();
		
		String url = "http://"+ host +"/Gravity/rest/Proton/ProtonLib/StartComponent";
		
		try {
			URL objUpdate = new URL(url);
			
			HttpURLConnection con = (HttpURLConnection) objUpdate.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", ProtonConfig.getProperty("wspwd"));
			con.setRequestProperty("Dataset_Run", System.getProperty("Id_Dataset_Run"));
			
			con.getResponseCode();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
 
	public static String endComponent(){
		
		String host = getHost();
		String returnValue = "";
		
		String url = "http://"+ host +"/Gravity/rest/Proton/ProtonLib/EndComponent";
		
		try {
			URL objUpdate = new URL(url);
			
			HttpURLConnection con = (HttpURLConnection) objUpdate.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", ProtonConfig.getProperty("wspwd"));
			con.setRequestProperty("Dataset_Run", System.getProperty("Id_Dataset_Run"));
			
			int responseCode = con.getResponseCode();
			
			if(responseCode == 200){
			
				String line = null;
				BufferedReader rd  = new BufferedReader(new InputStreamReader(con.getInputStream()));
				StringBuilder sb = new StringBuilder();
	
				while ((line = rd.readLine()) != null){
					sb.append(line);
				}
				
				returnValue = sb.toString();
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnValue;
				
	}
	
	public static void updateRunStatus(String sStatus){
		
		String host = getHost();
		String iDatasetRunId = System.getProperty("Id_Dataset_Run");
  
		String url = "http://"+ host +"/Gravity/rest/Proton/DatasetRun/UpdateStatus";
		
		try {
			URL objUpdate = new URL(url);
			
			HttpURLConnection con = (HttpURLConnection) objUpdate.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Authorization", ProtonConfig.getProperty("wspwd"));
			con.setRequestProperty("Id_Dataset_Run", iDatasetRunId);
			con.setRequestProperty("Status", sStatus);
			
			con.getResponseCode();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void setLog(String sLog){
		
		String host = getHost();
		String iDatasetRunId = System.getProperty("Id_Dataset_Run");
  
		String url = "http://"+ host +"/Gravity/rest/Proton/DatasetRunLog/Update";
		
		try {
			URL objUpdate = new URL(url);
			
			HttpURLConnection con = (HttpURLConnection) objUpdate.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Authorization", ProtonConfig.getProperty("wspwd"));
			con.setRequestProperty("Id_Dataset_Run", iDatasetRunId);
			con.setRequestProperty("Log", sLog);
			
			con.getResponseCode();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void setLog(Exception e){
		
		StringWriter writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		e.printStackTrace(printWriter);
		printWriter.flush();

		String stackTrace = writer.toString();
		String[] splitStackTrace = stackTrace.split("\n");
					
		for(int i = 0; i < splitStackTrace.length; i++){
			Proton.setLog(splitStackTrace[i]);
		}
		
	}
	
	
	private static String getHost(){
		
		String host = "";
		
		try {
			host = ProtonConfig.getProperty("hostname") + ":" + ProtonConfig.getProperty("port");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return host;
	}
	
	
	public static void takeScreenShot(WebDriver driver, String fileName) throws Exception {
       
        try {
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
	        String screenshotFolder = "C:\\Atomic Solutions\\ProtonClient\\Screenshots\\" + System.getProperty("Id_Dataset_Run") + "\\";
	        
	        String fullPath = screenshotFolder + fileName + ".png";
	        
	        FileUtils.copyFile(src, new File(fullPath));
	        
	        insertProtonFile(System.getProperty("Id_Dataset_Run"), screenshotFolder, fileName + ".png");
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	private static String insertProtonFile(String iDatasetRun, String filePath, String sFileName) throws Exception{
		
		String url = "http://" + ProtonConfig.getProperty("hostname") +"/Gravity/PionUp?entity=" + "Dataset_Run" +"&id=" + iDatasetRun + "&protonusername=tester01";
		
		FileUpload(url, filePath, sFileName);
		
		return "";
		
	}
	
	@SuppressWarnings("deprecation")
	private static void FileUpload(String URLPath, String FilePath, String fileName){
        HttpURLConnection conn = null;
        DataOutputStream dos = null;
        DataInputStream inStream = null;
        String lineEnd = "\r\n";
        String twoHyphens = "--";
        String boundary =  "*****";
        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 1*1024*1024;
        try{
            //------------------ CLIENT REQUEST
            FileInputStream fileInputStream = new FileInputStream(new File(FilePath + fileName));
            URL url = new URL(URLPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary="+boundary);
            dos = new DataOutputStream( conn.getOutputStream() );
            dos.writeBytes(twoHyphens + boundary + lineEnd);
            dos.writeBytes("Content-Disposition: form-data; name=\"upload\";" + " filename=\"" + fileName +"\"" + lineEnd);
            dos.writeBytes(lineEnd);

            bytesAvailable = fileInputStream.available();
            bufferSize = Math.min(bytesAvailable, maxBufferSize);
            buffer = new byte[bufferSize];

            bytesRead = fileInputStream.read(buffer, 0, bufferSize);
         while (bytesRead > 0){
             dos.write(buffer, 0, bufferSize);
             bytesAvailable = fileInputStream.available();
             bufferSize = Math.min(bytesAvailable, maxBufferSize);
             bytesRead = fileInputStream.read(buffer, 0, bufferSize);
         }

         dos.writeBytes(lineEnd);
         dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
         // close streams
         fileInputStream.close();
         dos.flush();
         dos.close();

        }catch (MalformedURLException ex){
            System.out.println("From ServletCom CLIENT REQUEST:"+ex);
        }catch (IOException ioe){
            System.out.println("From ServletCom CLIENT REQUEST:"+ioe);
        }
        
        //------------------ read the SERVER RESPONSE
        try {
            inStream = new DataInputStream ( conn.getInputStream() );
            String str;
            while (( str = inStream.readLine()) != null){
            	System.out.println("Server response is: " + str);
            }
            inStream.close();
        }catch (IOException ioex){
            System.out.println("From (ServerResponse): " + ioex);
        }
	}
	
	
	
}
