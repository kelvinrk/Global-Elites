package com.charles.elites.quest;

import java.util.ArrayList;
import java.util.Collection;

class Programmer {
    private Collection<String> languages;

    public Programmer() {
        this.languages = new ArrayList<String>();
    }

    public Collection<String> getLanguages() {
        return languages;
    }

    public void addLanguage(String language)  {
        this.languages.add(language);
    }
}

class ProgrammerTeacher extends Programmer{
    public boolean teach(Programmer programmer, String language) {
        if(this.getLanguages().contains(language)) {
            programmer.addLanguage(language);
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
      ProgrammerTeacher teacher = new ProgrammerTeacher();
      teacher.addLanguage("Java");

      Programmer programmer = new Programmer();
      teacher.teach(programmer, "Java");

      for(String language : programmer.getLanguages())
          System.out.println(language);
    }
}