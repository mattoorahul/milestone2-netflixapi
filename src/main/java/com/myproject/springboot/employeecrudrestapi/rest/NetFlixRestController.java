package com.myproject.springboot.employeecrudrestapi.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.springboot.employeecrudrestapi.entity.Data;
import com.myproject.springboot.employeecrudrestapi.service.NetflixService;

@RestController
@RequestMapping("/v1")
public class NetFlixRestController {

	private NetflixService netflixService;

	@Autowired
	public NetFlixRestController(NetflixService theNextFlixService) {
		netflixService = theNextFlixService;
	}

	// expose "/employees" and return list of employees
	@GetMapping("/tvshows")
	public List<Data> findAll(@RequestParam(required = true) Map<String, String> qparams) {
		if (qparams.containsKey("count")) {
			String count = qparams.get("count");
			return netflixService.find(Integer.parseInt(count));

		} else if (qparams.containsKey("movieType")) {
			String movieType = qparams.get("movieType");
			return netflixService.findBymovieType(movieType);

		} else if (qparams.containsKey("country")) {
			String country = qparams.get("country");
			return netflixService.findBycountry(country);

		} else if (qparams.containsKey("startDate") && qparams.containsKey("endDate")) {
			String startDate = qparams.get("startDate");
			String endDate = qparams.get("endDate");
			return netflixService.findByDate(startDate, endDate);

		}
		return netflixService.findAll();
	}

}
