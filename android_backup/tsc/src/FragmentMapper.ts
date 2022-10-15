import ErrorFragment from './ErrorFragment';
import ErrorDetailFragment from './ErrorDetailFragment';
 //start - import

import ChangePassword from './ChangePassword';

import Dashboard from './Dashboard';

import DashboardFilter from './DashboardFilter';

import DashboardQuantity from './DashboardQuantity';

import Faq from './Faq';

import ForgotPassword from './ForgotPassword';

import ForgotPasswordOtp from './ForgotPasswordOtp';

import Index from './Index';

import Login from './Login';

import NotificationList from './NotificationList';

import OrderBooked from './OrderBooked';

import OrderList from './OrderList';

import OrderPreviewCart from './OrderPreviewCart';

import QrcodeScanner from './QrcodeScanner';

import Register from './Register';

import Selectstore from './Selectstore';

import SelectstoreDialog from './SelectstoreDialog';

import Webview from './Webview';

//end - import

export const fragmentMapper : any = {
  'layout/error.xml': ErrorFragment,
  'layout/error_detail.xml': ErrorDetailFragment,
  //start - body
    
     'layout/change_password.xml': ChangePassword,
    
     'layout/dashboard.xml': Dashboard,
    
     'layout/dashboard_filter.xml': DashboardFilter,
    
     'layout/dashboard_quantity.xml': DashboardQuantity,
    
     'layout/faq.xml': Faq,
    
     'layout/forgot_password.xml': ForgotPassword,
    
     'layout/forgot_password_otp.xml': ForgotPasswordOtp,
    
     'layout/index.xml': Index,
    
     'layout/login.xml': Login,
    
     'layout/notification_list.xml': NotificationList,
    
     'layout/order_booked.xml': OrderBooked,
    
     'layout/order_list.xml': OrderList,
    
     'layout/order_preview_cart.xml': OrderPreviewCart,
    
     'layout/qrcode_scanner.xml': QrcodeScanner,
    
     'layout/register.xml': Register,
    
     'layout/selectstore.xml': Selectstore,
    
     'layout/selectstore_dialog.xml': SelectstoreDialog,
    
     'layout/webview.xml': Webview,
    
     //end - body
};