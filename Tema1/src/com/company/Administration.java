package com.company;

import java.util.ArrayList;

public class Administration {
    private  ArrayList<Language> languageArrayList;
    private ArrayList<PublishingRetailer> publishingRetailerArrayList;

    public ArrayList<Language> getLanguageArrayList() {
        return languageArrayList;
    }

    public void setLanguageArrayList(ArrayList<Language> languageArrayList) {
        this.languageArrayList = languageArrayList;
    }

    public ArrayList<PublishingRetailer> getPublishingRetailerArrayList() {
        return publishingRetailerArrayList;
    }

    public void setPublishingRetailerArrayList(ArrayList<PublishingRetailer> publishingRetailerArrayList) {
        this.publishingRetailerArrayList = publishingRetailerArrayList;
    }

    public ArrayList<Book> getBooksForPublishingRetailerID(int publishingRetailerID) {
        // Instantierea listei pe care o vom returna
        ArrayList<Book> booksForPublishingRetailerID = new ArrayList<>(0);
        PublishingRetailer pb = null;
        // Cautam publishingRetailer-ul dupa ID in lista de publisheri
        for (PublishingRetailer publishingRetailer : publishingRetailerArrayList) {
            if (publishingRetailer.getID() == publishingRetailerID) {
                pb = publishingRetailer;
                break;
            }
        }
        // Daca nu a fost gasit vom returna lista goala
        if (pb == null)
            return booksForPublishingRetailerID;

        // Testam tipul pentru fiecare artifact din lista de artifacte a publisher-ului
        for (IPublishingArtifact ipa : pb.getPublishingArtifacts()) {
            // Verificam daca este o instanta a clasei Carte
            if (ipa instanceof Book) {
                // Verificam ca elementul sa nu existe deja in lista pe care vrem sa o returnam
                if (!booksForPublishingRetailerID.contains((Book) ipa)) {
                    booksForPublishingRetailerID.add((Book) ipa);
                }
            } else if (ipa instanceof EditorialGroup editorialGroup) {
                // In cazul EditorialGroup si PublishingBrand parcurgem lista fiecaruia de carti
                for (Book book : editorialGroup.getBooks()) {
                    if (!booksForPublishingRetailerID.contains(book)) {
                        booksForPublishingRetailerID.add(book);
                    }
                }
            } else if (ipa instanceof PublishingBrand publishingBrand) {
                for (Book book : publishingBrand.getBooks()) {
                    if (!booksForPublishingRetailerID.contains(book)) {
                        booksForPublishingRetailerID.add(book);
                    }
                }
            }
        }
        return booksForPublishingRetailerID;
    }

    public ArrayList<Language> getLanguagesForPublishingRetailerID(int publishingRetailerID) {
        // Instantierea listei pe care o vom returna
        ArrayList<Language> languagesForPublishingRetailer = new ArrayList<>(0);
        PublishingRetailer pb = null;
        // Cautam publishingRetailer-ul dupa ID in lista de publisheri
        for (PublishingRetailer publishingRetailer : publishingRetailerArrayList) {
            if (publishingRetailer.getID() == publishingRetailerID) {
                pb = publishingRetailer;
                break;
            }
        }
        // Daca nu a fost gasit vom returna lista goala
        if (pb == null)
            return languagesForPublishingRetailer;

        // Testam tipul pentru fiecare artifact din lista de artifacte a publisher-ului
        for (IPublishingArtifact ipa : pb.getPublishingArtifacts()) {
            if (ipa instanceof Book) {
                // Parcurgem lista de limbi pentru gasirea limbii cartii curente
                for (Language l : languageArrayList) {
                    if (((Book) ipa).getLanguageID() == l.getID()) {
                        // Verificam ca elementul sa nu existe deja in lista pe care vrem sa o returnam
                        if (!languagesForPublishingRetailer.contains(l)) {
                            languagesForPublishingRetailer.add(l);
                        }
                    }
                }
            } else if (ipa instanceof EditorialGroup editorialGroup) {
                // In cazul EditorialGroup si PublishingBrand parcurgem lista fiecaruia de carti
                for (Book book : editorialGroup.getBooks()) {
                    for (Language l : languageArrayList) {
                        if (book.getLanguageID() == l.getID()) {
                            if (!languagesForPublishingRetailer.contains(l)) {
                                languagesForPublishingRetailer.add(l);
                            }
                        }
                    }
                }
            } else if (ipa instanceof PublishingBrand publishingBrand) {
                for (Book book : publishingBrand.getBooks()) {
                    for (Language l : languageArrayList) {
                        if (book.getLanguageID() == l.getID()) {
                            if (!languagesForPublishingRetailer.contains(l)) {
                                languagesForPublishingRetailer.add(l);
                            }
                        }
                    }
                }
            }
        }

        return languagesForPublishingRetailer;
    }

