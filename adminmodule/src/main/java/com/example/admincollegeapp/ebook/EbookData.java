package com.example.admincollegeapp.ebook;

public class EbookData {
    String pdfTitle,pdfUrl,key;

    public EbookData() {

    }

    public EbookData(String pdfTitle, String pdfUrl, String key) {
        this.pdfTitle = pdfTitle;
        this.pdfUrl = pdfUrl;
        this.key = key;
    }

    public String getPdfTitle() {
        return pdfTitle;
    }

    public void setPdfTitle(String pdfTitle) {
        this.pdfTitle = pdfTitle;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdf(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
