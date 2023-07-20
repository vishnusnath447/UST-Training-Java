package in.stackroute.service;

import in.stackroute.dto.Item;
import in.stackroute.dto.ItemCodeSearchDto;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class ItemServiceImpl implements ItemService {

    private RestTemplate restTemplate;

    private final String itemServiceUrl = "http://ITEM-SERVICE/api/v1/items/search-codes";

    public ItemServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<Item> getItemsByIds(List<String> codes) {
        final var dto = new ItemCodeSearchDto(codes);
//        HttpEntity<ItemCodeSearchDto> request = new HttpEntity<>(dto);
        final var response = restTemplate.postForEntity(itemServiceUrl,dto,Item[].class);
        return Stream.of(Objects.requireNonNull(response.getBody())).toList();
    }
}
