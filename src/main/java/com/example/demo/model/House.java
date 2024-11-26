package com.example.demo.model;

import com.example.demo.validation.PositiveGuests;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @PositiveGuests
    private int maxCountOfGuests;

    @ElementCollection
    private List<String> conveniences = new ArrayList<>();

   public House() {
       super();
   }
   public House(RoomType roomType, int maxCountOfGuests) {
       this.roomType = roomType;
       this.maxCountOfGuests = maxCountOfGuests;
   }
   public Long getId() {
       return id;
   }
   public void setId(Long id) {
       this.id = id;
   }
   public RoomType getRoomType() {
       return roomType;
   }
   public void setRoomType(RoomType roomType) {
       this.roomType = roomType;
   }
   public int getMaxCountOfGuests() {
       return maxCountOfGuests;
   }
   public void setMaxCountOfGuests(int maxCountOfGuests) {
       this.maxCountOfGuests = maxCountOfGuests;
   }
   public List<String> getConveniences() {
       return conveniences;
   }
   public void setConveniences(List<String> conveniences) {
       this.conveniences = conveniences;
   }
}
