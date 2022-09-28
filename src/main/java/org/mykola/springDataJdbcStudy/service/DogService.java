package org.mykola.springDataJdbcStudy.service;

import org.mykola.springDataJdbcStudy.model.Dog;
import org.mykola.springDataJdbcStudy.model.Owner;
import org.mykola.springDataJdbcStudy.repo.DogRepository;
import org.mykola.springDataJdbcStudy.repo.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service("dogService")
public class DogService {
    private static final Logger log= LoggerFactory.getLogger(DogService.class);

    private final DogRepository dogRepository;
    private final OwnerRepository ownerRepository;


    public DogService(DogRepository dogRepository, OwnerRepository ownerRepository) {
        this.dogRepository = dogRepository;
        this.ownerRepository = ownerRepository;
    }

    public void life(){
//        level1();
        level2();
//        level3();
    }

    private void level1() {
        String dogName="Шарик";
            log.info("Creating a new Dog:{}",dogName);
        Dog dog = new Dog(dogName);
        Dog dogCreated = dogRepository.save(dog);
            log.info("Created a new dog:{}", dog);
//        В логе параметр добавляем через запятую, в ексепшене тупо конкатим строку!
        Dog dogById = dogRepository.findById(dogCreated.getDogId())
                .orElseThrow(() -> new RuntimeException("dog not found, DogId: " + dogCreated.getDogId()));

            log.info("selected dog by id:{}", dogById);

        List<Dog> dogsByName = dogRepository.findByName(dogName);
            log.info("selected dog by Name:{}", dogsByName);

        Dog dog1 = dogRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("dog not found, id: " + 1));

        Dog dog1Renamed = new Dog(dog1.getDogId(),
                String.valueOf(System.currentTimeMillis()), dog1.getOwnerName());
        dogRepository.save(dog1Renamed);

        Dog dog1Selected = dogRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("dog not found, id: " + 1));

            log.info("dog #1 :{}", dog1Selected);
    }

    private void level2() {

        String ownerName  = String.format("Вася:%d", System.currentTimeMillis());
        Owner owner = new Owner(ownerName, "Васильки", Collections.emptySet(), true);
        ownerRepository.save(owner);

        Owner selectedOwner  = ownerRepository.findById(ownerName)
                .orElseThrow(() -> new RuntimeException("selected owner not found, name: " + ownerName));
        log.info("selectedOwner:{}", selectedOwner);

        Owner ownerReal = new Owner(ownerName, "London",
                Set.of(new Dog("Бобик", null),
                        new Dog("Wolf")),false);
        ownerRepository.save(ownerReal);

        Owner selectedOwnerReal = ownerRepository.findById(ownerName)
                .orElseThrow(() -> new RuntimeException("owner not found, name: " + ownerName));
        log.info("selectedOwnerReal:{}", selectedOwnerReal);
        log.info("selectedOwnerReal, dogs:{}", selectedOwnerReal.getDogs());

        ownerRepository.updateAddress(ownerName, "новый адрес");
        Owner selectedOwnerRealAddress = ownerRepository.findById(ownerName)
                .orElseThrow(() -> new RuntimeException("owner not found, name: " + ownerName));
        log.info("selectedOwnerRealAddress:{}", selectedOwnerRealAddress);
        log.info("selectedOwnerRealAddress, getAddress:{}", selectedOwnerRealAddress.getAddress());
                

    }

    private void level3() {

    }


}
