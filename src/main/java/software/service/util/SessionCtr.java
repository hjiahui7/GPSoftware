package software.service.util;

import org.mockito.internal.verification.Times;

import java.util.Map;
import java.util.concurrent.*;

public class SessionCtr {

  static final int sessionCtrThreadNumber = 1;
  private static ScheduledExecutorService scheduleSessionCtr;
  private static ConcurrentHashMap<String, String> sessionMap;

  static {
    scheduleSessionCtr = Executors.newScheduledThreadPool(sessionCtrThreadNumber);
    sessionMap = new ConcurrentHashMap<>();
  }

//  public void startSessionCtr() {
//    scheduleSessionCtr.scheduleAtFixedRate(new SessionCtrImpl(), 0, 2, TimeUnit.HOURS);
//  }

//  public void setSession(String token, String email){
//	  sessionMap.pu
//	}

  public static ConcurrentHashMap<String, String> getSessionMap() {
    return sessionMap;
  }

//  public static class SessionCtrImpl implements Runnable {
//
//    @Override
//    public void run() {
//      for (Map.Entry each : sessionMap.entrySet()) {
//      	if(each.getValue())
//      }
//    }
//  }
}
