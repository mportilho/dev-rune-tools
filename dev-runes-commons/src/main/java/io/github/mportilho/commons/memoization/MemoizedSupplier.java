package io.github.mportilho.commons.memoization;

import java.util.Objects;
import java.util.function.Supplier;

public class MemoizedSupplier<T> implements Supplier<T> {

	private Supplier<T> delegate;
	private volatile boolean initialized;
	private T cache;

	public MemoizedSupplier(Supplier<T> delegate) {
		this.delegate = Objects.requireNonNull(delegate, "Supplier delegate must be provided");
	}

	@Override
	public T get() {
		if (!initialized) {
			synchronized (this) {
				if (!initialized) {
					T value = delegate.get();
					cache = value;
					initialized = true;
					delegate = null; // to GC
					return value;
				}
			}
		}
		return cache;
	}

}
