package com.github.ichanzhar.rwlocker

import org.springframework.util.ConcurrentReferenceHashMap
import java.util.concurrent.locks.ReentrantReadWriteLock


class ReadWriteLockFactory<K>: IReadWriteLockFactory<K> {
	val map = ConcurrentReferenceHashMap<K, ReentrantReadWriteLock>(16, ConcurrentReferenceHashMap.ReferenceType.WEAK)

	override fun getMutex(key: K): ReentrantReadWriteLock {
		return this.map.computeIfAbsent(key) { k: K -> ReentrantReadWriteLock() }
	}

}