package com.github.ichanzhar.rwlocker

import java.util.concurrent.locks.ReentrantReadWriteLock

interface IReadWriteLockFactory<K> {
	fun getMutex(key: K): ReentrantReadWriteLock
}