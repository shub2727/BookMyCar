package book.my.car.service.impl;


import book.my.car.request.Cars;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.my.car.entity.AtmDetails;
import book.my.car.repo.AtmRepository;
import book.my.car.request.AtmApiRequest;
import book.my.car.response.AtmApiResponse;
import book.my.car.service.AtmService;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AtmServiceImpl implements AtmService {

	@Autowired
	private AtmRepository atmRepository;



	@Override
	public AtmApiResponse makePayment(AtmApiRequest apiRequest) {

		AtmApiResponse aResponse = new AtmApiResponse();

		aResponse.setCarColor(apiRequest.getCarColor());
		aResponse.setCarCompany(apiRequest.getCarCompany());
		aResponse.setCardNo(apiRequest.getCardNo());
		aResponse.setCarImg(apiRequest.getCarImg());
		aResponse.setCarModel(apiRequest.getCarModel());
		aResponse.setCarType(apiRequest.getCarType());
		aResponse.setCharge(apiRequest.getCharge());
		aResponse.setCharges(apiRequest.getCharges());
		aResponse.setDays(apiRequest.getDays());
		aResponse.setDriverID(apiRequest.getDriverID());
		aResponse.setDriverImg(apiRequest.getDriverImg());
		aResponse.setDriverMobNo(apiRequest.getDriverMobNo());
		aResponse.setDriverName(apiRequest.getDriverName());
		aResponse.setDropDate(apiRequest.getDropDate());
		aResponse.setDropLocation(apiRequest.getDropLocation());
		aResponse.setEmail(apiRequest.getEmail());
		aResponse.setFinalCost(apiRequest.getFinalCost());
		aResponse.setFname(apiRequest.getFname());
		aResponse.setFuelType(apiRequest.getFuelType());
		aResponse.setHotel(apiRequest.getHotel());
		aResponse.setLname(apiRequest.getLname());
		aResponse.setManageParking(apiRequest.getManageParking());
		aResponse.setMembers(apiRequest.getMembers());
		aResponse.setPassangerCapacity(apiRequest.getPassangerCapacity());
		aResponse.setPickUpDate(apiRequest.getPickUpDate());
		aResponse.setPickUpTime(apiRequest.getPickUpTime());
		aResponse.setRoom(apiRequest.getRoom());
		aResponse.setStay(apiRequest.getStay());


		WebClient webClient = WebClient.create();
		webClient.patch().uri("http://localhost:8081/api/v1/cars/carNum/{id}",apiRequest.getCarModel()).exchange().block();
		webClient.patch().uri("http://localhost:8083/api/drivers/driName/{id}",apiRequest.getDriverMobNo()).exchange().block();

		AtmDetails atmDetails = new AtmDetails();
		BeanUtils.copyProperties(apiRequest, atmDetails);
		AtmDetails save = atmRepository.save(atmDetails);
		return aResponse;
	}

	@Override
	public List<AtmApiResponse> getByEmailId(String email) {

	List<AtmDetails> atmDetails =atmRepository.findByEmail(email);
		List<AtmApiResponse> atmApiResponse =new ArrayList<>();

	atmDetails.stream().forEach((atm)->{

		AtmApiResponse aResponse = new AtmApiResponse();
		BeanUtils.copyProperties(atm,aResponse);

		atmApiResponse.add(aResponse);

	});



		return atmApiResponse;

	}

}
