package com.handyman.ias.infrastructure.models;
import com.handyman.ias.application.domian.ReportServ;
import com.handyman.ias.application.domian.valueobjects.Dates;
import com.handyman.ias.application.domian.valueobjects.IdServ;
import com.handyman.ias.application.domian.valueobjects.IdTechnician;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REPORTE_SERVICIOS")
public class ReportServDAO {
   @Id
   @Column(name = "id", nullable = false)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REPORTES")
   @SequenceGenerator(name = "SEQ_REPORTES", sequenceName = "SEQ_REPORTES", allocationSize = 1)
   private Long id;

   @Column(name = "ID_SERVICE")
   private String idServ;

   @Column(name = "ID_TECHNICIAN")
   private String idTechnician;

   @Column(name = "INIT_DATE")
   private LocalDateTime initDate;

   @Column(name = "END_DATE")
   private LocalDateTime endDate;

   public ReportServ toDomain(){
      return new ReportServ(
              id,
              new IdServ(idServ),
              new IdTechnician(idTechnician),
              new Dates(initDate, endDate)
      );
   }

   public ReportServDAO fromDomain(ReportServ reportServ){
      return new ReportServDAO(
              reportServ.getId(),
              reportServ.getIdServ().getValue(),
              reportServ.getIdTechnician().getValue(),
              reportServ.getDates().getInitDate(),
              reportServ.getDates().getEndDate()
      );
   }
}
