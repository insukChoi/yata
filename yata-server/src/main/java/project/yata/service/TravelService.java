package project.yata.service;

import project.yata.dto.TravelDeleteRequest;
import project.yata.dto.TravelRequest;
import project.yata.dto.TravelResponse;
import project.yata.dto.TravelUpdateRequest;
import project.yata.entity.Account;
import project.yata.entity.Travel;

import java.util.List;

public interface TravelService {

    TravelResponse saveTravel(Long accountId, TravelRequest travelRequest);

    TravelResponse getTravel(Long accountId, Long travelId);

    List<TravelResponse> getTravelList(Long accountId, int offset, int count);

    TravelResponse updateTravel(Long accountId, TravelUpdateRequest travelUpdateRequest);

    TravelResponse deleteTravel(Long accountId, TravelDeleteRequest travelDeleteRequest);
}