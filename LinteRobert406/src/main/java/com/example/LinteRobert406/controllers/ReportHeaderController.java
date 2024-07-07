package com.example.LinteRobert406.controllers;

import com.example.LinteRobert406.dtos.PostReportHeader;
import com.example.LinteRobert406.dtos.ReportHeaderResponse;
import com.example.LinteRobert406.entities.ReportHeader;
import com.example.LinteRobert406.enums.ReportHeaderType;
import com.example.LinteRobert406.exceptions.ReportHeaderAlreadyExistException;
import com.example.LinteRobert406.exceptions.ReportHeaderNotFound;
import com.example.LinteRobert406.mappers.ReportHeaderMapper;
import com.example.LinteRobert406.services.ReportHeaderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/report_header")
public class ReportHeaderController {
    @Autowired
    private ReportHeaderService reportHeaderService;

    @Autowired
    private ReportHeaderMapper reportHeaderMapper;

    @Autowired
    private Environment environment;

    @PostMapping
    public ResponseEntity<ReportHeaderResponse> createReportHeader(@RequestBody PostReportHeader postReportHeader) {
        System.out.println(environment.getProperty("local.server.port"));
        ReportHeader reportHeader = reportHeaderMapper.postReportHeaderToReportHeader(postReportHeader);
        reportHeader = reportHeaderService.create(reportHeader);

        ReportHeaderResponse reportHeaderResponse = reportHeaderMapper.reportHeaderToReportHeaderResponse(reportHeader);

        return ResponseEntity.created(URI.create("/report_header/"+ reportHeaderResponse.getId()))
                .body(reportHeaderResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReportHeader(@PathVariable("id") int id) {
        try {
            reportHeaderService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (ReportHeaderNotFound e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<ReportHeaderResponse> getReportHeaders(
            @RequestParam(name = "type", required = false) ReportHeaderType type
    ) {
        List<ReportHeaderResponse> reportHeaderResponses = new ArrayList<>();

        reportHeaderService.get(type).forEach(reportHeader ->
        {
            ReportHeaderResponse reportHeaderResponse = reportHeaderMapper.reportHeaderToReportHeaderResponse(reportHeader);
            reportHeaderResponse.add(linkTo(methodOn(ReportHeaderController.class).deleteReportHeader(reportHeader.getId())).withRel("delete"));
            reportHeaderResponses.add(reportHeaderResponse);

        });

        return reportHeaderResponses;
    }
}
