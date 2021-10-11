package com.github.ichanzhar.rwlocker

import java.util.function.Supplier

class ReadWriteLocker<K> {

	private val lockFactory: IReadWriteLockFactory<K>

	init {
		lockFactory = ReadWriteLockFactory()
	}

	fun <R> write(key: K, supplier: Supplier<R>): R {
		lockFactory.getLock(key).writeLock().lock()
		try {
			return supplier.get()
		} finally {
			lockFactory.getLock(key).writeLock().unlock()
		}
	}

	fun <R> read(key: K, supplier: Supplier<R>): R {
		lockFactory.getLock(key).readLock().lock()
		try {
			return supplier.get()
		} finally {
			lockFactory.getLock(key).readLock().unlock()
		}
	}
}