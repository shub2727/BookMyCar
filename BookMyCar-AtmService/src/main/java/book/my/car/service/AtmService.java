package book.my.car.service;

import book.my.car.request.AtmApiRequest;
import book.my.car.response.AtmApiResponse;

import java.util.List;

public interface AtmService {

	public AtmApiResponse makePayment(AtmApiRequest apiRequest);

	public List<AtmApiResponse> getByEmailId(String email);
	
}
