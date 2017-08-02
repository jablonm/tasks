package pl.kurs.spring.validation.travels.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kurs.spring.validation.travels.config.model.Trip;

@Controller
@RequestMapping("/trips")
public class TripController {

	private List<Trip> trips;

	@PostConstruct
	public void init() {
		trips = new ArrayList<Trip>();
		trips.add(new Trip("Polska", "Sydney", toDate(2017, 6, 20), toDate(2017, 7, 2), "GORY", new BigDecimal("4500")));
	}

	private Date toDate(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		return cal.getTime();
	}

	@GetMapping("/")
	public String enter(ModelMap model) {
		model.addAttribute("tripForm", new Trip());
		model.addAttribute("trips", trips);
		return "trips";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute("tripForm") @Valid Trip trip, BindingResult validationResult, ModelMap model) {
		if (!validationResult.hasErrors()) {
			System.out.println(trip);
		}
		System.out.println("TRIP: " + trip);
		model.addAttribute("trips", trips);
		return "trips";
	}

	@InitBinder
	private void tripParameterBinders(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}

}
