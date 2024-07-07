package com.example.LinteRobert406.exceptions;

public class ReportHeaderAlreadyExistException extends RuntimeException{
    public ReportHeaderAlreadyExistException() {
        super("There is already a BALANCE_SHEET report for the specified date");
    }
}
