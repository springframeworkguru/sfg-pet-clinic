package org.springframework.media;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.insurescan.quoteservice.household.model.Vehicle;
import com.insurescan.quoteservice.household.model.enums.VehicleImageAngle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
public class VehicleImage extends Media {

	@JsonIgnore
	@ManyToOne
	@RestResource(exported = false)
	@ToString.Exclude
	private Vehicle vehicle;

	@Enumerated(EnumType.STRING)
	private VehicleImageAngle vehicleImageAngle;
	
	private String session;

}
