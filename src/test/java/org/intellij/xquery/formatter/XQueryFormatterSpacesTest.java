/*
 * Copyright 2013 Grzegorz Ligas <ligasgr@gmail.com> and other contributors (see the CONTRIBUTORS file).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.intellij.xquery.formatter;

/**
 * User: ligasgr
 * Date: 12/09/13
 * Time: 16:52
 */
public class XQueryFormatterSpacesTest extends XQueryFormattingModelBuilderTest {
    @Override
    protected String getTestDataPath() {
        return "src/test/testData/org/intellij/xquery/formatter/spaces";
    }

    public void testSpaceAroundAssignmentOperators() {
        String withSpaces = "declare variable $fgdf := 'sdf';\n" +
                "let $df := zz:example()\n" +
                "return $df";
        String withoutSpaces = "declare variable $fgdf:='sdf';\n" +
                "let $df:=zz:example()\n" +
                "return $df";

        getSettings().SPACE_AROUND_ASSIGNMENT_OPERATORS = false;
        executeTest(withSpaces, withoutSpaces);
        getSettings().SPACE_AROUND_ASSIGNMENT_OPERATORS = true;
        executeTest(withoutSpaces, withSpaces);
    }

    public void testSpaceAroundEqualityOperators() {
        String withSpaces = "5 = 3, 4 != 6";
        String withoutSpaces = "5=3, 4!=6";

        getSettings().SPACE_AROUND_EQUALITY_OPERATORS = false;
        executeTest(withSpaces, withoutSpaces);
        getSettings().SPACE_AROUND_EQUALITY_OPERATORS = true;
        executeTest(withoutSpaces, withSpaces);
    }

    public void testSpaceAroundRelationalOperators() {
        String withSpaces = "1 < 2, 3 <= 4, 5 > 6, 7 >= 8";
        String withoutSpaces = "1<2, 3<=4, 5>6, 7>=8";

        getSettings().SPACE_AROUND_RELATIONAL_OPERATORS = false;
        executeTest(withSpaces, withoutSpaces);
        getSettings().SPACE_AROUND_RELATIONAL_OPERATORS = true;
        executeTest(withoutSpaces, withSpaces);
    }

    public void testSpaceAroundAdditiveOperators() {
        String withSpaces = "1 + 2, 3 - 4";
        String withoutSpaces = "1+2, 3-4";

        getSettings().SPACE_AROUND_ADDITIVE_OPERATORS = false;
        executeTest(withSpaces, withoutSpaces);
        getSettings().SPACE_AROUND_ADDITIVE_OPERATORS = true;
        executeTest(withoutSpaces, withSpaces);
    }

    public void testSpaceAroundMultiplicativeOperators() {
        String withoutSpaces = "let $var as map(*) := map {\n" +
                "a := 1*2,\n" +
                "b := /something/something:*/something}\n" +
                "return $var";
        String withSpaces = "let $var as map(*) := map {\n" +
                "a := 1 * 2,\n" +
                "b := /something/something:*/something}\n" +
                "return $var";

        getSettings().SPACE_AROUND_MULTIPLICATIVE_OPERATORS = true;
        executeTest(withoutSpaces, withSpaces);
        getSettings().SPACE_AROUND_MULTIPLICATIVE_OPERATORS = false;
        executeTest(withSpaces, withoutSpaces);
    }

    public void testSpaceBeforeComma() {
        String withoutSpaces = "1,2,3";
        String withSpaces = "1 ,2 ,3";

        getSettings().SPACE_AFTER_COMMA = false;
        getSettings().SPACE_BEFORE_COMMA = true;
        executeTest(withoutSpaces, withSpaces);
        getSettings().SPACE_BEFORE_COMMA = false;
        executeTest(withSpaces, withoutSpaces);
    }

    public void testSpaceAfterComma() {
        String withoutSpaces = "1,2,3";
        String withSpaces = "1, 2, 3";

        getSettings().SPACE_BEFORE_COMMA = false;
        getSettings().SPACE_AFTER_COMMA = true;
        executeTest(withoutSpaces, withSpaces);
        getSettings().SPACE_AFTER_COMMA = false;
        executeTest(withSpaces, withoutSpaces);
    }

