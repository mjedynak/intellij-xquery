# IntelliJ XQuery Support Plugin
Provides support for [XQuery](http://www.w3schools.com/xquery/) language in version 3.0 in [IntelliJ IDEA](http://www.jetbrains.com/idea/)

[Main page](http://ligasgr.github.io/intellij-xquery/) - For any details around plugin please visit this page

[Plugin in JetBrains Plugin Repository](http://plugins.jetbrains.com/plugin/7262?pr=) - Official plugin repository page

[GitHub Issues](https://github.com/ligasgr/intellij-xquery/issues) - please raise issues for any bugs you've found or any features that are missing

Cloudbees Jenkins status: [![Build Status](https://ligasgr.ci.cloudbees.com/buildStatus/icon?job=intellij-xquery-master-build)](https://ligasgr.ci.cloudbees.com/job/intellij-xquery-master-build/)


#XQuery - useful links
1. [XQuery 3.0: An XML Query Language - W3C Candidate Recommendation](http://www.w3.org/TR/xquery-30/)
1. [XQuery 3.0 Grammar](http://www.w3.org/TR/xquery-30/#nt-bnf)
1. [Building a Tokenizer for XPath or XQuery - Draft for XQuery 1.0](http://www.w3.org/TR/xquery-xpath-parsing/)
1. [XML Query Use Cases](http://www.w3.org/TR/xquery-use-cases/)
1. [XML Query Use Cases - all in one file version](http://www.w3.org/TR/2007/NOTE-xquery-use-cases-20070323/xquery-use-case-queries.txt)
1. [XQuery 3.0 compatiblity test suite](http://dev.w3.org/cvsweb/2011/QT3-test-suite/)
1. [Guidelines for Running the QT3 Test Suite](http://dev.w3.org/2011/QT3-test-suite/guide/running.html)

#Plugin development - useful links
1. [Developing Custom Language Plugins for IntelliJ IDEA](http://confluence.jetbrains.com/display/IDEADEV/Developing+Custom+Language+Plugins+for+IntelliJ+IDEA)
1. [Custom Language Support - Tutorial](http://confluence.jetbrains.com/display/IntelliJIDEA/Custom+Language+Support)
1. [Testing IntelliJ IDEA Plugins](http://confluence.jetbrains.com/display/IDEADEV/Testing+IntelliJ+IDEA+Plugins)
1. [Writing Tests for Plugins - Tutorial](http://confluence.jetbrains.com/display/IntelliJIDEA/Writing+Tests+for+Plugins)
1. [IntelliJ IDEA Architectural Overview](http://confluence.jetbrains.com/display/IDEADEV/IntelliJ+IDEA+Architectural+Overview)
1. [Open API and Plugin Development - Developer Community Forum](http://devnet.jetbrains.com/community/idea/open_api_and_plugin_development)
1. [Erlang support plugin for IntelliJ IDEA - source code on github](https://github.com/ignatov/intellij-erlang/)
1. [Developing a plugin for IntelliJ IDEA – some useful tips and links](http://tomaszdziurko.pl/2011/09/developing-plugin-intellij-idea-some-tips-and-links/)

#Building plugin locally on Linux
Run:
``` sh
git clone git@github.com:ligasgr/intellij-xquery.git
cd intellij-xquery
./gradlew downloadSdk
./gradlew unzipSdk
./gradlew build
```

## Change log

### Version 0.0.5
* Minor bug fixes.
* Small code completion display changes.
* Building project and generating idea project structure with gradle.
* Issue [#4](https://github.com/ligasgr/intellij-xquery/issues/4) - Function completion from imported files missing.
* Issue [#5](https://github.com/ligasgr/intellij-xquery/issues/5) - Lack of PI support.
* Issue [#6](https://github.com/ligasgr/intellij-xquery/issues/6) - Lack of CDATA support.
* Issue [#7](https://github.com/ligasgr/intellij-xquery/issues/7) - Lack of PRAGMA support.
* Issue [#14](https://github.com/ligasgr/intellij-xquery/issues/14) - Reference for default function namespace doesn't work (small performance degradation for find usages introduced while fixing).
* Issue [#36](https://github.com/ligasgr/intellij-xquery/issues/36) - Variable completion from imported files missing.

### Version 0.0.4
* Minor bug fixes.
* Additional file extensions added as supported by plugin.
* Updated required IntelliJ version to reflect code dependencies.
* Issue [#1](https://github.com/ligasgr/intellij-xquery/issues/1) - Error when trying to open file.
* Issue [#15](https://github.com/ligasgr/intellij-xquery/issues/15) - Function reference based completion to work without ().
* Issue [#16](https://github.com/ligasgr/intellij-xquery/issues/16) - Function completion to have () added by default.
* Issue [#17](https://github.com/ligasgr/intellij-xquery/issues/17) - Simple keyword completion.

### Version 0.0.3
* Bug fix - Usage type always unclassified.
* Bug fix - String highlighting didn't work while typing in some cases.
* Bug fix - Whole function invocation is highlighted instead of name only.
* Bug fix - Identifier while renamed doesn't accept - or .
* Inline rename for local variables (code, comments, strings references and optionally text files usage renamed).
* Code commenter.
* Brace matching.
* Word completion contributor for variable and function names (works after you've typed at least one character in fun/var name in new fun/var declaration; based on all words in current file).
* Find usages in text files (as an option).

### Version 0.0.2
* Highlighting improvements and bug-fixes.
* Variable reference resolution across files (scopes taken into account; no support for access modifiers).
* Variable name completion inside of the file.
* Function reference resolution across files (no support for access modifiers)
* Function name completion inside of the file (still has place for improvement - completes only if shortcut used in front of ())
* Namespace reference resolution inside of the file.
* Navigation between modules via file location and namespace (if includes file path) in module imports.
* Rename functionality for all references.
* Basic find usage.

### Version 0.0.1
* Basic syntax highlighting.
* Variable reference resolution inside of a file.
