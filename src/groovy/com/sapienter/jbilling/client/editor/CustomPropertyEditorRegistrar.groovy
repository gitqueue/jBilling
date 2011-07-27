/*
 jBilling - The Enterprise Open Source Billing System
 Copyright (C) 2003-2011 Enterprise jBilling Software Ltd. and Emiliano Conde

 This file is part of jbilling.

 jbilling is free software: you can redistribute it and/or modify
 it under the terms of the GNU Affero General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 jbilling is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License
 along with jbilling.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.sapienter.jbilling.client.editor

import org.springframework.beans.PropertyEditorRegistrar
import org.springframework.beans.PropertyEditorRegistry
import org.springframework.beans.propertyeditors.CustomDateEditor
import java.text.SimpleDateFormat
import org.springframework.context.i18n.LocaleContextHolder

/**
 * CustomPropertyEditorRegistrar 
 *
 * @author Brian Cowdery
 * @since 07/01/11
 */
class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

    def messageSource;

    public void registerCustomEditors(PropertyEditorRegistry registry) {
        // parse date values
        registry.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(messageSource.getMessage('date.format', null, LocaleContextHolder.locale)), true))
    }

}