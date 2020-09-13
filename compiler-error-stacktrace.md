```
> Task :compileKotlin UP-TO-DATE
> Task :compileJava NO-SOURCE
> Task :processResources NO-SOURCE
> Task :classes UP-TO-DATE
> Task :compileTestKotlin FAILED
e: org.jetbrains.kotlin.codegen.CompilationException: Back-end (JVM) Internal error: Couldn't inline method call 'aa' into
@org.junit.Test public final fun aa(): kotlin.Unit defined in MainTest
@Test
	fun aa() {
		aa(42)
	}
Cause: aa (I)V:
   L0
    LDC 0
    ISTORE 1
   L1
    LINENUMBER 7 L1
    GETSTATIC MainKt$aa$1.INSTANCE : LMainKt$aa$1;
    CHECKCAST kotlin/jvm/functions/Function0
    INVOKESTATIC MainKt.bb (Lkotlin/jvm/functions/Function0;)V
   L2
    LINENUMBER 8 L2
    RETURN
   L3
    LOCALVARIABLE x I L0 L3 0
    LOCALVARIABLE $i$f$aa I L1 L3 1
    MAXSTACK = 1
    MAXLOCALS = 2

File being compiled: (9,3) in C:/dev/git/kotlin-inline-compiler-error-repro/src/test/kotlin/MainTest.kt
The root cause java.lang.RuntimeException was thrown at: org.jetbrains.kotlin.codegen.inline.InlineCodegenUtilsKt.buildClassReaderByInternalName(inlineCodegenUtils.kt:354)
	at org.jetbrains.kotlin.codegen.inline.InlineCodegen.throwCompilationException(InlineCodegen.kt:107)
	at org.jetbrains.kotlin.codegen.inline.InlineCodegen.performInline(InlineCodegen.kt:152)
	at org.jetbrains.kotlin.codegen.inline.PsiInlineCodegen.genCallInner(PsiInlineCodegen.kt:67)
	at org.jetbrains.kotlin.codegen.CallGenerator$DefaultImpls.genCall(CallGenerator.kt:115)
	at org.jetbrains.kotlin.codegen.inline.PsiInlineCodegen.genCall(PsiInlineCodegen.kt:33)
	at org.jetbrains.kotlin.codegen.ExpressionCodegen.invokeMethodWithArguments(ExpressionCodegen.java:2656)
	at org.jetbrains.kotlin.codegen.ExpressionCodegen.invokeMethodWithArguments(ExpressionCodegen.java:2598)
	at org.jetbrains.kotlin.codegen.Callable$invokeMethodWithArguments$1.invoke(Callable.kt:41)
	at org.jetbrains.kotlin.codegen.Callable$invokeMethodWithArguments$1.invoke(Callable.kt:13)
	at org.jetbrains.kotlin.codegen.OperationStackValue.putSelector(StackValue.kt:79)
	at org.jetbrains.kotlin.codegen.StackValueWithLeaveTask.putSelector(StackValue.kt:67)
	at org.jetbrains.kotlin.codegen.StackValue.put(StackValue.java:124)
	at org.jetbrains.kotlin.codegen.StackValue.put(StackValue.java:117)
	at org.jetbrains.kotlin.codegen.ExpressionCodegen.putStackValue(ExpressionCodegen.java:393)
	at org.jetbrains.kotlin.codegen.ExpressionCodegen.gen(ExpressionCodegen.java:374)
	at org.jetbrains.kotlin.codegen.ExpressionCodegen.returnExpression(ExpressionCodegen.java:1760)
	at org.jetbrains.kotlin.codegen.FunctionGenerationStrategy$FunctionDefault.doGenerateBody(FunctionGenerationStrategy.java:64)
	at org.jetbrains.kotlin.codegen.FunctionGenerationStrategy$CodegenBased.generateBody(FunctionGenerationStrategy.java:86)
	at org.jetbrains.kotlin.codegen.FunctionCodegen.generateMethodBody(FunctionCodegen.java:639)
	at org.jetbrains.kotlin.codegen.FunctionCodegen.generateMethodBody(FunctionCodegen.java:467)
	at org.jetbrains.kotlin.codegen.FunctionCodegen.generateMethod(FunctionCodegen.java:249)
	at org.jetbrains.kotlin.codegen.FunctionCodegen.generateMethod(FunctionCodegen.java:165)
	at org.jetbrains.kotlin.codegen.FunctionCodegen.gen(FunctionCodegen.java:136)
	at org.jetbrains.kotlin.codegen.MemberCodegen.genSimpleMember(MemberCodegen.java:196)
	at org.jetbrains.kotlin.codegen.ClassBodyCodegen.generateDeclaration(ClassBodyCodegen.java:169)
	at org.jetbrains.kotlin.codegen.ClassBodyCodegen.generateBody(ClassBodyCodegen.java:89)
	at org.jetbrains.kotlin.codegen.MemberCodegen.generate(MemberCodegen.java:128)
	at org.jetbrains.kotlin.codegen.MemberCodegen.genClassOrObject(MemberCodegen.java:301)
	at org.jetbrains.kotlin.codegen.MemberCodegen.genClassOrObject(MemberCodegen.java:285)
	at org.jetbrains.kotlin.codegen.PackageCodegenImpl.generateClassesAndObjectsInFile(PackageCodegenImpl.java:119)
	at org.jetbrains.kotlin.codegen.PackageCodegenImpl.generateFile(PackageCodegenImpl.java:138)
	at org.jetbrains.kotlin.codegen.PackageCodegenImpl.generate(PackageCodegenImpl.java:70)
	at org.jetbrains.kotlin.codegen.DefaultCodegenFactory.generatePackage(CodegenFactory.kt:88)
	at org.jetbrains.kotlin.codegen.DefaultCodegenFactory.generateModule(CodegenFactory.kt:67)
	at org.jetbrains.kotlin.codegen.KotlinCodegenFacade.compileCorrectFiles(KotlinCodegenFacade.java:35)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.generate(KotlinToJVMBytecodeCompiler.kt:616)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli(KotlinToJVMBytecodeCompiler.kt:203)
	at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:164)
	at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:51)
	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:86)
	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:44)
	at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:98)
	at org.jetbrains.kotlin.incremental.IncrementalJvmCompilerRunner.runCompiler(IncrementalJvmCompilerRunner.kt:346)
	at org.jetbrains.kotlin.incremental.IncrementalJvmCompilerRunner.runCompiler(IncrementalJvmCompilerRunner.kt:102)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compileIncrementally(IncrementalCompilerRunner.kt:240)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.access$compileIncrementally(IncrementalCompilerRunner.kt:39)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner$compile$2.invoke(IncrementalCompilerRunner.kt:81)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compile(IncrementalCompilerRunner.kt:93)
	at org.jetbrains.kotlin.daemon.CompileServiceImplBase.execIncrementalCompiler(CompileServiceImpl.kt:601)
	at org.jetbrains.kotlin.daemon.CompileServiceImplBase.access$execIncrementalCompiler(CompileServiceImpl.kt:93)
	at org.jetbrains.kotlin.daemon.CompileServiceImpl.compile(CompileServiceImpl.kt:1633)
	at sun.reflect.GeneratedMethodAccessor100.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at sun.rmi.server.UnicastServerRef.dispatch(UnicastServerRef.java:357)
	at sun.rmi.transport.Transport$1.run(Transport.java:200)
	at sun.rmi.transport.Transport$1.run(Transport.java:197)
	at java.security.AccessController.doPrivileged(Native Method)
	at sun.rmi.transport.Transport.serviceCall(Transport.java:196)
	at sun.rmi.transport.tcp.TCPTransport.handleMessages(TCPTransport.java:573)
	at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run0(TCPTransport.java:834)
	at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.lambda$run$0(TCPTransport.java:688)
	at java.security.AccessController.doPrivileged(Native Method)
	at sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run(TCPTransport.java:687)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
Caused by: java.lang.RuntimeException: Couldn't find virtual file for MainKt$AA$1
	at org.jetbrains.kotlin.codegen.inline.InlineCodegenUtilsKt.buildClassReaderByInternalName(inlineCodegenUtils.kt:354)
	at org.jetbrains.kotlin.codegen.inline.ObjectTransformer.createClassReader(ObjectTransformer.kt:50)
	at org.jetbrains.kotlin.codegen.inline.AnonymousObjectTransformer.doTransform(AnonymousObjectTransformer.kt:61)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner$doInline$lambdaInliner$1.handleAnonymousObjectRegeneration(MethodInliner.kt:192)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner$doInline$lambdaInliner$1.anew(MethodInliner.kt:216)
	at org.jetbrains.org.objectweb.asm.commons.InstructionAdapter.visitTypeInsn(InstructionAdapter.java:472)
	at org.jetbrains.org.objectweb.asm.tree.TypeInsnNode.accept(TypeInsnNode.java:77)
	at org.jetbrains.org.objectweb.asm.tree.InsnList.accept(InsnList.java:144)
	at org.jetbrains.org.objectweb.asm.tree.MethodNode.accept(MethodNode.java:792)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner.doInline(MethodInliner.kt:370)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner.doInline(MethodInliner.kt:107)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner.doInline(MethodInliner.kt:77)
	at org.jetbrains.kotlin.codegen.inline.AnonymousObjectTransformer.inlineMethod(AnonymousObjectTransformer.kt:305)
	at org.jetbrains.kotlin.codegen.inline.AnonymousObjectTransformer.inlineMethodAndUpdateGlobalResult(AnonymousObjectTransformer.kt:265)
	at org.jetbrains.kotlin.codegen.inline.AnonymousObjectTransformer.doTransform(AnonymousObjectTransformer.kt:152)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner$doInline$lambdaInliner$1.handleAnonymousObjectRegeneration(MethodInliner.kt:192)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner$doInline$lambdaInliner$1.visitFieldInsn(MethodInliner.kt:359)
	at org.jetbrains.org.objectweb.asm.tree.FieldInsnNode.accept(FieldInsnNode.java:88)
	at org.jetbrains.org.objectweb.asm.tree.InsnList.accept(InsnList.java:144)
	at org.jetbrains.org.objectweb.asm.tree.MethodNode.accept(MethodNode.java:792)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner.doInline(MethodInliner.kt:370)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner.doInline(MethodInliner.kt:107)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner.doInline(MethodInliner.kt:77)
	at org.jetbrains.kotlin.codegen.inline.InlineCodegen.inlineCall(InlineCodegen.kt:251)
	at org.jetbrains.kotlin.codegen.inline.InlineCodegen.performInline(InlineCodegen.kt:146)
	... 65 more
FAILURE: Build failed with an exception.
```
