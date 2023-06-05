## This is a minimal example for reproducing a crash in kotlin compiler

### Run
```
./gradlew run
```
### Expected result
App prints output:
```
result: Counter(value=1)
```
### Actual result
Compilation failed:
```
➜  KBugSample git:(main) ✗ ./gradlew run
> Task :processResources NO-SOURCE

> Task :compileKotlin FAILED
e: org.jetbrains.kotlin.backend.common.BackendException: Backend Internal error: Exception during IR lowering
File being compiled: /Users/dkalita/code/KBugSample/src/main/kotlin/Main.kt
The root cause java.lang.RuntimeException was thrown at: org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate(FunctionCodegen.kt:51)
        at org.jetbrains.kotlin.backend.common.CodegenUtil.reportBackendException(CodegenUtil.kt:253)
        at org.jetbrains.kotlin.backend.common.CodegenUtil.reportBackendException$default(CodegenUtil.kt:237)
        at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invokeSequential(performByIrFile.kt:68)
        at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invoke(performByIrFile.kt:55)
        at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invoke(performByIrFile.kt:41)
        at org.jetbrains.kotlin.backend.common.phaser.NamedCompilerPhase.phaseBody(CompilerPhase.kt:147)
        at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:94)
        at org.jetbrains.kotlin.backend.common.phaser.CompositePhase.invoke(PhaseBuilders.kt:29)
        at org.jetbrains.kotlin.backend.common.phaser.CompositePhase.invoke(PhaseBuilders.kt:16)
        at org.jetbrains.kotlin.backend.common.phaser.NamedCompilerPhase.phaseBody(CompilerPhase.kt:147)
        at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:94)
        at org.jetbrains.kotlin.backend.common.phaser.CompilerPhaseKt.invokeToplevel(CompilerPhase.kt:43)
        at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory.invokeCodegen(JvmIrCodegenFactory.kt:321)
        at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.runCodegen(KotlinToJVMBytecodeCompiler.kt:348)
        at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli(KotlinToJVMBytecodeCompiler.kt:123)
        at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli$default(KotlinToJVMBytecodeCompiler.kt:47)
        at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:168)
        at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:53)
        at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:100)
        at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:46)
        at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:101)
        at org.jetbrains.kotlin.incremental.IncrementalJvmCompilerRunner.runCompiler(IncrementalJvmCompilerRunner.kt:495)
        at org.jetbrains.kotlin.incremental.IncrementalJvmCompilerRunner.runCompiler(IncrementalJvmCompilerRunner.kt:133)
        at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.doCompile(IncrementalCompilerRunner.kt:486)
        at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compileImpl(IncrementalCompilerRunner.kt:409)
        at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compileNonIncrementally(IncrementalCompilerRunner.kt:290)
        at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compile(IncrementalCompilerRunner.kt:112)
        at org.jetbrains.kotlin.daemon.CompileServiceImplBase.execIncrementalCompiler(CompileServiceImpl.kt:627)
        at org.jetbrains.kotlin.daemon.CompileServiceImplBase.access$execIncrementalCompiler(CompileServiceImpl.kt:101)
        at org.jetbrains.kotlin.daemon.CompileServiceImpl.compile(CompileServiceImpl.kt:1587)
        at jdk.internal.reflect.GeneratedMethodAccessor104.invoke(Unknown Source)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:568)
        at java.rmi/sun.rmi.server.UnicastServerRef.dispatch(UnicastServerRef.java:360)
        at java.rmi/sun.rmi.transport.Transport$1.run(Transport.java:200)
        at java.rmi/sun.rmi.transport.Transport$1.run(Transport.java:197)
        at java.base/java.security.AccessController.doPrivileged(AccessController.java:712)
        at java.rmi/sun.rmi.transport.Transport.serviceCall(Transport.java:196)
        at java.rmi/sun.rmi.transport.tcp.TCPTransport.handleMessages(TCPTransport.java:587)
        at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run0(TCPTransport.java:828)
        at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.lambda$run$0(TCPTransport.java:705)
        at java.base/java.security.AccessController.doPrivileged(AccessController.java:399)
        at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run(TCPTransport.java:704)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
        at java.base/java.lang.Thread.run(Thread.java:833)
Caused by: java.lang.RuntimeException: Exception while generating code for:
FUN name:main visibility:public modality:FINAL <> (args:kotlin.Array<kotlin.String>) returnType:kotlin.Unit
  VALUE_PARAMETER name:args index:0 type:kotlin.Array<kotlin.String>
  BLOCK_BODY
    RETURN type=kotlin.Nothing from='public final fun main (args: kotlin.Array<kotlin.String>): kotlin.Unit declared in <root>.MainKt'
      CALL 'public final fun runBlocking$default <T> (context: kotlin.coroutines.CoroutineContext?, block: @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction1<kotlinx.coroutines.CoroutineScope, T of kotlinx.coroutines.BuildersKt.runBlocking$default>, $mask0: kotlin.Int, $handler: kotlin.Any?): T of kotlinx.coroutines.BuildersKt.runBlocking$default declared in kotlinx.coroutines.BuildersKt' type=kotlin.Unit origin=DEFAULT_DISPATCH_CALL
        <T>: kotlin.Unit
        context: COMPOSITE type=kotlin.coroutines.CoroutineContext? origin=DEFAULT_VALUE
          CONST Null type=kotlin.coroutines.CoroutineContext? value=null
        block: BLOCK type=<root>.MainKt.main.<no name provided> origin=null
          CLASS SUSPEND_LAMBDA CLASS name:<no name provided> modality:FINAL visibility:public/*package*/ superTypes:[kotlin.coroutines.jvm.internal.SuspendLambda; kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<kotlin.Unit>?, kotlin.Any?>]
            $this: VALUE_PARAMETER INSTANCE_RECEIVER name:<this> type:<root>.MainKt.main.<no name provided>
            FIELD name:label type:kotlin.Int visibility:public/*package*/
            CONSTRUCTOR SUSPEND_LAMBDA visibility:public/*package*/ <> ($completion:kotlin.coroutines.Continuation<<root>.MainKt.main.<no name provided>>?) returnType:<root>.MainKt.main.<no name provided> [primary]
              VALUE_PARAMETER name:$completion index:0 type:kotlin.coroutines.Continuation<<root>.MainKt.main.<no name provided>>?
              BLOCK_BODY
                DELEGATING_CONSTRUCTOR_CALL 'public constructor <init> (arity: kotlin.Int, $completion: kotlin.coroutines.Continuation<kotlin.Any?>?) declared in kotlin.coroutines.jvm.internal.SuspendLambda'
                  arity: CONST Int type=kotlin.Int value=2
                  $completion: GET_VAR '$completion: kotlin.coroutines.Continuation<<root>.MainKt.main.<no name provided>>? declared in <root>.MainKt.main.<no name provided>.<init>' type=kotlin.coroutines.Continuation<<root>.MainKt.main.<no name provided>>? origin=null
                BLOCK type=kotlin.Unit origin=null
            FUN name:invokeSuspend visibility:public modality:FINAL <> ($this:<root>.MainKt.main.<no name provided>, $result:kotlin.Result<kotlin.Any?>) returnType:kotlin.Any?
              overridden:
                protected abstract fun invokeSuspend ($result: kotlin.Result<kotlin.Any?>): kotlin.Any? declared in kotlin.coroutines.jvm.internal.SuspendLambda
              $this: VALUE_PARAMETER INSTANCE_RECEIVER name:<this> type:<root>.MainKt.main.<no name provided>
              VALUE_PARAMETER name:$result index:0 type:kotlin.Result<kotlin.Any?>
              BLOCK_BODY
                VAR name:api type:<root>.Api [val]
                  CONSTRUCTOR_CALL 'public constructor <init> () [primary] declared in <root>.Api' type=<root>.Api origin=null
                VAR name:result type:<root>.Counter [val]
                  CALL 'public final fun mutate <T> (mutator: kotlin.Function1<T of <root>.MainKt.mutate, T of <root>.MainKt.mutate>, $completion: kotlin.coroutines.Continuation<T of <root>.MainKt.mutate>): kotlin.Any? [inline,suspend] declared in <root>.MainKt' type=<root>.Counter origin=null
                    <T>: <root>.Counter
                    $receiver: GET_VAR 'val api: <root>.Api [val] declared in <root>.MainKt.main.<no name provided>.invokeSuspend' type=<root>.Api origin=null
                    mutator: BLOCK type=kotlin.Function1<<root>.Counter, <root>.Counter> origin=LAMBDA
                      COMPOSITE type=kotlin.Unit origin=null
                      FUNCTION_REFERENCE 'private final fun invokeSuspend$lambda$0 (counter: <root>.Counter): <root>.Counter declared in <root>.MainKt.main.<no name provided>' type=kotlin.Function1<<root>.Counter, <root>.Counter> origin=INLINE_LAMBDA reflectionTarget=null
                    $completion: GET_VAR '<this>: <root>.MainKt.main.<no name provided> declared in <root>.MainKt.main.<no name provided>.invokeSuspend' type=<root>.MainKt.main.<no name provided> origin=null
                CALL 'public final fun println (message: kotlin.Any?): kotlin.Unit [inline] declared in kotlin.io.ConsoleKt' type=kotlin.Unit origin=null
                  message: STRING_CONCATENATION type=kotlin.String
                    CONST String type=kotlin.String value="result: "
                    GET_VAR 'val result: <root>.Counter [val] declared in <root>.MainKt.main.<no name provided>.invokeSuspend' type=<root>.Counter origin=null
            FUN name:create visibility:public modality:FINAL <> ($this:<root>.MainKt.main.<no name provided>, value:kotlin.Any?, $completion:kotlin.coroutines.Continuation<kotlin.Nothing>) returnType:kotlin.coroutines.Continuation<kotlin.Unit>
              overridden:
                public open fun create (value: kotlin.Any?, $completion: kotlin.coroutines.Continuation<kotlin.Nothing>): kotlin.coroutines.Continuation<kotlin.Unit> declared in kotlin.coroutines.jvm.internal.SuspendLambda
              $this: VALUE_PARAMETER INSTANCE_RECEIVER name:<this> type:<root>.MainKt.main.<no name provided>
              VALUE_PARAMETER name:value index:0 type:kotlin.Any?
              VALUE_PARAMETER name:$completion index:1 type:kotlin.coroutines.Continuation<kotlin.Nothing>
              BLOCK_BODY
                RETURN type=kotlin.Nothing from='public final fun create (value: kotlin.Any?, $completion: kotlin.coroutines.Continuation<kotlin.Nothing>): kotlin.coroutines.Continuation<kotlin.Unit> declared in <root>.MainKt.main.<no name provided>'
                  CONSTRUCTOR_CALL 'public/*package*/ constructor <init> ($completion: kotlin.coroutines.Continuation<<root>.MainKt.main.<no name provided>>?) [primary] declared in <root>.MainKt.main.<no name provided>' type=<root>.MainKt.main.<no name provided> origin=null
                    $completion: GET_VAR '$completion: kotlin.coroutines.Continuation<kotlin.Nothing> declared in <root>.MainKt.main.<no name provided>.create' type=kotlin.coroutines.Continuation<kotlin.Nothing> origin=null
            FUN name:invoke visibility:public modality:FINAL <> ($this:<root>.MainKt.main.<no name provided>, p1:kotlinx.coroutines.CoroutineScope, p2:kotlin.coroutines.Continuation<kotlin.Unit>?) returnType:kotlin.Any?
              overridden:
                public abstract fun invoke (p1: P1 of kotlin.jvm.functions.Function2, p2: P2 of kotlin.jvm.functions.Function2): R of kotlin.jvm.functions.Function2 declared in kotlin.jvm.functions.Function2
              $this: VALUE_PARAMETER INSTANCE_RECEIVER name:<this> type:<root>.MainKt.main.<no name provided>
              VALUE_PARAMETER name:p1 index:0 type:kotlinx.coroutines.CoroutineScope
              VALUE_PARAMETER name:p2 index:1 type:kotlin.coroutines.Continuation<kotlin.Unit>?
              BLOCK_BODY
                RETURN type=kotlin.Nothing from='public final fun invoke (p1: kotlinx.coroutines.CoroutineScope, p2: kotlin.coroutines.Continuation<kotlin.Unit>?): kotlin.Any? declared in <root>.MainKt.main.<no name provided>'
                  CALL 'public final fun invokeSuspend ($result: kotlin.Result<kotlin.Any?>): kotlin.Any? declared in <root>.MainKt.main.<no name provided>' type=kotlin.Any? origin=null
                    $this: TYPE_OP type=<root>.MainKt.main.<no name provided> origin=IMPLICIT_CAST typeOperand=<root>.MainKt.main.<no name provided>
                      CALL 'public final fun create (value: kotlin.Any?, $completion: kotlin.coroutines.Continuation<kotlin.Nothing>): kotlin.coroutines.Continuation<kotlin.Unit> declared in <root>.MainKt.main.<no name provided>' type=kotlin.coroutines.Continuation<kotlin.Unit> origin=null
                        $this: GET_VAR '<this>: <root>.MainKt.main.<no name provided> declared in <root>.MainKt.main.<no name provided>.invoke' type=<root>.MainKt.main.<no name provided> origin=null
                        value: GET_VAR 'p1: kotlinx.coroutines.CoroutineScope declared in <root>.MainKt.main.<no name provided>.invoke' type=kotlinx.coroutines.CoroutineScope origin=null
                        $completion: GET_VAR 'p2: kotlin.coroutines.Continuation<kotlin.Unit>? declared in <root>.MainKt.main.<no name provided>.invoke' type=kotlin.coroutines.Continuation<kotlin.Unit>? origin=null
                    $result: CALL 'public final fun <unsafe-coerce> <T, R> (v: T of kotlin.jvm.internal.<unsafe-coerce>): R of kotlin.jvm.internal.<unsafe-coerce> declared in kotlin.jvm.internal' type=kotlin.Result<kotlin.Any?> origin=null
                      <T>: kotlin.Any?
                      <R>: kotlin.Result<kotlin.Any?>
                      v: GET_FIELD 'FIELD FIELD_FOR_OBJECT_INSTANCE name:INSTANCE type:kotlin.Unit visibility:public [final,static]' type=kotlin.Unit origin=null
            FUN INLINE_LAMBDA name:invokeSuspend$lambda$0 visibility:private modality:FINAL <> (counter:<root>.Counter) returnType:<root>.Counter
              VALUE_PARAMETER name:counter index:0 type:<root>.Counter
              BLOCK_BODY
                VAR name:$i$a$-mutate-MainKt$main$1$result$1 type:kotlin.Int [val]
                  CONST Int type=kotlin.Int value=0
                RETURN type=kotlin.Nothing from='private final fun invokeSuspend$lambda$0 (counter: <root>.Counter): <root>.Counter declared in <root>.MainKt.main.<no name provided>'
                  CALL 'public final fun plus (x: kotlin.Long): <root>.Counter [operator] declared in <root>.Counter' type=<root>.Counter origin=PLUS
                    $this: GET_VAR 'counter: <root>.Counter declared in <root>.MainKt.main.<no name provided>.invokeSuspend$lambda$0' type=<root>.Counter origin=null
                    x: CONST Long type=kotlin.Long value=1
            FUN BRIDGE name:invoke visibility:public modality:OPEN <> ($this:<root>.MainKt.main.<no name provided>, p1:kotlin.Any?, p2:kotlin.Any?) returnType:kotlin.Any?
              $this: VALUE_PARAMETER INSTANCE_RECEIVER name:<this> type:<root>.MainKt.main.<no name provided>
              VALUE_PARAMETER BRIDGE name:p1 index:0 type:kotlin.Any?
              VALUE_PARAMETER BRIDGE name:p2 index:1 type:kotlin.Any?
              EXPRESSION_BODY
                RETURN type=kotlin.Nothing from='public open fun invoke (p1: kotlin.Any?, p2: kotlin.Any?): kotlin.Any? declared in <root>.MainKt.main.<no name provided>'
                  CALL 'public final fun invoke (p1: kotlinx.coroutines.CoroutineScope, p2: kotlin.coroutines.Continuation<kotlin.Unit>?): kotlin.Any? declared in <root>.MainKt.main.<no name provided>' type=kotlin.Any? origin=BRIDGE_DELEGATION
                    $this: GET_VAR '<this>: <root>.MainKt.main.<no name provided> declared in <root>.MainKt.main.<no name provided>.invoke' type=<root>.MainKt.main.<no name provided> origin=null
                    p1: TYPE_OP type=kotlinx.coroutines.CoroutineScope origin=IMPLICIT_CAST typeOperand=kotlinx.coroutines.CoroutineScope
                      GET_VAR 'p1: kotlin.Any? declared in <root>.MainKt.main.<no name provided>.invoke' type=kotlin.Any? origin=null
                    p2: TYPE_OP type=kotlin.coroutines.Continuation<*> origin=IMPLICIT_CAST typeOperand=kotlin.coroutines.Continuation<*>
                      GET_VAR 'p2: kotlin.Any? declared in <root>.MainKt.main.<no name provided>.invoke' type=kotlin.Any? origin=null
          CONSTRUCTOR_CALL 'public/*package*/ constructor <init> ($completion: kotlin.coroutines.Continuation<<root>.MainKt.main.<no name provided>>?) [primary] declared in <root>.MainKt.main.<no name provided>' type=<root>.MainKt.main.<no name provided> origin=null
            $completion: CONST Null type=kotlin.Nothing? value=null
        $mask0: CONST Int type=kotlin.Int value=1
        $handler: CONST Null type=kotlin.Any? value=null

        at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate(FunctionCodegen.kt:51)
        at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate$default(FunctionCodegen.kt:43)
        at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generateMethodNode(ClassCodegen.kt:391)
        at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generateMethod(ClassCodegen.kt:408)
        at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generate(ClassCodegen.kt:170)
        at org.jetbrains.kotlin.backend.jvm.FileCodegen.lower(JvmPhases.kt:44)
        at org.jetbrains.kotlin.backend.common.phaser.FileLoweringPhaseAdapter.invoke(PhaseBuilders.kt:120)
        at org.jetbrains.kotlin.backend.common.phaser.FileLoweringPhaseAdapter.invoke(PhaseBuilders.kt:116)
        at org.jetbrains.kotlin.backend.common.phaser.NamedCompilerPhase.phaseBody(CompilerPhase.kt:147)
        at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:94)
        at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invokeSequential(performByIrFile.kt:65)
        ... 43 more
Caused by: java.lang.RuntimeException: Exception while generating code for:
FUN name:invokeSuspend visibility:public modality:FINAL <> ($this:<root>.MainKt.main.<no name provided>, $result:kotlin.Result<kotlin.Any?>) returnType:kotlin.Any?
  overridden:
    protected abstract fun invokeSuspend ($result: kotlin.Result<kotlin.Any?>): kotlin.Any? declared in kotlin.coroutines.jvm.internal.SuspendLambda
  $this: VALUE_PARAMETER INSTANCE_RECEIVER name:<this> type:<root>.MainKt.main.<no name provided>
  VALUE_PARAMETER name:$result index:0 type:kotlin.Result<kotlin.Any?>
  BLOCK_BODY
    VAR name:api type:<root>.Api [val]
      CONSTRUCTOR_CALL 'public constructor <init> () [primary] declared in <root>.Api' type=<root>.Api origin=null
    VAR name:result type:<root>.Counter [val]
      CALL 'public final fun mutate <T> (mutator: kotlin.Function1<T of <root>.MainKt.mutate, T of <root>.MainKt.mutate>, $completion: kotlin.coroutines.Continuation<T of <root>.MainKt.mutate>): kotlin.Any? [inline,suspend] declared in <root>.MainKt' type=<root>.Counter origin=null
        <T>: <root>.Counter
        $receiver: GET_VAR 'val api: <root>.Api [val] declared in <root>.MainKt.main.<no name provided>.invokeSuspend' type=<root>.Api origin=null
        mutator: BLOCK type=kotlin.Function1<<root>.Counter, <root>.Counter> origin=LAMBDA
          COMPOSITE type=kotlin.Unit origin=null
          FUNCTION_REFERENCE 'private final fun invokeSuspend$lambda$0 (counter: <root>.Counter): <root>.Counter declared in <root>.MainKt.main.<no name provided>' type=kotlin.Function1<<root>.Counter, <root>.Counter> origin=INLINE_LAMBDA reflectionTarget=null
        $completion: GET_VAR '<this>: <root>.MainKt.main.<no name provided> declared in <root>.MainKt.main.<no name provided>.invokeSuspend' type=<root>.MainKt.main.<no name provided> origin=null
    CALL 'public final fun println (message: kotlin.Any?): kotlin.Unit [inline] declared in kotlin.io.ConsoleKt' type=kotlin.Unit origin=null
      message: STRING_CONCATENATION type=kotlin.String
        CONST String type=kotlin.String value="result: "
        GET_VAR 'val result: <root>.Counter [val] declared in <root>.MainKt.main.<no name provided>.invokeSuspend' type=<root>.Counter origin=null

        at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate(FunctionCodegen.kt:51)
        at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate$default(FunctionCodegen.kt:43)
        at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generateMethodNode(ClassCodegen.kt:391)
        at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generateMethod(ClassCodegen.kt:408)
        at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generate(ClassCodegen.kt:170)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitClass(ExpressionCodegen.kt:862)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitClass(ExpressionCodegen.kt:132)
        at org.jetbrains.kotlin.ir.declarations.IrClass.accept(IrClass.kt:64)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitStatementContainer(ExpressionCodegen.kt:459)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitContainerExpression(ExpressionCodegen.kt:472)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitContainerExpression(ExpressionCodegen.kt:132)
        at org.jetbrains.kotlin.ir.visitors.IrElementVisitor$DefaultImpls.visitBlock(IrElementVisitor.kt:192)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitBlock(ExpressionCodegen.kt:398)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitBlock(ExpressionCodegen.kt:132)
        at org.jetbrains.kotlin.ir.expressions.IrBlock.accept(IrBlock.kt:22)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.gen(ExpressionCodegen.kt:215)
        at org.jetbrains.kotlin.backend.jvm.codegen.IrCallGenerator.genValueAndPut(IrCallGenerator.kt:48)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitCall$handleValueParameter(ExpressionCodegen.kt:502)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitCall(ExpressionCodegen.kt:515)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitCall(ExpressionCodegen.kt:132)
        at org.jetbrains.kotlin.ir.expressions.IrCall.accept(IrCall.kt:25)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitReturn(ExpressionCodegen.kt:910)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitReturn(ExpressionCodegen.kt:132)
        at org.jetbrains.kotlin.ir.expressions.IrReturn.accept(IrReturn.kt:25)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitStatementContainer(ExpressionCodegen.kt:459)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitBlockBody(ExpressionCodegen.kt:463)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitBlockBody(ExpressionCodegen.kt:132)
        at org.jetbrains.kotlin.ir.expressions.IrBlockBody.accept(IrBlockBody.kt:24)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.generate(ExpressionCodegen.kt:238)
        at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.doGenerate(FunctionCodegen.kt:122)
        at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate(FunctionCodegen.kt:47)
        ... 53 more
Caused by: org.jetbrains.kotlin.codegen.CompilationException: Back-end (JVM) Internal error: Couldn't transform method node:
create (Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;:
  @Lorg/jetbrains/annotations/NotNull;() // invisible
    @Lorg/jetbrains/annotations/Nullable;() // invisible, parameter 0
    @Lorg/jetbrains/annotations/NotNull;() // invisible, parameter 1
   L0
    NEW MainKt$main$1$invokeSuspend$$inlined$mutate$1
    DUP
    ALOAD 2
    ALOAD 0
    GETFIELD MainKt$main$1$invokeSuspend$$inlined$mutate$1.callee$inlined : Lkotlin/jvm/functions/Function1;
    INVOKESPECIAL MainKt$main$1$invokeSuspend$$inlined$mutate$1.<init> (Lkotlin/coroutines/Continuation;)V
    ASTORE 3
    ALOAD 3
    ALOAD 1
    PUTFIELD MainKt$main$1$invokeSuspend$$inlined$mutate$1.L$0 : Ljava/lang/Object;
    ALOAD 3
    CHECKCAST kotlin/coroutines/Continuation
    ARETURN
   L1
    LOCALVARIABLE this LMainKt$main$1$invokeSuspend$$inlined$mutate$1; L0 L1 0
    LOCALVARIABLE value Ljava/lang/Object; L0 L1 1
    LOCALVARIABLE $completion Lkotlin/coroutines/Continuation; L0 L1 2
    MAXSTACK = 4
    MAXLOCALS = 4

File is unknown
The root cause java.lang.AssertionError was thrown at: org.jetbrains.kotlin.codegen.coroutines.UninitializedStoresProcessor.getUninitializedValueForConstructorCall(processUninitializedStores.kt:164)
        at org.jetbrains.kotlin.codegen.TransformationMethodVisitor.visitEnd(TransformationMethodVisitor.kt:89)
        at org.jetbrains.org.objectweb.asm.MethodVisitor.visitEnd(MethodVisitor.java:783)
        at org.jetbrains.org.objectweb.asm.MethodVisitor.visitEnd(MethodVisitor.java:783)
        at org.jetbrains.org.objectweb.asm.tree.MethodNode.accept(MethodNode.java:772)
        at org.jetbrains.kotlin.codegen.inline.DeferredMethodVisitor.visitEnd(DeferredMethodVisitor.kt:31)
        at org.jetbrains.kotlin.codegen.inline.AnonymousObjectTransformer.doTransform(AnonymousObjectTransformer.kt:192)
        at org.jetbrains.kotlin.codegen.inline.MethodInliner$doInline$lambdaInliner$1.handleAnonymousObjectRegeneration(MethodInliner.kt:190)
        at org.jetbrains.kotlin.codegen.inline.MethodInliner$doInline$lambdaInliner$1.anew(MethodInliner.kt:218)
        at org.jetbrains.org.objectweb.asm.commons.InstructionAdapter.visitTypeInsn(InstructionAdapter.java:473)
        at org.jetbrains.org.objectweb.asm.tree.TypeInsnNode.accept(TypeInsnNode.java:77)
        at org.jetbrains.org.objectweb.asm.tree.InsnList.accept(InsnList.java:144)
        at org.jetbrains.org.objectweb.asm.tree.MethodNode.accept(MethodNode.java:751)
        at org.jetbrains.kotlin.codegen.inline.MethodInliner.doInline(MethodInliner.kt:385)
        at org.jetbrains.kotlin.codegen.inline.MethodInliner.doInline(MethodInliner.kt:98)
        at org.jetbrains.kotlin.codegen.inline.MethodInliner.doInline(MethodInliner.kt:72)
        at org.jetbrains.kotlin.codegen.inline.InlineCodegen.inlineCall(InlineCodegen.kt:118)
        at org.jetbrains.kotlin.codegen.inline.InlineCodegen.performInline(InlineCodegen.kt:50)
        at org.jetbrains.kotlin.backend.jvm.codegen.IrInlineCodegen.genInlineCall(IrInlineCodegen.kt:159)
        at org.jetbrains.kotlin.backend.jvm.codegen.IrInlineCallGenerator.genCall(IrInlineCallGenerator.kt:31)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitCall(ExpressionCodegen.kt:523)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitCall(ExpressionCodegen.kt:132)
        at org.jetbrains.kotlin.ir.expressions.IrCall.accept(IrCall.kt:25)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitVariable(ExpressionCodegen.kt:653)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitVariable(ExpressionCodegen.kt:132)
        at org.jetbrains.kotlin.ir.declarations.IrVariable.accept(IrVariable.kt:37)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitStatementContainer(ExpressionCodegen.kt:459)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitBlockBody(ExpressionCodegen.kt:463)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitBlockBody(ExpressionCodegen.kt:132)
        at org.jetbrains.kotlin.ir.expressions.IrBlockBody.accept(IrBlockBody.kt:24)
        at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.generate(ExpressionCodegen.kt:238)
        at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.doGenerate(FunctionCodegen.kt:122)
        at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate(FunctionCodegen.kt:47)
        ... 83 more
Caused by: java.lang.AssertionError: Next value after NEW should be one generated by DUP
        at org.jetbrains.kotlin.codegen.coroutines.UninitializedStoresProcessor.getUninitializedValueForConstructorCall(processUninitializedStores.kt:164)
        at org.jetbrains.kotlin.codegen.coroutines.UninitializedStoresProcessor.access$getUninitializedValueForConstructorCall(processUninitializedStores.kt:75)
        at org.jetbrains.kotlin.codegen.coroutines.UninitializedStoresProcessor$UninitializedNewValueFrame.execute(processUninitializedStores.kt:136)
        at org.jetbrains.kotlin.codegen.optimization.common.FastMethodAnalyzer.analyze(FastMethodAnalyzer.kt:105)
        at org.jetbrains.kotlin.codegen.coroutines.UninitializedStoresProcessor.run(processUninitializedStores.kt:93)
        at org.jetbrains.kotlin.codegen.optimization.OptimizationMethodVisitor.performTransformations(OptimizationMethodVisitor.kt:70)
        at org.jetbrains.kotlin.codegen.TransformationMethodVisitor.visitEnd(TransformationMethodVisitor.kt:67)
        ... 114 more

Errors were stored into /Users/dkalita/code/KBugSample/.gradle/kotlin/errors/errors-1686001733631.log

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':compileKotlin'.
> A failure occurred while executing org.jetbrains.kotlin.compilerRunner.GradleCompilerRunnerWithWorkers$GradleKotlinCompilerWorkAction
   > Internal compiler error. See log for more details

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.

* Get more help at https://help.gradle.org

BUILD FAILED in 784ms
1 actionable task: 1 executed
➜  KBugSample git:(main) ✗ 
```
