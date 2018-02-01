package yakworks.codenarc

import org.codenarc.rule.AbstractRuleTestCase
import org.codenarc.rule.Rule
import org.codenarc.rule.Violation
import org.junit.Test

class CompileStaticRuleTest extends AbstractRuleTestCase {
    boolean  skipTestThatUnrelatedCodeHasNoViolations = true

    @Override
    protected Rule createRule() {
        return new CompileStaticRule()
    }

    @Test
    void "test class without explicit compile static not allowed"() {
        final source = """
            
            class Test {
            
            }
         """

        assertSingleViolation(source) { Violation violation ->
            violation.rule.priority == 2
            violation.rule.name == 'CompileStatic'
        }
    }

    @Test
    void "test class with GrailsCompileStatic is allowed"() {
        final source = """
            import grails.compiler.GrailsCompileStatic
            
            @GrailsCompileStatic
            class Test {
            
            }
         """

        assertNoViolations(source)
    }

    @Test
    void "test class with CompileStatic is allowed"() {
        final source = """
            import groovy.transform.CompileStatic
            
            @CompileStatic
            class Test {
            
            }
         """

        assertNoViolations(source)
    }

    @Test
    void "test class with CompileDynamic is allowed"() {
        final source = """
            import groovy.transform.CompileDynamic
            
            @CompileDynamic
            class Test {
            
            }
         """

        assertNoViolations(source)
    }

    @Test
    void "test interface is not checked"() {
        final source = """
            interface Test {
            
            }
         """
        assertNoViolations(source)
    }
}
