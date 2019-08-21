// Generated by Dagger (https://google.github.io/dagger).
package org.sagebionetworks.research.motor_control_module.inject;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import org.sagebionetworks.research.presentation.model.interfaces.StepView;
import org.sagebionetworks.research.presentation.show_step.show_step_view_model_factories.ShowStepViewModelFactory;

public final class HandSelectionStepModule_ProvideHandSelectionStepVMFFactory
    implements Factory<ShowStepViewModelFactory<?, ? extends StepView>> {
  private static final HandSelectionStepModule_ProvideHandSelectionStepVMFFactory INSTANCE =
      new HandSelectionStepModule_ProvideHandSelectionStepVMFFactory();

  @Override
  public ShowStepViewModelFactory<?, ? extends StepView> get() {
    return proxyProvideHandSelectionStepVMF();
  }

  public static HandSelectionStepModule_ProvideHandSelectionStepVMFFactory create() {
    return INSTANCE;
  }

  public static ShowStepViewModelFactory<?, ? extends StepView> proxyProvideHandSelectionStepVMF() {
    return Preconditions.checkNotNull(
        HandSelectionStepModule.provideHandSelectionStepVMF(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
