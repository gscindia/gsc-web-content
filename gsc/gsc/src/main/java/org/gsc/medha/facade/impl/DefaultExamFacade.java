package org.gsc.medha.facade.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.gsc.medha.dto.CandidateDto;
import org.gsc.medha.dto.ExamDto;
import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.Exam;
import org.gsc.medha.facade.ExamFacade;
import org.gsc.medha.page.form.CandidateForm;
import org.gsc.medha.page.form.ExamForm;
import org.gsc.medha.page.form.FilterForm;
import org.gsc.medha.repository.CandidateRepository;
import org.gsc.medha.service.CandidateService;
import org.gsc.medha.service.ExamService;
import org.gsc.populator.Populator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class DefaultExamFacade implements ExamFacade {

	@Resource(name = "examRevPopulator")
	Populator<ExamForm, Exam> examRevpopulator;
	@Resource(name = "examPopulator")
	Populator<Exam, ExamDto> examPopulator;
	@Resource(name = "candidateRevPopulator")
	Populator<CandidateForm, Candidate> candiRevPopulator;
	@Resource(name = "candidatePopulator")
	Populator<Candidate, CandidateDto> candidatePopulator;
	@Resource(name = "admitCardPopulator")
	Populator<Candidate, CandidateDto> admitCardPopulator;
	@Resource(name = "filterPopulator")
	Populator<FilterForm, Candidate> filterPopulator;
	@Autowired
	ExamService examService;
	@Autowired
	CandidateService candidateService;
	@Autowired
	CandidateRepository candidateRepository;

	@Override
	public ExamDto createExam(ExamForm form) {
		Exam exam = new Exam();
		ExamDto dto = new ExamDto();
		examRevpopulator.populate(form, exam);
		examService.save(exam);
		examPopulator.populate(exam, dto);
		return dto;
	}

	@Override
	public List<ExamDto> getAllExam() {
		List<ExamDto> target = new ArrayList<>();
		examPopulator.populateAll(examService.getAll(), target);
		return target;
	}

	@Override
	public CandidateDto addCandidate(CandidateForm source) {
		CandidateDto target = new CandidateDto();
		Candidate candidate = new Candidate();
		candiRevPopulator.populate(source, candidate);
		candidate = examService.registerCandidate(candidate);
		candidatePopulator.populate(candidate, target);

		return target;
	}

	@Override
	public List<CandidateDto> filterFormB(FilterForm form) {
		List<CandidateDto> candidates = new ArrayList<>();
		Candidate candidate = new Candidate();
		filterPopulator.populate(form, candidate);
		candidatePopulator.populateAll(examService.getFormB(candidate), candidates);
		return candidates;

	}

	@Override
	public List<CandidateDto> getAdmitCards(FilterForm form) {
		List<CandidateDto> candidates = new ArrayList<>();
		Candidate candidate = new Candidate();
		filterPopulator.populate(form, candidate);
		admitCardPopulator.populateAll(examService.getAdmitCards(candidate), candidates);
		return candidates;

	}

	@Override
	public ExamDto getActiveExam() {
		ExamDto dto = new ExamDto();
		Exam exam = examService.getActiveExam();
		if (exam != null)
			examPopulator.populate(exam, dto);
		return dto;
	}

	@Override
	public List<Candidate> readMarksFromFile(InputStream is) throws IOException {
		List<Candidate> dataRows = new ArrayList<>();
		try (InputStream inputStream = is) {
			Workbook workbook = WorkbookFactory.create(inputStream);

			for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				Sheet sheet = workbook.getSheetAt(sheetIndex);

				Iterator<Row> rowIterator = sheet.iterator();
				boolean firstRow = true;

				while (rowIterator.hasNext()) {

					if (firstRow) {
						rowIterator.next();
						firstRow = false;
						continue;
					}

					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();
					Candidate rowData = new Candidate();
					if (cellIterator.hasNext()) {
						int roll = Integer.parseInt(formatNumbers(row.getCell(0).toString()));
						int cls = Integer.parseInt(formatNumbers(row.getCell(1).toString()));
						int marks = Integer.parseInt(formatNumbers(row.getCell(2).toString()));
						Candidate studentDetails = candidateService.getStudent(roll, cls, examService.getActiveExam(),
								"ACTIVE");
						if (studentDetails == null) {
							rowData.setName("STUDENT NOT FOUND");

						} else {
							rowData.setName(studentDetails.getName().toUpperCase());
							rowData.setId(studentDetails.getId());
						}

						rowData.setRoll(roll);
						rowData.setSection(cls);
						rowData.setMarks(marks);
						rowData.setGender("");

					}
					dataRows.add(rowData);

				}

			}
		}
		return dataRows;
	}

	@Override
	public Map<Integer, Integer> saveMarksheet(List<Candidate> cand) {
		Map<Integer, Integer> idMarksMap = new HashMap<>();
		if (!CollectionUtils.isEmpty(cand)) {
			List<Candidate> tobeSaved = new ArrayList<Candidate>();
			List<Integer> listOfIds = new ArrayList<Integer>();
			cand.forEach(candidate -> {
				idMarksMap.put(candidate.getId(), candidate.getMarks());
				listOfIds.add(candidate.getId());
			});
			candidateService.getAllStudent(listOfIds).forEach(toBe -> {
				toBe.setMarks(idMarksMap.get(toBe.getId()));
				tobeSaved.add(toBe);

			});
			candidateRepository.saveAll(tobeSaved);
		}
		return idMarksMap;
	}

	public String formatNumbers(String str) {
		double number = Double.parseDouble(str);
		int intValue = (int) number; // Remove decimal places by converting to int
		return String.valueOf(intValue);
	}

}
