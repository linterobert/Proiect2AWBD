package com.example.LinteRobert406.repositories;

import com.example.LinteRobert406.entities.ReportHeader;
import com.example.LinteRobert406.enums.ReportHeaderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReportHeaderRepository extends JpaRepository<ReportHeader, Integer>, PagingAndSortingRepository<ReportHeader, Integer> {
    List<ReportHeader> findByTypeAndCreationDate(ReportHeaderType reportHeaderType, Date date);
    List<ReportHeader> findByType(ReportHeaderType type);
}
