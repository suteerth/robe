package io.robe.convert.csv;

import io.robe.convert.CSVPojo;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class CSVExporterTest {
    @Test
    public void testExportStream() throws Exception {

        CSVExporter exporter = new CSVExporter();
        ArrayList<CSVPojo> pojos = new ArrayList<CSVPojo>(3);
        pojos.add(new CSVPojo(1,"Seray","DDD",1,2, new BigDecimal("12.2"),new Date()));
        pojos.add(new CSVPojo(1,"Kaan","BBB",2,3, BigDecimal.ONE,new Date()));
        pojos.add(new CSVPojo(1,"Sinan","CCC",3,4, BigDecimal.ZERO,new Date()));

        exporter.exportStream(CSVPojo.class,System.out,pojos);

    }
}
