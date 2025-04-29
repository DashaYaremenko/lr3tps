package org.example.lr3tps.controller;

import org.example.lr3tps.dbModel.StationClass;
import org.example.lr3tps.repository.StationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/stations")
@CrossOrigin
public class DataController {
    private final StationRepository stationRepository;
    public DataController(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @GetMapping
    public String listStations(Model model) {
        model.addAttribute("stations", stationRepository.findAll());
        return "stations";
    }

    @PostMapping("/add")
    public String addStation(@RequestParam String nameStation) {
        stationRepository.save(new StationClass(nameStation));
        return "redirect:/stations";
    }

    @PostMapping("/update")
    public String updateStation(@RequestParam int id, @RequestParam String nameStation) {
        Optional<StationClass> optionalStation = stationRepository.findById(id);
        if (optionalStation.isPresent()) {
            StationClass station = optionalStation.get();
            station.setNameStation(nameStation);
            stationRepository.save(station);
        }
        return "redirect:/stations";
    }

    @PostMapping("/delete/{id}")
    public String deleteStation(@PathVariable int id) {
        stationRepository.deleteById(id);
        return "redirect:/stations";
    }
}
