package com.crud.tasks.trello.client;

import com.crud.tasks.config.TrelloConfig;
import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TrelloClientTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private TrelloConfig trelloConfig;

    @InjectMocks
    private TrelloClient trelloClient;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCreateCard() throws URISyntaxException {
        // Given
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn("https://api.trello.com/1");
        when(trelloConfig.getTrelloAppKey()).thenReturn("app_key");
        when(trelloConfig.getTrelloToken()).thenReturn("token");

        String expectedId = "testId";
        String expectedName = "Test Card";
        String expectedShortUrl = "https://trello.com/test";

        URI expectedUrl = new URI("https://api.trello.com/1/cards?key=app_key&token=token&name=Test%20Card&desc=Test%20Description&pos=top&idList=testListId");

        when(restTemplate.postForObject(expectedUrl, null, CreatedTrelloCard.class))
                .thenReturn(new CreatedTrelloCard(expectedId, expectedName, expectedShortUrl));

        TrelloCardDto trelloCardDto = new TrelloCardDto("Test Card", "Test Description", "top", "testListId");

        // When
        CreatedTrelloCard createdTrelloCard = trelloClient.createNewCard(trelloCardDto);

        // Then
        assertEquals(expectedId, createdTrelloCard.getId());
        assertEquals(expectedName, createdTrelloCard.getName());
        assertEquals(expectedShortUrl, createdTrelloCard.getShortUrl());
    }

    @Test
    public void shouldFetchTrelloBoards() throws URISyntaxException {
        // Given
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn("https://api.trello.com/1");
        when(trelloConfig.getTrelloAppKey()).thenReturn("app_key");
        when(trelloConfig.getTrelloToken()).thenReturn("token");
        when(trelloConfig.getTrelloUser()).thenReturn("testUser");

        URI expectedUrl = new URI("https://api.trello.com/1/members/testUser/boards?key=app_key&token=token&fields=name,id&lists=all");

        when(restTemplate.getForObject(expectedUrl, TrelloBoardDto[].class)).thenReturn(null);

        // When
        List<TrelloBoardDto> fetchedBoards = trelloClient.getTrelloBoards();

        // Then
        assertEquals(Collections.emptyList(), fetchedBoards);
    }
}
