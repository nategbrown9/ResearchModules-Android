// Generated by Dagger (https://google.github.io/dagger).
package org.sagebionetworks.research.motor_control_module.inject;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class InstructionStepModule_ProvideInstructionStepClassInfoFactory
    implements Factory<String> {
  private static final InstructionStepModule_ProvideInstructionStepClassInfoFactory INSTANCE =
      new InstructionStepModule_ProvideInstructionStepClassInfoFactory();

  @Override
  public String get() {
    return proxyProvideInstructionStepClassInfo();
  }

  public static InstructionStepModule_ProvideInstructionStepClassInfoFactory create() {
    return INSTANCE;
  }

  public static String proxyProvideInstructionStepClassInfo() {
    return Preconditions.checkNotNull(
        InstructionStepModule.provideInstructionStepClassInfo(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