    public ArrayList<Countries> getCountriesForBookID(int bookID) {
        // Instantierea listei pe care o vom returna
        ArrayList<Countries> countriesForBookID = new ArrayList<>(0);
        // Cautam cartea dupa ID printre toti PublishingRetailers
        for (PublishingRetailer pr : publishingRetailerArrayList) {
            boolean found = false;
            for (IPublishingArtifact ipa : pr.getPublishingArtifacts()) {
                if (ipa instanceof Book) {
                    if (bookID == ((Book) ipa).getID()) {
                        found = true; // marcam gasirea cartii
                        break; // oprim parcurgerea
                    }
                } else if (ipa instanceof EditorialGroup) {
                    // Pentru EditorialGroup si PublishingBrand cautam in lista acestora de carti
                    for (Book book : ((EditorialGroup) ipa).getBooks()) {
                        if (bookID == book.getID()) {
                            found = true;
                            break;
                        }
                    }
                } else if (ipa instanceof PublishingBrand) {
                    for (Book book : ((PublishingBrand) ipa).getBooks()) {
                        if (bookID == book.getID()) {
                            found = true;
                            break;
                        }
                    }
                }

            }
            // Daca cartea a fost gasita, adaugam toate tarile in care publishing retailerul publica
            if (found) {
                for (Countries country : pr.getCountries()) {
                    if (!countriesForBookID.contains(country)) {
                        countriesForBookID.add(country);
                    }
                }
            }
        }

        return countriesForBookID;
    }

    public ArrayList<Book> getCommonBooksForRetailerIDs(int retailerID1, int retailerID2) {
        // Instantierea listei pe care o vom returna
        ArrayList<Book> commonBooksForRetailerIDs = new ArrayList<>(0);
        ArrayList<Book> auxList1, auxList2;
        /*
         Folosim una din metodele definite anterior pentru a extrage lista de carti pentru fiecare
         retailerID
        */
        auxList1 = getBooksForPublishingRetailerID(retailerID1);
        auxList2 = getBooksForPublishingRetailerID(retailerID2);

        /*
         Pentru fiecare carte din prima lista verificam daca se gaseste in a doua si nu se gaseste
         in lista de returnat
         */
        for (Book book : auxList1) {
            if (auxList2.contains(book)) {
                if (!commonBooksForRetailerIDs.contains(book)) {
                    commonBooksForRetailerIDs.add(book);
                }
            }
        }
        return commonBooksForRetailerIDs;
    }

    public ArrayList<Book> getAllBooksForRetailerIDs (int retailerID1, int retailerID2) {
        // Instantierea listei pe care o vom returna
        ArrayList<Book> allBooksForRetailerIDs = new ArrayList<>(0);

        /*
        Ne folosim iar de metoda definita anterior pentru a obtine liste de carti dupa retailerID
        si adaugam toate cartile intr-o singura lista
         */

        for (Book book : getBooksForPublishingRetailerID(retailerID1)) {
            if (!allBooksForRetailerIDs.contains(book)) {
                allBooksForRetailerIDs.add(book);
            }
        }

        for (Book book : getBooksForPublishingRetailerID(retailerID2)) {
            if (!allBooksForRetailerIDs.contains(book)) {
                allBooksForRetailerIDs.add(book);
            }
        }

        return allBooksForRetailerIDs;
    }

}

