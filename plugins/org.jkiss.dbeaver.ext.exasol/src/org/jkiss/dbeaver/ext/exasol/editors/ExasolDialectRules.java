/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2019 Serge Rider (serge@jkiss.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jkiss.dbeaver.ext.exasol.editors;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.swt.SWT;
import org.jkiss.code.NotNull;
import org.jkiss.code.Nullable;
import org.jkiss.dbeaver.model.DBPDataSourceContainer;
import org.jkiss.dbeaver.model.sql.SQLConstants;
import org.jkiss.dbeaver.runtime.sql.SQLRuleProvider;
import org.jkiss.dbeaver.ui.UIUtils;
import org.jkiss.dbeaver.ui.editors.sql.syntax.rules.SQLFullLineRule;
import org.jkiss.dbeaver.ui.editors.sql.syntax.tokens.SQLControlToken;

import java.util.List;

/**
* Exasol dialect rules
*/
class ExasolDialectRules implements SQLRuleProvider {

    @Override
    public void extendRules(@Nullable DBPDataSourceContainer dataSource, @NotNull List<IRule> rules, @NotNull RulePosition position) {
        if (position == SQLRuleProvider.RulePosition.CONTROL) {
            final SQLControlToken defineToken = new SQLControlToken(
                new TextAttribute(UIUtils.getGlobalColor(SQLConstants.CONFIG_COLOR_COMMAND), null, SWT.BOLD),
                "exasol.define");

            SQLFullLineRule defineRule = new SQLFullLineRule("define", defineToken); //$NON-NLS-1$
            rules.add(defineRule);

            SQLFullLineRule defineRule2 = new SQLFullLineRule("DEFINE", defineToken); //$NON-NLS-1$
            rules.add(defineRule2);
        }
    }

}
