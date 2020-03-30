package com.example.sciencehub.base

import androidx.compose.Model
import com.example.sciencehub.navigation.ScreenModel

@Model
class BaseFlowState {
    var viewState: BaseFlowViewState? = null
}

sealed class BaseFlowViewState {
    class Navigate(val screenModel: ScreenModel): BaseFlowViewState()
}

class BaseFlowModel {

    val state: BaseFlowState = BaseFlowState()
}