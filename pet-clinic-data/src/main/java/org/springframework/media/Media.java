package org.springframework.media;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.ContentLength;
import org.springframework.content.commons.annotations.MimeType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Media {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", updatable = false, nullable = false, length = 32)
	private String id;

	@JsonIgnore
	@RestResource(exported = false)
	@ContentId 
	private String contentId;
	
	@ContentLength
	private long contentLength;
	
	@MimeType
	private String mimeType; 
	
	@CreatedDate
	@Column(updatable = false)
	protected Instant createdDate = Instant.now();
	
	protected Double lat;
	
	protected Double lon;
	
}
