package book.my.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import book.my.car.request.AtmApiRequest;
import book.my.car.response.AtmApiResponse;
import book.my.car.service.AtmService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/atms")
public class AtmServiceController {

	@Autowired
	private AtmService atmService;
	
	@PostMapping("/makePayment")
	public ResponseEntity<AtmApiResponse> makePayment(@RequestBody AtmApiRequest apiRequest){
		
		AtmApiResponse makePayment = atmService.makePayment(apiRequest);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(makePayment);
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<AtmApiResponse>> myBooking(@PathVariable String id){

		List<AtmApiResponse> makePayment = atmService.getByEmailId(id);

		return ResponseEntity.status(HttpStatus.CREATED).body(makePayment);
	}
}
