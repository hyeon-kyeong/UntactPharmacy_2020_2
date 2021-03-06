package controller.user;

import javax.servlet.http.HttpSession;

public class UserSessionUtils {
    public static final String USER_SESSION_KEY = "userId";
    public static final String USER_LEVEL = "userLevel";
    
    /* 현재 로그인한 사용자의 ID를 구함 */
    public static String getLoginUserId(HttpSession session) {
        String user_id = (String)session.getAttribute(USER_SESSION_KEY);
        return user_id;
    }
    

    /* 로그인한 상태인지를 검사 */
    public static boolean hasLogined(HttpSession session) {
        if (getLoginUserId(session) != null) {
            return true;
        }
        return false;
    }

    /* 현재 로그인한 사용자의 ID가 userId인지 검사 */
    public static boolean isLoginUser(String user_id, HttpSession session) {
        String loginUser = getLoginUserId(session);
        if (loginUser == null) {
            return false;
        }
        return loginUser.equals(user_id);
    }
//    현재 로그인한 사용자의 등급 
    public static int getLoginUserLevel(HttpSession session) {
    	int userLevel = (int)session.getAttribute(USER_LEVEL);
    	return userLevel;
    }
    public static boolean isLoginUserManager (String user_id, HttpSession session) {
    	if (getLoginUserLevel(session) == 2)
    		return true;
    	else return false;

    	
    	
    }
}
