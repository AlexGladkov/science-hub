package base

import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers

actual val uiDispatcher: CoroutineContext
    get() = Dispatchers.Main

actual val defaultDispatcher: CoroutineContext
    get() = Dispatchers.Default