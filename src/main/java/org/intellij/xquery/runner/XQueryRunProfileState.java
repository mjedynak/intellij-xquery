/*
 * Copyright 2013 Grzegorz Ligas
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

package org.intellij.xquery.runner;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.CommandLineState;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.filters.TextConsoleBuilder;
import com.intellij.execution.filters.TextConsoleBuilderFactory;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.util.io.FileUtil;
import org.jetbrains.annotations.NotNull;

/**
 * User: ligasgr
 * Date: 04/08/13
 * Time: 22:40
 */
public class XQueryRunProfileState extends CommandLineState {

    protected XQueryRunProfileState(ExecutionEnvironment environment) {
        super(environment);
    }

    @NotNull
    @Override
    protected ProcessHandler startProcess() throws ExecutionException {
        GeneralCommandLine commandLine = getCommand();

        return new OSProcessHandler(commandLine.createProcess(), commandLine.getCommandLineString());
    }

    private GeneralCommandLine getCommand() {
        XQueryRunConfiguration configuration = (XQueryRunConfiguration) getEnvironment()
                .getRunnerAndConfigurationSettings().getConfiguration();
        String filename = configuration.getMainModuleFilename();
        final GeneralCommandLine commandLine = new GeneralCommandLine();

        String java = FileUtil.toSystemDependentName("/opt/dev/jdk/bin/java");
        commandLine.setExePath(java);
        commandLine.setWorkDirectory(getEnvironment().getProject().getBasePath());
        commandLine.addParameters("-cp");
        commandLine.addParameters("/opt/dev/saxon/*");
        commandLine.addParameters("net.sf.saxon.Query");
        commandLine.addParameters(filename);

        final TextConsoleBuilder consoleBuilder = TextConsoleBuilderFactory.getInstance().createBuilder
                (getEnvironment().getProject());
        setConsoleBuilder(consoleBuilder);
        return commandLine;
    }
}
