package com.charles.elites.quest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kelvin.R.K on 6/26/2016.
 */
public class Paragraph {
    public static String changeDateFormat(String paragraph) {
        List<String> res = new ArrayList<String>();
        Matcher matcher = Pattern.compile("(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d").matcher(paragraph);;
        while(matcher.find()) {
            res.add(matcher.group());
        }

        for(String s : res) {
            paragraph = paragraph.replace(s, process(s));
        }
        return paragraph;
    }

    private static String process(String s) {
        String[] res = s.split("/");
        return res[1] + "/" + res[0] + "/" + res[2];
    }

    public static void main(String[] args) {
        System.out.println(changeDateFormat("Last time it rained was on 07/25/2013 and today is 08/09/2013."));
    }
}