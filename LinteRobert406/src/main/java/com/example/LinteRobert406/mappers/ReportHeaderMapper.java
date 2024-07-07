package com.example.LinteRobert406.mappers;

import com.example.LinteRobert406.dtos.PostReportHeader;
import com.example.LinteRobert406.dtos.ReportHeaderResponse;
import com.example.LinteRobert406.entities.ReportHeader;
import org.springframework.stereotype.Component;

@Component
public class ReportHeaderMapper {
    public ReportHeader postReportHeaderToReportHeader(PostReportHeader postReportHeader) {
        return new ReportHeader(postReportHeader.getTitle(), postReportHeader.getType(), postReportHeader.getCreationDate(), postReportHeader.getCreationUser());
    }

    public ReportHeaderResponse reportHeaderToReportHeaderResponse(ReportHeader reportHeader) {
        return new ReportHeaderResponse(reportHeader.getId(), reportHeader.getTitle(), reportHeader.getType(), reportHeader.getCreationDate(), reportHeader.getCreationUser());
    }
}
