package com.handyman.ias.infrastructure.configurations;

import com.handyman.ias.infrastructure.models.ReportServDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SpringJPARepository extends JpaRepository<ReportServDAO, Long> {
    @Query("SELECT i FROM ReportServDAO i WHERE i.idTechnician=:idTech AND i.initDate BETWEEN :initWeek AND :endWeek ORDER BY i.initDate ASC" )
    List<ReportServDAO> findReportServBy(@Param("idTech") String idTech, @Param("initWeek") LocalDateTime initWeek, @Param("endWeek") LocalDateTime endWeek);
}