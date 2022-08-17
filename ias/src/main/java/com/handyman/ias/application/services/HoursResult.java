package com.handyman.ias.application.services;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HoursResult {
    private String idTech;
    private String normalHours;
    private String nocturneHours;
    private String sundayHours;
    private String extraNormalHours;
    private String extraNocturneHours;
    private String extraSundayHours;
}
