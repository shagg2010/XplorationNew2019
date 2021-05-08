package com.saurabh.dada.iq.impl.multithreading;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;

public class Thread_Executor_ReadWebPage
{
   public static void main(final String[] args)
   {
      
      ExecutorService executor = Executors.newSingleThreadExecutor();
      Callable<List<String>> callable;
      callable = new Callable<List<String>>()
                 {
                    @Override
                    public List<String> call()
                       throws IOException, MalformedURLException
                    {
                       List<String> lines = new ArrayList<>();
                       URL url = new URL("https://www.google.co.in/");
                       HttpURLConnection con;
                       con = (HttpURLConnection) url.openConnection();
                       InputStreamReader isr;
                       isr = new InputStreamReader(con.getInputStream());
                       BufferedReader br;
                       br = new BufferedReader(isr);
                       String line;
                       while ((line = br.readLine()) != null)
                          lines.add(line);
                       return lines;
                    }
                 };
      Future<List<String>> future = executor.submit(callable);
      try
      {
         List<String> lines = future.get(5, TimeUnit.SECONDS);
         for (String line: lines)
            System.out.println(line);
      }
      catch (ExecutionException ee)
      {
         System.err.println("Callable through exception: "+ee.getMessage());
      }
      catch (InterruptedException | TimeoutException eite)
      {
         System.err.println("URL not responding");
      }
      executor.shutdown();
    }
}
