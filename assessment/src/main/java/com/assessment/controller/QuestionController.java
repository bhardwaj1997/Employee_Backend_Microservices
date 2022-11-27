package com.assessment.controller;

import com.assessment.model.Answers;
import com.assessment.model.Questions;
import com.assessment.service.QuestionService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("quiz")
public class QuestionController {

  @Autowired private QuestionService questionService;

  @GetMapping("run")
  public String test() {
    return "Service is Up";
  }

  @PostMapping("/saveQuestion")
  public Questions saveQuestion(@RequestBody Questions question) {
    return questionService.saveQuestion(question);
  }

  @PostMapping(
      value = "/readExcel",
      consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public void readFile(@RequestPart(value = "file") MultipartFile fileT) {

    String pats =
        "C:\\Users\\KuldeepB\\Employee_Backend\\assessment\\src\\main\\resources\\test.xlsx";

    try {
      Workbook workbook = new XSSFWorkbook(fileT.getInputStream());
      DataFormatter dateFormatter = new DataFormatter();
      Iterator<Sheet> sheetIterator = workbook.sheetIterator();

      while (sheetIterator.hasNext()) {
        Sheet sh = sheetIterator.next();
        for(int row = 0 ; row < sh.getPhysicalNumberOfRows() ; row++){
          System.out.println("sh.getSheetName() = " + sh.getSheetName());
          System.out.println("------------------------------------------------------");
          Questions questions = new Questions();
          for(int col = 0 ; col < sh.getRow(row).getPhysicalNumberOfCells();col++){
            Cell cell = sh.getRow(row).getCell(col);

            questions.setQuestion(sh.getRow(row).getCell(0).toString());
            Answers answer = new Answers();
            answer.setAnswerId(10);
            answer.setFirstAnswer(sh.getRow(row).getCell(1).toString());
            answer.setSecondAnswer(sh.getRow(row).getCell(2).toString());
            answer.setThirdAnswer(sh.getRow(row).getCell(3).toString());
            answer.setFourthAnswer(sh.getRow(row).getCell(4).toString());
//            List<Answers> answer = new ArrayList<Answers>();
//            answer.add(answer);
            questions.setAnswer(answer);

        }
          System.out.println("cell = " + questions);
          System.out.println();
        }
        workbook.close();
      }
    } catch (Exception e) {
      System.out.println("e = " + e);
    }
  }
}
