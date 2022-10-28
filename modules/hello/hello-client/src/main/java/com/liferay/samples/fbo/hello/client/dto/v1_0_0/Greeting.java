package com.liferay.samples.fbo.hello.client.dto.v1_0_0;

import com.liferay.samples.fbo.hello.client.function.UnsafeSupplier;
import com.liferay.samples.fbo.hello.client.serdes.v1_0_0.GreetingSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Fabian-Liferay
 * @generated
 */
@Generated("")
public class Greeting implements Cloneable, Serializable {

	public static Greeting toDTO(String json) {
		return GreetingSerDes.toDTO(json);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessage(
		UnsafeSupplier<String, Exception> messageUnsafeSupplier) {

		try {
			message = messageUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String message;

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public void setPerson(
		UnsafeSupplier<String, Exception> personUnsafeSupplier) {

		try {
			person = personUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String person;

	@Override
	public Greeting clone() throws CloneNotSupportedException {
		return (Greeting)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Greeting)) {
			return false;
		}

		Greeting greeting = (Greeting)object;

		return Objects.equals(toString(), greeting.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return GreetingSerDes.toJSON(this);
	}

}