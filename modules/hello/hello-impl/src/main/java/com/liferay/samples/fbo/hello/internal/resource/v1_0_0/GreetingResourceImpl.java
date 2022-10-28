package com.liferay.samples.fbo.hello.internal.resource.v1_0_0;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.samples.fbo.hello.dto.v1_0_0.Greeting;
import com.liferay.samples.fbo.hello.resource.v1_0_0.GreetingResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.ServerErrorException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Fabian-Liferay
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0_0/greeting.properties",
	scope = ServiceScope.PROTOTYPE, service = GreetingResource.class
)
public class GreetingResourceImpl extends BaseGreetingResourceImpl {

	private final static String LADY_GAGA = "Lady Gaga";

	private final static String JAMES_BOND = "James Bond";

	private final static String WALLY = "Wally";

	private final static String THE_INVISIBLE_MAN = "The invisible man";

	private final static String OOPS = "oops";
	
	@Override
	public void setContextBatchUnsafeConsumer(
			UnsafeBiConsumer<Collection<Greeting>, UnsafeConsumer<Greeting, Exception>, Exception> contextBatchUnsafeConsumer) {
		this.contextBatchUnsafeConsumer = contextBatchUnsafeConsumer;
	}

	protected UnsafeBiConsumer
	<java.util.Collection<Greeting>, UnsafeConsumer<Greeting, Exception>, Exception> contextBatchUnsafeConsumer;
	
	@Override
	public Page<Greeting> getGreetPage(@NotNull String person) throws Exception {

		if(StringPool.BLANK.equals(person)) {
			throw new ClientErrorException("You have to greet someone", 400);
		} else if(LADY_GAGA.equals(person)) {
			throw new ClientErrorException("You have to pay to meet that person", 402);
		} else if(JAMES_BOND.equals(person)) {
			throw new ClientErrorException("You are not allowed to greet that person", 403);
		} else if(WALLY.equals(person)) {
			throw new ClientErrorException("We have not found Wally", 404);
		} else if(THE_INVISIBLE_MAN.equals(person)) {
			throw new ClientErrorException("He's gone", 410);
		} else if(person.length() > 20) {
			throw new ClientErrorException("That's too long a name", 413);
		} else if(OOPS.equals(person)) {
			throw new ServerErrorException("Oh no!", 500);
		}
		
		List<Greeting> greetings = new ArrayList<>();

		Greeting greeting = new Greeting();
		greeting.setMessage("Hello " + person);
		greeting.setPerson(person);
		
		greetings.add(greeting);
		
		return Page.of(greetings);
	}

}