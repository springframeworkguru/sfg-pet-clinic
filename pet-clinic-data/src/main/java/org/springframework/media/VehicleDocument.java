package org.springframework.media;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.insurescan.quoteservice.household.model.Address;
import com.insurescan.quoteservice.household.model.Vehicle;
import com.insurescan.quoteservice.household.model.enums.VehicleDocumentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class VehicleDocument extends Media {

	@JsonIgnore
	@ManyToOne
	@RestResource(exported = false)
	private Vehicle vehicle;

	@Enumerated(EnumType.STRING)
	private VehicleDocumentType documentType;

	protected LocalDate startDate;
	protected LocalDate endDate;
	protected Address address;

}
