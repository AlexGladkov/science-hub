package base

import kotlin.coroutines.CoroutineContext

actual val uiDispatcher: CoroutineContext
    get() = IosMainDispatcher

// TODO: Use background Dispatcher when K/N Coroutines implementation can support it.
// See https://github.com/Kotlin/kotlinx.coroutines/issues/462
actual val defaultDispatcher: CoroutineContext
    get() = IosMainDispatcher