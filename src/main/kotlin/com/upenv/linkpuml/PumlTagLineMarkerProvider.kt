package com.upenv.linkpuml

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.openapi.util.IconLoader
import com.intellij.psi.PsiElement
import com.intellij.util.FunctionUtil
import org.jetbrains.annotations.Nullable


class PumlTagLineMarkerProvider : LineMarkerProvider {
    @Nullable
    @Override
    override fun getLineMarkerInfo(psiElement: PsiElement): LineMarkerInfo<*>? {
        val visitor = PumlTagVisitor()
        psiElement.accept(visitor)
        val pumlTag = visitor.pumlTag
        val pumlIcon = IconLoader.getIcon("/uml16.svg", PumlTagLineMarkerProvider::class.java)
        return if (pumlTag != null) {
            LineMarkerInfo(
                pumlTag,
                pumlTag.textRange,
                pumlIcon,
                FunctionUtil.constant("Open PlantUML Diagram"),
                PumlGutterIconNavigationHandler(),
                GutterIconRenderer.Alignment.LEFT
            )
            { "Open PlantUML Diagram" }
        } else {
            null
        }
    }
}
