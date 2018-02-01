package yakworks.codenarc

import groovy.transform.CompileStatic
import org.codehaus.groovy.ast.AnnotationNode
import org.codehaus.groovy.ast.ClassNode
import org.codenarc.rule.AbstractAstVisitor
import org.codenarc.rule.AbstractAstVisitorRule

@CompileStatic
class CompileStaticRule extends AbstractAstVisitorRule {
    int priority = 2
    String name = 'CompileStatic'
    Class astVisitorClass = GrailsTransactionalVisitor
}

class GrailsTransactionalVisitor extends AbstractAstVisitor {
    private static final String GRAILS_COMPILE_STATIC = 'GrailsCompileStatic'
    private static final String COMPILE_STATIC = "CompileStatic"
    private static final String COMPILE_DYNAMIC = "CompileDynamic"

    private static
    final String ERROR_MSG = 'Class should be marked with one of @GrailsCompileStatic, @CompileStatic or @CompileDynamic'


    @Override
    void visitClassEx(ClassNode classNode) {
        boolean isExplicitlyMarked = false

        if (!classNode.isInterface()) {
            for (AnnotationNode annotationNode : classNode.annotations) {
                String annotation = annotationNode.classNode.text
                if (annotation in [GRAILS_COMPILE_STATIC, COMPILE_STATIC, COMPILE_DYNAMIC]) {
                    isExplicitlyMarked = true
                }
            }

            if (!isExplicitlyMarked) {
                addViolation(classNode, ERROR_MSG)
            }
        }

        super.visitClassEx(classNode)

    }

}