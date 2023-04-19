package goldie.ejercicio1.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import goldie.ejercicio1.vo.MetricVO;

@Service
public class MetricsService {
    public List<MetricVO> sortList(List<MetricVO> unsortedMetrics) {
        return unsortedMetrics.stream()
                .sorted(Comparator.comparingDouble(MetricVO::getValue))
                .collect(Collectors.toList());
    }
}
