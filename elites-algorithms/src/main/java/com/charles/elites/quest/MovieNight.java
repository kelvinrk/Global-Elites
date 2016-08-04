package com.charles.elites.quest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class MovieNight {
    public static Boolean canViewAll(Collection<Movie> movies) {
        if(movies.isEmpty())
            return true;
        Comparator<Movie> comp = (o1, o2) -> {
                if(o1.getStart().equals(o2.getStart()))
                    return o1.getEnd().compareTo(o2.getEnd());
                return o1.getStart().compareTo(o2.getStart());
        };
        ArrayList<Movie> list = (ArrayList)movies;
        Collections.sort(list, comp);

        for(int i = 1; i < list.size(); i++) {
            if(list.get(i).getStart().compareTo(list.get(i - 1).getEnd()) < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));

        System.out.println(MovieNight.canViewAll(movies));
    }
}

class Movie {
    private Date start, end;

    public Movie(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }
}