    public void testSpaceBeforeAndAfterArgumentAndParamList() {
        String withSpaces = "declare function example ( $var     ) {()};\n" +
                "example ( 'sdf' )";
        String withoutSpaces = "declare function example($var) {()};\n" +
                "example('sdf')";

        executeTest(withSpaces, withoutSpaces);
    }

    public void testSpaceAroundKeyword() {
        String withTabs = "\t\tdeclare\t\tfunction\texample() {()};\n" +
                "example()";
        String withSpaces = "declare function example() {()};\n" +
                "example()";

        executeTest(withTabs, withSpaces);
    }

    public void testSpaceAroundAssignmentInModuleDeclAndFirstDecl() {
        String withSpaces = "module namespace example = \"example\";\n" +
                "declare default decimal-format decimal-separator = \"anything\" NaN = \"whatever\";\n" +
                "import schema namespace ex = \"ex\";\n" +
                "import module namespace m = \"m\";\n" +
                "declare namespace n = \"n\";";
        String withoutSpaces = "module namespace example=\"example\";\n" +
                "declare default decimal-format decimal-separator=\"anything\" NaN=\"whatever\";\n" +
                "import schema namespace ex=\"ex\";\n" +
                "import module namespace m=\"m\";\n" +
                "declare namespace n=\"n\";";

        getXQuerySettings().SPACE_AROUND_ASSIGNMENT_IN_PROLOG = false;
        executeTest(withSpaces, withoutSpaces);
        getXQuerySettings().SPACE_AROUND_ASSIGNMENT_IN_PROLOG = true;
        executeTest(withoutSpaces, withSpaces);
    }

    public void testSpaceAroundAssignmentInXmlAttributeWhenOn() {
        String withSpaces = "<tag attr = \"value\">\n" +
                "    <child attr = 'value'/>\n" +
                "</tag>";
        String withoutSpaces = "<tag attr=\"value\">\n" +
                "    <child attr='value'/>\n" +
                "</tag>";

        getXQuerySettings().SPACE_AROUND_ASSIGNMENT_IN_XML_ATTRIBUTE = false;
        executeTest(withSpaces, withoutSpaces);
        getXQuerySettings().SPACE_AROUND_ASSIGNMENT_IN_XML_ATTRIBUTE = true;
        executeTest(withoutSpaces, withSpaces);
    }

    public void testSpaceBeforeIfParentheses() {
        String withSpaces = "if (fn:true) then 'x' else 'y'";
        String withoutSpaces = "if(fn:true) then 'x' else 'y'";

        getSettings().SPACE_BEFORE_IF_PARENTHESES = false;
        executeTest(withSpaces, withoutSpaces);
        getSettings().SPACE_BEFORE_IF_PARENTHESES = true;
        executeTest(withoutSpaces, withSpaces);
    }

    public void testSpaceBeforeSwitchParentheses() {
        String withSpaces = "switch ('test') case \"case1\" return \"1\" default return \"default\"";
        String withoutSpaces = "switch('test') case \"case1\" return \"1\" default return \"default\"";

        getSettings().SPACE_BEFORE_SWITCH_PARENTHESES = false;
        executeTest(withSpaces, withoutSpaces);
        getSettings().SPACE_BEFORE_SWITCH_PARENTHESES = true;
        executeTest(withoutSpaces, withSpaces);
    }

    public void testSpaceBeforeTypeswitchParentheses() {
        String withSpaces = "typeswitch ('test') case xs:string return \"1\" default return \"default\"";
        String withoutSpaces = "typeswitch('test') case xs:string return \"1\" default return \"default\"";

        getXQuerySettings().SPACE_BEFORE_TYPESWITCH_PARENTHESES = false;
        executeTest(withSpaces, withoutSpaces);
        getXQuerySettings().SPACE_BEFORE_TYPESWITCH_PARENTHESES = true;
        executeTest(withoutSpaces, withSpaces);
    }

