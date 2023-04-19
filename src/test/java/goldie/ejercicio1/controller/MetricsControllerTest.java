package goldie.ejercicio1.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import goldie.ejercicio1.Controller.MetricsController;
import goldie.ejercicio1.enums.MetricType;
import goldie.ejercicio1.service.MetricsService;
import goldie.ejercicio1.vo.MetricVO;

@WebMvcTest(MetricsController.class)
public class MetricsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

	@MockBean
	MetricsService metricsService;
    
    @Test
	void testGivenValidListWhenSortThenSortedList() throws JsonProcessingException, Exception {
		List<MetricVO> unsortedMetrics = new ArrayList<>();
		unsortedMetrics.add(new MetricVO(5, MetricType.RESPONSE_TIME));
		unsortedMetrics.add(new MetricVO(8, MetricType.RESPONSE_TIME));
		unsortedMetrics.add(new MetricVO(3, MetricType.RESPONSE_TIME));

		List<MetricVO> expectedSortedMetrics = new ArrayList<>();
		expectedSortedMetrics.add(new MetricVO(3, MetricType.RESPONSE_TIME));
		expectedSortedMetrics.add(new MetricVO(5, MetricType.RESPONSE_TIME));
		expectedSortedMetrics.add(new MetricVO(8, MetricType.RESPONSE_TIME));

		when(metricsService.sortList(anyList())).thenReturn(expectedSortedMetrics);

		mockMvc.perform(MockMvcRequestBuilders.post("/metrics/sort")
				.content(mapper.writeValueAsString(unsortedMetrics)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
				    .andExpect(MockMvcResultMatchers.content()
						.json(mapper.writeValueAsString(expectedSortedMetrics)));
	}
}
