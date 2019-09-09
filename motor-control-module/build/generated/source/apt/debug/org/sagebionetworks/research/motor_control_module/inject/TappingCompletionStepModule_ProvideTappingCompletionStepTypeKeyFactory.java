// Generated by Dagger (https://google.github.io/dagger).
package org.sagebionetworks.research.motor_control_module.inject;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class TappingCompletionStepModule_ProvideTappingCompletionStepTypeKeyFactory
    implements Factory<String> {
  private static final TappingCompletionStepModule_ProvideTappingCompletionStepTypeKeyFactory
      INSTANCE = new TappingCompletionStepModule_ProvideTappingCompletionStepTypeKeyFactory();

  @Override
  public String get() {
    return proxyProvideTappingCompletionStepTypeKey();
  }

  public static TappingCompletionStepModule_ProvideTappingCompletionStepTypeKeyFactory create() {
    return INSTANCE;
  }

  public static String proxyProvideTappingCompletionStepTypeKey() {
    return Preconditions.checkNotNull(
        TappingCompletionStepModule.provideTappingCompletionStepTypeKey(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
