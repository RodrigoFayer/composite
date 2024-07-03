package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReportTest {
    @Test
    void shouldReturnReportData() {
        Number metaAdsNumber = new Number("Cost", 100);
        Number metaAdsConversion = new Number("Conversion", 0.5f);

        Source metaAds = new Source("Meta Ads");
        metaAds.addWidget(metaAdsNumber);
        metaAds.addWidget(metaAdsConversion);

        Number googleAdsNumber = new Number("Cost", 500);
        Number googleAdsConversion = new Number("Conversion", 0.75f);

        Source googleAds = new Source("Google Ads");
        googleAds.addWidget(googleAdsNumber);
        googleAds.addWidget(googleAdsConversion);

        Source reportData = new Source("Report Data");
        reportData.addWidget(metaAds);
        reportData.addWidget(googleAds);

        Report report = new Report();
        report.setWidget(reportData);

        String content = report.draw();
        assertEquals("------Report Data------\n" +
                "------Meta Ads------\n" +
                "Name: Cost,\n" +
                "Value: 100.0\n" +
                "Name: Conversion,\n" +
                "Value: 0.5\n" +
                "----End Meta Ads----\n" +
                "------Google Ads------\n" +
                "Name: Cost,\n" +
                "Value: 500.0\n" +
                "Name: Conversion,\n" +
                "Value: 0.75\n" +
                "----End Google Ads----\n" +
                "----End Report Data----", content);
    }

    @Test
    void shouldThrowExceptionWhenDrawAReportWithoutWidgets() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Report report = new Report();
            report.draw();
        });

        String expectedMessage = "Report without widgets";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}