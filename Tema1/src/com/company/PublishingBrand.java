package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PublishingBrand implements IPublishingArtifact{
    private int ID;
    private String name;
    private ArrayList<Book> books;

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String Publish() {
        StringBuilder s = new StringBuilder("<xml>\n");

        s.append("\t<publishingBrand>\n");
        s.append("\t\t<ID>").append(this.getID()).append("</ID>\n");
        s.append("\t\t<Name>").append(this.getName()).append("</Name>\n");
        s.append("\t</publishingBrand>\n");
        s.append("\t<books>\n");

        for (Book book : this.books) {
            s.append("\t\t<book>\n");
            s.append("\t\t\t<title>").append(book.getName()).append("</title>\n");
            s.append("\t\t\t<subtitle>").append(book.getSubtitle()).append("</subtitle>\n");
            s.append("\t\t\t<isbn>").append(book.getISBN()).append("</isbn>\n");
            s.append("\t\t\t<pageCount>").append(book.getPageCount()).append("</pageCount>\n");
            s.append("\t\t\t<keywords>").append(book.getKeywords()).append("</keywords>\n");
            s.append("\t\t\t<languageID>").append(book.getLanguageID()).append("</languageID>\n");

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyy hh:mm:ss");
            s.append("\t\t\t<createdOn>").append(dateFormat.format(book.getCreatedOn().getTime())).append("</createdOn>\n");

            for (Author author : book.getAuthors()) {
                s.append("\t\t\t<authors>").append(author.getLastName()).append(author.getFirstName()).append("</authors>\n");
            }
            s.append("\t\t</book>\n");
        }

        s.append("\t</books>\n");
        s.append("</xml>\n");

        return s.toString();
    }
}
