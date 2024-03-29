package space.eliseev.iplatform.clients;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import space.eliseev.iplatform.config.StockConfig;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestClient {
    private final RestTemplate template = new RestTemplate();
    private final StockConfig stockConfig;
    public List<String> printTestResults() {
        List<String> returnValue = new ArrayList<>();
        RequestEntity requestEntity = new RequestEntity(null, null);
        for (String url : stockConfig.getUrls()) {
            if (url != null && !url.equals("")) {
                ResponseEntity<String> result = template.exchange(url, HttpMethod.GET, requestEntity, String.class);
                returnValue.add(result.getBody());
            }
        }
        return returnValue;
    }
}
