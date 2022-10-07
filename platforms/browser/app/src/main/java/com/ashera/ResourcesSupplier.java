package com.ashera;

import org.teavm.classlib.ResourceSupplier;
import org.teavm.classlib.ResourceSupplierContext;

public class ResourcesSupplier implements ResourceSupplier {
	@Override
	public String[] supplyResources(ResourceSupplierContext context) {
		String[] result = { "www/css/styles.css", "res/xml/config.xml",
				//start - body
"www/layout/activity_main.xml",
"www/layout/change_password.xml",
"www/layout/dashboard.xml",
"www/layout/dashboard_filter.xml",
"www/layout/dashboard_filter_item.xml",
"www/layout/dashboard_item.xml",
"www/layout/dashboard_main_category.xml",
"www/layout/dashboard_mixer_item.xml",
"www/layout/dashboard_quantity.xml",
"www/layout/dashboard_sectionheader.xml",
"www/layout/datepicker.xml",
"www/layout/error.xml",
"www/layout/erroritem.xml",
"www/layout/error_detail.xml",
"www/layout/faq.xml",
"www/layout/forgot_password.xml",
"www/layout/forgot_password_otp.xml",
"www/layout/index.xml",
"www/layout/login.xml",
"www/layout/membership_details.xml",
"www/layout/notification_item.xml",
"www/layout/notification_list.xml",
"www/layout/order_booked.xml",
"www/layout/order_list.xml",
"www/layout/order_list_item.xml",
"www/layout/order_preview_cart.xml",
"www/layout/order_preview_cart_footer.xml",
"www/layout/order_preview_cart_item.xml",
"www/layout/qrcode_scanner.xml",
"www/layout/register.xml",
"www/layout/selectstore.xml",
"www/layout/selectstore_dialog.xml",
"www/layout/selectstore_item.xml",
"www/layout/timepicker.xml",
"www/layout/toolbar.xml",
"www/layout/webview.xml",
//end - body
		};
		return result;
	}
}