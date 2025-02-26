package com.hotel.controller.impl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.constants.BedType;
import com.hotel.constants.RoomType;
import com.hotel.controller.IRoomController;
import com.hotel.dto.DtoRoom;
import com.hotel.service.IRoomService;

@RestController
@RequestMapping("/rest/api/room")
public class RoomControllerImpl implements IRoomController{

    @Autowired
    private IRoomService roomService;

    @GetMapping("/list")
    public ResponseEntity<List<DtoRoom>> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoRoom> getRoomById(@PathVariable String id) {
        return roomService.getRoomById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<DtoRoom> createRoom(@RequestBody DtoRoom newRoom) {
        return roomService.createRoom(newRoom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DtoRoom> updateRoom(@PathVariable String id, @RequestBody DtoRoom updatedRoom) {
        return roomService.updateRoom(id, updatedRoom);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable String id) {
        return roomService.deleteRoom(id);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<DtoRoom>> getAvailableRooms(
            @RequestParam(required = false) RoomType roomType,
            @RequestParam(required = false) String bedType,
            @RequestParam(required = false) Boolean hasView,
            @RequestParam LocalDate checkInDate,
            @RequestParam LocalDate checkOutDate) {

        return roomService.findAvailableRooms(roomType, bedType, hasView, checkInDate, checkOutDate);
    }

    @GetMapping("/room-types")
    public ResponseEntity<List<String>> getRoomTypes() {
        List<String> roomTypes = Arrays.stream(RoomType.values())
                                    .map(Enum::name)
                                    .collect(Collectors.toList());
        return ResponseEntity.ok(roomTypes);
    }

    @GetMapping("/bed-types")
    public ResponseEntity<List<String>> getBedTypes() {
        List<String> bedTypes = Arrays.stream(BedType.values())
                                    .map(Enum::name)
                                    .collect(Collectors.toList());
        return ResponseEntity.ok(bedTypes);
    }
}