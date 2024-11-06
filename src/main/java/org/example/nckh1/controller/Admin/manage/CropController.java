package org.example.nckh1.controller.Admin.manage;

import org.example.nckh1.Service.CropService;
import org.example.nckh1.model.Crop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/crops")
public class CropController {
    @Autowired
    private CropService cropService;
    @GetMapping
    public List<Crop> getAllCrops() {
        return cropService.findAllCrops();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Crop> getCropById(@PathVariable("id") long id) {
        Optional<Crop> crop = cropService.findCropById(id);
        return crop.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Crop> createCrop(@RequestBody Crop crop) {
        Crop savedCrop = cropService.saveCrop(crop);
        return new ResponseEntity<>(savedCrop, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrop(@PathVariable("id") long id) {
        if (cropService.findCropById(id).isPresent()) {
            cropService.deleteCrop(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
