package goldie.ejercicio1.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import goldie.ejercicio1.enums.MetricType;
import goldie.ejercicio1.vo.MetricVO;

@SpringBootTest
public class MetricsServiceTest {
    @Autowired
	MetricsService metricsService;

	@Test
	void testGivenValidListWhenSortThenSortedList() throws Exception {
		List<MetricVO> unsortedMetrics = new ArrayList<>();
		unsortedMetrics.add(new MetricVO(5, MetricType.RESPONSE_TIME));
		unsortedMetrics.add(new MetricVO(8, MetricType.RESPONSE_TIME));
		unsortedMetrics.add(new MetricVO(3, MetricType.RESPONSE_TIME));

		List<MetricVO> expectedSortedMetrics = new ArrayList<>();
		expectedSortedMetrics.add(new MetricVO(3, MetricType.RESPONSE_TIME));
		expectedSortedMetrics.add(new MetricVO(5, MetricType.RESPONSE_TIME));
		expectedSortedMetrics.add(new MetricVO(8, MetricType.RESPONSE_TIME));
		
		List<MetricVO> actualSortedMetrics = metricsService.sortList(unsortedMetrics);
		
		assertEquals(expectedSortedMetrics, actualSortedMetrics);
	}
}
