/*
 * BSD 3-Clause License
 *
 * Copyright 2019  Sage Bionetworks. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1.  Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * 2.  Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * 3.  Neither the name of the copyright holder(s) nor the names of any contributors
 * may be used to endorse or promote products derived from this software without
 * specific prior written permission. No license is granted to the trademarks of
 * the copyright holders even if such marks are included in this software.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sagebionetworks.research.modules.psorcast.step.plaque_body_map

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import org.sagebionetworks.research.modules.psorcast.result.PlaqueDrawingResult
import org.sagebionetworks.research.presentation.model.action.ActionType
import org.sagebionetworks.research.presentation.perform_task.PerformTaskViewModel
import org.sagebionetworks.research.presentation.show_step.show_step_view_model_factories.ShowStepViewModelFactory
import org.sagebionetworks.research.presentation.show_step.show_step_view_models.ShowStepViewModel
import org.sagebionetworks.research.presentation.show_step.show_step_view_models.ShowUIStepViewModel
import org.threeten.bp.ZonedDateTime



class ShowPlaqueBodyMapStepViewModel(performTaskViewModel: PerformTaskViewModel,
        plaqueBodyMapStepView: PlaqueBodyMapStepView) :
        ShowUIStepViewModel<PlaqueBodyMapStepView>(performTaskViewModel, plaqueBodyMapStepView) {

    val pdResultBuilder : PlaqueDrawingResult.Builder
    var front : MutableLiveData<Boolean> = MutableLiveData()

    init {
        front.value = true

        val zonedStart = ZonedDateTime.now()
        pdResultBuilder = PlaqueDrawingResult.builder()
                .setStartTime(zonedStart.toInstant())
                .setIdentifier(stepView.identifier)
    }

    override fun handleAction(actionType: String) {
        // if next clicked, addStepResult()
        if (actionType == ActionType.FORWARD) {
            this.performTaskViewModel.addStepResult(pdResultBuilder.build())
        }
        super.handleAction(actionType)
    }

    fun  isFront() : LiveData<Boolean> {
        return this.front
    }

//    fun printPathResults() {
//        var result = pdResultBuilder.build()
//        for (frontPath in result.frontPaths) {
//            Log.e("Front", frontPath.toString())
//        }
//        for (backPath in result.backPaths) {
//            Log.e("Back", backPath.toString())
//        }
//    }
}

class ShowPlaqueBodyStepViewModelFactory :
        ShowStepViewModelFactory<ShowPlaqueBodyMapStepViewModel, PlaqueBodyMapStepView> {


    override fun create(performTaskViewModel: PerformTaskViewModel,
            stepView: PlaqueBodyMapStepView): ShowPlaqueBodyMapStepViewModel {
        return ShowPlaqueBodyMapStepViewModel(performTaskViewModel, stepView)
    }

    override fun getViewModelClass(): Class<out ShowStepViewModel<*>> {
        return ShowPlaqueBodyMapStepViewModel::class.java
    }
}