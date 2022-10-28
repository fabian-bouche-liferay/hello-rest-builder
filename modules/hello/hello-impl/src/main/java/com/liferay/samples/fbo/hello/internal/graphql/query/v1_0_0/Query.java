package com.liferay.samples.fbo.hello.internal.graphql.query.v1_0_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.samples.fbo.hello.dto.v1_0_0.Greeting;
import com.liferay.samples.fbo.hello.resource.v1_0_0.GreetingResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Fabian-Liferay
 * @generated
 */
@Generated("")
public class Query {

	public static void setGreetingResourceComponentServiceObjects(
		ComponentServiceObjects<GreetingResource>
			greetingResourceComponentServiceObjects) {

		_greetingResourceComponentServiceObjects =
			greetingResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {greet(person: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Pass the name of the person to greet")
	public GreetingPage greet(@GraphQLName("person") String person)
		throws Exception {

		return _applyComponentServiceObjects(
			_greetingResourceComponentServiceObjects,
			this::_populateResourceContext,
			greetingResource -> new GreetingPage(
				greetingResource.getGreetPage(person)));
	}

	@GraphQLName("GreetingPage")
	public class GreetingPage {

		public GreetingPage(Page greetingPage) {
			actions = greetingPage.getActions();

			items = greetingPage.getItems();
			lastPage = greetingPage.getLastPage();
			page = greetingPage.getPage();
			pageSize = greetingPage.getPageSize();
			totalCount = greetingPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Greeting> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(GreetingResource greetingResource)
		throws Exception {

		greetingResource.setContextAcceptLanguage(_acceptLanguage);
		greetingResource.setContextCompany(_company);
		greetingResource.setContextHttpServletRequest(_httpServletRequest);
		greetingResource.setContextHttpServletResponse(_httpServletResponse);
		greetingResource.setContextUriInfo(_uriInfo);
		greetingResource.setContextUser(_user);
		greetingResource.setGroupLocalService(_groupLocalService);
		greetingResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<GreetingResource>
		_greetingResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}