package org.gsc.medha.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SchoolLeaderBoardDto {
    List<String> school = new ArrayList<>();
    List<Long> application = new ArrayList<>();
}
