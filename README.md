# Kotlin compiler error caused by inline functions

This project is a minimal example to reproduce a compiler error with inline functions using 
two or more functions with the same name but different letter case, e.g. `aa()` and `AA()`, 
each calling another non-inline function with a lambda parameter. 

## Setup

- Define two or more `inline` functions with the same name but different letter case, e.g. `aa()` and `AA()`.
- Each of those functions calls another function that takes a lambda parameter.
- Call one of the above functions `aa()` or `AA()` from somewhere within the application and from a unit test.

Have a look at the [main.kt](src/main/kotlin/main.kt) file for a reference implementation.

## Errors

There are two errors caused by this setup:  
A) Runtime `NoClassDefFoundError`.  
B) File not found at compile time.

### A) Running `main()`

#### Expected behaviour

1. Successful compilation.
2. `aa` being printed.

#### Actual behaviour

1. Successful compilation.
2. `java.lang.NoClassDefFoundError: MainKt$aa$1 (wrong name: MainKt$AA$1)`

### B) Running `MainTest.test()`

#### Expected behaviour

1. Successful compilation.
2. `aa` being printed and test passed.

#### Actual behaviour

1. Compilation error:

    > org.jetbrains.kotlin.codegen.CompilationException: Back-end (JVM) Internal error: Couldn't inline method call 'aa' into
    @org.junit.Test public final fun test(): kotlin.Unit defined in MainTest  
    > ...  
    > File being compiled: (9,3) in C:/dev/git/kotlin-inline-compiler-error-repro/src/test/kotlin/MainTest.kt  
    > The root cause java.lang.RuntimeException was thrown at: org.jetbrains.kotlin.codegen.inline.InlineCodegenUtilsKt.buildClassReaderByInternalName(inlineCodegenUtils.kt:354)  
    > ...  
    > Caused by: java.lang.RuntimeException: Couldn't find virtual file for MainKt$AA$1

    See [compiler-error-stacktrace.md](compiler-error-stacktrace.md) for the complete stack trace.

### Workarounds

- Rename `AA()` to `aa()` or vice versa, such that their names are identical.
- Use two completely different names.
- Don't `inline` the functions, but that only fixes the compiler error, not the `NoClassDefFoundError`.

### Environment

> IntelliJ IDEA 2020.2.3 (Community Edition)  
> Build #IC-202.7660.26, built on October 6, 2020  
> Runtime version: 11.0.8+10-b944.34 amd64  
> VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.  
> Windows 10 10.0  
> GC: ParNew, ConcurrentMarkSweep  
> Memory: 1963M  
> Cores: 8  
> Non-Bundled Plugins: org.jetbrains.kotlin
