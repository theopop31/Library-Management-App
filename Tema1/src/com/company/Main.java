package com.company;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        /* Incepem cu intializarea tuturor listelor de care avem nevoie cu
            datele din fisierele .in */

        // Initializare autori

        File file = new File("F:\\Cursuri\\AN II\\POO\\IntelliJ\\Tema1\\init\\authors.in");
        // Initializam lista care este initial goala
        ArrayList<Author> authorArrayList = new ArrayList<>(0);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean ok = false; // ok devine true dupa prima linie citita din fisier

            while ((line = br.readLine()) != null) {
                // Facem split pe linia citita din fisier dupa separatorul ###
                String[] parts = line.split("###");
                if (ok) {
                    // Instantiem un nou obiect, ii setam atributele si apoi il adaugam la lista
                    Author a = new Author();
                    a.setID(Integer.parseInt(parts[0]));
                    a.setFirstName(parts[1]);
                    a.setLastName(parts[2]);
                    authorArrayList.add(a);
                }
                ok = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
            Vom folosi in mare acelasi sablon si pentru citirea si initializarea din
            celelalre fisiere, cu modificari la setarea atributelor.
         */

        // Initializare tari

        file = new File("F:\\Cursuri\\AN II\\POO\\IntelliJ\\Tema1\\init\\countries.in");
        ArrayList<Countries> countriesArrayList = new ArrayList<>(0);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean ok = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("###");
                if (ok) {
                    Countries c = new Countries();
                    c.setID(Integer.parseInt(parts[0]));
                    c.setCountryCode(parts[1]);
                    countriesArrayList.add(c);
                }
                ok = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initializare limbi

        file = new File("F:\\Cursuri\\AN II\\POO\\IntelliJ\\Tema1\\init\\languages.in");
        ArrayList<Language> languageArrayList = new ArrayList<>(0);
        try (BufferedReader br = new BufferedReader((new FileReader(file)))) {
            String line;
            boolean ok = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("###");
                if (ok) {
                    Language l = new Language();
                    l.setID(Integer.parseInt(parts[0]));
                    l.setCode(parts[1]);
                    l.setName(parts[2]);
                    languageArrayList.add(l);
                }
                ok = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initializare carti

        file = new File("F:\\Cursuri\\AN II\\POO\\IntelliJ\\Tema1\\init\\books.in");
        ArrayList<Book> bookArrayList = new ArrayList<>(0);
        try (BufferedReader br = new BufferedReader((new FileReader(file)))) {
            String line;
            boolean ok = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("###");
                if (ok) {
                    Book b = new Book();
                    b.setID(Integer.parseInt(parts[0]));
                    b.setName(parts[1]);
                    b.setSubtitle(parts[2]);
                    b.setISBN(parts[3]);
                    b.setPageCount(Integer.parseInt(parts[4]));
                    b.setKeywords(parts[5]);
                    b.setLanguageID(Integer.parseInt(parts[6]));
                    // pentru data la care a fost creat fisierul folosim un sdf pentru formatare
                    Calendar cal = Calendar.getInstance();
                    DateFormat formatter;
                    Date d;
                    formatter = new SimpleDateFormat("dd.mm.yyy hh:mm:ss");
                    d = formatter.parse(parts[7]);
                    cal.setTime(d);
                    b.setCreatedOn(cal);
                    bookArrayList.add(b);
                }
                ok = true;
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        // Initializare grupuri editoriale

        file = new File("F:\\Cursuri\\AN II\\POO\\IntelliJ\\Tema1\\init\\editorial-groups.in");
        ArrayList<EditorialGroup> editorialGroupArrayList = new ArrayList<>(0);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean ok = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("###");
                if (ok) {
                    EditorialGroup eg = new EditorialGroup();
                    eg.setID(Integer.parseInt(parts[0]));
                    eg.setName(parts[1]);
                    editorialGroupArrayList.add(eg);
                }
                ok = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initializare brand-uri de plubicare

        file = new File("F:\\Cursuri\\AN II\\POO\\IntelliJ\\Tema1\\init\\publishing-brands.in");
        ArrayList<PublishingBrand> publishingBrandArrayList = new ArrayList<>(0);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean ok = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("###");
                if (ok) {
                    PublishingBrand pb = new PublishingBrand();
                    pb.setID(Integer.parseInt(parts[0]));
                    pb.setName(parts[1]);
                    publishingBrandArrayList.add(pb);
                }
                ok = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initializare firme de publicare

        file = new File("F:\\Cursuri\\AN II\\POO\\IntelliJ\\Tema1\\init\\publishing-retailers.in");
        ArrayList<PublishingRetailer> publishingRetailerArrayList = new ArrayList<>(0);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean ok = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("###");
                if (ok) {
                    PublishingRetailer pr = new PublishingRetailer();
                    pr.setID(Integer.parseInt(parts[0]));
                    pr.setName(parts[1]);
                    publishingRetailerArrayList.add(pr);
                }
                ok = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Legaturi carti - autori

        file = new File("F:\\Cursuri\\AN II\\POO\\IntelliJ\\Tema1\\init\\books-authors.in");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean ok = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("###");
                if (ok) {
                    Author a = null;
                    for (Author author : authorArrayList) {
                        if (author.getID() == Integer.parseInt(parts[1])) {
                            a = author;
                            break;
                        }
                    }
                    for (Book book : bookArrayList) {
                        if (book.getID() == Integer.parseInt(parts[0])) {
                            if (book.getAuthors() == null) {
                                ArrayList<Author> aList = new ArrayList<>(0);
                                book.setAuthors(aList);
                            }
                            book.getAuthors().add(a);
                            break;
                        }
                    }
                }
                ok = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Legaturi grupuri editoriale - carti

        file = new File("F:\\Cursuri\\AN II\\POO\\IntelliJ\\Tema1\\init\\editorial-groups-books.in");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean ok = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("###");
                if (ok) {
                    Book b = null;
                    for (Book book : bookArrayList) {
                        if (book.getID() == Integer.parseInt(parts[1])) {
                            b = book;
                            break;
                        }
                    }
                    for (EditorialGroup editorialGroup : editorialGroupArrayList) {
                        if (editorialGroup.getID() == Integer.parseInt(parts[0])) {
                            if (editorialGroup.getBooks() == null) {
                                ArrayList<Book> bList = new ArrayList<>(0);
                                editorialGroup.setBooks(bList);
                            }
                            editorialGroup.getBooks().add(b);
                            break;
                        }
                    }
                }
                ok = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Legaturi brand-uri de publicare - carti

        file = new File("F:\\Cursuri\\AN II\\POO\\IntelliJ\\Tema1\\init\\publishing-brands-books.in");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean ok = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("###");
                if (ok) {
                    Book b = new Book();
                    for (Book book : bookArrayList) {
                        if (book.getID() == Integer.parseInt(parts[1])) {
                            b = book;
                            break;
                        }
                    }
                    for (PublishingBrand publishingBrand : publishingBrandArrayList) {
                        if (publishingBrand.getID() == Integer.parseInt(parts[0])) {
                            if (publishingBrand.getBooks() == null) {
                                ArrayList<Book> bList = new ArrayList<>(0);
                                publishingBrand.setBooks(bList);
                            }
                            publishingBrand.getBooks().add(b);
                            break;
                        }
                    }
                }
                ok = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Legaturi firme de publicare - tari

        file = new File("F:\\Cursuri\\AN II\\POO\\IntelliJ\\Tema1\\init\\publishing-retailers-countries.in");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean ok = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("###");
                if (ok) {
                    Countries c = null;
                    for (Countries country : countriesArrayList) {
                        if (country.getID() == Integer.parseInt(parts[1])) {
                            c = country;
                            break;
                        }
                    }
                    for (PublishingRetailer publishingRetailer : publishingRetailerArrayList) {
                        if (publishingRetailer.getID() == Integer.parseInt(parts[0])) {
                            if (publishingRetailer.getCountries() == null) {
                                ArrayList<Countries> cList = new ArrayList<>(0);
                                publishingRetailer.setCountries(cList);
                            }
                            publishingRetailer.getCountries().add(c);
                            break;
                        }
                    }
                }
                ok = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Legaturi firme de publicare - carti

        file = new File("F:\\Cursuri\\AN II\\POO\\IntelliJ\\Tema1\\init\\publishing-retailers-books.in");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean ok = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("###");
                if (ok) {
                    Book b = null;
                    for (Book book : bookArrayList) {
                        if (book.getID() == Integer.parseInt(parts[1])) {
                            b = book;
                            break;
                        }
                    }

                    for (PublishingRetailer publishingRetailer : publishingRetailerArrayList) {
                        if (publishingRetailer.getID() == Integer.parseInt(parts[0])) {
                            if (publishingRetailer.getPublishingArtifacts() == null) {
                                ArrayList<IPublishingArtifact> iList = new ArrayList<>(0);
                                publishingRetailer.setPublishingArtifacts(iList);
                            }
                            publishingRetailer.getPublishingArtifacts().add(b);
                            break;
                        }
                    }
                }
                ok = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Legaturi firme de publicare - grupuri editoriale

        file = new File("F:\\Cursuri\\AN II\\POO\\IntelliJ\\Tema1\\init\\publishing-retailers-editorial-groups.in");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean ok = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("###");
                if (ok) {
                    EditorialGroup eg = null;
                    for (EditorialGroup editorialGroup : editorialGroupArrayList) {
                        if (editorialGroup.getID() == Integer.parseInt(parts[1])) {
                            eg = editorialGroup;
                            break;
                        }
                    }

                    for (PublishingRetailer publishingRetailer : publishingRetailerArrayList) {
                        if (publishingRetailer.getID() == Integer.parseInt(parts[0])) {
                            if (publishingRetailer.getPublishingArtifacts() == null) {
                                ArrayList<IPublishingArtifact> iList = new ArrayList<>(0);
                                publishingRetailer.setPublishingArtifacts(iList);
                            }
                            publishingRetailer.getPublishingArtifacts().add(eg);
                            break;
                        }
                    }
                }
                ok = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Legaturi firme de publicare - brand-uri de publicare

        file = new File("F:\\Cursuri\\AN II\\POO\\IntelliJ\\Tema1\\init\\publishing-retailers-publishing-brands.in");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean ok = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("###");
                if (ok) {
                    PublishingBrand pb = null;
                    for (PublishingBrand publishingBrand : publishingBrandArrayList) {
                        if (publishingBrand.getID() == Integer.parseInt(parts[1])) {
                            pb = publishingBrand;
                            break;
                        }
                    }

                    for (PublishingRetailer publishingRetailer : publishingRetailerArrayList) {
                        if (publishingRetailer.getID() == Integer.parseInt(parts[0])) {
                            if (publishingRetailer.getPublishingArtifacts() == null) {
                                ArrayList<IPublishingArtifact> iList = new ArrayList<>(0);
                                publishingRetailer.setPublishingArtifacts(iList);
                            }
                            publishingRetailer.getPublishingArtifacts().add(pb);
                            break;
                        }
                    }
                }
                ok = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Testarea metodelor implementate

        // Initializam un element de tip Administration cu datele citite din fisiere

        Administration admin = new Administration();
        admin.setLanguageArrayList(languageArrayList);
        admin.setPublishingRetailerArrayList(publishingRetailerArrayList);


        //Testare getBooksForPublishingRetailerID
        System.out.println("Testare pentru metoda getBooksForPublishingRetailerID");
        for (int i = 0; i < 5; ++i) {
            System.out.println("Exemplul " + i);
            ArrayList<Book> booksForI = admin.getBooksForPublishingRetailerID(admin.getPublishingRetailerArrayList().get(i).getID());
            if (booksForI.size() == 0) {
                System.out.println("Nu exista carti de afisat");
            } else {
                for (Book book : booksForI) {
                    System.out.println(book.getName() + " " + book.getISBN());
                }
            }
            System.out.println();
        }

        //Testare getLanguagesForPublishingRetailerID()
        System.out.println("Testare pentru metoda getLanguagesForPublishingRetailerID");
        for (int i = 0; i < 5; ++i) {
            System.out.println("Exemplul " + i);
            ArrayList<Language> languageList = admin.getLanguagesForPublishingRetailerID(admin.getPublishingRetailerArrayList().get(i).getID());
            if (languageList.size() == 0) {
                System.out.println("Nu exista limbi de afisat");
            } else {
                for (Language language : languageList) {
                    System.out.println(language.getName() + " " + language.getCode());
                }
            }
            System.out.println();
        }

        //Testare getCountriesForBookID()
        System.out.println("Testare pentru metoda getCountriesForBookID");
        for (int i = 0; i < 5; ++i) {
            System.out.println("Exemplul " + i);
            ArrayList<Countries> countryList = admin.getCountriesForBookID(bookArrayList.get(i).getID());
            if (countryList.size() == 0) {
                System.out.println("Nu exista carti de afisat");
            } else {
                for (Countries country : countryList) {
                    System.out.println(country.getCountryCode() + " " + country.getID());
                }
            }
            System.out.println();
        }

        //Testare getCommonBooksForRetailerIDs()
        System.out.println("Testare pentru metoda getCommonBooksForRetailerIDs");
        for (int i = 0; i < 5; ++i) {
            System.out.println("Exemplul " + i);
            int retailerID1 = publishingRetailerArrayList.get(i).getID();
            int retailerID2 = publishingRetailerArrayList.get(i + 1).getID();
            ArrayList<Book> commonBooks = admin.getCommonBooksForRetailerIDs(retailerID1, retailerID2);
            if (commonBooks.size() == 0) {
                System.out.println("Nu exista carti comune");
            } else {
                for (Book book : commonBooks) {
                    System.out.println(book.getName() + " " + book.getISBN());
                }
            }
            System.out.println();
        }

        //Testare getAllBooksForRetailerIDs()
        System.out.println("Testare pentru metoda getAllBooksForRetailerIDs");
        for (int i = 0; i < 5; ++i) {
            System.out.println("Exemplul " + i);
            int retailerID1 = publishingRetailerArrayList.get(i).getID();
            int retailerID2 = publishingRetailerArrayList.get(i + 1).getID();
            ArrayList<Book> allBooks = admin.getAllBooksForRetailerIDs(retailerID1, retailerID2);
            if (allBooks.size() == 0) {
                System.out.println("Nu exista carti de afisat");
            } else {
                for (Book book : allBooks) {
                    System.out.println(book.getName() + " " + book.getISBN());
                }
            }
            System.out.println();
        }
    }
}
