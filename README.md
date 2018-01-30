Codenarc Extra.
----

Hosts extra codenarc rules which are not bundled with codenarc.

Usage
---

Add dependency to codenarc extra in build.gradle

```groovy

repositories {
    maven { url = "https://dl.bintray.com/9ci/maven" }
}


dependencies {
 codenarc "io.9ci.yakworks:codenarc-extra:1.0.1.RC2"
}


```

Add codenarc ruleset in rules.groovy file as shown below.

```groovy
ruleset {
    ruleset('rulesets/grails-extra.xml')
}
```

That should make the codenarc-extra rules apply.

Rules included in this package
----

CompileStaticRule
--

- This rule ensures that all groovy classes are annotated with one of the @CompileStatic, @CompileDynamic or @GrailsCompileStatic



