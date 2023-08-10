package org.gsc.api.endpoint;

import java.util.List;

import org.gsc.api.dto.VenueDto;
import org.gsc.medha.facade.VenueFacade;
import org.gsc.medha.page.form.VenueForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medha/venue")
public class VenueController {

	@Autowired
	VenueFacade venueFacade;

	@ResponseBody
	@GetMapping
	public List<VenueDto> getAllActive() {
		return venueFacade.getAllActiveVenue();
	}

	@PostMapping("/add")
	@ResponseBody
	public VenueDto addVenue(@RequestBody VenueForm form) {

		return venueFacade.save(form);
	}

}
