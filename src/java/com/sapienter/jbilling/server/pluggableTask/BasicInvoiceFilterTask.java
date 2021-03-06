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

/*
 * Created on Apr 28, 2003
 */
package com.sapienter.jbilling.server.pluggableTask;

import com.sapienter.jbilling.server.invoice.db.InvoiceDTO;
import com.sapienter.jbilling.server.process.db.BillingProcessDTO;

/**
 * This filter simply verifies that this invoice is being process after
 * its due date
 */
public class BasicInvoiceFilterTask
    extends PluggableTask
    implements InvoiceFilterTask {

    public boolean isApplicable(InvoiceDTO invoice, 
            BillingProcessDTO process) throws TaskException {

        /*
        if (process.getBillingDate().after(Util.truncateDate(
                invoice.getDueDate()))) {
            return true;
        } else {
            return false;
        }
        */
        
        // change: we always delegate, even when is not yet overdue
        // this ensures the 'last invoice holds them all' policy
        return true;
    }

}
