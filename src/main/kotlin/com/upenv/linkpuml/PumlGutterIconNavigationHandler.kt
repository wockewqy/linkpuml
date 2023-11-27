package com.upenv.linkpuml

import com.intellij.codeInsight.daemon.GutterIconNavigationHandler
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import java.awt.event.MouseEvent


class PumlGutterIconNavigationHandler : GutterIconNavigationHandler<PsiElement> {
    override fun navigate(e: MouseEvent?, elt: PsiElement?) {
        if (elt != null) {
            val pumlTag = getPumlTag(elt)
            if (pumlTag != null) {
                val pumlFilePath = extractPumlFilePath(pumlTag)
                openPumlFile(elt.project, pumlFilePath)
            }
        }
    }

    private fun getPumlTag(elt: PsiElement): String? {
        return if (elt is PsiComment) {
            val commentText = elt.getText()
            val matchResult = Regex("@puml\\s+(.*)\\.puml").find(commentText)
            if (matchResult != null) {
                matchResult.groupValues[1] + ".puml"
            } else {
                null
            }
        } else {
            null
        }
    }

    private fun extractPumlFilePath(pumlTag: String): String {
        return pumlTag
    }

    private fun openPumlFile(project: Project, pumlFilePath: String) {
        val projectFileIndex = ProjectRootManager.getInstance(project).fileIndex
        val contentRoots = projectFileIndex.getContentRootForFile(project.baseDir, false)
        val file =
            LocalFileSystem.getInstance().findFileByPath(contentRoots?.path + "/" + pumlFilePath)
        if (file != null) {
            FileEditorManager.getInstance(project).openFile(file, true)
        } else {
            Messages.showMessageDialog(project, "Cannot find file: $pumlFilePath", "Error", Messages.getErrorIcon())
        }


    }


}
