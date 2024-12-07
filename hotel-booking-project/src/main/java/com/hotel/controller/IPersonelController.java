package com.hotel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hotel.dto.DtoResponse;
import com.hotel.dto.user.DtoPersonel;
import com.hotel.dto.user.DtoPersonelIU;

public interface IPersonelController {

    public ResponseEntity<DtoPersonel> registerPersonel(DtoPersonelIU personel);

    public ResponseEntity<DtoResponse> loginPersonel(String email, String password);

    public ResponseEntity<List<DtoPersonel>> getAllPersonel();

    public ResponseEntity<DtoPersonel> getPersonelById(Long id);

    public ResponseEntity<DtoPersonel> updatePersonel(Long id, DtoPersonelIU updatedPersonel);

    public ResponseEntity<String> deletePersonel(String email);

    public ResponseEntity<String> changePassword(Long id, String oldPassword, String newPassword);

    public ResponseEntity<List<String>> getRoles();

}
