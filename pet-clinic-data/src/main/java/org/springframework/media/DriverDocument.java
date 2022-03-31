package org.springframework.media;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.insurescan.quoteservice.household.model.Driver;
import com.insurescan.quoteservice.household.model.enums.DriverDocumentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class DriverDocument extends Media {

	@JsonIgnore
	@ManyToOne
	@RestResource(exported = false)
	private Driver driver;

	@Enumerated(EnumType.STRING)
	private DriverDocumentType documentType;

	protected String reference;

}
