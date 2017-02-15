package com.example.loadimage;
///*  1:   */ package com.newrelic.agent.android.instrumentation;
///*  2:   */ 
///*  3:   */ import com.newrelic.agent.android.tracing.TraceMachine;
//
///*  4:   */ import java.util.ArrayList;
///*  5:   */ import java.util.Arrays;
//
///*  6:   */ import org.json.JSONException;
///*  7:   */ import org.json.JSONObject;
///*  8:   */ 
///*  9:   */ public class JSONObjectInstrumentation
///* 10:   */ {
///* 11:12 */   private static final ArrayList<String> categoryParams = new ArrayList<String>(Arrays.asList(new String[] { "category", MetricCategory.class.getName(), "JSON" }));
///* 12:   */   
///* 13:   */   @TraceConstructor
///* 14:   */   public static JSONObject init(String json)
///* 15:   */     throws JSONException
///* 16:   */   {
///* 17:   */     JSONObject jsonObject;
///* 18:   */     try
///* 19:   */     {
///* 20:21 */       TraceMachine.enterMethod(null, "JSONObject#<init>", categoryParams);
///* 21:22 */       jsonObject = new JSONObject(json);
///* 22:23 */       TraceMachine.exitMethod();
///* 23:   */     }
///* 24:   */     catch (JSONException e)
///* 25:   */     {
///* 26:25 */       TraceMachine.exitMethod();
///* 27:26 */       throw e;
///* 28:   */     }
///* 29:29 */     return jsonObject;
///* 30:   */   }
///* 31:   */   
///* 32:   */   @ReplaceCallSite(scope="org.json.JSONObject")
///* 33:   */   public static String toString(JSONObject jsonObject)
///* 34:   */   {
///* 35:34 */     TraceMachine.enterMethod(null, "JSONObject#toString", categoryParams);
///* 36:35 */     String jsonString = jsonObject.toString();
///* 37:36 */     TraceMachine.exitMethod();
///* 38:   */     
///* 39:38 */     return jsonString;
///* 40:   */   }
///* 41:   */   
///* 42:   */   @ReplaceCallSite(scope="org.json.JSONObject")
///* 43:   */   public static String toString(JSONObject jsonObject, int indentFactor)
///* 44:   */     throws JSONException
///* 45:   */   {
///* 46:45 */     TraceMachine.enterMethod(null, "JSONObject#toString", categoryParams);
///* 47:   */     String jsonString;
///* 48:   */     try
///* 49:   */     {
///* 50:48 */       jsonString = jsonObject.toString(indentFactor);
///* 51:49 */       TraceMachine.exitMethod();
///* 52:   */     }
///* 53:   */     catch (JSONException e)
///* 54:   */     {
///* 55:51 */       TraceMachine.exitMethod();
///* 56:52 */       throw e;
///* 57:   */     }
///* 58:55 */     return jsonString;
///* 59:   */   }
///* 60:   */ }
//
////
///* Location:           C:\Users\pc\Downloads\jd-gui-0.3.6.windows\newrelic.android.jar//
// * Qualified Name:     com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation//
// * JD-Core Version:    0.7.0.1//
// */