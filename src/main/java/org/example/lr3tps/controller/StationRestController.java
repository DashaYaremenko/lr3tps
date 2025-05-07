package org.example.lr3tps.controller;

import org.example.lr3tps.dbModel.StationClass;
import org.example.lr3tps.repository.StationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stations")
@CrossOrigin(origins = "http://localhost:8081")
public class StationRestController {

    private final StationRepository stationRepository;

    public StationRestController(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @GetMapping
    public List<StationClass> getAllStations() {
        return stationRepository.findAll();
    }

    @PostMapping
    public StationClass addStation(@RequestBody StationClass station) {
        return stationRepository.save(station);
    }

    @DeleteMapping("/{id}")
    public void deleteStation(@PathVariable int id) {
        stationRepository.deleteById(id);
    }
}