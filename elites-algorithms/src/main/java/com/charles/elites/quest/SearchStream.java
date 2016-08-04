package com.charles.elites.quest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SearchStream {
    public static List<String> findLines(String keyword, InputStream inStream) throws Exception {
        List<String> res = new ArrayList<String>();
        for(String s: getStringFromInputStream(inStream)) {
            if(s.contains(keyword))
                res.add(s);
        }
        return res;
    }

    private static List<String> getStringFromInputStream(InputStream is) {
        BufferedReader br = null;
        List<String> res = new ArrayList<String>();

        String line;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            while((line = bufferedReader.readLine()) != null) {
                res.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        String inMessage = "Hello, there!\nHow are you today?\nYes, you over there.";
        List<String> lines;

        try (InputStream inStream = new ByteArrayInputStream(inMessage.getBytes())) {
            lines = SearchStream.findLines("there", inStream);
        }

        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }
}