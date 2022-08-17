package com.handyman.ias.infrastructure.adapters.output;

import com.handyman.ias.application.ports.output.ReportRepository;
import com.handyman.ias.application.services.GetDatesOfWeek;
import com.handyman.ias.infrastructure.configurations.SpringJPARepository;
import com.handyman.ias.infrastructure.models.IMapper;
import com.handyman.ias.infrastructure.models.ReportServDAO;
import com.handyman.ias.infrastructure.models.ReportServDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JPARepository implements ReportRepository {
    private final SpringJPARepository springJPARepository;
    private final IMapper iMapper;

    public JPARepository(SpringJPARepository springJPARepository, IMapper iMapper) {
        this.springJPARepository = springJPARepository;
        this.iMapper = iMapper;
    }

    @Override
    public ReportServDTO save(ReportServDTO reportServDTO) {
        ReportServDAO reportServDAO = reportServDTO.ToDAO();
        reportServDAO.toDomain();
        return this.iMapper.DAOToDTO(springJPARepository.save(reportServDAO));
    }

    @Override
    public List<ReportServDTO> getHours(String idTech, int numWeek) {
        GetDatesOfWeek getDatesOfWeek = new GetDatesOfWeek();
        LocalDateTime initWeek = getDatesOfWeek.getDates(numWeek).getInitDate();
        LocalDateTime endWeek = getDatesOfWeek.getDates(numWeek).getEndDate();
        List<ReportServDAO> reportServDAOS = this.springJPARepository.findReportServBy(idTech, initWeek, endWeek);
        return this.iMapper.ListDAOtoListDTO(reportServDAOS);
    }
}
