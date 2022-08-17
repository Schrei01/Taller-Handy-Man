package com.handyman.ias.infrastructure.models;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapper {
    ReportServDTO DAOToDTO (ReportServDAO reportServDAO);
    List<ReportServDTO> ListDAOtoListDTO (List<ReportServDAO> reportServDAOS);
}
