package org.springframework.media;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.insurescan.quoteservice.household.model.VehicleMaintenanceRecord;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class MaintenanceEvidence extends Media {

	@JsonIgnore
	@ManyToOne
	@RestResource(exported = false)
	private VehicleMaintenanceRecord maintenanceRecord;

}
