package com.example.service;

import com.example.entity.TaxData;
import com.example.repository.TaxDataRepository;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class ExcelService {

	@Autowired
	private TaxDataRepository taxDataRepository;

	@Value("${excel.file.path}")
	private String filePath;

	@Transactional
	public void readExcel() throws IOException {

		try (Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath))) {
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				Sheet sheet = workbook.getSheetAt(i);

				boolean flag = true;

				for (Row row : sheet) {

					if (flag) {
						flag = false;
						continue;
					}

					boolean flag_0 = false;
					boolean flag_3 = false;
					boolean flag_7 = false;

					TaxData taxData = new TaxData();

					for (Cell cell : row) {
						int columnIndex = cell.getColumnIndex();

						if (0 == columnIndex) {
							flag_0 = true;
							taxData.setJurisdiction(cell.getStringCellValue()
									.trim());
						} else if (3 == columnIndex) {
							flag_3 = true;
							taxData.setItemGroupCode(cell.getStringCellValue()
									.trim());
						} else if (7 == columnIndex) {
							flag_7 = true;
							taxData.setTaxRateCode(String.valueOf(Double.valueOf(cell.getNumericCellValue())
									.intValue()));
						}

						if (flag_0 && flag_3 && flag_7) {
							break;
						}
					}

					taxDataRepository.save(taxData);
				}

			}
		}

	}
}
