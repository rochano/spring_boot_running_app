package com.rochano.runningapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rochano.runningapp.model.Track;
import com.rochano.runningapp.service.TrackServiceIf;

@RestController
@CrossOrigin(origins = "*")
public class TrackController {

	@Autowired
	private TrackServiceIf trackService;

	@RequestMapping(value = "getalltracks", method = RequestMethod.GET)
	public List<Track> getAllTracks() {
		return trackService.getAllTracks();
	}

	@RequestMapping(value = "addtrack", method = RequestMethod.POST)
	public void addTrack(@RequestBody Track track) {
		trackService.addTrack(track);
	}
}
