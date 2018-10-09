
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Shout extends DomainEntity {

	// Attributes

	private String	username;
	private String	text;
	private String	link;


	@NotBlank
	public String getUsername() {
		return this.username;
	}
	public void setUsername(final String username) {
		this.username = username;
	}

	@NotBlank
	public String getText() {
		return this.text;
	}
	public void setText(final String text) {
		this.text = text;
	}

	@NotBlank
	@URL
	public String getLink() {
		return this.link;
	}
	public void setLink(final String link) {
		this.link = link;
	}

}
