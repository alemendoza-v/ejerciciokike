package goldie.ejercicio1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import goldie.ejercicio1.service.MetricsService;
import goldie.ejercicio1.vo.MetricVO;

@RequestMapping("metrics")
@RestController
public class MetricsController {
    @Autowired
    MetricsService metricsService;
    
    @PostMapping("/sort")
    public ResponseEntity<List<MetricVO>> sortMetrics(@RequestBody List<MetricVO> metrics) {
        return new ResponseEntity<>(metricsService.sortList(metrics), HttpStatus.OK);
    }
}
