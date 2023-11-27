package com.upenv.linkpuml

import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiComment

class PumlTagVisitor : PsiElementVisitor() {
    var pumlTag: PsiComment? = null
    override fun visitComment(comment: PsiComment) {
        val commentText = comment.text
        if (commentText.contains("@puml")) {
            pumlTag = comment
        }
    }

}
