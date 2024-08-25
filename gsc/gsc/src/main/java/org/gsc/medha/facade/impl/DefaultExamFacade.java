package org.gsc.medha.facade.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.gsc.medha.dto.CandidateDto;
import org.gsc.medha.dto.ExamDto;
import org.gsc.medha.entity.Candidate;
import org.gsc.medha.entity.Exam;
import org.gsc.medha.facade.ExamFacade;
import org.gsc.medha.facade.SchoolFacade;
import org.gsc.medha.page.form.CandidateForm;
import org.gsc.medha.page.form.ExamForm;
import org.gsc.medha.page.form.FilterForm;
import org.gsc.medha.repository.CandidateRepository;
import org.gsc.medha.service.CandidateService;
import org.gsc.medha.service.ExamService;
import org.gsc.populator.Populator;
import org.gsc.utility.GscUtils;
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
	@Autowired
	SchoolFacade schoolFacade;

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
		if (examService.getActiveExam() != null) {
			Candidate candidate = new Candidate();
			candiRevPopulator.populate(source, candidate);
			candidate = examService.registerCandidate(candidate);
			candidatePopulator.populate(candidate, target);
		} else {
			target.setRoll("-1");
		}
		return target;
	}

	@Override
	public List<CandidateDto> addCandidates(List<CandidateForm> sourceList) {
		List<CandidateDto> result = new ArrayList<CandidateDto>();
		result = sourceList.stream().map(item -> addCandidate(item)).toList();
		return result;
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
	public List<CandidateForm> readBulkEnrollmentFile(InputStream is) throws IOException {
		List<CandidateForm> finalData = new ArrayList<>();

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
					CandidateForm rowData = new CandidateForm();
					if (cellIterator.hasNext()) {
						String name = row.getCell(0).toString();
						String gender = row.getCell(1).toString();
						String cls = formatNumbers(row.getCell(2).toString());
						String contactNumber = row.getCell(3) == null ? null : String.format("%.0f",row.getCell(3).getNumericCellValue());
						if (Objects.isNull(name) || Objects.isNull(gender) || Objects.isNull(cls)) {
							rowData = null;
						} else {
							rowData.setName(name.toUpperCase());
							rowData.setGender(gender.toUpperCase());
							rowData.setCls(cls);
							rowData.setMobile(contactNumber);
						}

					}
					if (Objects.nonNull(rowData))
						finalData.add(rowData);

				}

			}
		}

		return finalData;
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
						Candidate studentDetails = candidateService.getStudent(roll, cls, examService.getPostExam(),
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

	@Override
	public ByteArrayOutputStream preFillData(FilterForm form) throws IOException {

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Sheet1");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Roll");
		headerRow.createCell(1).setCellValue("Class");
		headerRow.createCell(2).setCellValue("Marks");
		List<CandidateDto> candidateList = schoolFacade.filteFormA(form);
		for (int row = 0; row < candidateList.size(); row++) {
			Row dataRow = sheet.createRow(row + 1);
			dataRow.createCell(0).setCellValue(candidateList.get(row).getRoll());
			dataRow.createCell(1).setCellValue(GscUtils.romanToInteger(candidateList.get(row).getCls()));
			dataRow.createCell(2).setCellValue("");
		}

		// Convert workbook to byte array
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		workbook.write(outputStream);
		workbook.close();
		return outputStream;
	}

	public String formatNumbers(String str) {
		if(StringUtils.isNoneEmpty(str)) {
			double number = Double.parseDouble(str);
			int intValue = (int) number; 
			return String.valueOf(intValue);
		}
		else {
			return null;
		}
		
	}

}
