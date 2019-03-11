package com.windwagon.logres.triggers;

import org.springframework.scheduling.*;

import java.util.*;
import java.util.concurrent.*;

public class FakeScheduler implements TaskScheduler {

	private static class NoFuture implements ScheduledFuture<Void> {

		@Override
		public long getDelay( TimeUnit unit ) {
			return Long.MAX_VALUE;
		}

		@Override
		public int compareTo( Delayed object ) {
			return Long.compare(
					getDelay( TimeUnit.MILLISECONDS ),
					object.getDelay( TimeUnit.MILLISECONDS ) );
		}

		@Override
		public boolean cancel( boolean mayInterruptIfRunning ) {
			return true;
		}

		@Override
		public Void get() {
			return null;
		}

		@Override
		public Void get( long timeout, TimeUnit unit ) {
			return null;
		}

		@Override
		public boolean isCancelled() {
			return false;
		}

		@Override
		public boolean isDone() {
			return false;
		}

	}

	@Override
	public ScheduledFuture<?> schedule( Runnable Task, Date startTime ) {
		return new NoFuture();
	}

	@Override
	public ScheduledFuture<?> schedule( Runnable Task, Trigger trigger ) {
		return new NoFuture();
	}

	@Override
	public ScheduledFuture<?> scheduleAtFixedRate( Runnable Task, Date startTime, long periode ) {
		return new NoFuture();
	}

	@Override
	public ScheduledFuture<?> scheduleAtFixedRate( Runnable Task, long periode ) {
		return new NoFuture();
	}

	@Override
	public ScheduledFuture<?> scheduleWithFixedDelay(
			Runnable Task,
			Date startTime,
			long periode ) {
		return new NoFuture();
	}

	@Override
	public ScheduledFuture<?> scheduleWithFixedDelay( Runnable Task, long periode ) {
		return new NoFuture();
	}

}
