package com.booksys.roomtype;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * REST Controller for Room Type management.
 */
@RestController
@RequestMapping("/api/booksys/roomtypes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RoomTypeController {

    private final RoomTypeService roomTypeService;

    @PostMapping("/save")
    public ResponseEntity<RoomType> save(@RequestBody RoomType roomType) {
        return ResponseEntity.ok(roomTypeService.create(roomType));
    }

    @GetMapping
    public ResponseEntity<List<RoomType>> getAll() {
        return ResponseEntity.ok(roomTypeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomType> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(roomTypeService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        roomTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}