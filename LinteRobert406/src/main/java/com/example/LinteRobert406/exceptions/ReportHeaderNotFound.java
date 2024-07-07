package com.example.LinteRobert406.exceptions;

public class ReportHeaderNotFound extends RuntimeException{
    public ReportHeaderNotFound() {
        super("The report header does not exist");
    }
}
