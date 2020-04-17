package com.codeblizz.developer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
//import org.springframework.data.mongodb.core.index.IndexDirection;
//import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection="vehicle_store")
@CompoundIndex(def="{'objectId':1, 'make':1, 'model':-1, 'stats':1, 'vin':1, 'color':1, 'description':-1, 'price':-1,"
		+ "'discount':1, 'lastChecked':-1, 'torque':1, 'manufacturingYear':1}", name="vehicle_index")

/**@CompoundIndexes({
	  @CompoundIndex(def = "{'make':1, 'model':-1, 'stats':1, 'vin':1, 'color':1, 'description':-1, 'price':-1}", name = "compound_index_1"),
	  @CompoundIndex(def = "{'discount':1, 'lastChecked':-1, 'torque':1, 'manufacturingYear':1}", name = "compound_index_2")
	})**/

public class Vehicles {
	
	@Id
	private String objectId;
	//@Indexed(direction=IndexDirection.ASCENDING)
	private String make;
	private String model;
	private String stats;
	private String vin;
	private String color;
	private String description;
	private double price;
	private double discount;
	private String lastChecked;
	private String torque;
	private String manufacturingYear;

}