    public void testSpaceBeforeTypeTestParentheses() {
        String withoutSpaces = "let $x as empty-sequence() := ()\n" +
                "let $x as item() := 'x'\n" +
                "let $x as node() := 'x'\n" +
                "let $x as document-node() := 'x'\n" +
                "let $x as text() := 'x'\n" +
                "let $x as comment() := 'x'\n" +
                "let $x as namespace-node() := 'x'\n" +
                "let $x as processing-instruction() := 'x'\n" +
                "let $x as attribute() := 'x'\n" +
                "let $x as schema-attribute(x) := 'x'\n" +
                "let $x as element() := 'x'\n" +
                "let $x as map(*) := 'x'\n" +
                "let $x as schema-element(xs:string) := 'x'\n" +
                "let $x as function(*) := ref#1\n" +
                "let $x as function(xs:integer) as xs:string := ref#1\n" +
                "let $x as (function(*)) := 1\n" +
                "return $x";
        String withSpaces = "let $x as empty-sequence () := ()\n" +
                "let $x as item () := 'x'\n" +
                "let $x as node () := 'x'\n" +
                "let $x as document-node () := 'x'\n" +
                "let $x as text () := 'x'\n" +
                "let $x as comment () := 'x'\n" +
                "let $x as namespace-node () := 'x'\n" +
                "let $x as processing-instruction () := 'x'\n" +
                "let $x as attribute () := 'x'\n" +
                "let $x as schema-attribute (x) := 'x'\n" +
                "let $x as element () := 'x'\n" +
                "let $x as map (*) := 'x'\n" +
                "let $x as schema-element (xs:string) := 'x'\n" +
                "let $x as function (*) := ref#1\n" +
                "let $x as function (xs:integer) as xs:string := ref#1\n" +
                "let $x as (function (*)) := 1\n" +
                "return $x";

        getXQuerySettings().SPACE_BEFORE_TYPE_TEST_PARENTHESES = true;
        executeTest(withoutSpaces, withSpaces);
        getXQuerySettings().SPACE_BEFORE_TYPE_TEST_PARENTHESES = false;
        executeTest(withSpaces, withoutSpaces);
    }

    public void testSpaceBeforeFunctionDeclarationParentheses() {
        String withoutSpaces = "declare function example() {function() {()}};";
        String withSpaces = "declare function example () {function () {()}};";

        getXQuerySettings().SPACE_BEFORE_FUNCTION_DECLARATION_PARENTHESES = true;
        executeTest(withoutSpaces, withSpaces);
        getXQuerySettings().SPACE_BEFORE_FUNCTION_DECLARATION_PARENTHESES = false;
        executeTest(withSpaces, withoutSpaces);
    }

    public void testSpaceBeforeFunctionCallParentheses() {
        String withoutSpaces = "fn:true()";
        String withSpaces = "fn:true ()";

        getXQuerySettings().SPACE_BEFORE_FUNCTION_CALL_PARENTHESES = true;
        executeTest(withoutSpaces, withSpaces);
        getXQuerySettings().SPACE_BEFORE_FUNCTION_CALL_PARENTHESES = false;
        executeTest(withSpaces, withoutSpaces);
    }

    public void testSpaceAroundAxisOperator() {
        String withoutSpaces = "parent::DirElemConstructor";
        String withSpaces = "parent :: DirElemConstructor";

        getXQuerySettings().SPACE_AROUND_AXIS_OPERATOR = true;
        executeTest(withoutSpaces, withSpaces);
        getXQuerySettings().SPACE_AROUND_AXIS_OPERATOR = false;
        executeTest(withSpaces, withoutSpaces);
    }

    public void testSpaceAroundUnaryOperator() {
        String withSpace = "(- 1)";
        String withoutSpace = "(-1)";

        getSettings().SPACE_AROUND_UNARY_OPERATOR = false;
        executeTest(withSpace, withoutSpace);
        getSettings().SPACE_AROUND_UNARY_OPERATOR = true;
        executeTest(withoutSpace, withSpace);
    }
}
