package com.application.sync.core.common.annotations

import com.application.sync.core.common.model.AppDispatchers
import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class AppDispatcher(val appDispatcher: AppDispatchers)