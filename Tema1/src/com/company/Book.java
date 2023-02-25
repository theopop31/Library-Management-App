package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;

public class Book implements IPublishingArtifact{
    private int ID;
    private String name, subtitle;
    public String ISBN;
    private int pageCount;
    private String keywords;
    private int languageID;
    private Calendar createdOn;
    private ArrayList<Author> authors;

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getKeywords() {
        return keywords;
    }

    public int getLanguageID() {
        return languageID;
    }

    public Calendar getCreatedOn() {
        return createdOn;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public void setCreatedOn(Calendar createdOn) {
        this.createdOn = createdOn;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String Publish() {
        // Am folosit StringBuiler pentru concatenare mai eficienta
        StringBuilder s;
        s = new StringBuilder("<xml>\n");
        s.append("\t<title>").append(this.getName()).append("</title>\n");
        s.append("\t<subtitle>").append(this.getSubtitle()).append("</subtitle>\n");
        s.append("\t<isbn>").append(this.getISBN()).append("</isbn>\n");
        s.append("\t<pageCount>").append(this.getPageCount()).append("</pageCount>\n");
        s.append("\t<keywords>").append(this.getKeywords()).append("</keywords>\n");
        s.append("\t<languageID>").append(this.getLanguageID()).append("</languageID>\n");

        // Formatam informatiile care se afla in CreatedOn pentru a afisa rezultatul sub o anumita forma
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyy hh:mm:ss");
        s.append("\t<createdOn>").append(dateFormat.format(this.getCreatedOn().getTime())).append("</createdOn>\n");

        // Afisam toti autorii
        for (Author author : this.authors) {
            s.append("\t<authors>").append(author.getLastName()).append(author.getFirstName()).append("</authors>\n");
        }
        s.append("</xml>");

        return s.toString();
    }
}
