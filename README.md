## Kotlin compiler error caused by inline functions

This project is a minimal example to reproduce a compiler error with inline functions using two or more functions with the same name but different letter case, e.g. `aa()` and `AA()`.

There are two related errors:  
A) Runtime `NoClassDefFoundError`.  
B) File not found at compile time.

### A) Running `main()`

#### Expected behaviour

1. Successful compilation.
2. `aa` being printed.

#### Actual behaviour

1. Successful compilation.
2. `java.lang.NoClassDefFoundError: MainKt$aa$1 (wrong name: MainKt$AA$1)`

### B) Running `MainTest.aa()`

#### Expected behaviour

1. Successful compilation.
2. `aa` being printed.

#### Actual behaviour

1. Compilation error:

    > org.jetbrains.kotlin.codegen.CompilationException: Back-end (JVM) Internal error: Couldn't inline method call 'aa' into
    @org.junit.Test public final fun aa(): kotlin.Unit defined in MainTest  
    > ...  
    > File being compiled: (9,3) in C:/dev/git/kotlin-inline-compiler-error-repro/src/test/kotlin/MainTest.kt
    The root cause java.lang.RuntimeException was thrown at: org.jetbrains.kotlin.codegen.inline.InlineCodegenUtilsKt.buildClassReaderByInternalName(inlineCodegenUtils.kt:354)  
    > ...  
    > Caused by: java.lang.RuntimeException: Couldn't find virtual file for MainKt$AA$1

### Workarounds

- Rename `AA()` to `aa()` or vice versa, such that their names are identical.
- Use two completely different names.
- Don't `inline` the functions, but that only fixes the compiler error, not the `NoClassDefFoundError`.

### Environment

<small>IntelliJ IDEA 2020.2.1 (Community Edition)  
Build #IC-202.6948.69, built on August 24, 2020  
Runtime version: 11.0.8+10-b944.31 amd64  
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.  
Windows 10 10.0  
GC: ParNew, ConcurrentMarkSweep  
Memory: 1963M  
Cores: 8  
Non-Bundled Plugins: org.jetbrains.kotlin</small>
