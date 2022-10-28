package com.liferay.samples.fbo.hello.client.function;

import javax.annotation.Generated;

/**
 * @author Fabian-Liferay
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}