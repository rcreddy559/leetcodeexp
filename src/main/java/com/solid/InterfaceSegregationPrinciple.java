package com.solid;

public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        DocumentService documentService = new DocumentService();

        // Different devices with specific capabilities
        Printable basicPrinter = new BasicPrinter();
        Scannable networkScanner = new ScannableDoc();
        AllInOne multiDevicePrinter = new AllInOne();

        // Process print and scan jobs
        documentService.processPrintJob(basicPrinter, "Report.pdf");
        documentService.processScanJob(networkScanner, "Contract.docx");

        // Multifunction device can handle multiple operations
        multiDevicePrinter.print("Presentation.pptx");
        multiDevicePrinter.scan("Invoice.jpg");
        multiDevicePrinter.fax("Agreement.pdf");
        multiDevicePrinter.copy("Manual.docx");
    }
}

interface Printable {
    void print(String docmunt);
}

interface Scannable {
    void scan(String docmunt);
}

interface Faxble {
    void fax(String docmunt);
}

interface Copyble {
    void copy(String docmunt);
}

class BasicPrinter implements Printable {
    @Override
    public void print(String docmunt) {
        System.out.println("Base Printer is printing documents");
    }
}

class ScannableDoc implements Scannable {
    @Override
    public void scan(String docmunt) {
        System.out.println("Sending documents by Fax");
    }
}

class AllInOne implements Printable, Scannable, Faxble, Copyble {

    @Override
    public void copy(String docmunt) {
        System.out.println("copying documents");
    }

    @Override
    public void fax(String docmunt) {
        System.out.println("Sending documents by Fax");
    }

    @Override
    public void scan(String docmunt) {
        System.out.println("Scanning documents");
    }

    @Override
    public void print(String docmunt) {
        System.out.println("Printin documents");
    }

}

class DocumentService {
    public void processPrintJob(Printable printer, String document) {
        printer.print(document);
    }

    public void processScanJob(Scannable scanner, String document) {
        scanner.scan(document);
    }
}
