package org.example.nckh1.Service;

import org.example.nckh1.Repository.CropRepository;
import org.example.nckh1.model.Crop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    public List<Crop> findAllCrops() {
        return cropRepository.findAll();
    }

    public Optional<Crop> findCropById(long cropId) {
        return cropRepository.findById(cropId);
    }

    @Transactional
    public Crop saveCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    @Transactional
    public void deleteCrop(long cropId) {
        cropRepository.deleteById(cropId);
    }
}
