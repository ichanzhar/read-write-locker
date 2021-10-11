package com.github.ichanzhar.rwlocker

import java.util.function.Supplier

class ReadWriteLocker<K> {

	private val lockFactory: IReadWriteLockFactory<K>

	init {
		lockFactory = ReadWriteLockFactory()
	}

	fun <R> write(key: K, supplier: Supplier<R>): R {
		lockFactory.getMutex(key).writeLock().lock()
		try {
			return supplier.get()
		} finally {
			lockFactory.getMutex(key).writeLock().unlock()
		}
	}

	fun <R> read(key: K, supplier: Supplier<R>): R {
		lockFactory.getMutex(key).readLock().lock()
		try {
			return supplier.get()
		} finally {
			lockFactory.getMutex(key).readLock().unlock()
		}
	}
}