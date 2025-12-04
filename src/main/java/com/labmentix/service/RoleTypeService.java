package com.labmentix.service;

import com.labmentix.entities.RoleType;
import com.labmentix.repository.RoleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleTypeService {

    @Autowired
    private RoleTypeRepository repository;

    public List<RoleType> getAllRoles(){

     return  repository.findAll();
    }
}
