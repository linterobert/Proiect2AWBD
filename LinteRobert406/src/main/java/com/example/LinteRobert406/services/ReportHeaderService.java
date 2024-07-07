package com.example.LinteRobert406.services;

import com.example.LinteRobert406.entities.ReportHeader;
import com.example.LinteRobert406.enums.ReportHeaderType;
import com.example.LinteRobert406.exceptions.ReportHeaderAlreadyExistException;
import com.example.LinteRobert406.exceptions.ReportHeaderNotFound;
import com.example.LinteRobert406.repositories.ReportHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportHeaderService {
    @Autowired
    private ReportHeaderRepository reportHeaderRepository;

    public ReportHeader create(ReportHeader reportHeader) {
        if(reportHeader.getType() != ReportHeaderType.BALANCE_SHEET) {
            return reportHeaderRepository.save(reportHeader);
        }

        List<ReportHeader> reportHeaders = reportHeaderRepository.findByTypeAndCreationDate(reportHeader.getType(), reportHeader.getCreationDate());

        if(reportHeaders.isEmpty()) {
            return reportHeaderRepository.save(reportHeader);
        }

        throw  new ReportHeaderAlreadyExistException();
    }

    public void delete(int id) {
        Optional<ReportHeader> reportHeader = reportHeaderRepository.findById(id);

        if(!reportHeader.isPresent()){
            throw new ReportHeaderNotFound();
        }

        reportHeaderRepository.delete(reportHeader.get());
    }

    public List<ReportHeader> get(ReportHeaderType type) {
        if(type == null) {
            return  reportHeaderRepository.findAll();
        }

        return  reportHeaderRepository.findByType(type);
    }
}
