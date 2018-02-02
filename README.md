Codenarc Extra.
----

Hosts extra codenarc rules which are not bundled with codenarc.

Usage
---

Add dependency to codenarc extra in build.gradle

```groovy

repositories {
    jcenter()
}


dependencies {
 codenarc "io.9ci.yakworks:codenarc-extra:1.0.1"
}


```

Add codenarc ruleset in rules.groovy file as shown below.

```groovy
ruleset {
    ruleset('rulesets/codenarc-extra.xml')
}
```

That should make the codenarc-extra rules apply.

Rules included in this package
----


- **CompileStaticRule** This rule ensures that all groovy classes are annotated with one of the @CompileStatic, @CompileDynamic or @GrailsCompileStatic



