package project.yata.service;

import project.yata.dto.*;

import java.util.List;

public interface TravelService {
    TravelResponse saveTravel(Long accountId, TravelRequest travelRequest);

    TravelDto getTravel(Long accountId, Long travelId);

    List<TravelDto> getTravels(Long accountId, int pageSize, int pageNumber);

    TravelResponse updateTravel(Long accountId, TravelUpdateRequest travelUpdateRequest);

    TravelResponse deleteTravel(Long accountId, TravelDeleteRequest travelDeleteRequest);
}