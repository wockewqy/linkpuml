# PlantUML Linker IntelliJ IDEA 插件

## 描述

PlantUML Linker 是一个 IntelliJ IDEA 插件，它可以在你的 Java 代码注释中识别出 `@puml` 标签，并在该行前面添加一个小图标。当你点击这个小图标时，插件将会在编辑器中打开对应的 PlantUML 文件。

## 功能

- 扫描 Java 代码注释，识别出 `@puml` 标签。
- 在含有 `@puml` 标签的注释行前添加一个小图标。
- 当点击小图标时，跳转到对应的 PlantUML 文件。

## 使用方法

1. 在你的 Java 代码注释中添加 `@puml` 标签，后面跟着 PlantUML 文件的路径。例如：

```java
// @puml src/main/resources/diagram.puml
public class MyClass {
    // ...
}
```

2. 在含有 `@puml` 标签的注释行前，你会看到一个小图标。

3. 点击这个小图标，插件将会在编辑器中打开 `src/main/resources/diagram.puml` 文件。
