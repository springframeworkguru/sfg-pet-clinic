package org.springframework.media;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.insurescan.quoteservice.household.model.PolicyQuestionAnswer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class QuestionEvidence extends Media {

	@JsonIgnore
	@ManyToOne
	private PolicyQuestionAnswer answer;

}
